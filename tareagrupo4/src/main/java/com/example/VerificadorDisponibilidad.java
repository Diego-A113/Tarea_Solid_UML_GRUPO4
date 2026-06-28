package com.example;

import java.time.LocalDate;
import java.util.Date;

public class VerificadorDisponibilidad implements IVerificadorDisponibilidad {

    private int id;
    private Date fecha;
    private boolean cuposDisponibles;
    private int personalDisponible;
    private EstadoReserva estadoReserva;

    @Override
    public boolean verificar(Reserva reserva) {
        if (reserva == null) {
            return false;
        }

        if (this.personalDisponible <= 0) {
            this.cuposDisponibles = false;
            return false;
        }

        for (LocalDate fechaAsistencia : reserva.getFechasAsistencia()) {
            for (IServicio servicio : reserva.getServicios()) {

                if (!servicio.verificarDisponibilidad(fechaAsistencia)) {
                    return false;
                }
            }
        }

        this.cuposDisponibles = true;
        return true;
    }

    public boolean hayCupos() {
        return this.cuposDisponibles;
    }

    public void actualizarCupos() {
        if (this.personalDisponible > 0) {
            this.personalDisponible--;
        }

        this.cuposDisponibles = this.personalDisponible > 0;
    }
}
