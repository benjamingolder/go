# Learning Log

## 2026-10-31 – Domänenmodell in Java

### Was ich gelernt habe

**Package-Struktur in Java:**

- Der Ordnerpfad muss exakt zum Package-Namen passen
- `package ch.golders.backend.domain;` → Datei liegt in `ch/golders/backend/domain/`
- Ohne Package-Deklaration landet die Klasse im Default-Package (nicht importierbar)

**Enums:**

- Für kleine, bekannte Wertemengen, die das System steuern (Status, Rollen, Typen)
- NICHT für Daten, die sich ändern oder vom Benutzer eingegeben werden (Marken, Modelle)
- Beispiel: `Kraftstoff` als Enum ✅, `Marke` als String ✅

**Immutability mit `final`:**

- Felder, die sich nie ändern, als `final` deklarieren
- Verhindert versehentliche Änderungen
- Macht Code leichter verständlich und thread-sicher
- Beispiel: `private final String id;` – kann nur im Konstruktor gesetzt werden

**Kapselung:**

- Felder immer `private` machen
- Zugriff nur über Getter
- Keine Setter für Felder, die sich nicht ändern sollen
- Später: Sprechende Methoden statt Setter (z.B. `vermieten()` statt `setStatus()`)

**Bidirektionale Beziehungen vermeiden:**

- `Mitarbeiter` hat KEINE `List<Reservierung>`
- Beziehungen werden über Repository abgebildet
- Einfacher, flexibler, weniger fehleranfällig

**Moderne Datums-API:**

- `java.time.LocalDate` statt veraltetem `java.util.Date`
- Nur Datum, ohne Zeitzone – perfekt für Geburtstage und Reservierungszeiträume

**Maven:**

- `mvnw.cmd compile` – kompiliert den Code
- Maven Wrapper lädt automatisch die richtige Maven-Version
- Kompilieren ist pro Datei – nur geänderte Dateien werden neu kompiliert
- Bytecode (`.class`-Dateien) läuft überall, wo eine JVM läuft

**Git Commit Messages:**

- Conventional Commits: `feat:`, `fix:`, `docs:`, `chore:`, etc.
- Kurze erste Zeile (max. 50-72 Zeichen)
- Details im Body

## 2026-11-09 – Repository-Interfaces in Java

### Was ich gelernt habe

**Interfaces als Vertrag:**

- Ein Interface definiert nur Methodensignaturen, keine Implementierung
- Methoden sind implizit `public` – Modifier kann man weglassen
- Die Geschäftslogik hängt nur vom Interface ab, nicht von der Implementierung
  (Dependency Inversion) → Dataverse-Implementierung später austauschbar

**Default-Package-Falle:**

- Ohne `package`-Deklaration landet eine Klasse im namenlosen Default-Package
- Klassen in benannten Packages können Default-Package-Klassen nicht importieren
- Symptom: "Symbol nicht gefunden" für eigentlich existierende Klassen

## 2026-11-09 – Repository-Pattern: Interface vs. Implementierung

### Was ich gelernt habe

**Die Trennung Interface (domain) / Klasse (infrastructure):**

- Das Interface in `domain` ist der **Vertrag** (Steckdose) – nur Signaturen, keine Logik
- Die Klasse in `infrastructure` ist die **Umsetzung** (Stecker) – enthält die echte
  Logik (z.B. `HashMap`)
- `implements` = Versprechen an den Compiler, alle Interface-Methoden zu liefern
- `@Override` markiert Methoden aus dem Interface → Compiler warnt bei Tippfehlern

**Der Nutzen:**

- Später kommt `DataverseAutoRepository implements AutoRepository` als zweite
  Implementierung dazu
- Der Service kennt nur das Interface → beim Wechsel ändert sich im Service
  **keine Zeile**
- Abhängigkeiten zeigen nach innen Richtung `domain` (Dependency Inversion)

**Auch intern gegen Interfaces programmieren:**

- `Map<String, Auto> autos = new HashMap<>()` statt `HashMap<...> autos`
- Gleiches Prinzip, eine Ebene tiefer

## 2026-11-09 – In-Memory-Repositories implementiert

### Was ich gelernt habe

**HashMap als "Datenbank":**

- `HashMap<String, Auto>` – Key ist die ID, Value das Objekt
- `put(key, value)` = INSERT/UPDATE, `get(key)` = SELECT, `values()` = alle Einträge
- `findAll()` gibt `new ArrayList<>(map.values())` zurück (defensive Kopie –
  aussen kann niemand die interne Map verändern)

**Filter-Methoden mit Schleife:**

- Über `map.values()` iterieren, per `if` filtern, Treffer in Ergebnis-Liste sammeln
- Zugehörigkeit über **ID-Vergleich** prüfen, nicht Objekt-Referenz:
  `reservierung.getAuto().getId().equals(auto.getId())`

**Method Chaining:**

- `reservierung.getAuto().getId()` – jeder Getter gibt ein Objekt zurück,
  auf dem der nächste Getter aufgerufen wird
- `Reservierung` speichert Objekte (`Auto`, `Mitarbeiter`), keine IDs

**Typische Stolpersteine:**

- Methodensignatur muss beim `implements` **exakt** dem Interface entsprechen
  (Name, Parameter-Typen, Rückgabetyp) – sonst "setzt abstrakte Methode nicht
  ausser Kraft"
- Java ist case-sensitiv: `entraId` ≠ `entraID` – "Symbol nicht gefunden"
  heisst oft: Schreibweise prüfen
- Methoden, die das Interface nicht deklariert, dürfen kein `@Override` haben

## 2026-11-12 – Service und Überschneidungsprüfung

- `domain` beschreibt Fachmodell und Repository-Verträge; `application`
  koordiniert Anwendungsfälle; `infrastructure` implementiert technische
  Zugriffe. Fachregeln können je nach Verantwortung auch im Modell liegen.
- Ein Service implementiert das Repository nicht selbst: Er erhält ein konkretes
  Repository-Objekt über seinen Konstruktor und verwendet es über den Interface-Typ.
  Die Verdrahtung muss noch erfolgen; ein Interface erzeugt kein Objekt.
- Ein In-Memory-Repository besitzt pro Instanz eine eigene Map. Beim Neustart
  gehen die darin gespeicherten Daten verloren.
- Zwei gültige Zeiträume überschneiden sich, wenn jeder vor dem Ende des
  anderen beginnt. Direkt anschliessende Zeiträume überschneiden sich nicht.
- Enum-Werte werden als Enum verglichen, nicht als Text.

### Nächste Lernziele

- Überschneidungsprüfung mit dem Speichern verbinden
- Gültige Zeiträume und relevante Reservierungsstatus festlegen
- Unit-Tests mit JUnit schreiben
- Statuswechsel mit Validierung implementieren
