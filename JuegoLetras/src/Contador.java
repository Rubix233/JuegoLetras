
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class Contador extends Thread{
    
    private JuegoLetras juegoLetras;
    
    private final String VOCALESREG = "(?i)[aeiouáéíóúü]";
    private final String LETRASREG = "[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ]";
    private final String MAYUSREG = "[A-ZÑÁÉÍÓÚÜ]";
    private final String PALABRASREG = " ";
    
    private String frase;
    
    public Contador(JuegoLetras jl){
        this.juegoLetras = jl;
    }
    
    private int contar(String regex){
        if(this.frase == null || this.frase.isEmpty()) return 0;
        
        String fraseLocal = this.frase.trim().replaceAll(regex, "");
        int conteo = this.frase.length() - fraseLocal.length();;
        
        if(regex.equals(this.PALABRASREG)) conteo++;
        
        
        return conteo;
        
    }
    
    @Override
    public void run(){
        while(true){
            try {
                this.frase = juegoLetras.getTexto();
                juegoLetras.actualizarVentana(contar(VOCALESREG), contar(LETRASREG), contar(MAYUSREG), contar(PALABRASREG));
                
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                System.err.println("¡ERROR EN EL HILO!");
                ex.printStackTrace();
            }
        }
    }
}
