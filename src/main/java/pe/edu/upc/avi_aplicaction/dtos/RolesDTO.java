package pe.edu.upc.avi_aplicaction.dtos;

import pe.edu.upc.avi_aplicaction.entities.Users;

public class RolesDTO {

    private Long id;
    private String rol;
    private Users user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
