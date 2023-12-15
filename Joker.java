import java.util.Scanner;

public class Joker {

    private boolean usedTelefonjoker = false;
    private boolean usedPublikumsjoker = false;
    private boolean usedFiftyFiftyjoker = false;

    public Joker() {

    }

    public void zeigeMöglicheJoker() {
        System.out.println("Sie können zwischen diesen Jokern auswählen");

        if (!usedFiftyFiftyjoker) {
            System.out.println("1. FiftyFiftyJoker");
        }
        if (!usedPublikumsjoker) {
            System.out.println("2. Publikumsjoker");
        }
        if (!usedTelefonjoker) {
            System.out.println("3. Telefonjoker");
        }
        // wähleMöglichkeit();
    }

    public Antwort wähleMöglichkeit(Antwort antwort1, Antwort antwort2, Antwort antwort3, Antwort richtigeAntwort) {
        zeigeMöglicheJoker();
        Scanner input = new Scanner(System.in);
        int eingabe = input.nextInt();

        if (eingabe == 1) {
            usedFiftyFiftyjoker = true; // abfrage für fiftyfiftyJoker
            return useFiftyFiftyjoker(antwort1, antwort2, antwort3, richtigeAntwort);

        }
        else if (eingabe == 2){
            usedPublikumsjoker = true;
            return usePublikumsjoker(antwort1, antwort2, antwort3, richtigeAntwort);
        }else if (eingabe == 3){
            usedTelefonjoker = true;
            useTelefonjoker(antwort1, antwort2, antwort3, richtigeAntwort);
            return null;
        }
        input.close();
        return null;
    }

    public void setTelefonjoker(boolean pTelefonjoker) {
        this.usedTelefonjoker = pTelefonjoker;
    }

    public void setPublikumsjoker(boolean pPublikumsjoker) {
        this.usedPublikumsjoker = pPublikumsjoker;
    }

    public void setFiftyFiftyjoker(boolean pFiftyFiftyjoker) {
        this.usedFiftyFiftyjoker = pFiftyFiftyjoker;
    }

    public Antwort  useFiftyFiftyjoker(Antwort antwort1, Antwort antwort2, Antwort antwort3,
            Antwort richtigeAntwort) {
        fiftyfiftyJoker Joker = new fiftyfiftyJoker(antwort1, antwort2, antwort3, richtigeAntwort);
        Scanner input = new Scanner(System.in);

        System.out.println(Joker.getFalscheAntwort().getAntwortText());
        System.out.println(Joker.getRichtigeAntwort().getAntwortText()); // TODO : Zufällig richtige und Falsche Antwort
                                                                         // wiedergeben

        int antwort = input.nextInt();
        switch (antwort) {
            case 1:
                return Joker.getFalscheAntwort();
                
            case 2:
                return Joker.getRichtigeAntwort();
                
            default:
                break;
        }
       return null;
    }

    public Antwort usePublikumsjoker(Antwort antwort1, Antwort antwort2, Antwort antwort3, Antwort antwort4) {
        Publikumsjoker publikumsjoker = new Publikumsjoker();
        Scanner input = new Scanner(System.in);

        
        int[] wahrscheinlichkieten = publikumsjoker.generiereZahlenMitSumme(4, 100);
        System.out.println("Das Publikum zeigt folgende Werte ");
        System.out.println(antwort1 +" " + wahrscheinlichkieten[0] +"%");
        System.out.println(antwort2 +" " + wahrscheinlichkieten[1] +"%");
        System.out.println(antwort3 +" " + wahrscheinlichkieten[2] +"%");
        System.out.println(antwort4 +" " + wahrscheinlichkieten[3] +"%");
        System.out.println("Welcher dieser Antworten möchten Sie wählen?");

            int innumb = input.nextInt();
            switch (innumb) {
                case 1:
                    return antwort1;
                case 2:
                    return antwort2;
                case 3:
                    return antwort3;
                case 4:
                    return antwort4;
            }
        

        return null;
    }

    public Antwort useTelefonjoker(Antwort antwort1, Antwort antwort2, Antwort antwort3, Antwort antwort4){
        Telefonjoker telefonjoker = new Telefonjoker(antwort1, antwort2, antwort3, antwort4);
        int antwort = telefonjoker.KontakteAuswaehlen();
        Antwort antwortTeleJ=null;
        Scanner input = new Scanner(System.in);
         switch (antwort){
                case 1:  antwortTeleJ = antwort1; System.out.print("Ihr Telefonjoker wählt die Antwort: " +antwort1.getAntwortText() ); 
                case 2:  antwortTeleJ = antwort2; System.out.print("Ihr Telefonjoker wählt die Antwort: " +antwort2.getAntwortText() ); 
                case 3:  antwortTeleJ = antwort3; System.out.print("Ihr Telefonjoker wählt die Antwort: " +antwort3.getAntwortText() ); 
                case 4:  antwortTeleJ = antwort4; System.out.print("Ihr Telefonjoker wählt die Antwort: " +antwort4.getAntwortText() ); 
            }

            System.out.println("Möchten Sie diese Antwort wählen?  (J/N)");
            if(input.next().toLowerCase().equals("j")){
            return antwortTeleJ;
        }else { 
            System.out.println("Folgende Antworten stehen zur Verfügung: ");
            System.out.println(antwort1);
            System.out.println(antwort2);
            System.out.println(antwort3);
            System.out.println(antwort4);

            int innumb = input.nextInt();
            switch (innumb){
                case 1: return antwort1;
                case 2: return antwort2;
                case 3: return antwort3;
                case 4: return antwort4;
            }
        }
        return null;

    }
}
