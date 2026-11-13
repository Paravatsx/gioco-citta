import java.awt.Color;

public class casa extends edificio {
    private int max_persone = 5;
    
    
    public casa(){
        costo = 5;
        nome = "casa: 5$";
        colore = new Color(150,75,0);
    }

    public int getMax_persone() {
        return max_persone;
    }
}
