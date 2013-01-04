
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
    
    public Student() {
       super();
    }
    
    public void setStudentnummer(int studentnummer) {
        this.studentnummer = studentnummer; 
    }
    
    public int getStudentnummer(int studentnummer) {
        return studentnummer; 
    }
    
    public void setStudierichting(String studierichting) {
        this.studierichting = studierichting; 
    }
    
    public String getStudierichting(String studierichting) {
        return studierichting; 
    }
    
    @Override
    public void drukAf() {
        System.out.println("\nstudentnummer : "+studentnummer+"\nteststudierichting : "+studierichting);
    }
}
