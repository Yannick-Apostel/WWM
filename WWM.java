import java.util.*;
public class WWM
{
    private ArrayList<Frage> fragenKatalog = new ArrayList<Frage>();
    private ArrayList<Spiel> spielHistorie = new ArrayList<Spiel>();
    private Spiel aktuellesSpiel=null;       
    
    public WWM(int anzahlZuGenerierenderTestFragen){
        
        if(anzahlZuGenerierenderTestFragen>0){
            
            int zufallszahlTitel, zufahllszahlFragenText, zufallsZahllStufe;
            int zuFallsZahlText;
            boolean zuFälligRichtigOderFalsch;
            
            for(int i=0;anzahlZuGenerierenderTestFragen>i;i++ ){
                
                zufallszahlTitel = Services.erzeugeZufallszahl(1000000,9000000);
                zuFallsZahlText = Services.erzeugeZufallszahl(1000000,9000000);
                zufallsZahllStufe =  Services.erzeugeZufallszahl(1,15);
                Frage eineFrage = new Frage(new Integer(zufallszahlTitel).toString(),new Integer(zuFallsZahlText).toString(),zufallsZahllStufe);
                
                zuFallsZahlText = Services.erzeugeZufallszahl(1000000,9000000);
                eineFrage.addAntwort(new Integer(zuFallsZahlText).toString(),true);
                zuFallsZahlText = Services.erzeugeZufallszahl(1000000,9000000);
                eineFrage.addAntwort(new Integer(zuFallsZahlText).toString(),false);
                zuFallsZahlText = Services.erzeugeZufallszahl(1000000,9000000);
                eineFrage.addAntwort(new Integer(zuFallsZahlText).toString(),false);
                zuFallsZahlText = Services.erzeugeZufallszahl(1000000,9000000);
                eineFrage.addAntwort(new Integer(zuFallsZahlText).toString(),false);
                
                fragenKatalog.add(eineFrage);
            }
            
            // Frage eineFrage = new Frage("Weltmeister","Wer war am häuigsten FIFA-Weltmeister?",3);
            // fragenKatalog.add(eineFrage);
            // eineFrage = new Frage("Hauptstadt","Wie heißt die Hauptstadt von Deutschland?",1);
            // fragenKatalog.add(eineFrage);
            // eineFrage = new Frage("Präsident","Welcher Präsident ist ein Berliner",5);
            // fragenKatalog.add(eineFrage);
            
            // erstelleSpiel();
        }
        
    }

    public Spiel getaktuellesSpiel(){
        return aktuellesSpiel;
    }
    
    public Frage gibFrageAuFragenKatalog(int stufe){
            for(Frage aktuelleFrage:fragenKatalog){
                if(aktuelleFrage.getStufe()==stufe && aktuelleFrage.getWurdeSchonMalBenutz()==false ){
                    aktuelleFrage.setWurdeSchonMalBenutz(true);
                    return aktuelleFrage;
                }  
            }
            return null;
    }
    
    public void erstelleSpiel(){
        Spiel einSpiel = new Spiel();
        aktuellesSpiel = einSpiel;
        int anzahlFragen = 15;
        for (int i=1; anzahlFragen>=i;i++){
            Frage eineFrage = gibFrageAuFragenKatalog(i);
            if(eineFrage!=null){
                einSpiel.addFrage(eineFrage);
            }
        }
        spielHistorie.add(einSpiel);
    }
    
    
    
}
