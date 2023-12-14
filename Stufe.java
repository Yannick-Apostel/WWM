public class Stufe
{
    private int geld;
    private int level;
    private String geldString;
    
    public Stufe() {
        
    }
    public Stufe(int level) {
        switch (level) {
            case 1: setGeldString("50€"); setGeld(50); setLevel(level); break;
            case 2: setGeldString("100€"); setGeld(100); setLevel(level); break;
            case 3: setGeldString("200€"); setGeld(200); setLevel(level); break;
            case 4: setGeldString("300€"); setGeld(300); setLevel(level); break;
            case 5: setGeldString("500€"); setGeld(500); setLevel(level); break;
            case 6: setGeldString("1.000€"); setGeld(1000); setLevel(level); break;
            case 7: setGeldString("2.000€"); setGeld(2000); setLevel(level); break;
            case 8: setGeldString("4.000€"); setGeld(4000); setLevel(level); break;
            case 9: setGeldString("8.000€"); setGeld(8000); setLevel(level); break;
            case 10: setGeldString("16.000€"); setGeld(16000); setLevel(level); break;
            case 11: setGeldString("32.000€"); setGeld(32000); setLevel(level); break;
            case 12: setGeldString("64.000€"); setGeld(64000); setLevel(level); break;
            case 13: setGeldString("125.000€"); setGeld(125000); setLevel(level); break;
            case 14: setGeldString("500.000€"); setGeld(500000); setLevel(level); break;
            case 15: setGeldString("1.000.000€"); setGeld(1000000); setLevel(level); break;
        }
    }
    
    public void setGeld(int geld) {
        this.geld = geld;
    }
    public int getGeld() {
        return geld;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }
    public int getLevel() {
        return this.level;
    }
    
    public void setGeldString(String geldString) {
        this.geldString = geldString;
    }
    public String getGeldString() {
        return this.geldString;
    }
}
