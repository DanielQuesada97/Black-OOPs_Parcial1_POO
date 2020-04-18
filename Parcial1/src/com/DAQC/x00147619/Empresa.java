package com.JSPR.x00046119;

import javax.swing.*;
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
        for(Empleado empleado : planilla){
            empleado.getNombre();
            empleado.getSalario();
            empleado.getPuesto();
        }

        return planilla;
    }

    public void addEmpleado(Empresa empleado){

    }

    public void quitEmpleado(String nombre){

    }

    public void addEmpleado(ServicioProfesional servicioProfesional) {
        ServicioProfesional e = servicioProfesional;
        planilla.add(e);
    }

    public void addEmpleado(PlazaFija plazaFija) {
        PlazaFija p = plazaFija;
        planilla.add(p);
    }
}