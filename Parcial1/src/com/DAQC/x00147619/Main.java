package com.DAQC.x00147619;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList<>();
        Empresa empresa = new Empresa("Black OOPs");

        String nombre, puesto, numero;
        double salario;
        int mesesContrato, extension;

        int opt;

        //Variables para Menu JOptionPane
        String[] tipoEmpleado = {"Servicio Profesional", "Plaza Fija"};

        do{
            opt = Integer.parseInt(JOptionPane.showInputDialog(null, menu()));
            switch(opt){
                case 1: //AGREGAR EMPLEADO
                    opt = JOptionPane.showOptionDialog(null,
                            "Tipo de empleado que desea agregar", "AGREGAR EMPLEADOS",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tipoEmpleado,
                            tipoEmpleado[0]);
                    switch(opt){
                        case 0: //SERVICIO PROFESIONAL
                            nombre = JOptionPane.showInputDialog(null, "Nombre: ");
                            numero = JOptionPane.showInputDialog(null, "DUI: ");
                            puesto = JOptionPane.showInputDialog(null, "Puesto: ");
                            salario = Double.parseDouble(JOptionPane.showInputDialog(null,
                                    "Salario: "));
                            mesesContrato = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Meses de Contrato: "));
                            empleados.add(new ServicioProfesional(nombre, puesto, salario, mesesContrato));
                            break;
                        case 1:
                            break;
                    }
                    empresa.addEmpleado();
                    break;

                case 2: //DESPEDIR EMPLEADO
                    break;
                case 3: //VER LISTA DE EMPLEADOS
                    break;
                case 4: //CALCULAR SUELDO
                    break;
                case 5: //MOSTRAR TOTALES
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Salindo...");
                    break;
            }

        }while(opt != 6);

    }

    public static String menu(){
        return "[1]- Agregar empleado" +
                "\n[2]- Despedor empleado" +
                "\n[3]- Ver lista de empleados" +
                "\n[4]- Calcular sueldo" +
                "\n[5]- Mostrar totales" +
                "\n[6]- Salir" +
                "\nSu opcion: ";
    }
}
