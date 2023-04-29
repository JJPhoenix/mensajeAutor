package pe.edu.pucp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Autor {
    @Id
    @GeneratedValue
    @Column(name = "autor_id")
    Long id;
    @Column(name = "email",nullable = false,unique = true)
    private String correo;
    private String nombre;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Mensaje> mensajes = new HashSet<Mensaje>();

    @Version
    private int version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(Set<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Autor() {}

    public Autor(String correo, String nombre) {
        this.correo = correo;
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", correo='" + correo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", mensajes=" + mensajes +
                '}';
    }
}
