/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class AnalizadorHilo extends Thread {

    private JuegoLetrasController controlador;

    public AnalizadorHilo(JuegoLetrasController controlador) {
        this.controlador = controlador;
    }

    @Override
    public void run() {
        while (true) {
            try {
                
                controlador.analizarTexto();

                Thread.sleep(200);  
            } catch (InterruptedException ex) {
                System.err.println("¡ERROR EN EL HILO!");
                ex.printStackTrace();
            }
        }
    }
}
