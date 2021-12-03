package com.example.finalmultimedia;

public class ChatP {
    public String mensaje_enviadoXML;
    public String horaMensaje;
    public String idMensaje;

    public String getMensaje_enviadoXML(){
        return mensaje_enviadoXML;
    }
    public void  setMensaje_enviadoXML(String mensaje_enviadoXML){
        this.mensaje_enviadoXML = mensaje_enviadoXML;
    }

    public String getHoraMensaje(){
        return horaMensaje;
    }
    public void  setHoraMensaje(String horaMensaje){
        this.horaMensaje = horaMensaje;
    }

    public String getIdMensaje(){
        return idMensaje;
    }
    public void setIdMensaje(String idMensaje){
        this.idMensaje = idMensaje;
    }
}
