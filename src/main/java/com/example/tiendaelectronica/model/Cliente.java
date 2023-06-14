package com.example.tiendaelectronica.model;

public class Cliente {
    private String nombre_cliente;
    private String rut;
    private String mail;

    public Cliente(String nombre_cliente, String rut, String mail) {
        this.nombre_cliente = nombre_cliente;
        this.rut = rut;
        this.mail = mail;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Cliente: "+this.nombre_cliente +", "+this.rut+", "+this.mail;
    }
}
