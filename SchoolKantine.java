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
    private JFrame frame;
    private static JTextArea log;
    
    private JTextField minArtikelSoort;
    private JTextField maxArtikelSoort;
    private JTextField minArtikelPersoon;
    private JTextField maxArtikelPersoon;
    private JTextField minPersoonDag;
    private JTextField maxPersoonDag;
    private JTextField aantalDagen;
    
    
    public SchoolKantine()
    {
        makeFrame();
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
        
        JLabel minSoortText=new JLabel("Minimaal aantal artikelen per soort ");
        instellingen.add(minSoortText);
        minArtikelSoort=new JTextField("0");
        instellingen.add(minArtikelSoort);
        
        JLabel maxSoortText=new JLabel("Maximaal aantal artikelen per soort ");
        instellingen.add(maxSoortText);
        maxArtikelSoort=new JTextField("100");
        instellingen.add(maxArtikelSoort);
        
        JLabel minPersoonText=new JLabel("Maximaal aantal artikelen per persoon ");
        instellingen.add(minPersoonText);
        minArtikelPersoon=new JTextField("0");
        instellingen.add(minArtikelPersoon);
        
        JLabel maxPersoonText=new JLabel("Maximaal aantal artikelen per persoon ");
        instellingen.add(maxPersoonText);
        maxArtikelPersoon=new JTextField("100");
        instellingen.add(maxArtikelPersoon);
        
        JLabel minPersoonDagText=new JLabel("minimaal aantal personen per dag ");
        instellingen.add(minPersoonDagText);
        minPersoonDag=new JTextField("1");
        instellingen.add(minPersoonDag);
        
        JLabel maxPersoonDagText=new JLabel("Maximaal aantal personen per dag ");
        instellingen.add(maxPersoonDagText);
        maxPersoonDag=new JTextField("4");
        instellingen.add(maxPersoonDag);
        
        JLabel aantalDagenText=new JLabel("Aantal dagen ");
        instellingen.add(aantalDagenText);
        aantalDagen=new JTextField("1");
        instellingen.add(aantalDagen);
        
        JButton startSimulatie=new JButton("start simulatie");
        startSimulatie.addActionListener(new startsimulatie());
        instellingen.add(startSimulatie);
        
        JPanel leftside=new JPanel();
        leftside.add(instellingen);
        contentPane.add(leftside, BorderLayout.EAST);
        
        log=new JTextArea();
        contentPane.add(log, BorderLayout.CENTER);
        
        frame.setSize(300, 300);
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void addToLog(String text) {
            if(log!=null) {
                log.append(text+"\n");
            }
        
    }
    
    public class startsimulatie implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            KantineSimulatie kantinesimulatie=new KantineSimulatie(Integer.parseInt(minArtikelSoort.getText()), Integer.parseInt(maxArtikelSoort.getText()), Integer.parseInt(minArtikelPersoon.getText()), Integer.parseInt(maxArtikelPersoon.getText()), Integer.parseInt(minPersoonDag.getText()), Integer.parseInt(maxPersoonDag.getText()));
            kantinesimulatie.simuleer(Integer.parseInt(aantalDagen.getText()));
        }
    }
    
}
