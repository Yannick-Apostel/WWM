import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.util.Arrays;

public class Services
{
    private String[][] fragen;
    private String[] currFrage;
    
    public static int erzeugeZufallszahl(int min, int max){
         int zufallzahl = (int)(Math.random() * ((max - min) + 1)) + min;
         return zufallzahl;
    }
    
    public void leseFragen() {
        String line = "";
        fragen = new String[1][];
        try {
            BufferedReader br = new BufferedReader(new FileReader("Fragen.csv"));
            int zeile = 0;
            
            while ((line = br.readLine()) != null) {
                String[] reihe = line.split(";");
                
                if (zeile >= fragen.length) {
                    fragen = Arrays.copyOf(fragen, zeile + 1);
                }
                
                fragen[zeile] = new String[reihe.length];
                for (int i=0 ; i<reihe.length ; i++) {
                    String tmp = reihe[i];
                    fragen[zeile][i] = tmp;
                }
                zeile++;
            }
        }
        catch (Exception e) {
            System.out.println("Fehler beim laden der Fragen");
        }
    }
    
    public void setRandomFrage(int stufe) {
        Random random = new Random();
        String stufeString = "" + stufe;
        int rng = random.nextInt(fragen.length);
        
        while (!fragen[rng][0].equals(stufeString)) {
            rng = random.nextInt(fragen.length);
        }
        
        currFrage = new String[fragen[0].length];
        for (int i=0 ; i<currFrage.length ; i++) {
            currFrage[i] = fragen[rng][i];
        }
    }
    
    public String[] getCurrentFrage() {
        return currFrage;
    }
}
