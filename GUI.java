import java.util.Scanner;

public class GUI {
    WWM einWWM = new WWM(500);
    Joker alleJoker;
    Scanner scan = new Scanner(System.in);

    public GUI() {

        starten();
    }

    public static void main(String[] args) {
        GUI hi = new GUI();
    }

    public void starten() {
        alleJoker = new Joker();
        Scanner input = new Scanner(System.in);
        int counter = 0;
        einWWM.erstelleSpiel();
        System.out.println("Herzlich Willkommen zu WWM!");
        System.out.println("Geben Sie die 1.Gewinnstufe ein");
        int stufe1 = input.nextInt();
        System.out.println("Geben Sie die 2.Gewinnstufe ein");
        int stufe2 = input.nextInt();

        Gewinnstufe stufe = new Gewinnstufe(stufe1, stufe2);

        for (int i = 0; i < 15; i++) {
            Frage aktuelleFrage = einWWM.getaktuellesSpiel().gibdieNaechsteFrage();
            System.out.println("Hier die " + (i + 1) + ".Frage: " + aktuelleFrage.getText());
            System.out.println("Bitte wählen Sie eine Antwort aus: ");

            for (Antwort aktuelleAntwort : aktuelleFrage.getAntwortenListe()) {
                counter++;
                System.out.println(counter + ". " + aktuelleAntwort.getAntwortText());
            }
            System.out.println("5. Joker benutzen");
            counter = 0;
            int antwort = scan.nextInt();
            antwort -= 1;
            if (antwort == 4) {
               int anzahl=0;
                Antwort JokerAntwort = zeigeMöglicheJoker(aktuelleFrage.getAntwortenListe().get(0), aktuelleFrage.getAntwortenListe().get(1), aktuelleFrage.getAntwortenListe().get(2), aktuelleFrage.getAntwortenListe().get(3)); // Die vierte Antwort ist die richtige Antwort TODO: anpassen
                
                for (Antwort aktuelleAntwort : aktuelleFrage.getAntwortenListe()) {
                    anzahl++;
                    if(JokerAntwort == aktuelleAntwort){
                        antwort = anzahl;
                        break;
                    }else{
                        continue;
                    }
                }
                 antwort -=1;   
                
            


            } 
             if (aktuelleFrage.getAntwortenListe().get(antwort).getIstAnwortRichtig()) {
                System.out.println("Herzlichen Glückwunsch, das war richtig!");
            }
            else {
                System.out.println("Oh! Leider falsch");
                System.out.println("Sie haben " + stufe.checkGewinnstufe(i) + " Euro gewonnen.");
                System.out.println("Möchten Sie nochmal spielen? J für Ja und N für Nein!");
                String AntwortStr = scan.next();

                if (AntwortStr.toLowerCase().equals("j")) {
                    starten();
                } else {
                    System.out.println("Auf Wiedersehen!");
                    System.exit(0);
                }
            }
        }
        System.out.println("GEWONNEN");
        askForANewGame();
    }

    public int checkinputAntwort(int antwort) {
        int newAntwort = 0;
        Scanner input = new Scanner(System.in);
        if (antwort >= 4) {
            System.out.println("Ungültige Eingabe, geben Sie nur Zahlen von 1-4 ein");
            while (true) {
                newAntwort = input.nextInt();
                if (newAntwort >= 4) {
                    System.out.println("Ungültige Eingabe, geben Sie nur Zahlen von 1-4 ein");
                } else {
                    break;
                }
            }
        }
        input.close();

        return newAntwort;
    }

    public void askForANewGame() {
        Scanner Input = new Scanner(System.in);
        System.out.println("Möchtest du eine neue Runde starten? (J/N)");
        String input = Input.next().toLowerCase();
        Input.close();
        if (input.equals("j")) {
            starten();
        } else {
            System.out.println("Auf Wiedersehen!");
            System.exit(0);
        }

    }

    public Antwort zeigeMöglicheJoker(Antwort antwort1, Antwort antwort2, Antwort antwort3, Antwort richtigeAntwort) {
        return alleJoker.wähleMöglichkeit( antwort1,  antwort2,  antwort3,  richtigeAntwort);

    }

}
