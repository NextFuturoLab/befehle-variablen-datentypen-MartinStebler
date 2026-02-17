import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Aufgabe2_Test {

  private final PrintStream originalOut = System.out;
  private ByteArrayOutputStream outputCapture;

  @BeforeEach
  void setUp() {
    outputCapture = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputCapture));
  }

  @AfterEach
  void tearDown() {
    System.setOut(originalOut);
  }

  private String getOutput() {
    Aufgabe2.main(new String[0]);
    return outputCapture.toString().replace("\r\n", "\n").trim();
  }

  @Test
  void programmLaeuftOhneFehler() {
    assertDoesNotThrow(() -> Aufgabe2.main(new String[0]),
        "Das Programm sollte ohne Fehler laufen");
  }

  @Test
  void hatMindestensZweiZeilenAusgabe() {
    String output = getOutput();
    String[] lines = output.split("\n");
    assertTrue(lines.length >= 2,
        "Das Programm sollte mindestens 2 Zeilen ausgeben "
        + "(einmal Vor-/Nachname, einmal alles zusammen)");
  }

  @Test
  void ersteAusgabeEnthaeltVorUndNachname() {
    String output = getOutput();
    String firstLine = output.split("\n")[0].trim();
    assertFalse(firstLine.isEmpty(),
        "Die erste Zeile sollte nicht leer sein");
    assertTrue(firstLine.matches(".*[a-zA-ZäöüÄÖÜ]+.*\\s+.*[a-zA-ZäöüÄÖÜ]+.*"),
        "Die erste Zeile sollte Vorname und Nachname enthalten (mindestens zwei Wörter). "
        + "Gefunden: \"" + firstLine + "\"");
  }

  @Test
  void ausgabeEnthaeltGanzzahl() {
    String output = getOutput();
    assertTrue(output.matches("(?s).*\\b\\d{1,3}\\b.*"),
        "Die Ausgabe sollte eine Ganzzahl enthalten (z.B. das Alter). "
        + "Gefunden: \"" + output + "\"");
  }

  @Test
  void ausgabeEnthaeltDezimalzahl() {
    String output = getOutput();
    assertTrue(output.matches("(?s).*\\d+[.,]\\d+.*"),
        "Die Ausgabe sollte eine Dezimalzahl enthalten (z.B. die Grösse in Meter, wie 1.75). "
        + "Gefunden: \"" + output + "\"");
  }

  @Test
  void letzteZeileEnthaeltAlleInfos() {
    String output = getOutput();
    String[] lines = output.split("\n");
    String lastLine = lines[lines.length - 1].trim();

    assertTrue(lastLine.matches(".*[a-zA-ZäöüÄÖÜ]+.*"),
        "Die letzte Zeile sollte Text enthalten (z.B. Lieblingsessen). "
        + "Gefunden: \"" + lastLine + "\"");
    assertTrue(lastLine.matches(".*\\d+.*"),
        "Die letzte Zeile sollte eine Zahl enthalten (z.B. Alter). "
        + "Gefunden: \"" + lastLine + "\"");
    assertTrue(lastLine.length() > 10,
        "Die letzte Zeile sollte alle Infos zusammen enthalten "
        + "(Vorname, Nachname, Alter, Grösse, Lieblingsessen). "
        + "Gefunden: \"" + lastLine + "\"");
  }
}
