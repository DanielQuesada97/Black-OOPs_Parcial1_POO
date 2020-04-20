package com.JSPR.x00046119;

import javax.swing.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;


public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("Black OOPs");
        String nombre, puesto, numero, nombreDocumento = "DUI";
        double salario, pago = 0;
        int mesesContrato, extension;

        int opt;

        //Variables para Menu JOptionPane
        String[] tipoEmpleado = {"Servicio Profesional", "Plaza Fija"};

        do{
            opt = Integer.parseInt(JOptionPane.showInputDialog(null, menu()));
            switch(opt){
                case 1: //AGREGAR EMPLEADO

                    //MENU DE OPCIONES PARA ESCOGER EL TIPO DE EMPLEADO PARA AGREGAR
                    opt = JOptionPane.showOptionDialog(null,
                            "Tipo de empleado que desea agregar", "AGREGAR EMPLEADOS",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tipoEmpleado,
                            tipoEmpleado[0]);

                    switch(opt){
                        case 0: //SERVICIO PROFESIONAL
                            nombre = JOptionPane.showInputDialog(null, "Nombre: ");
                            nombreDocumento = JOptionPane.showInputDialog(null,
                                    "Nombre de Documento a ingrear: ");
                            numero = JOptionPane.showInputDialog(null, nombreDocumento + ": ");
                            puesto = JOptionPane.showInputDialog(null, "Puesto: ");
                            salario = Double.parseDouble(JOptionPane.showInputDialog(null,
                                    "Salario: "));
                            mesesContrato = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Meses de Contrato: "));

                            ServicioProfesional nuevoProfesional = new ServicioProfesional(nombre, puesto, salario, mesesContrato);
                            Documento documento = new Documento(nombreDocumento, numero);
                            nuevoProfesional.addDocumento(documento);
                            empresa.addEmpleado(nuevoProfesional);
                            break;

                        case 1: //PLAZA FIJA
                            nombre = JOptionPane.showInputDialog(null, "Nombre: ");
                            numero = JOptionPane.showInputDialog(null, "DUI: ");
                            puesto = JOptionPane.showInputDialog(null, "Puesto: ");
                            salario = Double.parseDouble(JOptionPane.showInputDialog(null,
                                    "Salario: "));
                            extension = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Meses de Contrato: "));

                            PlazaFija nuevoFijo = new PlazaFija(nombre, puesto, salario, extension);
                            documento = new Documento(nombreDocumento, numero);

                            empresa.addEmpleado(nuevoFijo);
                            nuevoFijo.addDocumento(documento);

                            break;
                    }
                    break;

                case 2: //DESPEDIR EMPLEADO
                    nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre: ");
                    empresa.quitEmpleado(nombre);
                    break;

                case 3: //VER LISTA DE EMPLEADOS
                    for(Empleado empleado : empresa.getPlanilla()){
                        JOptionPane.showMessageDialog(null, "Nombre: " + empleado.getNombre() +
                                "\nPuesto: " + empleado.getPuesto() +
                                "\nSalario: " + empleado.getSalario());
                    }
                    break;

                case 4: //CALCULAR SUELDO
                    nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre: ");
                    for(Empleado empleado : empresa.getPlanilla()) {
                        if(empleado.getNombre().equals(nombre)){
                            pago = CalculadoraImpuestos.caluladoraPago(empleado);
                            JOptionPane.showMessageDialog(null, "Pago: $" + pago);
                        }
                    }
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, CalculadoraImpuestos.mostrarTotales(), "TOTALES", JOptionPane.PLAIN_MESSAGE);
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Salindo...");
                    break;
            }

        }while(opt != 6);

    }

    public static String menu(){
        return "[1]- Agregar empleado" +
                "\n[2]- Despedir empleado" +
                "\n[3]- Ver lista de empleados" +
                "\n[4]- Calcular sueldo" +
                "\n[5]- Mostrar totales" +
                "\n[6]- Salir" +
                "\nSu opcion: ";
    }


}