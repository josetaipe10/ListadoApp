package com.example.appdelivery.modelos;

public class Comida {
    private String nombrecomida;
    private String descripcioncomida;
    private String preciocomida;
    private int imagencomida;

    public Comida(String nombrecomida) { }

    public Comida(String nombrecomida, String descripcioncomida, String preciocomida) {
        this.nombrecomida = nombrecomida;
        this.descripcioncomida = descripcioncomida;
        this.preciocomida = preciocomida;
        this.imagencomida = imagencomida;
    }

    public String getNombrecomida() {
        return nombrecomida;
    }

    public void setNombrecomida(String nombrecomida) {
        this.nombrecomida = nombrecomida;
    }

    public String getDescripcioncomida() {
        return descripcioncomida;
    }

    public void setDescripcioncomida(String descripcioncomida) {
        this.descripcioncomida = descripcioncomida;
    }

    public String getPreciocomida() {
        return preciocomida;
    }

    public void setPreciocomida(String preciocomida) {
        this.preciocomida = preciocomida;
    }

    public int getImagencomida() {
        return imagencomida;
    }

    public void setImagencomida(int imagencomida) {
        this.imagencomida = imagencomida;
    }
}
