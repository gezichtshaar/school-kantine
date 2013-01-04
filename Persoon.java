/**
 * Write a description of class Persoon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Persoon
{
    // instance variables - replace the example below with your own
    private String BSN;
    private String voorNaam;
    private String achterNaam;
    private int geboorteDag, geboorteMaand, geboorteJaar;
    private char geslacht;
    private Dienblad dienblad;

    /**
     * Constructor for objects of class Persoon
     */
    public Persoon() {
        geboorteDag=0;
        geboorteMaand=0;
        geboorteJaar=0;
        geslacht='O';
    }
    
    public Persoon(String BSN, String voorNaam, String achterNaam, int geboorteDag, int geboorteMaand, int geboorteJaar, char geslacht) {
        setBSN(BSN);
        setVoorNaam(voorNaam);
        setAchterNaam(achterNaam);
        setGeboortedatum(geboorteDag, geboorteMaand, geboorteJaar);
        setGeslacht(geslacht);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    
    public String getGeboorteDatum() {
        String temp;
        if(geboorteDag==0 && geboorteMaand==0 && geboorteJaar==0){
            temp="Onbekend";
        }else{
            temp=geboorteDag+"/"+geboorteMaand+"/"+geboorteJaar;
        }
        return temp;
    }
    
    public String getVoorNaam() {
        return voorNaam;
    }
    
    public String getAchterNaam() {
        return achterNaam;
    }
    
    public String getBSN() {
        return BSN;
    }
    
    public String getGeslacht() {
        String temp;
        switch(geslacht){
            case 'M': temp="Man";
                      break;
            case 'V': temp="Vrouw";
                      break;
            default: temp="Onbekend";
                      break;
        }
        return temp;
    }
    
    public Dienblad getDienblad() {
        return dienblad;
    }
    
    public void pakDienblad(Dienblad dienblad) {
        this.dienblad=dienblad;
    }
    
    public void setBSN(String BSN) {
        this.BSN = BSN;
    }
    
    public void setVoorNaam(String voorNaam){
        this.voorNaam=voorNaam;
    }
    
    public void setAchterNaam(String achterNaam) {
        this.achterNaam=achterNaam;
    }
    
    public void setGeboortedatum(int dag, int maand, int jaar){
        boolean error=true;
        if(dag >= 1){
            if(maand>=1 && maand<=12){
                if(jaar>=1900 && jaar<=2100){
                    int maandDagen[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                    boolean schrikkel=false;
                    if(maand==2){
                        if((jaar % 4)==0 && ((jaar % 400)==0 || (jaar % 100)!=0)){
                                schrikkel=true;
                        }
                    }
        
                        
                    if(dag<=maandDagen[maand-1] || (schrikkel && dag<=29)){
                        geboorteDag=dag;
                        geboorteMaand=maand;
                        geboorteJaar=jaar;
                        error=false;
                    }
                }
            }
        }
        
        if(error){
            geboorteDag=0;
            geboorteMaand=0;
            geboorteJaar=0;
        }
    }
    
    public void setGeslacht(char geslacht) {
        geslacht=Character.toUpperCase(geslacht);
        if(geslacht=='M' || geslacht=='V'){
            this.geslacht=geslacht;
        }else{
            this.geslacht='O';
        }
    }
    
    public void drukAf() {
        System.out.println("Voornaam: "+voorNaam+ "\nAchternaam: "+achterNaam+"\nBSN: "+BSN+ "\nGeboortedatum: "+getGeboorteDatum()+"\nGeslacht: "+getGeslacht());
    }    
    
}