import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class GUI
{
    private WWM wwm = new WWM();
    private Scanner scan = new Scanner(System.in);
    private Scanner scanInt = new Scanner(System.in);
    
    public GUI() {
        starten();
    }
    
    public void starten() {
        System.out.println("Herzlich Willkommen bei Wer Wird Millionär!");
        wwm.erstelleSpiel();
        eingabeSicherheitsstufe(wwm.getAktuellesSpiel());
        System.out.println("Geben Sie \"E\" ein, um das Spiel zu verlassen.");
        System.out.println("Geben sie \"J\" ein, um einen Joker zu verwenden.");
        System.out.println();
        
        for (int i=0 ; i<wwm.getAktuellesSpiel().getSpielFragen().length ; i++) {
            Frage aktuelleFrage = wwm.getAktuellesSpiel().getFrageNr(i);
            System.out.println("Hier ist die " + aktuelleFrage.getStufe().getGeldString() + " Frage: " + aktuelleFrage.getText());
            System.out.println();
            System.out.println("Antwortmöglichkeiten:");
            int j=1;
            for (Antwort aktuelleAntwort : aktuelleFrage.getAntwortenListe()) {
                switch (j) {
                    case 1: System.out.print("A: "); break;
                    case 2: System.out.print("B: "); break;
                    case 3: System.out.print("C: "); break;
                    case 4: System.out.print("D: "); break;
                }
                System.out.println(aktuelleAntwort.getText());
                j++;
            }
            
            int antwort;
            switch (scan.nextLine().toLowerCase()) {
                case "a": antwort = 0; break;
                case "b": antwort = 1; break;
                case "c": antwort = 2; break;
                case "d": antwort = 3; break;
                case "j": antwort = 4; break;
                case "e": antwort = 5; break;
                default: antwort = 6; break;
            }
            
            if (antwort==6) {
                System.out.println("Inkorrekte Eingabe");
                i--;
            }
            
            else if (antwort==4) {
                String joker = jokermenü(wwm.getAktuellesSpiel());
                if (joker != null) {
                    switch (joker) {
                        case "fj": aktuelleFrage = fiftyfiftyjoker(aktuelleFrage); break;
                        case "tj": telefonjoker(aktuelleFrage); break;
                        case "pj": publikumjoker(aktuelleFrage); break;
                    }
                }
                i--;
            }
            
            else if (antwortAuswertung(aktuelleFrage, antwort) == true) {
                if (aktuelleFrage.getStufe().getLevel() == 15) {
                    wwm.getAktuellesSpiel().setGewonnen(true);
                    wwm.addSpielToSpielHistorie(wwm.getAktuellesSpiel());
                }
            }
            
            else { 
                checkeSicherheitsstufe(wwm.getAktuellesSpiel(), aktuelleFrage);
                wwm.getAktuellesSpiel().setGewonnen(false);
                wwm.addSpielToSpielHistorie(wwm.getAktuellesSpiel());
                if(nochmalSpielen() == true) {
                    starten();
                }
            }
            
            System.out.println();
        }
        
        if (wwm.getAktuellesSpiel().getGewonnen() == true) {
            System.out.println("Herzlichen Glückwunsch! Sie haben 1.000.000€ gewonnen!");
        }
        if (nochmalSpielen() == true) {
            starten();
        }
    }
    
    public boolean antwortAuswertung(Frage aktuelleFrage, int antwort) {
        if (antwort==5) {
            System.out.println("Auf Wiedersehen!");
            System.exit(0);
            return false;
        } else if (aktuelleFrage.getAntwortenListe().get(antwort).getIstRichtig()==true) {
            System.out.println("Richtig!");
            return true;
        } else {
            System.out.println("Falsch.");
            return false;
        }
    }
    
    public String jokermenü(Spiel aktuellesSpiel) {
        Scanner scan = new Scanner(System.in);
        
        if(aktuellesSpiel.getPublikumjoker() == true || aktuellesSpiel.getTelefonjoker() == true || aktuellesSpiel.getFiftyfiftyjoker() == true) {
            System.out.println("Wählen Sie Ihren erwünschten Joker: ('x' = zurück)");
            if (aktuellesSpiel.getPublikumjoker() == true) {
                System.out.println("P: Publikumjoker");
            }
            if (aktuellesSpiel.getTelefonjoker() == true) {
                System.out.println("T: Telefonjoker");
            }
            if (aktuellesSpiel.getFiftyfiftyjoker() == true) {
                System.out.println("F: Fifty/Fifty-Joker");
            }
            String auswahl = scan.next().toLowerCase();
            if (auswahl.equals("x")) {
                return null;
            }
            else if (auswahl.equals("p") && aktuellesSpiel.getPublikumjoker() == true) {
                aktuellesSpiel.setPublikumjoker(false);
                return "pj";
            }
            else if (auswahl.equals("t") && aktuellesSpiel.getTelefonjoker() == true) {
                aktuellesSpiel.setTelefonjoker(false);
                return "tj";
            }
            else if (auswahl.equals("f") && aktuellesSpiel.getFiftyfiftyjoker() == true) {
                aktuellesSpiel.setFiftyfiftyjoker(false);
                return "fj";
            }
            else {
                System.out.println("Inkorrekte Eingabe");
                jokermenü(aktuellesSpiel);
            }
            System.out.println();
        } 
        else {
            System.out.println("Sie haben keine Joker mehr");
        }
        return null;
    }
    
    public Frage fiftyfiftyjoker(Frage aktuelleFrage) {
        Frage veränderteFrage = aktuelleFrage;
        
        Antwort richtigeAntwort = new Antwort(), falscheAntwort = new Antwort();
        int rng = (int)(Math.random() * 3);
        int i = 0;
        for (Antwort aktuelleAntwort : aktuelleFrage.getAntwortenListe()) {
            if (aktuelleAntwort.getIstRichtig() == true) {
                richtigeAntwort = aktuelleAntwort;
            }
            else {
                if (i == rng) {
                    falscheAntwort = aktuelleAntwort;
                }
                i++;
            }
        }
        
        ArrayList<Antwort> veränderteAntwortenListe = new ArrayList<Antwort>();
        veränderteAntwortenListe.add(richtigeAntwort);
        veränderteAntwortenListe.add(falscheAntwort);
        veränderteFrage.setAntwortenListe(veränderteAntwortenListe);
        
        return veränderteFrage;
    }
    
    public void telefonjoker(Frage aktuelleFrage) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Wen möchten Sie anrufen?");
        System.out.println("V: Vater");
        System.out.println("M: Mitschüler/Mitarbeiter");
        System.out.println("N: Nachbar");
        System.out.println("B: Bester Freund");
        System.out.println("P: Pablo");
        
        Antwort richtigeAntwort = new Antwort();
        ArrayList<Antwort> falscheAntworten = new ArrayList<Antwort>();
        for (Antwort aktuelleAntwort : aktuelleFrage.getAntwortenListe()) {
            if (aktuelleAntwort.getIstRichtig() == true) {
                richtigeAntwort = aktuelleAntwort;
            }
            else {
                falscheAntworten.add(aktuelleAntwort);
            }
        }
        String antwort = scan.next().toLowerCase();
        int rng = (int)(Math.random() * 21);
        int rng2 = (int)(Math.random() * 4);
        switch (antwort) {
            case "v":
                if (rng == 1) {
                    System.out.println("\"V: Die Antwort weiß ich auch nicht.\"");
                }
                else if (rng==2||rng==3||rng==4||rng==5||rng==6) {
                    System.out.println("\"V: Ich denke, die richtige Antwort ist \"" + 
                    falscheAntworten.get(rng2).getText() + "\".\"");
                }
                else {
                    System.out.println("\"V: Ich denke, die richtige Antwort ist \"" +
                    richtigeAntwort.getText() + "\".\"");
                }
                break;
            case "m":
                if (rng == 1) {
                    System.out.println("\"M: Woher soll ich das wissen?\"");
                }
                else if (rng==2||rng==3||rng==4||rng==5||rng==6) {
                    System.out.println("\"M: Meiner Meinung nach sollte \"" + 
                    falscheAntworten.get(rng2).getText() + "\" richtig sein.\"");
                }
                else {
                    System.out.println("\"M: Meiner Meinung nach sollte \"" +
                    richtigeAntwort.getText() + "\" richtig sein.\"");
                }
                break;
            case "n":
                if (rng == 1) {
                    System.out.println("\"N: Ich helf dir ja gern, aber hier hab ich auch keinen Plan.\"");
                }
                else if (rng==2||rng==3||rng==4||rng==5||rng==6) {
                    System.out.println("\"N: Wenn ich mich recht erinnere, ist es \"" + 
                    falscheAntworten.get(rng2).getText() + "\".\"");
                }
                else {
                    System.out.println("\"N: Wenn ich mich recht erinnere, ist es \"" +
                    richtigeAntwort.getText() + "\".\"");
                }
                break;
            case "b":
                if (rng == 1) {
                    System.out.println("\"B: Digga(h), keine Ahnung.\"");
                }
                else if (rng==2||rng==3||rng==4||rng==5||rng==6) {
                    System.out.println("\"B: 100 pro ist es \"" + 
                    falscheAntworten.get(rng2).getText() + "\".\"");
                }
                else {
                    System.out.println("\"B: 100 pro ist es \"" +
                    richtigeAntwort.getText() + "\".\"");
                }
                break;
            case "p":
                if (rng == 1) {
                    System.out.println("\"P: Sorry homie, da musst du allein durch.\"");
                }
                else if (rng==2||rng==3||rng==4||rng==5) {
                    System.out.println("\"P: Hombre, die Antwort die du suchst ist offensichtlich \"" + 
                    falscheAntworten.get(rng2).getText() + "\".\"");
                }
                else {
                    System.out.println("\"P: Hombre, die Antwort die du suchst ist offensichtlich \"" +
                    richtigeAntwort.getText() + "\".\"");
                }
                break;
            case "e":
                System.out.println("Auf Wiedersehen!");
                System.exit(0);
                break;
            default: 
                System.out.println("Inkorrekter Input");
                System.out.println();
                telefonjoker(aktuelleFrage);
        }
    }
    
    public void publikumjoker(Frage aktuelleFrage) {
        int rngRichtigeAntwort = (int)(Math.random() * ((75 - 25) + 1) + 25); // int rng = (int)(Math.random() * ((max - min) + 1) + min)
        int rngFalscheAntwort1 = (int)(Math.random() * ((100 - rngRichtigeAntwort) + 1));
        int rngFalscheAntwort2 = (int)(Math.random() * ((100 - rngRichtigeAntwort - rngFalscheAntwort1) + 1));
        int rngFalscheAntwort3 = 100 - rngRichtigeAntwort - rngFalscheAntwort1 - rngFalscheAntwort2;
        
        System.out.println("Das Publikum hat abgestimmt:");
        int rIndex = 0;
        for (int i = 1 ; i<=aktuelleFrage.getAntwortenListe().size() ; i++) {
            if (aktuelleFrage.getAntwortenListe().get(i-1).getIstRichtig()==true) {
                switch(i) {
                    case 1: System.out.print("A: " + rngRichtigeAntwort + "%, "); break;
                    case 2: System.out.print("B: " + rngRichtigeAntwort + "%, "); break;
                    case 3: System.out.print("C: " + rngRichtigeAntwort + "%, "); break;
                    case 4: System.out.print("D: " + rngRichtigeAntwort + "% "); break;
                }
                rIndex = i;
            }
            else {
                switch (rIndex) {
                    case 0: 
                    switch (i) {
                        case 1: System.out.print("A: " + rngFalscheAntwort1 + "%, "); break;
                        case 2: System.out.print("B: " + rngFalscheAntwort2 + "%, "); break;
                        case 3: System.out.print("C: " + rngFalscheAntwort3 + "%, "); break;
                    }
                    break;
                    case 1:
                    switch (i) {
                        case 2: System.out.print("B: " + rngFalscheAntwort1 + "%, "); break;
                        case 3: System.out.print("C: " + rngFalscheAntwort2 + "%, "); break;
                        case 4: System.out.print("D: " + rngFalscheAntwort3 + "% "); break;
                    }
                    break;
                    case 2:
                    switch (i) {
                        case 3: System.out.print("C: " + rngFalscheAntwort2 + "%, "); break;
                        case 4: System.out.print("D: " + rngFalscheAntwort3 + "% "); break;
                    }
                    break;
                    case 3:
                        System.out.print("D: " + rngFalscheAntwort3 + "%, "); 
                    break;
                }
            }
        }
        System.out.println();
    }
    
    public boolean nochmalSpielen() {
        System.out.println("Nochmal spielen? (j/n)");
        
        while (true) {
            String jn = scan.nextLine().toLowerCase();
            if (jn.equals("j")) {
                System.out.print('\u000C');
                wwm.resetFragenKatalog();
                return true;
            }
            else if (jn.equals("n")){
                System.out.println("Auf Wiedersehen!");
                System.exit(0);
                return false;
            }
            else {
                System.out.println("Inkorrekte Eingabe");
            }
        }
    }
    
    public void eingabeSicherheitsstufe(Spiel aktuellesSpiel) {
        System.out.println("1: 50€");
        System.out.println("2: 100€");
        System.out.println("3: 200€");
        System.out.println("4: 300€");
        System.out.println("5: 500€");
        System.out.println("6: 1.000€");
        System.out.println("7: 2.000€");
        System.out.println("8: 4.000€");
        System.out.println("9: 8.000€");
        System.out.println("10: 16.000€");
        System.out.println("11: 32.000€");
        System.out.println("12: 64.000€");
        System.out.println("13: 125.000€");
        System.out.println("14: 500.000€");
        System.out.println("15: 1.000.000€");
        
        System.out.println("Wo möchten Sie ihre erste Sicherheitstufe setzen? (Geben Sie die zugehörige Zahl ein)");
        try {
            Stufe stufe1 = new Stufe(scanInt.nextInt());
            if (stufe1.getLevel()>=1 && stufe1.getLevel()<=15) {
                aktuellesSpiel.setSicherheitsStufe1(stufe1);
            }
        } catch (InputMismatchException e) {
            System.out.println("Inkorrekter Input");
        }
        
        
        System.out.println("Wo möchten Sie ihre zweite Sicherheitsstufe setzen? (Darf nicht kleiner sein als Stufe 1)");
        try {
            Stufe stufe2 = new Stufe(scanInt.nextInt());
            if (stufe2.getLevel()>=1 && stufe2.getLevel()<=15 && stufe2.getLevel()>=aktuellesSpiel.getSicherheitsStufe1().getLevel()) {
                aktuellesSpiel.setSicherheitsStufe2(stufe2);
            }
        }catch (Exception e) {
            System.out.println("Error");
        }
    }
    
    public void spielVerlassen() {
        while (true) {
            System.out.println("Möchten Sie das Spiel verlassen? (j/n)");
            String eingabe = scan.nextLine().toLowerCase();
            if (eingabe.equals("j")) {
                System.out.println("Auf Wiedersehen!");
                System.exit(0);
            } else if (eingabe.equals("n")) {
                break;
            } else {}
        }
    }
    
    public void checkeSicherheitsstufe(Spiel aktuellesSpiel, Frage aktuelleFrage) {
        if (aktuelleFrage.getStufe().getLevel() > aktuellesSpiel.getSicherheitsStufe2().getLevel()) {
            System.out.println("Sie gewinnen dennoch dank ihrer zweiten Sicherheitsstufe " + aktuellesSpiel.getSicherheitsStufe2().getGeldString() + ". ");
        } else if (aktuelleFrage.getStufe().getLevel() > aktuellesSpiel.getSicherheitsStufe1().getLevel()) {
            System.out.println("Sie gewinnen dennoch dank ihrer ersten Sicherheitsstufe " + aktuellesSpiel.getSicherheitsStufe1().getGeldString() + ". ");
        } else {
            System.out.println("Sie gewinnen nichts.");
        }
    }
}
