import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Publikumsjoker {

  public Antwort AntwortPublikumsjoker(Antwort a1, Antwort a2, Antwort a3, Antwort a4) {
    Map<Antwort, Double> answerProbabilities = calculateAnswerProbabilities(a1, a2, a3, a4);

    // Zufällige Auswahl basierend auf den berechneten Wahrscheinlichkeiten
    double randomNumber = Math.random() * 100;
    double cumulativeProbability = 0;

    for (Map.Entry<Antwort, Double> entry : answerProbabilities.entrySet()) {
      cumulativeProbability += entry.getValue();
      if (randomNumber <= cumulativeProbability) {
        return entry.getKey();
      }
    }

    // Wenn aus irgendeinem Grund keine Antwort ausgewählt wurde
    return null;
  }

  private Map<Antwort, Double> calculateAnswerProbabilities(Antwort a1, Antwort a2, Antwort a3, Antwort a4) {
    Map<Antwort, Double> answerProbabilities = new HashMap<>();
    Random random = new Random();

    // Gewichtungen basierend auf Richtigkeit (hier einfach als Beispiel)
    double weightA1 = a1.getIstAnwortRichtig() ? 0.3 : 0.1;
    double weightA2 = a2.getIstAnwortRichtig() ? 0.2 : 0.1;
    double weightA3 = a3.getIstAnwortRichtig() ? 0.2 : 0.1;
    double weightA4 = a4.getIstAnwortRichtig() ? 0.3 : 0.1;

    // Summe der Gewichtungen für die Normalisierung
    double totalWeight = weightA1 + weightA2 + weightA3 + weightA4;

    // Berechnung der prozentualen Wahrscheinlichkeiten
    answerProbabilities.put(a1, (weightA1 / totalWeight) * 100);
    answerProbabilities.put(a2, (weightA2 / totalWeig);
