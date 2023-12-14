import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Frage
{
    private String titel;
    private String text;
    private Stufe stufe;
    private boolean wurdeSchonMalBenutzt = false;
    private ArrayList<Antwort> antwortenListe = new <Antwort>ArrayList();
    
    public Frage (boolean mitTestWerten){
        int zufahllszahlFragenText;
        if(mitTestWerten){
            addAntwort("Paris",false);
            addAntwort("Berlin",true);
            addAntwort("Bonn",true);
            addAntwort("Rom",false);
            addAntwort("London",false);
            addAntwort("New York",false);
        }
    }
    public Frage(String titel, String text, Stufe stufe){
        this.titel=titel;
        this.text = text;
        this.stufe = stufe;
    }
    
    public void setTitel(String titel){
        this.titel=titel;
    }
    public String getTitel(){
        return titel;
    }
    
    public void setText(String text){
        this.text=text;
    }
    public String getText(){
        return text;
    }
    
    public void setStufe(Stufe stufe){
        if(stufe.getLevel() > 0 && stufe.getLevel() <= 15){
            this.stufe=stufe;
        }
    }
    public Stufe getStufe(){
        return stufe;
    }
    
    public void setWurdeSchonMalBenutzt(boolean wurdeSchonMalBenutzt){
        this.wurdeSchonMalBenutzt = wurdeSchonMalBenutzt;
    }
    public boolean getWurdeSchonMalBenutzt(){
        return wurdeSchonMalBenutzt;
    }
    
    public void setAntwortenListe(ArrayList<Antwort> antwortenListe) {
        this.antwortenListe = antwortenListe;
    }
    public ArrayList<Antwort> getAntwortenListe(){
        return antwortenListe;
    }
    
    public void addAntwort(Antwort antwort) {
        this.antwortenListe.add(antwort);
    }
    public void addAntwort(String antwortText, boolean istRichtig){
        Antwort antwort = new Antwort();
        antwort.setText(antwortText);
        antwort.setIstRichtig(istRichtig);
        if (antwortenListe.size()<4){
            if(istRichtig==true && getAnzahlRichtigeFalscheAnworten(true)<1){
                antwortenListe.add(antwort);
            }else if(istRichtig==false && getAnzahlRichtigeFalscheAnworten(false)<3){
                antwortenListe.add(antwort);
            }
        }
    }
    
    private int getAnzahlRichtigeFalscheAnworten(boolean richtigeOderFalsche){
        int zaehler=0;
        for(Antwort aktuelleAnworten:antwortenListe){
            if(aktuelleAnworten.getIstRichtig()==richtigeOderFalsche){
                zaehler++;
            }
        }
        return zaehler;
    }
}
