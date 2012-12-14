import java.util.ArrayList;
import java.util.Iterator;

/**
 * Write a description of class Dienblad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dienblad
{
    private ArrayList<Artikel> artikelen;    

    /**
     * Constructor for objects of class Dienblad
     */
    public Dienblad() {
        artikelen=new ArrayList();
    }
    
    public Iterator getArtikelen() {
        Iterator<Artikel> artikelLijst=artikelen.iterator();
        return artikelLijst;
    }

    public void voegToe(Artikel artikel) {
        artikelen.add(artikel);
    }    
    
}
