package pe.edu.upc.avi_aplicaction.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.avi_aplicaction.dtos.ConjuntoDiaDTO;
import pe.edu.upc.avi_aplicaction.entities.ConjuntoDia;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IConjuntosDiaService;


import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/conjunto-dia")
public class ConjuntoDiaController {

    @Autowired
    private IConjuntosDiaService service;

    @PreAuthorize("hasAnyAuthority('USUARIO', 'ADMINISTRADOR')")
    @GetMapping
    public List<ConjuntoDiaDTO> listar(){
        return service.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ConjuntoDiaDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAnyAuthority('USUARIO', 'ADMINISTRADOR')")
    @PostMapping
    public void registrar(@RequestBody ConjuntoDiaDTO dto) {
        ModelMapper m = new ModelMapper();
        ConjuntoDia conjuntoDia = m.map(dto, ConjuntoDia.class);
        service.insert(conjuntoDia);
    }

    @PreAuthorize("hasAnyAuthority('USUARIO', 'ADMINISTRADOR')")
    @GetMapping("/{id}")
    public ConjuntoDiaDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(service.listId(id), ConjuntoDiaDTO.class);
    }

    @PreAuthorize("hasAnyAuthority('USUARIO', 'ADMINISTRADOR')")
    @PutMapping
    public void modificar(@RequestBody ConjuntoDiaDTO dto) {
        ModelMapper m = new ModelMapper();
        ConjuntoDia conjuntoDia = m.map(dto, ConjuntoDia.class);
        service.update(conjuntoDia);
    }

    @PreAuthorize("hasAnyAuthority('USUARIO', 'ADMINISTRADOR')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        service.delete(id);
    }


    // Consultas personalizadas
    @PreAuthorize("hasAnyAuthority('USUARIO', 'ADMINISTRADOR')")
    @GetMapping("/buscarPorUsuario")
    public List<ConjuntoDiaDTO> buscarPorUsuario(@RequestParam int id_usuario) {
        return service.buscarPorUsuario(id_usuario).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ConjuntoDiaDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAnyAuthority('USUARIO', 'ADMINISTRADOR')")
    @GetMapping("/buscarPorIdConjunto")
    public List<ConjuntoDiaDTO> buscarPorIdConjunto(@RequestParam int id_conjunto) {
        return service.buscarporIdConjunto(id_conjunto).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ConjuntoDiaDTO.class);
        }).collect(Collectors.toList());
    }


    //Listar por semana el conjunto: método realizado por Linda
    @PreAuthorize("hasAnyAuthority('USUARIO', 'ADMINISTRADOR')")
    @GetMapping("/buscarPorSemana")
    public List<ConjuntoDiaDTO> buscarPorSemana() {
        LocalDateTime ahora = LocalDateTime.now(); // Obtener la fecha y hora actual
        LocalDateTime inicioSemana = ahora.with(DayOfWeek.MONDAY).toLocalDate().atStartOfDay();
        LocalDateTime finSemana = ahora.with(DayOfWeek.SUNDAY).toLocalDate().atTime(23, 59, 59);

        return service.buscarPorFechaCreacion(inicioSemana, finSemana).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ConjuntoDiaDTO.class);
        }).collect(Collectors.toList());
    }
}
