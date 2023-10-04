import java.util.ArrayList;

public class fiftyfiftyJoker {
    private Antwort falscheAntwort;
    private Antwort richtigeAntwort;

    public fiftyfiftyJoker(Antwort richtigeAntwort, Antwort zweiteAntwort, Antwort dritteAntwort, Antwort ersteAntwort) {
        this.richtigeAntwort = richtigeAntwort;
        int rnd = Services.erzeugeZufallszahl(0, 2);

        switch (rnd) {
            case 0:
                falscheAntwort = ersteAntwort;
                break;
            case 1:
                falscheAntwort = zweiteAntwort;
                break;
            case 2:
                falscheAntwort = dritteAntwort;
                break;
            default:
        }
    }
    

    public Antwort getFalscheAntwort(){
        return falscheAntwort;
    }
    public Antwort getRichtigeAntwort(){
        return richtigeAntwort;
    }

    public void useFiftyFiftyJoker(){

    }

}
