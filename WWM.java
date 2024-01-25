import java.util.*;
public class WWM
{
    private ArrayList<Frage> fragenKatalog = new ArrayList<Frage>();
    private ArrayList<Spiel> spielHistorie = new ArrayList<Spiel>();
    private Spiel aktuellesSpiel=null;       
    
    public WWM(int anzahlZuGenerierenderTestFragen){
        
        //if(anzahlZuGenerierenderTestFragen>0){
            
           /* int zufallszahlTitel, zufahllszahlFragenText, zufallsZahllStufe;
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
            }*/
            
            Frage eineFrage = new Frage("IF it works dont touch it","IF it works dont touch it",3);
            //IF it works dont touch it!
            fragenKatalog.add(eineFrage);


            Frage Frage1= new Frage(" ... Apostel?","... Apostel?",3);
            Frage1.addAntwort("Yannick",true);
            Frage1.addAntwort("Jannick",false);
            Frage1.addAntwort("Gannick",false);
            Frage1.addAntwort("Cannick",false);
            fragenKatalog.add(Frage1);

            Frage Frage2= new Frage("5+5","5+5=?",3);
            Frage2.addAntwort("4",false);
            Frage2.addAntwort("6",false);
            Frage2.addAntwort("5",false);
            Frage2.addAntwort("10",true);
            fragenKatalog.add(Frage2);

            
            
            erstelleSpiel();
        //}
        
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
