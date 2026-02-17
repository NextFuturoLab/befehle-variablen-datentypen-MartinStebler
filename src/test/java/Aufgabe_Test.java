import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Aufgabe_Test {

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

  private String[] runAndGetLines() {
    Aufgabe.main(new String[0]);
    return outputCapture.toString().replace("\r\n", "\n").split("\n");
  }

  @Test
  void hatVierZeilenAusgabe() {
    String[] lines = runAndGetLines();
    assertEquals(4, lines.length,
        "Das Programm sollte genau 4 Zeilen ausgeben");
  }

  @Test
  void birnenIstDrei() {
    String[] lines = runAndGetLines();
    assertTrue(lines.length > 0, "Keine Ausgabe vorhanden");
    assertEquals("3 erwartet: 3", lines[0],
        "Die Variable 'birnen' sollte den Wert 3 haben");
  }

  @Test
  void birnenPlusFuenfIstAcht() {
    String[] lines = runAndGetLines();
    assertTrue(lines.length > 1, "Zu wenig Ausgabe");
    assertEquals("8 erwartet: 8", lines[1],
        "Nach der Addition von 5 sollte 'birnen' den Wert 8 haben");
  }

  @Test
  void aepfelIstFuenf() {
    String[] lines = runAndGetLines();
    assertTrue(lines.length > 2, "Zu wenig Ausgabe");
    assertEquals("5 erwartet: 5", lines[2],
        "Die Variable 'aepfel' sollte den Wert 5 haben");
  }

  @Test
  void aepfelMinusZweiIstDrei() {
    String[] lines = runAndGetLines();
    assertTrue(lines.length > 3, "Zu wenig Ausgabe");
    assertEquals("3 erwartet: 3", lines[3],
        "Nach der Subtraktion von 2 sollte 'aepfel' den Wert 3 haben");
  }
}
