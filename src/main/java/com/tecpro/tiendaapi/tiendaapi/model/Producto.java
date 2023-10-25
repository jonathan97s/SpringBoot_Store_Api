package com.tecpro.tiendaapi.tiendaapi.model;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "especificaciones")
    private List<String> especificacion;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "disponibilidad")
    private boolean disponible;

    @Column(name = "marca")
    private String marca;

    @Column(name = "url_imagen")
    private String urlImagen;

    @Column(name = "imagen_especificacion")
    private String imagenEspecificacionUrl;

    @Column(name = "destacado")
    private boolean destacado;

    @Column(name = "oferta")
    private int oferta;

    //@ManyToOne
    @Column(name = "categoria")
    private String categoria;

    public Producto() {
    }

    public Producto(String nombre, String descripcion, List<String> especificacion, BigDecimal precio, boolean disponible, String marca, String urlImagen
            , String imagenEspecificacionUrl, boolean destacado, int oferta, String categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.especificacion = especificacion;
        this.precio = precio;
        this.disponible = disponible;
        this.marca = marca;
        this.urlImagen = urlImagen;
        this.imagenEspecificacionUrl = imagenEspecificacionUrl;
        this.destacado = destacado;
        this.oferta = oferta;
        this.categoria = categoria;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(List<String> especificacion) {
        this.especificacion = especificacion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getImagenEspecificacionUrl() {
        return imagenEspecificacionUrl;
    }

    public void setImagenEspecificacionUrl(String imagenEspecificacionUrl) {
        this.imagenEspecificacionUrl = imagenEspecificacionUrl;
    }

    public boolean getDestacado() {
        return destacado;
    }

    public void setDestacado(boolean destacado) {
        this.destacado = destacado;
    }

    public int getOferta() {
        return oferta;
    }

    public void setOferta(int oferta) {
        this.oferta = oferta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto[Id=" + Id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", disponible=" + disponible +
                ", marca='" + marca + '\'' +
                ", urlImagen='" + urlImagen + '\'' +
                ", destacado=" + destacado +
                ", oferta=" + oferta +
                ", categoria='" + categoria + '\'' +
                ']';
    }
}
