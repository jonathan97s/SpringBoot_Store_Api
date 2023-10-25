package com.tecpro.tiendaapi.tiendaapi.model;


import com.tecpro.tiendaapi.tiendaapi.DataBase.Usuario;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "productosCesta")
public class ProductoCesta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "imagen_especificacion")
    private String imagenEspecificacionUrl;

    @Column(name = "entUsuario")
    private long idUsuario;

    public ProductoCesta(String imagenEspecificacionUrl, String nombre, BigDecimal precio, long idUsuario) {
        this.nombre = nombre;
        this.precio = precio;
        this.imagenEspecificacionUrl = imagenEspecificacionUrl;
        this.idUsuario = idUsuario;
    }

    public ProductoCesta() {
    }


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getImagenEspecificacionUrl() {
        return imagenEspecificacionUrl;
    }

    public void setImagenEspecificacionUrl(String imagenEspecificacionUrl) {
        this.imagenEspecificacionUrl = imagenEspecificacionUrl;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
