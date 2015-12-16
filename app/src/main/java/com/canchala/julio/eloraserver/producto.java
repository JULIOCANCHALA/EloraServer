package com.canchala.julio.eloraserver;

/**
 * Created by Julio on 16/12/2015.
 */
public class producto {
    private String nombre;
    private String cantidad;
    private String costo;
    private String fabricante;
    private String tipo;

    public producto(String nombre, String cantidad, String costo, String fabricante, String tipo) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costo = costo;
        this.fabricante = fabricante;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public String getCosto() {
        return costo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getTipo() {
        return tipo;
    }
}

