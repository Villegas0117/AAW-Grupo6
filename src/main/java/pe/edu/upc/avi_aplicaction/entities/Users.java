package pe.edu.upc.avi_aplicaction.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table  (name = "usuarios")

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;

    @Column(name = "nombre_usuario", nullable = false,length = 25)
    private String nombre_usuario;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "contrasena",nullable = false)
    private String contrasena;


    @ManyToOne
    @JoinColumn(name = "id_Rol")
    private roles id_Rol;//FK

    @Column(name = "fecha_creacion")
    private LocalDate fecha_registro;

    @Column(name = "fecha_modificacion")
    private LocalDate fecha_modificacion;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public roles getId_Rol() {
        return id_Rol;
    }

    public void setId_Rol(roles id_Rol) {
        this.id_Rol = id_Rol;
    }



    public LocalDate getFecha_registro() {
        return fecha_registro;
    }



    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public LocalDate getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(LocalDate fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public Users() {
    }

    public Users(int id_usuario, String nombre_usuario, String email, String contrasena, roles id_Rol, LocalDate fecha_registro, LocalDate fecha_modificacion) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.email = email;
        this.contrasena = contrasena;
        this.id_Rol = id_Rol;
        this.fecha_registro = fecha_registro;
        this.fecha_modificacion = fecha_modificacion;
    }
}
