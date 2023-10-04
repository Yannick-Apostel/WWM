

import java.util.*;
public class Frage
{
    private String titel;
    private String text;
    private int stufe;
    private boolean wurdeSchonMalBenutz=false;
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
    
    
    public Frage(String titel, String text, int stufe){
        this.titel=titel;
        this.text = text;
        this.stufe = stufe;
        
        
    }
    
    public void addAntwort(String antwortText, boolean istRichtig){
        Antwort antwort = new Antwort();
        antwort.setAnwortText(antwortText);
        antwort.setIstAnwortRichtig(istRichtig);
        if (antwortenListe.size()<4){
            if(istRichtig==true && gibAnzahlRichtigeFalscheAnworten(true)<1){
                antwortenListe.add(antwort);
            }else if(istRichtig==false && gibAnzahlRichtigeFalscheAnworten(false)<3){
                antwortenListe.add(antwort);
            }
        }
    }
    
    private int gibAnzahlRichtigeFalscheAnworten(boolean istRichtig){
        int zaehler=0;
        for(Antwort aktuelleAnworten:antwortenListe){
            if(aktuelleAnworten.getIstAnwortRichtig()==istRichtig){
                zaehler++;
            }
        }
        return zaehler;
    }
    
    public ArrayList<Antwort> getAntwortenListe(){
        return antwortenListe;
    }
    
    public void setWurdeSchonMalBenutz(boolean wurdeSchonMalBenutz){
        this.wurdeSchonMalBenutz = wurdeSchonMalBenutz;
    }
    
    public boolean getWurdeSchonMalBenutz(){
        return wurdeSchonMalBenutz;
    }
    public void setTitel(String titel){
        this.titel=titel;
    }
    
    public void setText(String text){
        this.text=text;
    }
    
    public void setStufe(int stufe){
        if(stufe>0 & stufe <=15){
            this.stufe=stufe;
        }
    }
    
    public String getTitel(){
        return titel;
    }
    
    public String getText(){
        return text;
    }
    
    public int getStufe(){
        return stufe;
    }
    
}
