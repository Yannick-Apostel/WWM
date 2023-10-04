
public class Services {
    public static int erzeugeZufallszahl(int min, int max) {

        int zufallzahl = (int) (Math.random() * ((max - min) + 1)) + min;
        return zufallzahl;
    }
}
