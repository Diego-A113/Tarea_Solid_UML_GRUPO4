package com.example;

public class Usuario {
    private int id;
    private String nombre;
    private String correo;
    private String telefono;

    public Usuario(int id, String nombre, String correo, String telefono){
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getNombre(){
        return nombre;
    }

    /* 
    public void registrarMascota(){
        //Añadir logica si es necesario
    }

    public Reserva crearReserva(){

    }

    public void cancelarReserva(){

    }

    public void reportarIncidente(){

    }

    public List<Reserva> consultarReservas(){

    } */

}
