import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class barra extends JPanel{
    private char edificio_selezionato;
    private JLabel soldi = new JLabel();
    private JLabel popolazione = new JLabel();

    public barra(){
        edificio[] edifici = {new casa(),new negozio()};
        JButton bottoneRemove = new JButton("Rimuovi");
        this.add(soldi);
        this.add(popolazione);
        this.add(bottoneRemove);
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

    public void setTextPopolazione(String text){
        popolazione.setText(text);
    }
}

