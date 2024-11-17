package pe.edu.upc.avi_aplicaction.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.avi_aplicaction.dtos.ConjuntosDTO;
import pe.edu.upc.avi_aplicaction.dtos.RolesDTO;
import pe.edu.upc.avi_aplicaction.entities.Conjuntos;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IConjuntosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/conjuntos")
public class ConjuntosController {

    @Autowired
    private IConjuntosService cs;

    @PreAuthorize("hasAuthority('CREADOR')")
    @GetMapping
    public List<ConjuntosDTO> listar(){
        return cs.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,ConjuntosDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody ConjuntosDTO dto) {
        ModelMapper m = new ModelMapper();
        Conjuntos c = m.map(dto, Conjuntos.class);
        cs.insert(c);
    }

    @PreAuthorize("hasAuthority('CREADOR')")
    @GetMapping("/{id}")
    public ConjuntosDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        ConjuntosDTO dto=m.map(cs.listId(id),ConjuntosDTO.class);
        return dto;
    }


    @PutMapping
    public void modificar(@RequestBody ConjuntosDTO dto) {
        ModelMapper m = new ModelMapper();
        Conjuntos c = m.map(dto, Conjuntos.class);
        cs.update(c);
    }
    @GetMapping("/buscarConjunto")
    public List<ConjuntosDTO> buscar(@RequestParam String nombreConjunto) {
        return cs.buscar(nombreConjunto).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,ConjuntosDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        cs.delete(id);
    }


    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping("/buscarUltimosModificados")
    public List<ConjuntosDTO> buscarUltimosModificados() {
        return cs.buscarUltimosModificados().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ConjuntosDTO.class);
        }).collect(Collectors.toList());
    }



}
