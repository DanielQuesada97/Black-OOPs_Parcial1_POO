package com.DAQC.x00147619;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Empresa empresa = new Empresa("Black OOPs");

        String nombre, puesto, numero, nombreDocumento;
        double salario, pago;
        int mesesContrato, extension;

        int opt = 0;

        //Variables para Menu JOptionPane
        String[] tipoEmpleado = {"Servicio Profesional", "Plaza Fija"};

        do{
            try {
                opt = Integer.parseInt(JOptionPane.showInputDialog(null, menu()));
                switch (opt) {
                    case 1: //AGREGAR EMPLEADO

                        //MENU DE OPCIONES PARA ESCOGER EL TIPO DE EMPLEADO PARA AGREGAR
                        opt = JOptionPane.showOptionDialog(null,
                                "Tipo de empleado que desea agregar", "AGREGAR EMPLEADOS",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tipoEmpleado,
                                tipoEmpleado[0]);

                        switch (opt) {
                            case 0: //SERVICIO PROFESIONAL
                                try {
                                    nombre = JOptionPane.showInputDialog(null, "Nombre: ");
                                    nombreDocumento = JOptionPane.showInputDialog(null,
                                            "Nombre de Documento a ingrear: ");
                                    numero = JOptionPane.showInputDialog(null, nombreDocumento + ": ");
                                    puesto = JOptionPane.showInputDialog(null, "Puesto: ");
                                    salario = Double.parseDouble(JOptionPane.showInputDialog(null,
                                            "Salario: "));
                                    mesesContrato = Integer.parseInt(JOptionPane.showInputDialog(null,
                                            "Meses de Contrato: "));
                                } catch (NumberFormatException exc) {
                                    JOptionPane.showMessageDialog(null, "Por favor digite numeros en salario y/o contrato");
                                    break;
                                }

                                ServicioProfesional nuevoProfesional = new ServicioProfesional(nombre, puesto, salario, mesesContrato);
                                Documento documento = new Documento(nombreDocumento, numero);

                                nuevoProfesional.addDocumento(documento);
                                empresa.addEmpleado(nuevoProfesional);
                                break;

                            case 1: //PLAZA FIJA
                                try {
                                    nombre = JOptionPane.showInputDialog(null, "Nombre: ");
                                    nombreDocumento = JOptionPane.showInputDialog(null,
                                            "Nombre de Documento a ingrear: ");
                                    numero = JOptionPane.showInputDialog(null, nombreDocumento + ": ");
                                    puesto = JOptionPane.showInputDialog(null, "Puesto: ");
                                    salario = Double.parseDouble(JOptionPane.showInputDialog(null,
                                            "Salario: "));
                                    extension = Integer.parseInt(JOptionPane.showInputDialog(null,
                                            "Extension: "));
                                } catch (NumberFormatException exc) {
                                    JOptionPane.showMessageDialog(null, "Porfavor digite numeros en salario y/o extension");
                                    break;
                                }

                                PlazaFija nuevoFijo = new PlazaFija(nombre, puesto, salario, extension);
                                documento = new Documento(nombreDocumento, numero);

                                nuevoFijo.addDocumento(documento);
                                empresa.addEmpleado(nuevoFijo);

                                break;
                        }
                        break;

                    case 2: //DESPEDIR EMPLEADO
                        nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre: ");
                        empresa.quitEmpleado(nombre);
                        break;

                    case 3: //VER LISTA DE EMPLEADOS
                        for (Empleado empleado : empresa.getPlanilla()) {

                            if (empleado instanceof ServicioProfesional) {
                                JOptionPane.showMessageDialog(null,
                                        "Empleado de Servicio Profesional\n" +
                                                "Nombre: " + empleado.getNombre() +
                                                "\n" + empleado.documentos.get(0).getNombre() + ": " +
                                                empleado.documentos.get(0).getNumero() +
                                                "\nPuesto: " + empleado.getPuesto() +
                                                "\nMeses de Contrato: " + ((ServicioProfesional) empleado).getMesesContrato() +
                                                "\nSalario: " + empleado.getSalario());
                            } else if (empleado instanceof PlazaFija) {
                                JOptionPane.showMessageDialog(null,
                                        "Empleado de Plaza Fija\n" +
                                                "Nombre: " + empleado.getNombre() +
                                                "\n" + empleado.documentos.get(0).getNombre() + ": " +
                                                empleado.documentos.get(0).getNumero() +
                                                "\nPuesto: " + empleado.getPuesto() +
                                                "\nExtension: " + ((PlazaFija) empleado).getExtension() +
                                                "\nSalario: " + empleado.getSalario());
                            }
                        }
                        break;

                    case 4: //CALCULAR SUELDO
                        nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre: ");
                        for (Empleado empleado : empresa.getPlanilla()) {
                            if (empleado.getNombre().equals(nombre)) {
                                pago = CalculadoraImpuestos.caluladoraPago(empleado);
                                JOptionPane.showMessageDialog(null, "Sueldo Liquido: $" + pago);

                            }
                        }
                        break;
                    case 5: //MOSTRAR TOTALES
                        JOptionPane.showMessageDialog(null, CalculadoraImpuestos.mostrarTotales(),
                                "TOTALES", JOptionPane.PLAIN_MESSAGE);
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "Saliendo...");
                        break;
                }
            }catch(NumberFormatException|NullPointerException exc){
                JOptionPane.showMessageDialog(null, "Usted a presionado Cancel o no selecciono una opcion!");
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
