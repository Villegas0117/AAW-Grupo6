package pe.edu.upc.avi_aplicaction.controllers;

import jakarta.validation.OverridesAttribute;
import jakarta.validation.groups.ConvertGroup;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.avi_aplicaction.dtos.GaleriaDTO;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IGaleriaService;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/galerias")
public class GaleriaController {

    @Autowired
    private IGaleriaService gS;
    @GetMapping
    public List<GaleriaDTO> listar(){
        return gS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,GaleriaDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody GaleriaDTO dto){
        ModelMapper m = new ModelMapper();
        Galeria ga = m.map(dto, Galeria.class);
        gS.inert(ga);
    }
    @GetMapping("/{id}")
    public GaleriaDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        GaleriaDTO dto = m.map(gS.listId(id),GaleriaDTO.class);

        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody GaleriaDTO dto){
        ModelMapper m = new ModelMapper();
        Galeria ga = m.map(dto, Galeria.class);
        gS.update(ga);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        gS.delete(id);
    }

    @GetMapping("/busquedas")
    public List<GaleriaDTO> buscar(@RequestParam String nombre){

        return gS.buscarnombre(nombre).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return  m.map(x,GaleriaDTO.class);
        }).collect(Collectors.toList());
    }
}
