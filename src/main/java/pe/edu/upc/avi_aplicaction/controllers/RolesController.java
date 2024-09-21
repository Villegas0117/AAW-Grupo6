
package pe.edu.upc.avi_aplicaction.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.avi_aplicaction.dtos.RolesDTO;
import pe.edu.upc.avi_aplicaction.entities.roles;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IRolesService;


import java.util.List;


import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private IRolesService rR;

    @GetMapping
    public List<RolesDTO> listar(){
        return rR.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, RolesDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void registrar(@RequestBody RolesDTO dto) {
        ModelMapper m = new ModelMapper();
        roles d = m.map(dto, roles.class);
        rR.insert(d);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        rR.delete(id);
    }

    @GetMapping("/{id}")
    public RolesDTO listarId(@PathVariable("id") Long id) {
        ModelMapper m=new ModelMapper();
        RolesDTO dto=m.map(rR.listId(id),RolesDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody RolesDTO dto) {
        ModelMapper m = new ModelMapper();
        roles d = m.map(dto, roles.class);
        rR.update(d);
    }

    @GetMapping("/buscarRol")
    public List<RolesDTO> buscar(@RequestParam String rol) {
        return rR.buscar(rol).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,RolesDTO.class);
        }).collect(Collectors.toList());
    }


}
