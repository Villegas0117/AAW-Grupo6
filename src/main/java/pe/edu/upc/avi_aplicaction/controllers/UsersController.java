package pe.edu.upc.avi_aplicaction.controllers;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.avi_aplicaction.dtos.UsersDTO;
import pe.edu.upc.avi_aplicaction.dtos.UsersNoPassDTO;
import pe.edu.upc.avi_aplicaction.entities.Users;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IUsersService;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsersController {

    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private IUsersService uR;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Método auxiliar para obtener la IP del cliente
    private String getClientIp(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");

        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }

        // Si hay múltiples IPs, tomar la primera
        if (ipAddress != null && ipAddress.contains(",")) {
            ipAddress = ipAddress.split(",")[0].trim();
        }

        return ipAddress;
    }

    @PostMapping("/registroNoAuth")
    public ResponseEntity<?> registrarNoAuth(@RequestBody UsersDTO dto, HttpServletRequest request) {
        String clientIp = getClientIp(request);

        logger.info("=== INTENTO DE REGISTRO SIN AUTENTICACIÓN ===");
        logger.info("IP Cliente: {}", clientIp);
        logger.info("Email: {}", dto.getEmail());
        logger.info("Username: {}", dto.getUsername());

        try {
            ModelMapper m = new ModelMapper();
            Users u = m.map(dto, Users.class);
            String encodedPassword = passwordEncoder.encode(u.getPassword());
            u.setPassword(encodedPassword);
            uR.insertUser(u);

            logger.info("✅ REGISTRO EXITOSO - Usuario: {} desde IP: {}", dto.getUsername(), clientIp);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado exitosamente");

        } catch (Exception e) {
            logger.error("❌ ERROR EN REGISTRO - Usuario: {} desde IP: {} - Error: {}",
                    dto.getUsername(), clientIp, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al registrar usuario: " + e.getMessage());
        }
    }

    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','CREADOR')")
    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody UsersDTO dto, HttpServletRequest request) {
        String clientIp = getClientIp(request);

        logger.info("=== CREACIÓN DE USUARIO POR ADMIN/CREADOR ===");
        logger.info("IP Cliente: {}", clientIp);
        logger.info("Email: {}", dto.getEmail());
        logger.info("Username: {}", dto.getUsername());

        try {
            ModelMapper m = new ModelMapper();
            Users u = m.map(dto, Users.class);
            String encodedPassword = passwordEncoder.encode(u.getPassword());
            u.setPassword(encodedPassword);
            uR.insertUser(u);

            logger.info("✅ USUARIO CREADO EXITOSAMENTE - Usuario: {} desde IP: {}",
                    dto.getUsername(), clientIp);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado exitosamente");

        } catch (Exception e) {
            logger.error("❌ ERROR AL CREAR USUARIO - Usuario: {} desde IP: {} - Error: {}",
                    dto.getUsername(), clientIp, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear usuario: " + e.getMessage());
        }
    }

    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','CREADOR')")
    @GetMapping
    public List<UsersNoPassDTO> listar(HttpServletRequest request) {
        String clientIp = getClientIp(request);
        logger.info("📋 LISTADO DE USUARIOS - Solicitado desde IP: {}", clientIp);

        List<UsersNoPassDTO> usuarios = uR.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsersNoPassDTO.class);
        }).collect(Collectors.toList());

        logger.debug("Total de usuarios retornados: {}", usuarios.size());
        return usuarios;
    }

    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','CREADOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") Long id, HttpServletRequest request) {
        String clientIp = getClientIp(request);

        logger.warn("⚠️ INTENTO DE ELIMINACIÓN - IP: {}, ID Usuario: {}", clientIp, id);

        try {
            uR.deleteUser(id);
            logger.warn("🗑️ USUARIO ELIMINADO - ID: {}, desde IP: {}", id, clientIp);
            return ResponseEntity.ok("Usuario eliminado exitosamente");

        } catch (Exception e) {
            logger.error("❌ ERROR AL ELIMINAR USUARIO - ID: {}, IP: {}, Error: {}",
                    id, clientIp, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar usuario: " + e.getMessage());
        }
    }

    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','CREADOR')")
    @GetMapping("/{id}")
    public UsersNoPassDTO listarPorId(@PathVariable("id") Long id) {
        logger.debug("Buscando usuario por ID: {}", id);
        ModelMapper m = new ModelMapper();
        UsersNoPassDTO dto = m.map(uR.listUserById(id), UsersNoPassDTO.class);
        return dto;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @PutMapping
    public ResponseEntity<?> modificar(@RequestBody UsersDTO dto, HttpServletRequest request) {
        String clientIp = getClientIp(request);

        logger.info("✏️ INTENTO DE MODIFICACIÓN - IP: {}, Usuario ID: {}", clientIp, dto.getId());

        try {
            ModelMapper m = new ModelMapper();
            Users u = m.map(dto, Users.class);
            String encodedPassword = passwordEncoder.encode(u.getPassword());
            u.setPassword(encodedPassword);
            uR.updateUser(u);

            logger.info("✅ USUARIO MODIFICADO EXITOSAMENTE - ID: {}, IP: {}", dto.getId(), clientIp);
            return ResponseEntity.ok("Usuario modificado exitosamente");

        } catch (Exception e) {
            logger.error("❌ ERROR AL MODIFICAR USUARIO - ID: {}, IP: {}, Error: {}",
                    dto.getId(), clientIp, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al modificar usuario: " + e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping("/buscarUsuario")
    public List<UsersDTO> buscarUsuario(@RequestParam String email, HttpServletRequest request) {
        String clientIp = getClientIp(request);
        logger.info("🔎 BÚSQUEDA DE USUARIO - Email: {}, IP: {}", email, clientIp);

        List<UsersDTO> resultados = uR.searchUser(email).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsersDTO.class);
        }).collect(Collectors.toList());

        logger.debug("Resultados encontrados: {}", resultados.size());
        return resultados;
    }

    @GetMapping("/NoAuth/{email}")
    public List<UsersNoPassDTO> buscarUsuarioNoAuth(@PathVariable String email, HttpServletRequest request) {
        String clientIp = getClientIp(request);
        logger.info("🔎 BÚSQUEDA PÚBLICA - Email: {}, IP: {}", email, clientIp);

        List<UsersNoPassDTO> resultados = uR.searchUser(email).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsersNoPassDTO.class);
        }).collect(Collectors.toList());

        logger.debug("Resultados encontrados: {}", resultados.size());
        return resultados;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UsersDTO dto, HttpServletRequest request) {
        String clientIp = getClientIp(request);

        logger.info("=== CREACIÓN DE USUARIO CON ROL ===");
        logger.info("IP Cliente: {}", clientIp);
        logger.info("Email: {}", dto.getEmail());
        logger.info("Username: {}", dto.getUsername());

        try {
            ModelMapper mapper = new ModelMapper();
            Users user = mapper.map(dto, Users.class);

            // Codificar la contraseña
            String encodedPassword = passwordEncoder.encode(user.getPassword());

            // Llamar al procedimiento almacenado
            uR.insertarUsuarioConRol(user.getEmail(), encodedPassword, user.getUsername());

            logger.info("✅ USUARIO CON ROL CREADO EXITOSAMENTE - Usuario: {} desde IP: {}",
                    dto.getUsername(), clientIp);
            return ResponseEntity.ok("Usuario creado con rol correctamente");

        } catch (Exception e) {
            logger.error("❌ ERROR AL CREAR USUARIO CON ROL - Usuario: {} desde IP: {} - Error: {}",
                    dto.getUsername(), clientIp, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear usuario: " + e.getMessage());
        }
    }
}