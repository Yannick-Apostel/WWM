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

        if (eingabe == 1) { // abfrage für fiftyfiftyJoker
            return useFiftyFiftyjoker(antwort1, antwort2, antwort3, richtigeAntwort);

        }
        else if (eingabe == 2){
            return usePublikumsjoker(antwort1, antwort2, antwort3, richtigeAntwort);
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

    public Antwort usePublikumsjoker(Antwort antwort1, Antwort antwort2, Antwort antwort3, Antwort antwort4){
        Publikumsjoker publikumsjoker = new Publikumsjoker();
        Scanner input = new Scanner(System.in);

        Antwort answet = publikumsjoker.AntwortPublikumsjoker(antwort1, antwort2, antwort3, antwort4);
        System.out.println("Das Publikum: " +answet);
        System.out.println("möchten Sie diese Antwort wählen? (J/N)");
        if(input.next().toLowerCase().equals("j")){

        }


        return null;
    }
}
