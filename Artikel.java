public class Artikel
{
    // instance variables - replace the example below with your own
    private double prijs;
    private String naam;
    

    
    public Artikel(String naam, double prijs){
     this.naam=naam;   
     this.prijs=prijs;  // initialise instance variables
     }
     
    public double getPrijsArtikel(){
         return prijs;
    }
     
    public void setPrijsArtikel(int prijs){
        this.prijs=prijs;
    }
        
    public void setNaamArtikel(String naam){
        this.naam=naam;
    }
     
    public String getNaamArtikel(){
         return naam;
    }
         
    @Override
    public String toString(){
        return "Artikel: "+naam+"\nPrijs: "+prijs;
    }
}