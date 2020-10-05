package com.example.inventario.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Producto implements Serializable {
        private Integer id;
        private String nombre;
        private  String descripcion;
        private String fecha;
        private String marca;
        private Integer tipo;
        private Integer cantidad;
        private Double precio;
        private String codigo;

    public Producto() {
    }

    public Producto(Integer id, String nombre, String descripcion, String fecha, String marca, Integer tipo, Integer cantidad, Double precio, String codigo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.marca = marca;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.codigo = codigo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
