package com.JSPR.x00046119;

import java.util.ArrayList;
import java.util.List;

public abstract class Empleado{
    protected String nombre;
    protected String puesto;
    protected List<Documento> documentos;
    protected double salario;

    public Empleado(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    /*public List<Documento> getDocumentos(){
        documentos.forEach(s ->{
            s.getNombre();
            s.getNumero();
        });

    }*/

    public void removeDocumento(String nombre){
        String n = nombre;
        String nombreFinal = n;
        documentos.removeIf(s -> (nombreFinal.equals(s.getNombre())));
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario){

    }
}
