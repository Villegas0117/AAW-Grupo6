package pe.edu.upc.avi_aplicaction.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.avi_aplicaction.dtos.PrendasDTO;
import pe.edu.upc.avi_aplicaction.entities.Prendas;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IPrendasService;


import java.time.LocalDate;
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
    public void registrar(@RequestBody PrendasDTO dto) {
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
    public PrendasDTO listarPorId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        PrendasDTO dto=m.map(pR.listPrendaById(id),PrendasDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody PrendasDTO dto){
        ModelMapper m=new ModelMapper();
        Prendas p = m.map(dto, Prendas.class);
        pR.updatePrenda(p);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping("/buscarPorTipoPrenda")
    public List<PrendasDTO> buscarPorTipoPrenda(@RequestParam String tipo_prenda){
        return pR.prendaPorTipo(tipo_prenda).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, PrendasDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping("/buscarPorFechaModificacion")
    public List<PrendasDTO> buscarPorFecha(@RequestParam LocalDate fecha_modificacion){
        return pR.prendaPorFecha(fecha_modificacion).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, PrendasDTO.class);
        }).collect(Collectors.toList());
    }









}
