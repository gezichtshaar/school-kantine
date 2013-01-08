
/**
 * Write a description of class TeWeinigGeldException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TeWeinigGeldException extends Exception
{   
    private String message;

    public TeWeinigGeldException() {
        message="Te weinig geld";
    }
    
    public TeWeinigGeldException(Exception e) {
        super(e);
    }
    
    public TeWeinigGeldException(String message) {
        super(message);
        this.message=message;
    }
    
    public String toString() {
        return message+"euro";
    }
}
