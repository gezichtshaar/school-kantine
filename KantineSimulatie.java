import java.util.*;

public class KantineSimulatie {
    // kantine
    private Kantine kantine;

    // kantineaanbod
    private KantineAanbod kantineaanbod;

    // random generator
    private Random random;

    // minimum en maximum aantal artikelen per soort
    private int MinArtikelSoort;
    private int MaxArtikelSoort;

    // minimum en maximum aantal personen per dag
    private int MinArtikelPersoon;
    private int MaxArtikelPersoon;

    // minimum en maximum artikelen per persoon
    private int MinPersoonDag;
    private int MaxPersoonDag;

    // kantinesimulatie - personen
    private int studentaantal = 0;
    private int docentaantal = -1;
    private int kantineaantal = -1;

    /**
     * Constructor
     */
    public KantineSimulatie(int MinArtikelSoort, int MaxArtikelSoort, int MinArtikelPersoon, int MaxArtikelPersoon, int MinPersoonDag, int MaxPersoonDag) 
    {
        this.MinArtikelSoort=Math.abs(MinArtikelSoort);
        this.MaxArtikelSoort=Math.abs(MaxArtikelSoort);
        this.MinArtikelPersoon=Math.abs(MinArtikelPersoon);
        this.MaxArtikelPersoon=Math.abs(MaxArtikelPersoon);
        this.MinPersoonDag=Math.abs(MinPersoonDag);
        this.MaxPersoonDag=Math.abs(MaxPersoonDag);
        kantine=new Kantine();
        random=new Random();
        kantineaanbod=new KantineAanbod(); 
        kantine.setKantineAanbod(kantineaanbod);
    }

    /**
     * Methode om een array van random getallen liggend tussen min en max 
     * van de gegeven lengte te genereren
     * @param lengte
     * @param min
     * @param max
     * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) 
    {
        int[] temp=new int[lengte];
        for(int i=0;i<lengte;i++) {
            temp[i]=getRandomValue(min, max);
        }
        return temp;
    }

    /**
     * Methode om een random getal tussen min(incl) en max(incl) te genereren.
     * @param min
     * @param max
     * @return Een random getal
     */
    private int getRandomValue(int min, int max) 
    {
        return random.nextInt(max-min+1)+min;
    }

    /**
     * Methode om op basis van een array van indexen voor de array 
     * artikelnamen de bijhorende array van artikelnamen te maken
     * @param indexen
     * @return De array met artikelnamen
     */
    private String[] geefArtikelNamen(String[] artikelnamen, int[] indexen) 
    {
        String[] artikelen=new String[indexen.length];
        for(int i=0;i<indexen.length;i++) 
        { 
            artikelen[i]=artikelnamen[indexen[i]];
        }
        return artikelen;
    }

    private String doubleNaarGeld(double prijs) {
        String[] tmp_prijs=Double.toString(prijs).split("\\.");
        if(tmp_prijs[1].length()>2) {
            tmp_prijs[1]=tmp_prijs[1].substring(0,2);
        }
        return tmp_prijs[0]+","+tmp_prijs[1];
    }

    public void addArtikel(String naam, double prijs, int hoeveelheid) {
        kantineaanbod.addArtikel(naam, prijs, hoeveelheid);
    }

    public void setMinArtikelSoort(int hoeveelheid) {
        
    }
    
    public void setMaxArtikelSoort(int hoeveelheid) {
        
    }
    
    public void setMinArtikelPersoon(int hoeveelheid) {
        
    }
    
    public void setMaxArtikelPersoon(int hoeveelheid) {
        
    }

    /**
     * Deze methode simuleert een aantal dagen in het verloop van de kantine
     * @param dagen
     */
    public void simuleer(int dagen) 
    {
        if(kantineaanbod.getKeyArray().length>0) {
            int[] ratio={89, 99, 100};
            int aantalpersonen = ratio[ratio.length-1];
            int[] aantal=new int[dagen*aantalpersonen];
            double[] omzet=new double[dagen];
            int tmp=0;
            for(int i=0; i<dagen; i++) {
                // for lus voor dagen
                // bedenk hoeveel personen vandaag binnen lopen
                // int aantalpersonen=getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);
                // laat de personen maar komen...
                for(int j=0;j<aantalpersonen;j++) 
                {

                    int randomPersoon=getRandomValue(0, ratio[ratio.length-1]);
                    // maak persoon en dienblad aan, koppel ze
                    Dienblad dienblad=new Dienblad();
                    Persoon persoon;
                    if(randomPersoon < ratio[0]) {
                        persoon=new Student(42, "random");
                    }else if(randomPersoon < ratio[1]) {
                        persoon=new Docent("vier", "random");
                    }else if(randomPersoon < ratio[2]) {
                        persoon=new KantineMedewerker(true, 42);
                    }else{
                        persoon=new Persoon();
                    }
                    Betaalwijze betaalwijze=new Contant();
                    betaalwijze.setSaldo(6.0);
                    persoon.setBetaalwijze(betaalwijze);
                    persoon.pakDienblad(dienblad);

                    //System.out.println(persoon.toString());

                    // bedenk hoeveel artikelen worden gepakt
                    int aantalartikelen=getRandomValue(MinArtikelPersoon, MaxArtikelPersoon);
                    aantal[tmp]=aantalartikelen;
                    tmp++;

                    // genereer de “artikelnummers”, dit zijn indexen 
                    // van de artikelnamen array  
                    int[] tepakken=getRandomArray(aantalartikelen, 0, kantineaanbod.getKeyArray().length-1);

                    // vind de artikelnamen op basis van de indexen hierboven
                    String[] artikelen=geefArtikelNamen(kantineaanbod.getKeyArray(), tepakken);

                    // loop de kantine binnen, pak de gewenste artikelen, sluit aan
                    kantine.loopPakSluitAan(persoon, artikelen);
                    for(String artikel:artikelen) {
                        if(kantineaanbod.getArtikelHoeveelheid(artikel)>MinArtikelSoort) {
                            kantineaanbod.vulStapel(artikel, MaxArtikelSoort);
                        }
                    }
                }
                kantine.verwerkRijVoorKassa();
                omzet[i]=kantine.getKassa().hoeveelheidGeldInKassa();
                SchoolKantine.addToLog("Dag: "+(i+1)+"\nAantal artikelen verkocht: "+kantine.getKassa().aantalArtikelen()+"\nHoeveelheid geld verdient: "+doubleNaarGeld(kantine.getKassa().hoeveelheidGeldInKassa())+" euro");
                kantine.getKassa().resetKassa();
            }
            SchoolKantine.addToLog(Administratie.berekenGemiddeldAantal(aantal)+", "+doubleNaarGeld(Administratie.berekenGemiddeldeOmzet(omzet))+", "+Arrays.toString(Administratie.berekenDagOmzet(omzet)));
        }else{
            SchoolKantine.addToLog("Voeg eerst artikelen toe.");
        }
    }
}

