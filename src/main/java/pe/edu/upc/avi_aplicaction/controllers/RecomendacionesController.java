package pe.edu.upc.avi_aplicaction.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.avi_aplicaction.dtos.RecomendacionesDTO;
import pe.edu.upc.avi_aplicaction.dtos.UsersDTO;
import pe.edu.upc.avi_aplicaction.entities.Recomendaciones;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IRecomendacionesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recomendaciones")
public class RecomendacionesController {
    @Autowired
    private IRecomendacionesService rS;

    @PostMapping
    public void registrar(@RequestBody RecomendacionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Recomendaciones p = m.map(dto, Recomendaciones.class);
        rS.insertar_Recomendacion(p);
    }

    @GetMapping
    public List<RecomendacionesDTO> listar(){
        return rS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, RecomendacionesDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){rS.deleteRecomendacion(id);}


    @GetMapping("/{id}")
    public RecomendacionesDTO listarPorId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        RecomendacionesDTO dto=m.map(rS.listRecomendacionById(id),RecomendacionesDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody UsersDTO dto){
        ModelMapper m=new ModelMapper();
        Recomendaciones r = m.map(dto, Recomendaciones.class);
        rS.updateRecomendacion(r);
    }
}
