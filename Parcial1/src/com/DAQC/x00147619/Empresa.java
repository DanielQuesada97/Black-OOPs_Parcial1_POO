package com.DAQC.x00147619;

import java.util.ArrayList;
import java.util.List;


public class Empresa{
    private String nombre;
    private List<Empleado> planilla = new ArrayList<>();


    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Empleado> getPlanilla() {
        return planilla;
    }

    public void addEmpleado(Empleado empleado){
        planilla.add(empleado);
    }

    public void quitEmpleado(String nombre){
        planilla.removeIf(s -> s.getNombre().equals(nombre));
    }
}


