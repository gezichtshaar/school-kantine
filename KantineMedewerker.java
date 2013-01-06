
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

    public KantineMedewerker(boolean kassarecht, int medewerkernummer) {
        this.kassarecht=kassarecht;
        this.medewerkernummer=medewerkernummer;
    }

    public KantineMedewerker(String BSN, String voorNaam, String achterNaam, int geboorteDag, int geboorteMaand, int geboorteJaar, char geslacht, boolean kassarecht, int medewerkernummer) {
        super(BSN, voorNaam, achterNaam, geboorteDag, geboorteMaand, geboorteJaar, geslacht);
        this.kassarecht=kassarecht;
        this.medewerkernummer=medewerkernummer;
    }

    public boolean getKassarecht() {
        return kassarecht;
    }

    public int getMedewerkernummer() {
        return medewerkernummer;
    }

    @Override
    public String toString() {
        return "\nkassarecht : "+kassarecht+"\nmedewerkernummer : "+medewerkernummer;
    }

    public void setMedewerkernummer(int medewerkernummer) {
        this.medewerkernummer = medewerkernummer;  
    }

    public void setKassarecht(boolean kassarecht) {
        this.kassarecht = kassarecht;
    }
}
