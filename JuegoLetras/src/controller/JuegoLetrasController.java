/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.SwingUtilities;
import model.TextoModel;
import view.JuegoLetrasView;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class JuegoLetrasController {

    private TextoModel modelo;
    private JuegoLetrasView vista;
    private AnalizadorHilo hilo;

    public JuegoLetrasController() {
        this.modelo = new TextoModel();
        this.vista = new JuegoLetrasView();
        this.hilo = new AnalizadorHilo(this);
    }

    public void iniciar() {
        // Mostrar vista
        vista.setVisible(true);


        hilo.start();
    }

    public void analizarTexto() {

        String texto = vista.getTextoIntroducido();


        modelo.setFrase(texto);


        final int vocales = modelo.getVocales();
        final int letras = modelo.getLetras();
        final int mayusculas = modelo.getMayusculas();
        final int palabras = modelo.getPalabras();


        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                vista.actualizarContadores(vocales, letras, mayusculas, palabras);
            }
        });
    }
}
