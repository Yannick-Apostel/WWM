import java.util.*;
public class Telefonjoker {
    ArrayList<String> Kontakte = new ArrayList<String>();
    public Telefonjoker() {
        super();
        
        
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Wer sind ihre drei Kontakte?");
        for(int i=0;i<3;i++){
        String userKontakt = scan.nextLine();
        Kontakte.add(userKontakt);
        }

        
    }
    
    public String auswahl(String wahl){
            for(String Kontakt:Kontakte){
                if(Kontakt.equals(wahl)){
                    return Kontakt;
                }
            }
            return "Kontakt nicht vorhanden";
            
        }
}