package pe.edu.upc.avi_aplicaction.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.avi_aplicaction.dtos.*;
import pe.edu.upc.avi_aplicaction.entities.Galerias;
import pe.edu.upc.avi_aplicaction.entities.Prendas;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IGaleriasService;

import java.time.LocalDate;
import java.util.ArrayList;
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
    public GaleriasDTO listarPorId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        GaleriasDTO dto=m.map(galeriasService.listGaleriaById(id),GaleriasDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody GaleriasDTO dto){
        ModelMapper m=new ModelMapper();
        Galerias p = m.map(dto, Galerias.class);
        galeriasService.updateGalerias(p);
    }

    @GetMapping("/galeríaReciente")
    public List<GaleriaUserDTO> galeriareciente(){
        List<String[]> lista=galeriasService.GaleriaMasReciente();
        List<GaleriaUserDTO>listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            GaleriaUserDTO dto=new GaleriaUserDTO();
            dto.setNombre_usuario(columna[0]);
            dto.setNombreGaleria(columna[1]);
            dto.setFechaCreacion(LocalDate.parse(columna[2]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
    @GetMapping("/galeríaPorUsuario")
    public List<GaleriaTotalUsuarioDTO> galeriaporusuario(){
        List<String[]> lista=galeriasService.GaleriaPorUsuario();
        List<GaleriaTotalUsuarioDTO>listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            GaleriaTotalUsuarioDTO dto=new GaleriaTotalUsuarioDTO();
            dto.setNombre_usuario(columna[0]);
            dto.setTotal_galerias(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }



}
