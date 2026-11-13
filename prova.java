import java.awt.BorderLayout;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;

public class prova{
    static char edificio_selezionato;
    public static void main(String[] args){
        JFrame frame = new JFrame("Simulazione città");
        barra barra = new barra();
        PannelloCitta pannelloCitta = new PannelloCitta(barra);

        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(pannelloCitta,BorderLayout.CENTER);
        frame.add(barra,BorderLayout.NORTH);
        //frame.pack();
        frame.setVisible(true);

        while (true) {
            pannelloCitta.setGiorni(pannelloCitta.getGiorni()+1);
            barra.setTextGiorni("Giorni: "+String.valueOf(pannelloCitta.getGiorni()));;
            try {
                TimeUnit.SECONDS.sleep(3);
                pannelloCitta.epaint();
            } catch (Exception e) {
                System.out.print("Errore");
            }
            
        }
    }
}
