import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Aufgabe3_Test {

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
    Aufgabe3.main(new String[0]);
    return outputCapture.toString().replace("\r\n", "\n").trim();
  }

  private List<String> extractNumbers(String line) {
    List<String> numbers = new ArrayList<>();
    Matcher m = Pattern.compile("-?\\d+").matcher(line);
    while (m.find()) {
      numbers.add(m.group());
    }
    return numbers;
  }

  @Test
  void programmLaeuftOhneFehler() {
    assertDoesNotThrow(() -> Aufgabe3.main(new String[0]),
        "Das Programm sollte ohne Fehler laufen");
  }

  @Test
  void hatDreiZeilenAusgabe() {
    String output = getOutput();
    String[] lines = output.split("\n");
    assertEquals(3, lines.length,
        "Das Programm sollte genau 3 Zeilen ausgeben "
        + "(println, print, printf). Gefunden: " + lines.length);
  }

  @Test
  void jedeZeileEnthaeltFuenfZahlen() {
    String output = getOutput();
    String[] lines = output.split("\n");
    assertTrue(lines.length >= 3, "Zu wenig Ausgabezeilen");

    String[] labels = {"println", "print", "printf"};
    for (int i = 0; i < 3; i++) {
      List<String> numbers = extractNumbers(lines[i]);
      assertEquals(5, numbers.size(),
          "Die " + labels[i] + "-Zeile sollte genau 5 Zahlen enthalten. "
          + "Gefunden: " + numbers.size() + " in \"" + lines[i].trim() + "\"");
    }
  }

  @Test
  void alleZeilenEnthaltenDieSelbenZahlen() {
    String output = getOutput();
    String[] lines = output.split("\n");
    assertTrue(lines.length >= 3, "Zu wenig Ausgabezeilen");

    List<String> printlnNumbers = extractNumbers(lines[0]);
    List<String> printNumbers = extractNumbers(lines[1]);
    List<String> printfNumbers = extractNumbers(lines[2]);

    assertEquals(printlnNumbers, printNumbers,
        "Die print-Zeile sollte die gleichen Zahlen wie die println-Zeile enthalten");
    assertEquals(printlnNumbers, printfNumbers,
        "Die printf-Zeile sollte die gleichen Zahlen wie die println-Zeile enthalten");
  }

  @Test
  void zahlenSindGanzzahlen() {
    String output = getOutput();
    String firstLine = output.split("\n")[0];
    List<String> numbers = extractNumbers(firstLine);
    assertFalse(numbers.isEmpty(), "Die erste Zeile sollte Zahlen enthalten");

    for (String num : numbers) {
      assertDoesNotThrow(() -> Integer.parseInt(num),
          "Alle Werte sollten Ganzzahlen (int) sein. \"" + num + "\" ist keine gültige Ganzzahl");
    }
  }
}
