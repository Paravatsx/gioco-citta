import java.awt.BorderLayout;
import javax.swing.JFrame;

public class prova{
    static char edificio_selezionato;
    public static void main(String[] args){
        JFrame frame = new JFrame("Simulazione città");
        barra barra = new barra();

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(new  PannelloCitta(barra),BorderLayout.CENTER);
        frame.add(barra,BorderLayout.NORTH);
        //frame.pack();
        frame.setVisible(true);
    }
}
