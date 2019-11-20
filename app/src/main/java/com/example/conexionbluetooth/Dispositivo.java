package com.example.conexionbluetooth;

class Dispositivo {

    String nombre;
    String mac;
    boolean isCheck;

    public Dispositivo(String nombre, String mac, boolean isCheck) {
        this.nombre = nombre;
        this.mac = mac;
        this.isCheck = isCheck;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}
