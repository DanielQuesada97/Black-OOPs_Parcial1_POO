package com.DAQC.x00147619;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;


public final class CalculadoraImpuestos {
    private static double totalRenta;
    private static double totalISSS;
    private static double totalAFP;

    private CalculadoraImpuestos(double totalRenta, double totalISSS, double totalAFP) {
        this.totalRenta = totalRenta;
        this.totalISSS = totalISSS;
        this.totalAFP = totalAFP;
    }

    public static double caluladoraPago(Empleado empleado){
        double p = 0;
        if(empleado instanceof ServicioProfesional){
            double renta;
            renta = 0.1*empleado.salario;
            totalRenta = totalRenta + renta;
            p = ((ServicioProfesional) empleado).salario - renta;
            BigDecimal bd = new BigDecimal(p).setScale(2, RoundingMode.HALF_UP);
            double pago = bd.doubleValue();
        }
        else if(empleado instanceof PlazaFija){

            double afp;
            double isss;
            double renta;
            double restante;
            afp = 0.0625 * ((PlazaFija) empleado).salario;
            totalAFP = totalAFP + afp;
            isss = 0.03 * ((PlazaFija) empleado).salario;
            totalISSS = totalISSS + isss;
            restante = ((PlazaFija) empleado).salario - afp - isss;
            if( ((PlazaFija) empleado).salario >= 0.01 && ((PlazaFija) empleado).salario <= 472.00 ){
                renta = 0;
                p = restante - renta;
                BigDecimal bd = new BigDecimal(p).setScale(2, RoundingMode.HALF_UP);
                double pago = bd.doubleValue();
            }
            else if(((PlazaFija) empleado).salario >= 472.01 && ((PlazaFija) empleado).salario <= 895.24){
                renta = 0.1*(restante - 472) + 17.67;
                totalRenta = totalRenta + renta;
                p = restante - renta;
                BigDecimal bd = new BigDecimal(p).setScale(2, RoundingMode.HALF_UP);
                double pago = bd.doubleValue();
            }
            else if(((PlazaFija) empleado).salario >= 895.25 && ((PlazaFija) empleado).salario <= 2038.10){
                renta = 0.2*(restante-895.24) + 60;
                totalRenta = totalRenta + renta;
                p = restante - renta;
                BigDecimal bd = new BigDecimal(p).setScale(2, RoundingMode.HALF_UP);
                double pago = bd.doubleValue();
            }
            else if(((PlazaFija) empleado).salario >= 2038.11){
                renta = 0.3*(restante - 2038.10) + 288.57;
                totalRenta = totalRenta + renta;
                p = restante - renta;
                BigDecimal bd = new BigDecimal(p).setScale(2, RoundingMode.HALF_UP);
                double pago = bd.doubleValue();

            }
        }
        BigDecimal bd = new BigDecimal(p).setScale(2, RoundingMode.HALF_UP);
        double pago = bd.doubleValue();
        return pago;
    }

    public static String mostrarTotales(){
        double a = totalAFP;
        BigDecimal bd = new BigDecimal(a).setScale(2, RoundingMode.HALF_UP);
        double afp = bd.doubleValue();
        double i = totalISSS;
        BigDecimal bd2 = new BigDecimal(i).setScale(2, RoundingMode.HALF_UP);
        double isss = bd2.doubleValue();
        double r = totalRenta;
        BigDecimal bd3 = new BigDecimal(r).setScale(2, RoundingMode.HALF_UP);
        double renta = bd3.doubleValue();
        return "Total renta: $" + renta +
                "\nTotal afp: $" + afp +
                "\nTotal isss: $" + isss;
    }
}