public class citta{
    private edificio[][] griglia = new edificio[40][40];
    private int soldi = 20;
    private int guadagno_giornaliero;
    private int popolazione;
    private int possibilePopolazione;
    private int disuccopazione;
    private int postiLavoro;
    private int giorni = 0;
    private int Case,Negozi;
    

    public edificio[][] getGriglia() {
        return griglia;
    }

    public void getDisoccupati(){
        disuccopazione = popolazione-postiLavoro;
        System.out.println("dis: "+disuccopazione);
        if(disuccopazione >= 0){
            for (edificio[] e : griglia) {
                for (edificio ed : e) {
                    if(ed instanceof negozio){
                        ((negozio)ed).setFull(true);
                    }
                        
                }
            }
        }else{
            //CALCOLO I POSTI DI LAVORO EFFITTIVAMENTE OCCUPATI E LI DIVIDO PER OGNI NEGOZIO
            int negoziFull = (postiLavoro+disuccopazione)/new negozio().getPostilavoro();
            int cont =0;
            for (edificio[] e : griglia) {
                for (edificio ed : e) {
                    if(ed instanceof negozio && negoziFull!=cont){
                        cont+=1;
                        ((negozio)ed).setFull(true);
                    }else
                        break;
                        
                }
            }
            System.out.println(negoziFull);
        }
    }

    public void addGuadagno(){
        getDisoccupati();
        guadagno_giornaliero =(int)Math.ceil((new negozio().getGuadagnoTAX(0.20)*getNegozioFull())-disuccopazione*-0.2);
        System.out.println("Guadagno giornaliero: "+ guadagno_giornaliero);
        System.out.println("decremento Disoccupati: "+disuccopazione*-0.2);
        soldi+= guadagno_giornaliero;
    }

    public void addEdificio(int x,int y,edificio e){
        griglia[x][y] = e;
        if(e instanceof casa)
            Case+=1;
        else if(e instanceof negozio)
            Negozi+=1;
    }

    public edificio getCella(int x,int y) {
        return griglia[x][y];
    }

    public int removeEdificio(int x,int y){
        int soldi = griglia[x][y].getCosto();
        if(griglia[x][y] instanceof casa){
            possibilePopolazione-=new casa().getMax_persone();
        }else if(griglia[x][y] instanceof negozio){
            postiLavoro-= new negozio().getPostilavoro();
        }
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
    
    public void setPopolazione(int popolazione) {
        this.popolazione = popolazione;
    }

    public int getGiorni() {
        return giorni;
    }

    public void setGiorni(int giorni) {
        this.giorni = giorni;
    }
    public int getCasa() {
        return Case;
    }

    public int getNegozio() {
        return Negozi;
    }

    public int getNegozioFull() {
        int negozifull =0;
        for (edificio[] e : griglia) {
            for (edificio ed : e) {
                if(ed instanceof negozio && ((negozio)ed).getFull()){
                    negozifull+=1;
                }
            }
        }

        return negozifull;
    }

    public void setPossibilePopolazione(int possibilePopolazione) {
        this.possibilePopolazione = possibilePopolazione;
    }

    public int getPossibilePopolazione() {
        return possibilePopolazione;
    }

    public void setPostiLavoro(int postiLavoro) {
        this.postiLavoro = postiLavoro;
    }

    public int getPostiLavoro() {
        return postiLavoro;
    }

}
