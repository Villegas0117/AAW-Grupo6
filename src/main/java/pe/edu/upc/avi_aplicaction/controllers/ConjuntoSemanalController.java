package pe.edu.upc.avi_aplicaction.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.avi_aplicaction.dtos.ConjuntoDiaSemanaDTO;
import pe.edu.upc.avi_aplicaction.dtos.ConjuntoPorUsuarioDTO;
import pe.edu.upc.avi_aplicaction.dtos.ConjuntoSemanalDTO;
import pe.edu.upc.avi_aplicaction.entities.ConjuntoSemanal;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IConjuntosDiaService;


import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/conjunto-semanal")
public class ConjuntoSemanalController {

    @Autowired
    private IConjuntosDiaService service;

    //@PreAuthorize("hasAnyAuthority('USUARIO', 'ADMINISTRADOR')")
    @GetMapping
    public List<ConjuntoSemanalDTO> listar(){
        return service.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ConjuntoSemanalDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAnyAuthority('USUARIO', 'ADMINISTRADOR')")
    @PostMapping
    public void registrar(@RequestBody ConjuntoSemanalDTO dto) {
        ModelMapper m = new ModelMapper();
        ConjuntoSemanal conjuntoSemanal = m.map(dto, ConjuntoSemanal.class);
        service.insert(conjuntoSemanal);
    }

    @PreAuthorize("hasAnyAuthority('USUARIO', 'ADMINISTRADOR')")
    @GetMapping("/{id}")
    public ConjuntoSemanalDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(service.listId(id), ConjuntoSemanalDTO.class);
    }

    @PreAuthorize("hasAnyAuthority('USUARIO', 'ADMINISTRADOR')")
    @PutMapping
    public void modificar(@RequestBody ConjuntoSemanalDTO dto) {
        ModelMapper m = new ModelMapper();
        ConjuntoSemanal conjuntoSemanal = m.map(dto, ConjuntoSemanal.class);
        service.update(conjuntoSemanal);
    }

    @PreAuthorize("hasAnyAuthority('USUARIO', 'ADMINISTRADOR')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        service.delete(id);
    }

    // Consultas personalizadas
    @PreAuthorize("hasAnyAuthority('USUARIO', 'ADMINISTRADOR')")
    @GetMapping("/buscarPorUsuario")
    public List<ConjuntoSemanalDTO> buscarPorUsuario(@RequestParam int id_usuario) {
        return service.buscarPorUsuario(id_usuario).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ConjuntoSemanalDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAnyAuthority('USUARIO', 'ADMINISTRADOR')")
    @GetMapping("/buscarPorIdConjunto")
    public List<ConjuntoSemanalDTO> buscarPorIdConjunto(@RequestParam int id_conjunto) {
        return service.buscarporIdConjunto(id_conjunto).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ConjuntoSemanalDTO.class);
        }).collect(Collectors.toList());
    }

    // Query de valor: Obtener el registro mas reciente por usuario
    @PreAuthorize("hasAnyAuthority('USUARIO', 'ADMINISTRADOR')")
    @GetMapping("/registroRecientePorUsuario")
    public ConjuntoSemanal obtenerRegistroMasRecientePorUsuario(@RequestParam int id_usuario) {
        return service.obtenerRegistroMasRecientePorUsuario(id_usuario);
    }

    @GetMapping("/conjuntosporusuariosemanal")
    public List<ConjuntoPorUsuarioDTO> conjuntoporusuario(){
        List<String[]> lista=service.ConjuntosPorUsuario();
        List<ConjuntoPorUsuarioDTO>listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            ConjuntoPorUsuarioDTO dto=new ConjuntoPorUsuarioDTO();
            dto.setUsername(columna[0]);
            dto.setTotal_conjuntos(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/conjuntospordiasemanal")
    public List<ConjuntoDiaSemanaDTO> conjuntopordiasemanal(){
        List<String[]> lista= service.ConjuntosPorDiaDeSemana();
        List<ConjuntoDiaSemanaDTO>listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            ConjuntoDiaSemanaDTO dto=new ConjuntoDiaSemanaDTO();
            dto.setNombreconjunto(columna[0]);
            dto.setTotalDias(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }




}


