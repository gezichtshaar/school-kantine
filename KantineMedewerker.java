
/**
 * Write a description of class KantineMedewerker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KantineMedewerker extends Persoon
{
    private boolean kassarecht;
    private int medewerkernummer;
    
    public KantineMedewerker() {
        super();
    }
    
    public void setKassarecht(boolean kassarecht) {
        this.kassarecht = kassarecht;
    }
    
    public boolean getKassarecht() {
        return kassarecht;
    }
    
    public void setMedewerkernummer(int medewerkernummer) {
      this.medewerkernummer = medewerkernummer;  
    }
    
    public int getMedewerkernummer() {
        return medewerkernummer;
    }
    
    @Override
    public void drukAf() {
        System.out.println("\nkassarecht : "+kassarecht+"\nmedewerkernummer : "+medewerkernummer);
    }
}
