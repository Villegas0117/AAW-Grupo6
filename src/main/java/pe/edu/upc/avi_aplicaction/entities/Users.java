package pe.edu.upc.avi_aplicaction.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import javax.management.relation.Role;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table  (name = "usuarios")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 25, unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String password;
    private Boolean enabled;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<roles> roles;

    @Column(name = "fecha_creacion")
    private LocalDate fecha_registro;

    @Column(name = "fecha_modificacion")
    private LocalDate fecha_modificacion;

    public Users() {
    }

    public Users(Long id, String username, String email, String password, Boolean enabled, List<pe.edu.upc.avi_aplicaction.entities.roles> roles, LocalDate fecha_registro, LocalDate fecha_modificacion) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
        this.fecha_registro = fecha_registro;
        this.fecha_modificacion = fecha_modificacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<pe.edu.upc.avi_aplicaction.entities.roles> getRoles() {
        return roles;
    }

    public void setRoles(List<pe.edu.upc.avi_aplicaction.entities.roles> roles) {
        this.roles = roles;
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
}
