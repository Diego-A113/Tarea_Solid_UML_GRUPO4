package com.example;

public class NotificacionApp implements INotificacion{
    @Override
    public void enviar(Usuario usuario, String mensaje){
        System.out.println("Enviando Notificacion en la APP a: "+usuario.getNombre()+", Mensaje:"+mensaje);
    }

}
