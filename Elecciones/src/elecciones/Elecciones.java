/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elecciones;

/**
 *
 * @author Padilla_Bustamante
 */
public class Elecciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Registro r = new Registro(args);
        r.setVisible(true);
        Boleta b = new Boleta();
        //b.setVisible(true);
    }
    
}
