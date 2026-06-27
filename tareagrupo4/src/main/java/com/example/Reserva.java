package com.example;

import java.time.LocalDate;

public class Reserva {

    private int id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private EstadoReserva estadoReserva;
    private INotificacion notificador;
    private boolean esRecurrente;
    private FrecuenciaReserva frecuencia;
    private IMetodoPago metodoPago;

    public void confirmar() {

    }

    public void cancelar() {

    }

    public double calcularMonto() {

    }

    public void programarRecurrencia() {

    }
}
