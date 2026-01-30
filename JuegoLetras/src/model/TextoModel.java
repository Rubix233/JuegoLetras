/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class TextoModel {

    private static final String VOCALESREG = "(?i)[aeiouáéíóúü]";
    private static final String LETRASREG = "[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ]";
    private static final String MAYUSREG = "[A-ZÑÁÉÍÓÚÜ]";
    private static final String PALABRASREG = " ";
    private String frase;

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public int getVocales() {
        return contar(VOCALESREG);
    }

    public int getLetras() {
        return contar(LETRASREG);
    }

    public int getMayusculas() {
        return contar(MAYUSREG);
    }

    public int getPalabras() {
        return contar(PALABRASREG);
    }

    private int contar(String regex) {
        if (this.frase == null || this.frase.isEmpty()) {
            return 0;
        }

        
        if (regex.equals(PALABRASREG)) {
            int conteo = 0;
            boolean enPalabra = false;
            for (char c : frase.toCharArray()) {
                boolean esLetra = String.valueOf(c).matches(LETRASREG);
                if (esLetra && !enPalabra) {
                    conteo++;          
                    enPalabra = true;
                } else if (!esLetra) {
                    enPalabra = false;  
                }
            }
            return conteo; 
        }

        
        String fraseLocal = this.frase.trim().replaceAll(regex, "");
        int conteo = this.frase.length() - fraseLocal.length();

        if (regex.equals(PALABRASREG)) {  
            conteo++;
        }

        return conteo;
    }
}
