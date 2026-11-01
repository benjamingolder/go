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

### Nächste Lernziele

- Repository-Pattern verstehen
- Geschäftslogik in Services kapseln
- Unit-Tests mit JUnit schreiben
- Statuswechsel mit Validierung implementieren
