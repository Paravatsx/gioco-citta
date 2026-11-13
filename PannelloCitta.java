import javax.swing.JPanel;
import java.awt.*;

public class PannelloCitta extends JPanel{
    static final int N=10, CELLE = 40;
    private citta citta = new citta();

    public PannelloCitta(barra barra){
        setPreferredSize(new Dimension(N*CELLE,N*CELLE));
        barra.setTextDenaro("Denaro: "+citta.getSoldi()+ "$");
        barra.setTextPopolazione("Popolazione: "+citta.getPopolazione());

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent e){
                int x = e.getX() /CELLE;
                int y = e.getY()/CELLE;
                casa casa =  new casa();
                negozio negozio = new negozio();
                char edificio_selezionato = barra.getEdificio_selezionato();
                if(edificio_selezionato == 'C' && citta.getSoldi()>=casa.getCosto() && citta.getCella(x, y) == null){
                    citta.addEdificio(x, y,casa);
                    citta.setSoldi(citta.getSoldi()-casa.getCosto());
                    barra.setEdificio_selezionato('A');
                }else if(edificio_selezionato == 'D' && citta.getSoldi()>=negozio.getCosto() && citta.getCella(x, y) == null){
                    citta.addEdificio(x, y,negozio);
                    citta.setSoldi(citta.getSoldi()-negozio.getCosto());
                    barra.setEdificio_selezionato('A');
                }else if(edificio_selezionato == 'R' && citta.getCella(x, y) != null){
                    citta.setSoldi(citta.getSoldi()+citta.removeEdificio(x, y));
                    barra.setEdificio_selezionato('A');
                }
                System.out.println(x+" "+y);
                if(citta.getSoldi()>0)
                    barra.setTextDenaro("Denaro: "+citta.getSoldi()+"$");
                else
                    barra.setTextDenaro("Denaro: Esaurito");                   
                repaint();
            }
        });
    }

    public int getGiorni(){
        return citta.getGiorni();
    }

    public void setGiorni(int giorni){
        citta.setGiorni(giorni);
    }

    public void epaint(){
        repaint();
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(citta.getCella(i, j) ==null)
                    g.setColor(new Color(185,211,160));
                else
                    g.setColor(citta.getCella(i, j).getColore());
                g.fillRect(i*CELLE, j*CELLE, CELLE-2, CELLE-2);
            }
        }
    }

    
}
