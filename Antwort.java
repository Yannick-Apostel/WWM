public class Antwort
{
   private String antwortText;
   private boolean istRichtig = false;
   
   public Antwort(){
       
   }
   public Antwort (String einAntwortText,boolean istAnwortRichtig ){
       setText(einAntwortText);
       setIstRichtig(istAnwortRichtig);
   }
   
   public void setText(String einText){
       antwortText= einText;
   }
   public String getText (){
       return antwortText;
   }
   
   public void setIstRichtig(boolean istRichtig){
       this.istRichtig = istRichtig;
   }
   public boolean getIstRichtig(){
       return istRichtig;
   }
}
