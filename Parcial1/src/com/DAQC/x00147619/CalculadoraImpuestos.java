package com.JSPR.x00046119;

import java.util.ArrayList;
import java.util.List;

public final class CalculadoraImpuestos {
    private double totalRenta;
    private double totalISSS;
    private double totalAFP;

    private CalculadoraImpuestos(double totalRenta, double totalISSS, double totalAFP) {
        this.totalRenta = totalRenta;
        this.totalISSS = totalISSS;
        this.totalAFP = totalAFP;
    }

    /*public double caluladoraPago(Empleado empleado){
        List<Empleado> empleados = new ArrayList<>();
        empleados = ;
        double pago = 0;
        if(empleados instanceof ServicioProfesional){
            double renta;
            renta = 0.1*empleado.salario;
            pago = ((ServicioProfesional) empleados).salario - renta;
        }
        else if(empleados instanceof PlazaFija){

            double afp;
            double isss;
            double renta;
            double restante;
            afp = 0.0625 * ((PlazaFija) empleados).salario;
            isss = 0.03 * ((PlazaFija) empleados).salario;
            restante = ((PlazaFija) empleados).salario - afp - isss;
            if( ((PlazaFija) empleados).salario >= 0.01 && ((PlazaFija) empleados).salario <= 472.00 ){
                renta = 0;
                pago = restante - renta;
            }
            else if(((PlazaFija) empleados).salario >= 472.01 && ((PlazaFija) empleados).salario <= 895.24){
                renta = 0.1(restante - 472) + 17.67;
                pago = restante - renta;
            }
            else if(((PlazaFija) empleados).salario >= 895.25 && ((PlazaFija) empleados).salario <= 2038.10){
                renta = 0.2(restante-895.24) + 60;
                pago = restante - renta;
            }
            else if(((PlazaFija) empleados).salario >= 2038.11){
                renta = 0.3*(restante - 2038.10) + 288.57;
                pago = restante -renta;

            }
        }
        return pago;
    }*/

    public String mostrarTotales(){
        return "!";
    }
}
