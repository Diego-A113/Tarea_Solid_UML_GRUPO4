package com.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class Reserva {

    private int id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private INotificacion notificador;
    private boolean esRecurrente;
    private FrecuenciaReserva frecuencia;
    private IMetodoPago metodoPago;
    private Usuario cliente;
    private Mascota mascota;
    private List<IServicio> servicios;
    private List<LocalDate> fechasAsistencia;

    public void confirmar() {
        for (LocalDate fecha : fechasAsistencia) {
            for (IServicio servicio : servicios) {
                if (servicio.verificarDisponibilidad(fecha)) {
                    servicio.cambiarEstadoPorFecha(fecha, EstadoReserva.OCUPADO);
                } else {
                    System.out.println("Alerta: El servicio " + servicio.getNombre() + " ya está ocupado para el " + fecha);
                }
            }
        }
        System.out.println("¡Proceso de confirmación completado!");
    }

    public void cancelar() {
        for (LocalDate fecha : fechasAsistencia) {
            for (IServicio servicio : servicios) {
                servicio.cambiarEstadoPorFecha(fecha, EstadoReserva.CANCELADO);
            }
        }
        System.out.println("Reserva cancelada con éxito. Cupos liberados.");
    }

    public double calcularMonto() {
        double totalServicios = 0;
        for (IServicio servicio : servicios) {
            totalServicios += servicio.calcularPrecio();
        }

        if (!esRecurrente) {
            long diasUnicos = fechaInicio.until(fechaFin).getDays() + 1;
            return totalServicios * diasUnicos;
        }

        return totalServicios * fechasAsistencia.size();
    }

    public void programarRecurrencia() {
        if (this.frecuencia != FrecuenciaReserva.DIARIA) {
            return;
        }
        this.esRecurrente = true;
        this.fechasAsistencia.clear();

        LocalDate actual = fechaInicio;
        while (!actual.isAfter(fechaFin)) {
            this.fechasAsistencia.add(actual);
            actual = actual.plusDays(1);
        }
    }

    public void programarRecurrencia(Set<DayOfWeek> diasSemana) {
        if (this.frecuencia != FrecuenciaReserva.SEMANAL) {
            return;
        }
        this.esRecurrente = true;
        this.fechasAsistencia.clear();

        LocalDate actual = fechaInicio;
        while (!actual.isAfter(fechaFin)) {
            if (diasSemana.contains(actual.getDayOfWeek())) {
                this.fechasAsistencia.add(actual);
            }
            actual = actual.plusDays(1);
        }
    }

    public void programarRecurrencia(int diaDelMes) {
        if (this.frecuencia != FrecuenciaReserva.MENSUAL) {
            return;
        }
        this.esRecurrente = true;
        this.fechasAsistencia.clear();

        LocalDate actual = fechaInicio;
        while (!actual.isAfter(fechaFin)) {
            if (actual.getDayOfMonth() == diaDelMes) {
                this.fechasAsistencia.add(actual);
            }
            actual = actual.plusDays(1);
        }
    }

    public void programarRecurrencia(List<LocalDate> fechasEspecificas) {
        if (this.frecuencia != FrecuenciaReserva.PERSONALIZADA) {
            return;
        }
        this.esRecurrente = true;
        this.fechasAsistencia.clear();
        this.fechasAsistencia.addAll(fechasEspecificas);
    }

    public int getId() {
        return id;
    }

    public List<LocalDate> getFechasAsistencia() {
        return fechasAsistencia;
    }

    public List<IServicio> getServicios() {
        return servicios;
    }
}
