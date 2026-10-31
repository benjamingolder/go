# Architecture Decision Log

## 2026-10-31 – Package-Struktur: Clean Architecture (leichtgewichtig)

**Entscheidung:** Das Backend wird in vier Packages gegliedert:
`domain` (Entities, Enums, Repository-Interfaces), `application` (Services/Geschäftslogik),
`infrastructure` (In-Memory-Repos, später Dataverse), `api` (REST-Controller).

**Kontext:** Die Persistenz (Dataverse) kommt erst später, die Geschäftslogik soll aber
jetzt schon implementiert und getestet werden.

**Alternativen:** Flache Struktur (alles in einem Package); klassische
Controller-Service-Repository-Schicht ohne explizites Domain-Package.

**Begründung:** Abhängigkeiten zeigen nach innen Richtung `domain`. Beim späteren
Wechsel auf Dataverse wird nur `infrastructure` ersetzt – Geschäftslogik und API
bleiben unberührt. Gleichzeitig bleibt die Struktur für ein Semesterprojekt
überschaubar.

## 2026-10-31 – Reservierungsstatus um AKTIV und ABGESCHLOSSEN erweitert

**Entscheidung:** Der Status einer Reservierung wird um `AKTIV` und `ABGESCHLOSSEN`
erweitert. Lebenszyklus: `PROVISORISCH → BESTAETIGT → AKTIV → ABGESCHLOSSEN`,
jederzeit (vor Übernahme) `ABGESAGT` möglich.

**Kontext:** Die README verlangt Geschäftslogik für Fahrzeugübernahme und -rückgabe.
Das ursprüngliche Modell (`PROVISORISCH`, `BESTAETIGT`, `ABGESAGT`) konnte das nicht
abbilden.

**Alternativen:** Übernahme nur über den Auto-Status (`VERMIETET`) abbilden;
Übernahme/Rückgabe vorerst weglassen.

**Begründung:** Ein expliziter Lebenszyklus macht die erlaubten Statuswechsel
klar definiert und gut testbar – genau darauf liegt der Schwerpunkt der
Backend-Tests laut README.
