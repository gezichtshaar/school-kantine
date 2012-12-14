import java.util.*;
/**
 * Write a description of class Kantine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kantine
{
    private Kassa kassa;
    private Kassarij kassarij;
    private KantineAanbod kantineAanbod;

    /**
     * Constructor for objects of class Kantine
     */
    public Kantine()
    {
        kassarij=new Kassarij();
        kassa=new Kassa(kassarij);
    }

    public Kassa getKassa() {
        return kassa;
    }
    
    public void setKantineAanbod(KantineAanbod kantineAanbod) {
        this.kantineAanbod=kantineAanbod;
    }
    
    public void loopPakSluitAan(Persoon persoon, String[] artikelnamen) {
        
        for(int n=0; n<artikelnamen.length; n++) {
            persoon.getDienblad().voegToe(kantineAanbod.getArtikel(artikelnamen[n]));
        }
        
        kassarij.sluitAchteraan(persoon);
    }
    
    public void verwerkRijVoorKassa() {
        if(kassarij.erIsEenRij()) {
            Iterator<Kassarij> itr=kassarij.getKassaRijIterator();
            while(itr.hasNext()) {
                kassa.rekenAf(kassarij.eerstePersoonInRij());
            }
        }
    }
    
    
}
