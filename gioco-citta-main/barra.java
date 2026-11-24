import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class barra extends JPanel{
    private char edificio_selezionato;
    private JLabel soldi = new JLabel();
    private JLabel popolazione = new JLabel();
    private JLabel giorni = new JLabel();
    private JPanel statPanel = new JPanel();
    private JLabel postiLetto = new JLabel("Posti Letto: ");
    private JLabel disoccupati = new JLabel("Disoccupati: ");
    private JLabel guadagnoGiornaliero = new JLabel("Guadagno giornalieri: ");
    private JLabel postiLavoro = new JLabel("Posti lavoro: ");
    

    public barra(JFrame frame){
        statPanel.setLayout(new BoxLayout(statPanel, BoxLayout.Y_AXIS));
        postiLetto.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
        disoccupati.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
        guadagnoGiornaliero.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
        postiLavoro.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
        statPanel.add(postiLetto);
        statPanel.add(disoccupati);
        statPanel.add(guadagnoGiornaliero);
        statPanel.add(postiLavoro);

        edificio[] edifici = {new casa(),new negozio()};
        JButton bottoneRemove = new JButton("Rimuovi");
        bottoneRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edificio_selezionato = 'R';
            }
        });

        JButton stat = new JButton("Statistiche");
        stat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog(frame,"Statistiche");
                
                dialog.setSize(300,300);
                dialog.setResizable(false);
                dialog.setLocationRelativeTo(frame);
                dialog.add(statPanel);
                dialog.setVisible(true);
            }
        });
        this.add(giorni);
        this.add(soldi);
        this.add(popolazione);
        this.add(bottoneRemove);
        this.add(stat);
        for (edificio e : edifici) {
            JButton b = new JButton(e.getNome());
            if(e.getNome().equals("casa: 5$")){
                b.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       edificio_selezionato ='C';
                   } 
            });
            }if(e.getNome().equals("negozio: 5$")){
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        edificio_selezionato='D';
                    }
                });
            }
            this.add(b);
        }
        
    }

    public char getEdificio_selezionato() {
        return edificio_selezionato;
    }

    public void setEdificio_selezionato(char edificio_selezionato) {
        this.edificio_selezionato = edificio_selezionato;
    }

    public void setTextDenaro(String text){
        soldi.setText(text);
    }

    public void setTextGiorni(String text){
        giorni.setText(text);
    }

    public void setTextPopolazione(String text){
        popolazione.setText(text);
    }

    public void setTextPostiLetto(String text){
        postiLetto.setText(text);
    }
    public void setDisoccupati(String text){
        disoccupati.setText(text);
    }
    public void setGuadagnoGiornaliero(String text){
        guadagnoGiornaliero.setText(text);
    }
    public void setTextPostiLavoro(String text){
        postiLavoro.setText(text);
    }
}

