package pe.edu.upc.avi_aplicaction.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.avi_aplicaction.dtos.ConjuntoSemanalDTO;
import pe.edu.upc.avi_aplicaction.entities.ConjuntoSemanal;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IConjuntosDiaService;


import java.time.DayOfWeek;
import java.time.LocalDateTime;
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





}


