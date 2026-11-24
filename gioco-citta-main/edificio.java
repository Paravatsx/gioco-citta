import java.awt.Color;

public abstract class edificio {
    protected  int costo;
    protected String nome;
    protected Color colore;
    protected boolean checked = false;
    public String getNome() {
        return nome;
    } 

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean getChecked(){
        return checked;
    }

    public int getCosto() {
        return costo;
    }
    public Color getColore() {
        return colore;
    }
}
