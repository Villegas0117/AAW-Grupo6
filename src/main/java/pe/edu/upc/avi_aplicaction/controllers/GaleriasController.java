package pe.edu.upc.avi_aplicaction.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.avi_aplicaction.dtos.GaleriasDTO;
import pe.edu.upc.avi_aplicaction.dtos.PrendasDTO;
import pe.edu.upc.avi_aplicaction.dtos.UsersDTO;
import pe.edu.upc.avi_aplicaction.entities.Galerias;
import pe.edu.upc.avi_aplicaction.entities.Prendas;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IGaleriasService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("(/galerias")
public class GaleriasController {
    @Autowired
    private IGaleriasService galeriasService;

    @PostMapping
    public void registrar(@RequestBody GaleriasDTO dto) {
        ModelMapper m = new ModelMapper();
        Galerias p = m.map(dto, Galerias.class);
        galeriasService.insertar(p);
    }

    @GetMapping
    public List<GaleriasDTO> listar(){
        return galeriasService.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, GaleriasDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){galeriasService.deleteGaleria(id);}


    @GetMapping("/{id}")
    public UsersDTO listarPorId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        UsersDTO dto=m.map(galeriasService.listGaleriaById(id),UsersDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody GaleriasDTO dto){
        ModelMapper m=new ModelMapper();
        Galerias p = m.map(dto, Galerias.class);
        galeriasService.updateGalerias(p);
    }

}
