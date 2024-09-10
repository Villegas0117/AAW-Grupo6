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
    private IRecomendacionesService rR;

    @PostMapping
    public void registrar(@RequestBody RecomendacionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Recomendaciones p = m.map(dto, Recomendaciones.class);
        rR.insertar_Recomendacion(p);
    }

    @GetMapping
    public List<RecomendacionesDTO> listar(){
        return rR.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, RecomendacionesDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){rR.deleteRecomendacion(id);}


    @GetMapping("/{id}")
    public RecomendacionesDTO listarPorId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        RecomendacionesDTO dto=m.map(rR.listRecomendacionById(id),RecomendacionesDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody RecomendacionesDTO dto){// Corrección RecomendacionesDTO - UsersDTO
        ModelMapper m=new ModelMapper();
        Recomendaciones r = m.map(dto, Recomendaciones.class);
        rR.updateRecomendacion(r);
    }

    @GetMapping("/BuscarRecomendacionesPorIdUsuario")
    public List<RecomendacionesDTO> BuscarPorUsuario(@RequestParam int idUsuario) {
        return rR.getRecomendacionesByUserId(idUsuario).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, RecomendacionesDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/BuscarRecomendacionesPorIdTendencia")
    public List<RecomendacionesDTO> BuscarPorTendencia(@RequestParam int idTendencia) {
        return rR.getRecomendacionesByTrendId(idTendencia).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, RecomendacionesDTO.class);
        }).collect(Collectors.toList());
    }
}
