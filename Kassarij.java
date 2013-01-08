import java.util.*;
/**
 * Write a description of class Kassarij here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kassarij
{

    private LinkedList<Persoon> kassaRij;
    /**
     * Constructor for objects of class Kassarij
     */
    public Kassarij() {
        kassaRij=new LinkedList();
    }
    
    public Persoon eerstePersoonInRij() {
        Persoon persoon=null;
        if(erIsEenRij()) {
            persoon=kassaRij.getFirst();
            kassaRij.removeFirst();
        }
        return persoon;
    }
    
    public boolean erIsEenRij() {
        return (kassaRij.size()>0);
    }

    public Iterator getKassaRijIterator() {
        Iterator<Persoon> itr=kassaRij.iterator();
        return itr;
    }
    
    public void sluitAchteraan(Persoon persoon) {
        kassaRij.add(persoon);
    }
    
}
