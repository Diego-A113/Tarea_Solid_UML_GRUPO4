package com.example;

import java.util.List;

public class Mascota {

    private int id;
    private String nombre;
    private String especie;
    private String raza;
    private String tamano;
    private int edad;
    private List<String> necesidadesEspeciales;
    private List<String> preferenciasTrato;
    private List<AlertaSalud> alertas;
    private Usuario propietario;

    public void actualizarDatos(String nuevoNombre, String nuevaRaza, String nuevoTamano, int nuevaEdad,
            List<String> nuevasNecesidades, List<String> nuevasPreferencias) {

        if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
            this.nombre = nuevoNombre;
        }
        if (nuevaRaza != null && !nuevaRaza.trim().isEmpty()) {
            this.raza = nuevaRaza;
        }
        if (nuevoTamano != null && !nuevoTamano.trim().isEmpty()) {
            this.tamano = nuevoTamano;
        }

        if (nuevaEdad >= 0) {
            this.edad = nuevaEdad;
        }

        if (nuevasNecesidades != null) {
            this.necesidadesEspeciales = nuevasNecesidades;
        }
        if (nuevasPreferencias != null) {
            this.preferenciasTrato = nuevasPreferencias;
        }
    }

    public String getTamano() {
        return tamano;
    }

    public String getRaza() {
        return raza;
    }

    public String getNombre() {
        return nombre;
    }
}
