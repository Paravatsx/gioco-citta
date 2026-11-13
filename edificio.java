import java.awt.Color;

public abstract class edificio {
    protected  int costo;
    protected String nome;
    protected Color colore;
    public String getNome() {
        return nome;
    } 

    public int getCosto() {
        return costo;
    }
    public Color getColore() {
        return colore;
    }
}
