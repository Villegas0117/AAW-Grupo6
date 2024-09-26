package pe.edu.upc.avi_aplicaction.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.avi_aplicaction.dtos.TendenciaDTO;
import pe.edu.upc.avi_aplicaction.dtos.UsersNoPassDTO;
import pe.edu.upc.avi_aplicaction.entities.Tendencia;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.ITendenciasService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tendencias")
public class TendenciaController {

    @Autowired
    private ITendenciasService service;

    @GetMapping
    public List<TendenciaDTO> listar() {
        return service.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TendenciaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody TendenciaDTO dto) {
        ModelMapper m = new ModelMapper();
        Tendencia tendencia = m.map(dto, Tendencia.class);
        service.insert(tendencia);
    }

    @GetMapping("/{id}")
    public TendenciaDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(service.listId(id), TendenciaDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody TendenciaDTO dto) {
        ModelMapper m = new ModelMapper();
        Tendencia tendencia = m.map(dto, Tendencia.class);
        service.update(tendencia);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        service.delete(id);
    }

    // Consultas personalizadas
    @GetMapping("/buscarPorCategoria")
    public List<TendenciaDTO> buscarPorCategoria(@RequestParam String categoria) {
        return service.buscarPorCategoria(categoria).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TendenciaDTO.class);
        }).collect(Collectors.toList());
    }


}
