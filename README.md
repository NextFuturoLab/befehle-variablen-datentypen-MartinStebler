# Cheat Sheet
## Variable deklarieren
```
// int (Integer) ist eine Ganzzahl (1, 2, 3, 4, 5, ...)
int alter = 16;

// double ist eine Gleitkommazahl (1.0, 1.5, 1.6, ...)
double gewicht = 145.67;

// char ist ein Buchstabe (a, b, c, ?, ...)
char anfangsbuchstabe = 's';

// String ist ein Text (abc, Ich bin ein Text)
String passwort = "MeinSicheresPa$$wortKannNiemandKnacken";
/*
Beachte dass der Char mit einem Hochkomma ' gemacht wird und ein String mit Gänsefüschen "
*/

// Ein Boolean ist wahr (true) oder false (falsch)
boolean ichBinEinLuegner = false;
boolean darfIchAutoFahren = alter >= 18;
```

## Konstante deklarieren
Eine Konstante ist eine Variabel welche nicht angepasst werden kann.
Sobald ein Wert zugewiesen wurde, kann der Wert nicht mehr angepasst werden.

```
// Durch das Keyword final wird definiert, dass eine Variabel unveränderbar ist.
final int MEIN_VORNAME = "Simon";
// somit ist folgendes NICHT zulässig!
MEIN_VORNAME = "Peter";
```

## Variable manipulieren
```
int alter = 15; // das ist die Deklaration
alter = alter + 1; // Alter um 1 erhöht
alter++; // Hier wurde ebenfalls das Alter um 1 erhöht. Man sagt auch inkrementieren.
alter--; // Alter wurde um 1 gesenkt. Das nennt man auch dekrementieren.
String name = "Simon";
name = "Peter; // Ich habe mich umtaufen lassen
```

## Weitere Datentypen
```
// byte ist eine Ganzkommazahl von -128 bis 127
byte alter = 1;

// short ist eine Ganzkommazahl von 32'768 bis 32'767
short kontostand = 10000;

// int ist eine Ganzkommazahl von -2'147'483'648 bis 2'147'483'647
// int ist die gängigste Ganzzahl und wird meistens verwendet
int alter = 10;

// long ist eine Ganzkommazahl von -9'223'372'036'854'775'808 bis 9'223'372'036'854'775'807
long kontostand = 9132456789L; // beachte das L. Es ist nicht notwendig, aber best practice.

// möglich ist auch folgende Schreibweise:
long kontostand = 9_132_456_789L; // so ist das ganze leserlicher.

// float ist eine Fliesskommazahl mit 7 Anzahl Stellen
float kontostand = 1.234567F; // beachte das F. Es ist nicht notwendig, aber best practice.

// double ist eine Fliesskommazahl mit 15 Anzahl Stellen
double kontostand = 1.23456789;
```