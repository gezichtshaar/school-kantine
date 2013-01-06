
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

    public Docent(String vierlettercode, String afdeling) {
        super();
        this.vierlettercode=vierlettercode;
        this.afdeling=afdeling;
    }

    public Docent(String BSN, String voorNaam, String achterNaam, int geboorteDag, int geboorteMaand, int geboorteJaar, char geslacht, String vierlettercode, String afdeling) {
        super(BSN, voorNaam, achterNaam, geboorteDag, geboorteMaand, geboorteJaar, geslacht);
        this.vierlettercode=vierlettercode;
        this.afdeling=afdeling;
    }

    public String getVierlettercode(String vierlettercode) {
        return vierlettercode;
    }

    public String getAfdeling(String afdeling) {
        return afdeling;    
    }

    @Override
    public String toString() {
        return super.toString()+"\nvierlettercode : "+vierlettercode+"\nafdeling : "+afdeling;
    }

    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }

    public void setVierlettercode(String vierlettercode) {
        this.vierlettercode = vierlettercode;  
    }
}

