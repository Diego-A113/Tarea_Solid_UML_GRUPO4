package com.example;

public class NotificacionEmail implements INotificacion {

    @Override
    public void enviar(Usuario usuario, String mensaje) {
        System.out.println("Enviando Email a: " + usuario.getNombre() + ", Mensaje:" + mensaje);
    }

}
