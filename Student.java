
/**
 * Write a description of class Student here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Student extends Persoon
{
    private int studentnummer;
    private String studierichting;

    public Student(int studentnummer, String studierichting) {
        this.studentnummer=studentnummer;
        this.studierichting=studierichting; 
    }

    public Student(String BSN, String voorNaam, String achterNaam, int geboorteDag, int geboorteMaand, int geboorteJaar, char geslacht, int studentnummer, String studierichting) {
        super(BSN, voorNaam, achterNaam, geboorteDag, geboorteMaand, geboorteJaar, geslacht);
        this.studentnummer=studentnummer;
        this.studierichting=studierichting;
    }

    public int getStudentnummer(int studentnummer) {
        return studentnummer; 
    }

    public String getStudierichting(String studierichting) {
        return studierichting; 
    }

    @Override
    public String toString() {
        return super.toString()+"\nstudentnummer : "+studentnummer+"\nteststudierichting : "+studierichting;
    }

    public void setStudierichting(String studierichting) {
        this.studierichting = studierichting; 
    }

    public void setStudentnummer(int studentnummer) {
        this.studentnummer = studentnummer; 
    }
}
