package pe.edu.upc.avi_aplicaction.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.avi_aplicaction.dtos.UsersDTO;
import pe.edu.upc.avi_aplicaction.dtos.UsersNoPassDTO;
import pe.edu.upc.avi_aplicaction.entities.Users;
import pe.edu.upc.avi_aplicaction.serviceinterfaces.IUsersService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsersController {
    @Autowired
    private IUsersService uR;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','CREADOR')")
    @PostMapping
    public void registrar(@RequestBody UsersDTO dto) {
        ModelMapper m = new ModelMapper();
        Users u = m.map(dto, Users.class);
        String encodedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPassword);
        uR.insertUser(u);
    }

    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','CREADOR')")
    @GetMapping
    public List<UsersNoPassDTO> listar(){
        return uR.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, UsersNoPassDTO.class);
        }).collect(Collectors.toList());
    }


    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','CREADOR')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id){uR.deleteUser(id);}

    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','CREADOR')")
    @GetMapping("/{id}")
    public UsersNoPassDTO listarPorId(@PathVariable("id") Long id){
        ModelMapper m=new ModelMapper();
        UsersNoPassDTO dto=m.map(uR.listUserById(id),UsersNoPassDTO.class);
        return dto;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @PutMapping
    public void modificar(@RequestBody UsersDTO dto){
        ModelMapper m = new ModelMapper();
        Users u = m.map(dto, Users.class);
        String encodedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPassword);
        uR.updateUser(u);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping("/buscarUsuario")
    public List<UsersDTO> buscarUsuario(@RequestParam String email){
        return uR.searchUser(email).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, UsersDTO.class);
        }).collect(Collectors.toList());
    }

}
