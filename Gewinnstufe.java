import java.util.ArrayList;

public class Gewinnstufe
{   
    private int Stufe1; //4
    private int Stufe2; //6
    private int [] Geldbetrag = {50,100,200,300,500,1000,2000,4000,8000,16000,32000,64000,125000,500000,1000000};

    
    
    public Gewinnstufe(int stufe1, int stufe2){
        setStufe1(stufe1);
        setStufe2(stufe2);
    }

    public int checkGewinnstufe(int anzahlRichtigeFrage){
        if(anzahlRichtigeFrage == 15 ){ 
            return getGeldbetrag(14);
        }
        else if(anzahlRichtigeFrage>=Stufe2){ // get
            return getGeldbetrag(anzahlRichtigeFrage-1);
        }
        else if(anzahlRichtigeFrage>=Stufe1){//get
            return getGeldbetrag(anzahlRichtigeFrage-1);
        }
        else{
            return 0;
        }
        
    }

    


    public int getStufe1(){
        return Stufe1;
    }

    public void setStufe1(int stufe1){
        Stufe1 = stufe1;
    }

    public int getStufe2(){
        return Stufe2;
    }

    public void setStufe2(int stufe2){
        Stufe2 = stufe2;
    }

    public int getGeldbetrag(int index){
        return Geldbetrag[index];
    }


}
