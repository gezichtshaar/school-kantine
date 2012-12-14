import java.util.Iterator;
/**
 * Write a description of class Kassa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kassa
{
    // instance variables - replace the example below with your own
    private double geldInKassa;
    private int totaalAantalArtikelen;
    private Kassarij kassarij;
    

    /**
     * Constructor for objects of class Kassa
     */
    public Kassa(Kassarij kassarij) {
        this.kassarij=kassarij;
        resetKassa();
    }
    
    public int aantalArtikelen() {
        return totaalAantalArtikelen;
    }
    
    public double hoeveelheidGeldInKassa() {
        return geldInKassa;
    }
    
    public void resetKassa() {
        geldInKassa=0.0;
        totaalAantalArtikelen=0;        
    }
    
    public void rekenAf(Persoon persoon) {
        Iterator<Artikel> itr=persoon.getDienblad().getArtikelen();
        while(itr.hasNext()) {
            geldInKassa+=itr.next().getPrijsArtikel();
            totaalAantalArtikelen+=1;
        }
    }

}
