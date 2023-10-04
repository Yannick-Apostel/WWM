

public class Spiel
{
    Frage [] spielFragen = new Frage[16];
    int anzahlFragen=0;
    int aktuelleFrage=-1; // represäntiert die spielstufe
    public Spiel()
    {
        
    }

    public void addFrage(Frage eineFrage){
        if(spielFragen.length>anzahlFragen){
            spielFragen[anzahlFragen]= eineFrage;
            anzahlFragen++;
        }
    }

    //public Frage gibdieNaechsteFrage(){
     //   int testzahl =0;
     //   do{
     //       testzahl++;
     //       aktuelleFrage++;
     //   }while(false);
        //aktuelleFrage++;
     //   return spielFragen[aktuelleFrage];

   // }

   public Frage gibdieNaechsteFrage() {
        if (aktuelleFrage + 1 < anzahlFragen) {
        aktuelleFrage++;
        return spielFragen[aktuelleFrage];
    } else {
        aktuelleFrage = -1;
        return null; 
    }
}
}
