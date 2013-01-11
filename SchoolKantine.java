import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class SchoolKantine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SchoolKantine
{
    private KantineSimulatie kantinesimulatie;

    private JFrame frame;
    private static JTextArea log;

    private JTextField artikelNaam;
    private JTextField artikelPrijs;
    private JTextField artikelHoeveelheid;
    
    private ArrayList<JTextField> simulatieinstellingen;
    private JTextField aantalDagen;

    public SchoolKantine()
    {
        simulatieinstellingen=new ArrayList();
        makeFrame();
        kantinesimulatie=new KantineSimulatie(Integer.parseInt(simulatieinstellingen.get(0).getText()), Integer.parseInt(simulatieinstellingen.get(1).getText()), Integer.parseInt(simulatieinstellingen.get(2).getText()), Integer.parseInt(simulatieinstellingen.get(3).getText()), Integer.parseInt(simulatieinstellingen.get(4).getText()), Integer.parseInt(simulatieinstellingen.get(5).getText()));
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void makeFrame() {
        frame=new JFrame("Schoolkantine project");
        Container contentPane=frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        JPanel instellingen=new JPanel();
        instellingen.setLayout(new GridLayout(0, 2));
        
        instellingen.add(new JLabel("Artikelnaam "));
        artikelNaam=new JTextField("");
        instellingen.add(artikelNaam);
        instellingen.add(new JLabel("artikelprijs "));
        artikelPrijs=new JTextField("");
        instellingen.add(artikelPrijs);
        instellingen.add(new JLabel("artikel hoeveelheid "));
        artikelHoeveelheid=new JTextField("");
        instellingen.add(artikelHoeveelheid);
        
        instellingen.add(new JLabel(""));
        JButton nieuwArtikel=new JButton("Voeg artikel toe");
        nieuwArtikel.addActionListener(new nieuwArtikel());
        instellingen.add(nieuwArtikel);
        

        JLabel minSoortText=new JLabel("Minimaal aantal artikelen per soort ");
        instellingen.add(minSoortText);
        simulatieinstellingen.add(new JTextField("0"));
        instellingen.add(simulatieinstellingen.get(0));

        JLabel maxSoortText=new JLabel("Maximaal aantal artikelen per soort ");
        instellingen.add(maxSoortText);
        simulatieinstellingen.add(new JTextField("100"));
        instellingen.add(simulatieinstellingen.get(1));

        JLabel minPersoonText=new JLabel("Minimaal aantal artikelen per persoon ");
        instellingen.add(minPersoonText);
        simulatieinstellingen.add(new JTextField("0"));
        instellingen.add(simulatieinstellingen.get(2));

        JLabel maxPersoonText=new JLabel("Maximaal aantal artikelen per persoon ");
        instellingen.add(maxPersoonText);
        simulatieinstellingen.add(new JTextField("100"));
        instellingen.add(simulatieinstellingen.get(3));

        JLabel minPersoonDagText=new JLabel("minimaal aantal personen per dag ");
        instellingen.add(minPersoonDagText);
        simulatieinstellingen.add(new JTextField("1"));
        instellingen.add(simulatieinstellingen.get(4));

        JLabel maxPersoonDagText=new JLabel("Maximaal aantal personen per dag ");
        instellingen.add(maxPersoonDagText);
        simulatieinstellingen.add(new JTextField("4"));
        instellingen.add(simulatieinstellingen.get(5));

        instellingen.add(new JLabel(""));
        JButton veranderInstellingen=new JButton("Verander instellingen");
        veranderInstellingen.addActionListener(new veranderinstelling());
        instellingen.add(veranderInstellingen);

        JLabel aantalDagenText=new JLabel("Aantal dagen ");
        instellingen.add(aantalDagenText);
        aantalDagen=new JTextField("1");
        instellingen.add(aantalDagen);

        instellingen.add(new JLabel(""));
        JButton simulatie=new JButton("start simulatie");
        simulatie.addActionListener(new startsimulatie());
        instellingen.add(simulatie);

        JPanel leftside=new JPanel();
        leftside.add(instellingen);
        contentPane.add(leftside, BorderLayout.EAST);

        log=new JTextArea();
        contentPane.add(log, BorderLayout.CENTER);
        
        JScrollPane scrollingArea = new JScrollPane(log);
        contentPane.add(scrollingArea);

        frame.setSize(500, 500);
        frame.pack();
        frame.setVisible(true);
    }

    public static void addToLog(String text) {
        if(log!=null) {
            log.append(text+"\n");
            log.setCaretPosition(log.getDocument().getLength());
        }

    }

    public class startsimulatie implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            aantalDagen.setText(Integer.toString(Math.abs(Integer.parseInt(aantalDagen.getText()))));
            kantinesimulatie.simuleer(Integer.parseInt(aantalDagen.getText()));
        }
    }

    public class veranderinstelling implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            int[] tmp=new int[simulatieinstellingen.size()];
            for(int e=0; e<simulatieinstellingen.size(); e++) {
                if(((e+1)%2) == 0 && Integer.parseInt(simulatieinstellingen.get(e-1).getText()) > Integer.parseInt(simulatieinstellingen.get(e).getText())) {
                    simulatieinstellingen.get(e).setText(simulatieinstellingen.get(e-1).getText());
                }else{
                    simulatieinstellingen.get(e).setText(Integer.toString(Math.abs(Integer.parseInt(simulatieinstellingen.get(e).getText()))));
                }
                tmp[e]=Integer.parseInt(simulatieinstellingen.get(e).getText());
            }
            kantinesimulatie.stelIn(tmp);
            addToLog("Instellingen veranderd");
        }
    }
    
    public class nieuwArtikel implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if(artikelNaam.getText().length()>0 && artikelPrijs.getText().length()>0 && artikelHoeveelheid.getText().length()>0) {
                kantinesimulatie.addArtikel(artikelNaam.getText(), Double.parseDouble(artikelPrijs.getText()), Integer.parseInt(artikelHoeveelheid.getText()));
                artikelNaam.setText("");
                artikelPrijs.setText("");
                artikelHoeveelheid.setText("");
                addToLog("artikel toegevoegd");
            }else{
                addToLog("Vul alle velden in");
            }
        }
    }
}

