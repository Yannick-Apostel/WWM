import java.util.Random;

public class Publikumsjoker {

  public int[] generiereZahlenMitSumme(int anzahlZahlen, int zielSumme) {
    Random rand = new Random();
    int[] zahlen = new int[anzahlZahlen];
    int aktuelleSumme = 0;

    
    for (int i = 0; i < anzahlZahlen - 1; i++) {
      zahlen[i] = rand.nextInt(zielSumme - aktuelleSumme);
      aktuelleSumme += zahlen[i];
    }

    
    zahlen[anzahlZahlen - 1] = zielSumme - aktuelleSumme;

    return zahlen;
  }

  public void ausgabe(int[] zahlen){
    for (int i : zahlen) {
      System.out.println(i);
    }
  }
}
