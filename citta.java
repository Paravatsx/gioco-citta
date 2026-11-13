public class citta{
    private edificio[][] griglia = new edificio[40][40];
    private int soldi = 20;
    private int popolazione;

    public void addEdificio(int x,int y,edificio e){
        griglia[x][y] = e;
    }

    public edificio getCella(int x,int y) {
        return griglia[x][y];
    }

    public int removeEdificio(int x,int y){
        int soldi = griglia[x][y].getCosto();
        griglia[x][y] = null;
        return soldi;
    }

    public int getSoldi() {
        return soldi;
    }

    public void setSoldi(int soldi) {
        this.soldi = soldi;
    }

    public int getPopolazione() {
        return popolazione;
    }
}
