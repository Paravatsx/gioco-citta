import java.awt.Color;

public class negozio extends edificio {
    private final  int postiLavoro = 3;
    private  int guadagno = 5;
    private boolean  isFull = false;

    public negozio(){
        colore = new Color(65,105,225);
        nome = "negozio: 5$";
        costo = 5;
    }

    public negozio(negozio n){
        colore = n.colore;
        nome = n.nome;
        costo = n.costo;
        guadagno = n.guadagno;
        isFull = n.isFull;
    }

    public int getGuadagno() {
        return guadagno;
    }

    public boolean getFull(){
        return isFull;
    }

    public void setFull(boolean isFull) {
        this.isFull = isFull;
    }
    public int getGuadagnoTAX(double tax) {
        return (int)(guadagno*tax);
    }
    
    public int getPostilavoro() {
        return postiLavoro;
    }

    
}
