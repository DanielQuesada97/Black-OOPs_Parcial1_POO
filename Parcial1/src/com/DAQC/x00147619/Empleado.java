package com.DAQC.x00147619;

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
        documentos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public List<Documento> getDocumentos(){
        return documentos;
    }

    public void addDocumento(Documento documento){
        documentos.add(documento);
    }

    public void removeDocumento(String nombre){
        String nombreFinal = nombre;
        documentos.removeIf(s -> (nombreFinal.equals(s.getNombre())));
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }


}