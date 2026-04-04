package pe.edu.upc.avi_aplicaction.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.avi_aplicaction.securities.JwtRequest;
import pe.edu.upc.avi_aplicaction.securities.JwtResponse;
import pe.edu.upc.avi_aplicaction.securities.JwtTokenUtil;
import pe.edu.upc.avi_aplicaction.serviceimplements.JwtUserDetailsService;

import jakarta.servlet.http.HttpServletRequest;

//Clase 3
@RestController
@CrossOrigin
public class JwtAuthenticationController {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest req, HttpServletRequest request) throws Exception {

        // Obtener IP del cliente
        String clientIp = getClientIp(request);

        // Log de intento de login
        logger.info("=== INTENTO DE LOGIN ===");
        logger.info("IP Cliente: {}", clientIp);
        logger.info("Username: {}", req.getUsername());

        try {
            authenticate(req.getUsername(), req.getPassword());

            final UserDetails userDetails = userDetailsService.loadUserByUsername(req.getUsername());
            final String token = jwtTokenUtil.generateToken(userDetails);

            // Log de login exitoso
            logger.info("✅ LOGIN EXITOSO - Usuario: {} desde IP: {}", req.getUsername(), clientIp);

            return ResponseEntity.ok(new JwtResponse(token));

        } catch (BadCredentialsException e) {
            // Log de credenciales inválidas
            logger.warn("❌ LOGIN FALLIDO - Credenciales inválidas - Usuario: {} desde IP: {}",
                    req.getUsername(), clientIp);
            throw new Exception("INVALID_CREDENTIALS", e);

        } catch (DisabledException e) {
            // Log de usuario deshabilitado
            logger.warn("❌ LOGIN FALLIDO - Usuario deshabilitado: {} desde IP: {}",
                    req.getUsername(), clientIp);
            throw new Exception("USER_DISABLED", e);

        } catch (Exception e) {
            // Log de otros errores
            logger.error("❌ ERROR EN LOGIN - Usuario: {} desde IP: {} - Error: {}",
                    req.getUsername(), clientIp, e.getMessage());
            throw e;
        }
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    // Método auxiliar para obtener la IP real del cliente
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

        // Si hay múltiples IPs (por proxies), tomar la primera
        if (ipAddress != null && ipAddress.contains(",")) {
            ipAddress = ipAddress.split(",")[0].trim();
        }

        return ipAddress;
    }
}