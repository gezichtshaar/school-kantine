public class Administratie {
    
    final static int DAYS_IN_WEEK=7;

    private Administratie() {
    }
    
     /**
     * Deze methode berekent van de int array aantal de 
     * gemiddelde waarde
     * @param aantal
     * @return het gemiddelde
     */
    static double berekenGemiddeldAantal(int[] aantal) {
        int n=0;
        int result=0;
        for(int elem : aantal) {
            result+=elem;
            n++;
        }
        return (double)result/n;
    }

    /**
     * Deze methode berekent van de double array omzet de 
     * gemiddelde waarde
     * @param omzet
     * @return Het gemiddelde
     */
    static double berekenGemiddeldeOmzet(double[] omzet) {
        int n=0;
        double result=0.0;
        for(double elem : omzet) {
            result+=elem;
            n++;
        }
        return result/n;
    }
    
    /**
     * Methode om dagomzet uit te rekenen
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */
    public static double[] berekenDagOmzet(double[] omzet) 
    {
        double[] temp=new double[DAYS_IN_WEEK];
        for(int i=0;i<DAYS_IN_WEEK;i++) {
            int j=0;
            while((i+DAYS_IN_WEEK*j) < omzet.length) {
                temp[i]+=omzet[i+DAYS_IN_WEEK*j];
                j++;
            }
        }
        return temp;
    }
}
