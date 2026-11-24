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
                if(citta.getSoldi()>0)
                    barra.setTextDenaro("Denaro: "+citta.getSoldi()+"$");
                else
                    barra.setTextDenaro("Denaro: Esaurito");                   
                repaint();
            }
        });
    }

    public void avanzaGiorno(){
        //Scorro la griglia per vedere quanti edifici e quali ho 
        edificio[][] griglia = citta.getGriglia();
        for (int x = 0; x < griglia.length; x++) {
            for (int y = 0; y < griglia[0].length; y++) {
                //le case aumentano la popolazione che posso ospitare(ma non effettiva)
                if(griglia[x][y] instanceof casa && griglia[x][y].getChecked() == false){
                    citta.setPossibilePopolazione(citta.getPossibilePopolazione()+new casa().getMax_persone());
                    griglia[x][y].setChecked(true);
                }
                //i negozi creano posti di lavori
                else if(griglia[x][y] instanceof negozio && griglia[x][y].getChecked() == false){
                    citta.setPostiLavoro(citta.getPostiLavoro()+new negozio().getPostilavoro());
                    griglia[x][y].setChecked(true);
                }

            }
        }

        //LOGICA DIETRO SE PIAZZI UNA CASA MA NON C'é LAVORO LA POPOLAZIONE NON AUMENTA
        if(citta.getPossibilePopolazione()<=citta.getPostiLavoro())
            citta.setPopolazione(citta.getPossibilePopolazione());
        if(citta.getPopolazione()>citta.getPossibilePopolazione())
            citta.setPopolazione(citta.getPossibilePopolazione());

        citta.addGuadagno();
        System.out.println("Soldi: "+citta.getSoldi());
        
    }
    
    

    public int getCasa(){
        return citta.getCasa();
    }

    public int getDisoccupati(){
        return citta.getDisuccopazione();
    }

    public int getGuadagno_giornaliero(){
        return citta.getGuadagno_giornaliero();
    }
    
    public int getNegozio(){
        return citta.getNegozio();
    }

    public int getGiorni(){
        return citta.getGiorni();
    }

    public void setGiorni(int giorni){
        citta.setGiorni(giorni);
    }

    public int getPopolazione(){
        return citta.getPopolazione();
    }

    public int getPossibilePopolazione(){
        return citta.getPossibilePopolazione();
    }

     public int getPostiLavoro(){
        return citta.getPostiLavoro();
    }

    public int getSoldi(){
        return citta.getSoldi();
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
