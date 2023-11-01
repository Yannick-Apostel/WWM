import java.util.*;

public class Telefonjoker {
    ArrayList<String> Kontakte = new ArrayList<String>();

    public Telefonjoker(Antwort a1, Antwort a2, Antwort a3, Antwort a4) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Wer sind ihre drei Kontakte?");
        for (int i = 0; i < 3; i++) {
            String userKontakt = scan.nextLine();
            Kontakte.add(userKontakt);
        }

    }

    public int KontakteAuswaehlen() {
        System.out.println("Sie können zwischen folgenden Kontakten wählen: ");
        String Person = "";
        for (int i = 0; i < Kontakte.size(); i++) {
            System.out.println((i + 1) + Kontakte.get(i));
        }

        Scanner input = new Scanner(System.in);
        int person = input.nextInt();

        switch (person) {
            case 1:
                Person = Kontakte.get(0);
                break;
            case 2:
                Person = Kontakte.get(1);
                break;
            case 3:
                Person = Kontakte.get(2);
                break;

        }

        System.out.println(Person + " überlegt...");

        int antwort = Services.erzeugeZufallszahl(1, 4);

        return antwort;
    }

}