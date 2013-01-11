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
        artikelen=new ArrayList<Artikel>();
    }

    public Iterator getArtikelen() {
        return artikelen.iterator();
    }

    public void voegToe(Artikel artikel) {
        if(artikel != null) {
            artikelen.add(artikel);
        }
    }    

}
