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
    private Usuario cliente;
    private Mascota mascota;
    private List<IServicio> servicios;
    private PoliticaCancelacion politicaCancelacion;

    public void confirmar() {

    }

    public void cancelar() {

    }

    public double calcularMonto() {

    }

    public void programarRecurrencia() {

    }
}
