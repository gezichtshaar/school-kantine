
/**
 * Write a description of interface KortingskaartHouder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface KortingskaartHouder
{
    // methode om kortingspercentage op te vragen
    public double geefKortingsPercentage();
    // methode om op te vragen of er maximum per keer aan de korting zit
    public boolean heeftMaximum();
    // methode om het maximum kortingsbedrag op te vragen
    public double geefMaximum();
}
