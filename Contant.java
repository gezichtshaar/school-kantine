
/**
 * Write a description of class Contant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Contant extends Betaalwijze {
    /**
     * Methode om betaling af te handelen
     */
    public void betaal(double tebetalen) throws TeWeinigGeldException {
        if(saldo-tebetalen > 0) {
            saldo-=tebetalen;
        }else{
            throw new TeWeinigGeldException(Double.toString((saldo-tebetalen)*-1));
        }
    }
}
