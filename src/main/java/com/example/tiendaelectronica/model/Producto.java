package com.example.tiendaelectronica.model;

public class Producto {
    private String nombre_producto;
    private String tipo;
    private int peso;
    private int precio;

    public Producto(String nombre_producto, String tipo, int peso, int precio) {
        this.nombre_producto = nombre_producto;
        this.tipo = tipo;
        this.peso = peso;
        this.precio = precio;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto: "+this.nombre_producto +", "+this.tipo+", "+this.peso+", "+this.precio;
    }
}
