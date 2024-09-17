package pe.edu.upc.avi_aplicaction.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.avi_aplicaction.dtos.PrendasConjuntosDTO;
import pe.edu.upc.avi_aplicaction.entities.PrendasConjuntos;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IPrendasConjuntosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/prendasconjuntos")
public class PrendasConjuntosController {

    @Autowired
    private IPrendasConjuntosService cs;

    @GetMapping
    public List<PrendasConjuntosDTO> listar(){
        return cs.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,PrendasConjuntosDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody PrendasConjuntosDTO dto) {
        ModelMapper m = new ModelMapper();
        PrendasConjuntos pc = m.map(dto, PrendasConjuntos.class);
        cs.insert(pc);
    }

    @GetMapping("/{id}")
    public PrendasConjuntosDTO listarById(Integer id){
        ModelMapper m = new ModelMapper();
        PrendasConjuntosDTO dto=m.map(cs.listById(id),PrendasConjuntosDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody PrendasConjuntosDTO dto) {
        ModelMapper m = new ModelMapper();
        PrendasConjuntos c = m.map(dto, PrendasConjuntos.class);
        cs.updatePrendasConjuntos(c);
    }


    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        cs.deletePrendasConjuntos(id);
    }


}
