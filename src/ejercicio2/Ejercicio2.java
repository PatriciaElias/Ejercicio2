/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

/**
 *
 * @author Administrador
 */
import java.awt.event.*;
import javax.swing.*;

public class Ejercicio2 extends JFrame {

    private JLabel lblNumero; 
    private static JTextField txtNumero; 
    private JButton btnCalcular; 
    private JButton btnSalir;

    private Ejercicio2() {
        setSize(300, 150);
        setTitle("Tabla de conversion de Kg a Lb");
        inicializarComponentes(); 
    }

    private void inicializarComponentes() {
        lblNumero = new JLabel();
        txtNumero = new JTextField();
        btnCalcular = new JButton(); 
        btnSalir = new JButton();

        getContentPane().setLayout(null);

        addWindowListener(new WindowAdapter() {
            public void WindowClosing(WindowEvent evt) {
                salirDeAplicacion(evt);
            }
        });

        lblNumero.setText("Digite un numero:");
        getContentPane().add(lblNumero);
        lblNumero.setBounds(25, 15, 100, 25);

       
        txtNumero.setText("");
        getContentPane().add(txtNumero);
        txtNumero.setBounds(140, 15, 50, 25);

        btnCalcular.setText("Calcular");
        btnCalcular.setToolTipText("Tabla de conversion Kg a Lb");
        btnCalcular.setMnemonic('c');
        getContentPane().add(btnCalcular);
        btnCalcular.setBounds(30, 60, 100, 30);
        btnCalcular.addActionListener(new AccionCalcular());

        btnSalir.setText("Salir");
        btnSalir.setToolTipText("Salir de la aplicación");
        btnSalir.setMnemonic('s');
        getContentPane().add(btnSalir);
        btnSalir.setBounds(150, 60, 100, 30);
        btnSalir.addActionListener(new AccionSalir());

        getRootPane().setDefaultButton(btnCalcular);
        setLocationRelativeTo(null);
    }

    static class AccionCalcular implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
            double numero = 0;

            try {
                numero = Double.parseDouble(txtNumero.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Tipo de datos incorrecto",
                        "ATENCION!!!", JOptionPane.ERROR_MESSAGE);
                reiniciar();
                return; 
            }

            String cad = "";

            ImageIcon icono = new ImageIcon(Ejercicio2.class.getResource("/imagenes/pesa.png"));

            if (numero == 0) {
                cad = "No se puede generar la tabla de conversion";
                JOptionPane.showMessageDialog(null, cad, "Respecto al cero",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                for (int i = 1; i <= numero; i++) {
                    cad += i + " Kg " + " = " + (i * 2.2045) + " lb. " + "\n";
                }
                JOptionPane.showMessageDialog(null, cad, "Tabla de conversion de kg a lb." ,
                        JOptionPane.INFORMATION_MESSAGE, icono);
            }
            reiniciar();
        }
    }

    static void reiniciar() {
        txtNumero.setText("");
        txtNumero.requestFocus();
    }

    static class AccionSalir implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    private void salirDeAplicacion(WindowEvent evt) {
        System.exit(0);
    }

    public static void main(String[] args) {
        Ejercicio2 formularioDemo = new Ejercicio2();

        formularioDemo.mostrarEventoDemo();
    }

    private void mostrarEventoDemo() {
        setVisible(true);
    }
}

