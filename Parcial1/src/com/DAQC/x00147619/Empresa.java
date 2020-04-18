package com.DAQC.x00147619;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Empresa {
    private String nombre;
    private List<Empleado> planilla;

    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Empleado> getPlanilla() {
        return planilla;
    }

    public void addEmpleado(Empleado nuevoEmpleado){
        List<Empleado> nuevoEmpleadoList = nuevoEmpleado;

        planilla.add(new nuevoEmpleadoList);
    }

    public void quitEmpleado(String nombre){

    }
}
