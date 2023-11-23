

public class FragenGenerator {
    static String[][] Qualifragen = {{"Was macht man, wenn man an einem Baum hochklettert?","Tschächen umarmen","mit Polän kuscheln","auf Lätten liegen","an Ästen festhalten","d","n"}
                        ,{"Wie lautet eine kurz gefasste Aufforderung zum Diebstahl?","Klau's","Jen's","Han's","Nil's","a","n"}
                        ,{"Von allen Seiten betrachtet oder auch: Wie man es ...?","startet und gibt Gas","biegt ab und verfährt sich","hält an und fragt Passanten","dreht und wendet","d","n"}
                        ,{"Wobei wird vor einem sogenannten Rebound-Effekt gewarnt, der nicht selten zu einer Abhängigkeit führt?","Haarspray","Nasenspray","Deospray","Pfefferspray","b","n"}
                        };
                        
                        public static Frage generateFrage(int type) {
                            int min = 0;
                            int max = 3;
                            int randomNum = min + (int)(Math.random() * ((max - min) + 1));
                            String[] frageInfo = null;
                            
                            // Wenn der gewählte Frageindex bereits ausgewählt wurde, wähle eine andere zufällige Frage aus.
                            while (frageInfo == null || frageInfo[6].equals("j")) {
                                randomNum = min + (int)(Math.random() * ((max - min) + 1));
                                frageInfo = Qualifragen[randomNum];
                            }
                            
                            // Markiere die ausgewählte Frage als "ausgewählt".
                            frageInfo[6] = "j";
                            
                            Frage frage = new Frage();
                            frage.frage = frageInfo[0];
                            frage.antwort1 = frageInfo[1];
                            frage.antowrt2 = frageInfo[2];
                            frage.antwort3 = frageInfo[3];
                            frage.antowrt4 = frageInfo[4];
                            frage.loesung = frageInfo[5];
                            
                        
                            return frage;
                        }
}
