package pe.edu.upc.avi_aplicaction.controllers;

import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.avi_aplicaction.dtos.UsersDTO;
import pe.edu.upc.avi_aplicaction.entities.Users;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IUsersService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsersController {
    @Autowired
    private IUsersService uR;

    @PostMapping
    public void registrar(@RequestBody UsersDTO dto) {
        ModelMapper m = new ModelMapper();
        Users u = m.map(dto, Users.class);
        uR.insertUser(u);
    }



    @GetMapping
    public List<UsersDTO> listar(){
        return uR.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, UsersDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){uR.deleteUser(id);}

    @GetMapping("/{id}")
    public UsersDTO listarPorId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        UsersDTO dto=m.map(uR.listUserById(id),UsersDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody UsersDTO dto){
        ModelMapper m=new ModelMapper();
        Users u = m.map(dto, Users.class);
        uR.updateUser(u);
    }

    @GetMapping("/buscarUsuario")
    public List<UsersDTO> buscarUsuario(@RequestParam String email){
        return uR.searchUser(email).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, UsersDTO.class);
        }).collect(Collectors.toList());
    }


}
