public class Spiel
{
    private Frage [] spielFragen = new Frage[15];
    private int anzahlFragen = 0;
    private int aktuelleFrage = -1;
    private Stufe sicherheitsStufe1;
    private Stufe sicherheitsStufe2;
    private boolean gewonnen;
    private boolean telefonjoker = true, fiftyfiftyjoker = true, publikumjoker = true;
    
    public Spiel()
    {
        
    }
    
    public Frage getNächsteFrage() {
        aktuelleFrage++;
        return spielFragen[aktuelleFrage];
    }
    
    public Frage getFrageNr(int i) {
        return spielFragen[i];
    }
    
    public void setSpielfragen(Frage[] spielFragen) {
        if(spielFragen.length==15) {
            this.spielFragen = spielFragen;
        }
    }
    public Frage[] getSpielFragen() {
        return spielFragen;
    }

    public void addFrage(Frage frage){
        if(spielFragen.length>anzahlFragen){
            spielFragen[anzahlFragen] = frage;
            anzahlFragen++;
        }
    }
    public void removeFrage(Frage frage) {
        int i = 0;
        for (Frage spielFrage : spielFragen) {
            if (spielFrage==frage) {
                spielFragen[i] = null;
            }
            i++;
        }
    }
    
    public void setAnzahlFragen(int anzahlFragen) {
        this.anzahlFragen = anzahlFragen;
    }
    public int getAnzahlFragen() {
        return this.anzahlFragen;
    }
    
    public void setAktuelleFrage(int aktuelleFrage) {
        this.aktuelleFrage = aktuelleFrage;
    }
    public int getAktuelleFrage() {
        return this.aktuelleFrage;
    }
    
    public void setSicherheitsStufe1(Stufe sicherheitsStufe1) {
        this.sicherheitsStufe1 = sicherheitsStufe1;
    }
    public Stufe getSicherheitsStufe1() {
        return this.sicherheitsStufe1;
    }
    
    public void setSicherheitsStufe2(Stufe sicherheitsStufe2) {
        this.sicherheitsStufe2 = sicherheitsStufe2;
    }
    public Stufe getSicherheitsStufe2() {
        return this.sicherheitsStufe2;
    }
    
    public void setGewonnen(boolean gewonnen) {
        this.gewonnen = gewonnen;
    }
    public boolean getGewonnen() {
        return this.gewonnen;
    }
    
    public void setTelefonjoker(boolean vorhanden) {
        this.telefonjoker = vorhanden;
    }
    public boolean getTelefonjoker() {
        return this.telefonjoker;
    }
    
    public void setFiftyfiftyjoker(boolean vorhanden) {
        this.fiftyfiftyjoker = vorhanden;
    }
    public boolean getFiftyfiftyjoker() {
        return this.fiftyfiftyjoker;
    }
    
    public void setPublikumjoker(boolean vorhanden) {
        this.publikumjoker = vorhanden;
    }
    public boolean getPublikumjoker() {
        return this.publikumjoker;
    }
}
