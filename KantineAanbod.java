import java.util.*;

public class KantineAanbod {
    // interne opslag voorraad
    private HashMap<String, ArrayList<Artikel>> aanbod;

    public KantineAanbod() {
        aanbod=new HashMap<String, ArrayList<Artikel>>();
    }
    /**
     * Constructor. Het eerste argument is een lijst met artikelnamen,
     * het tweede argument is een lijst met prijzen en het derde argument
     * is een lijst met hoeveelheden. Let op: de dimensies van de drie arrays
     * moeten wel gelijk zijn!
     */
    public KantineAanbod(String[] artikelnaam, double[] prijs, int[] hoeveelheid) 
    {
        aanbod=new HashMap<String, ArrayList<Artikel>>();
        for(int i=0;i<artikelnaam.length;i++) 
        {
            ArrayList<Artikel> artikelen=new ArrayList<Artikel>();
            for(int j=0;j<hoeveelheid[i];j++) 
            {
                artikelen.add(new Artikel(artikelnaam[i], prijs[i]));
            }
            aanbod.put(artikelnaam[i], artikelen);
        }
    }

    /*
     * Private methode om de lijst van artikelen te krijgen op basis van de    
     * naam van het artikel. Retourneert null als artikel niet bestaat.
     */
    private ArrayList<Artikel> getArrayList(String productnaam) {
        return aanbod.get(productnaam); 
    }
    
    public String[] getKeyArray() {
        return aanbod.keySet().toArray(new String[aanbod.keySet().size()]);
    }

    public void vulStapel(String artikelnaam, int hoeveelheid) {
        double prijs=aanbod.get(artikelnaam).get(0).getPrijsArtikel();
        ArrayList<Artikel> artikelen=new ArrayList<Artikel>();
        for(int n=0; n<hoeveelheid; n++) {
            artikelen.add(new Artikel(artikelnaam, prijs));
        }
        aanbod.put(artikelnaam, artikelen);
    }

    public void addArtikel(String artikelnaam, double prijs, int hoeveelheid) {
        ArrayList<Artikel> artikelen=new ArrayList<Artikel>();
        for(int i=0; i<hoeveelheid; i++) {
            artikelen.add(new Artikel(artikelnaam, prijs));
        }
        aanbod.put(artikelnaam, artikelen);
    }

    /**
     * Private methode om een Artikel van de stapel artikelen af te pakken. 
     * Retourneert null als de stapel leeg is.
     */
    private Artikel getArtikel(ArrayList<Artikel> stapel) 
    {
        if (stapel==null) { 
            return null;
        }
        if (stapel.size()==0)
        {
            return null;
        }
        else 
        {
            Artikel a=stapel.get(0);
            stapel.remove(0);
            return a;
        }
    }

    public int getArtikelHoeveelheid(String artikel) {
        return aanbod.get(artikel).size();
    }

    /**
     * Publieke methode om een artikel via naam van de stapel te pakken.
     * Retouneert null als artikel niet bestaat of niet op voorraad is.
     * @param naam (van artikel)
     * @return artikel (of null)
     */
    public Artikel getArtikel(String naam) {
        return getArtikel(getArrayList(naam));
    }
}
