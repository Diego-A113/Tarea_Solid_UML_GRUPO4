package com.example;

public class Cuidador {

    private int id;
    private String nombre;
    private String especialidad;
    private Centro centro;

    public void atenderMascotas(Mascota mascota) {
        System.out.println("Atendiendo mascota: " + mascota.getNombre());
    }

    public String generarComentario() {
        return "Comentarios...";
    }
}
