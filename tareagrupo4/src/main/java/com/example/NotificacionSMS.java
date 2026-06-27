package com.example;

public class NotificacionSMS implements INotificacion {

    @Override
    public void enviar(Usuario usuario, String mensaje) {
        System.out.println("Enviando SMS a: " + usuario.getNombre() + ", Mensaje:" + mensaje);
    }

}
