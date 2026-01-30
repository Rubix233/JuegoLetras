
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy
 */
public class Contador extends Thread{
    
    private JuegoLetras juegoLetras;
    private Tipo tipo; 
    private String frase;
    
    public Contador(JuegoLetras jl, Tipo tipo){
        this.juegoLetras = jl;
        this.tipo = tipo;
    }
    
    private int contar(){
        
        if(this.frase == null || this.frase.isEmpty()) return 0;

        int conteo = this.frase.length() - this.frase.trim().replaceAll(tipo.getTipo(), "").length();;
        
        if(tipo.getTipo().equals(Tipo.PALABRAS.getTipo())) conteo++;
                
        return conteo;
        
    }
    
    @Override
    public void run(){
        while(true){
            try {
                this.frase = juegoLetras.getTexto();
                juegoLetras.actualizarVentana(contar(), this.tipo);
                
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                System.err.println("¡ERROR EN EL HILO!");
                ex.printStackTrace();
            }
        }
    }
}
