
/**
 * Write a description of class Docent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Docent extends Persoon
{
    private String vierlettercode;
    private String afdeling;
    
    public Docent() {
        super();
    }
    
    public void setVierlettercode(String vierlettercode) {
        this.vierlettercode = vierlettercode;  
    }
    
    public String getVierlettercode(String vierlettercode) {
        return vierlettercode;
    }
    
    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }
    
    public String getAfdeling(String afdeling) {
        return afdeling;    
    }
    
    @Override
    public void drukAf() {
        System.out.println("\nvierlettercode : "+vierlettercode+"\nafdeling : "+afdeling);
    }
    
}

