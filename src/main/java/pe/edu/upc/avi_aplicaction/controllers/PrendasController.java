package pe.edu.upc.avi_aplicaction.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.avi_aplicaction.dtos.PrendasDTO;
import pe.edu.upc.avi_aplicaction.dtos.UsersDTO;
import pe.edu.upc.avi_aplicaction.dtos.UsersDTONoPassword;
import pe.edu.upc.avi_aplicaction.entities.Prendas;
import pe.edu.upc.avi_aplicaction.entities.Users;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IPrendasService;

import java.util.List;
import java.util.stream.Collectors;

//Anotaciones para declarar que esta clase es de tipo API REST
@RestController
@RequestMapping("/prendas")
public class PrendasController {
    //Nuevamente se realiza la inyección de dependencias
    @Autowired
    private IPrendasService pR;

    @PostMapping
    public void registrar(@RequestBody UsersDTO dto) {
        ModelMapper m = new ModelMapper();
        Prendas p = m.map(dto, Prendas.class);
        pR.insertar_Prendas(p);
    }

    @GetMapping
    public List<PrendasDTO> listar(){
        return pR.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, PrendasDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){pR.deletePrenda(id);}


    @GetMapping("/{id}")
    public UsersDTO listarPorId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        UsersDTO dto=m.map(pR.listPrendaById(id),UsersDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody PrendasDTO dto){
        ModelMapper m=new ModelMapper();
        Prendas p = m.map(dto, Prendas.class);
        pR.updatePrenda(p);
    }

    @PreAuthorize("hasAuthority('USUARIO')")
    @GetMapping("/buscarPrendaTemporada")
    public List<PrendasDTO> buscarPrendaTemporada(@RequestParam String temporada){
        return pR.searchPrendasTemp(temporada).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, PrendasDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('USUARIO')")
    @GetMapping("/buscarPrendaPorTipo")
    public List<PrendasDTO> buscarPrendaPorTipo(@RequestParam String temporada){
        return pR.searchPorTipo(temporada).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, PrendasDTO.class);
        }).collect(Collectors.toList());
    }

}
