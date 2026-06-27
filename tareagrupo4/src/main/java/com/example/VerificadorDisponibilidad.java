package com.example;

import java.util.Date;

public class VerificadorDisponibilidad implements IVerificadorDisponibilidad {
    private int id;
    private Date fecha;
    private boolean cuposDisponibles;
    private int personalDisponible;
    private EstadoReserva estadoReserva;

    @Override
    public boolean verificar(Reserva reserva){
        //codigo
        return true;
    }

    public boolean hayCupos(){
        //codigo
        return cuposDisponibles;
        
    }

    public void actualizarCupos(){
        //codigo
    }
}
