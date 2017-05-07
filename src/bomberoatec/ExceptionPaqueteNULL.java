/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberoatec;

/**
 *
 * @author Andres
 */
/**
 * Esta es una excepcion que ayuda a que el programa no se caiga*/
public class ExceptionPaqueteNULL extends Exception {
            String message1;
    public ExceptionPaqueteNULL(String message) {
        super(message);
        this.message1=message;
    }
    
    
}
