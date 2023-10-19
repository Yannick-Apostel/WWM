public class Publikumsjoker {
   
   
   public  Antwort AntwortPublikumsjoker(Antwort a1, Antwort a2, Antwort a3, Antwort a4) {
     Services zufallsgen = new Services();

     int zufallzahl = zufallsgen.erzeugeZufallszahl(1, 4);

     switch(zufallzahl){
      case 1: return a1;
      case 2: return a2;
      case 3: return a3; 
      case 4: return a4;
     }

     return null;
   }
}
