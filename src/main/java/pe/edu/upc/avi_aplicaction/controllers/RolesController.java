package pe.edu.upc.avi_aplicaction.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.avi_aplicaction.dtos.RolesDTO;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IRolesService;


import java.util.List;


import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolesController {

    @Autowired

    @GetMapping
    public List<RolesDTO> listar(){
            ModelMapper m=new ModelMapper();
            return m.map(x, RolesDTO.class);
        }).collect(Collectors.toList());
    }

}
