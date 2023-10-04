

public class Antwort
{
   private String antwortText;
   private boolean istAnwortRichtig =false;
   
   public Antwort (String einAntwortText,boolean istAnwortRichtig ){
       setAnwortText(einAntwortText);
       setIstAnwortRichtig(istAnwortRichtig);
   }
   
   public Antwort(){
       
   }
   
   public String getAntwortText (){
       return antwortText;
   }
   
   public void setAnwortText(String einAntwortText){
       antwortText= einAntwortText;
   }
   
   public boolean getIstAnwortRichtig(){
       return istAnwortRichtig;
   }
   
   public void setIstAnwortRichtig(boolean istAnwortRichtig){
       this.istAnwortRichtig = istAnwortRichtig;
   }
}
