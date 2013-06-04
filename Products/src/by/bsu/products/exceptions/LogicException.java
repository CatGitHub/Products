/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package by.bsu.products.exceptions;


public class LogicException extends Exception {

    public LogicException(Throwable cause) {
        super(cause);
    }

    public LogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogicException(String message) {
        super(message);
    }

    public LogicException() {
    }

}
