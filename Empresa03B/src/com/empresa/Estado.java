package com.empresa;

public enum Estado { 
    A("Activo"), I("Inactivo"), B("Baja"), V("Vacaciones");
    
    private String estado;      
    
    private Estado(String estado){
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}
