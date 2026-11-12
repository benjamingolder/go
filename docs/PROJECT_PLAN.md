# Projektplan GO

## Projektziel

Firmeninternes Autovermietungs-System für Golders.ch. Mitarbeitende können
Firmenfahrzeuge finden, reservieren, übernehmen und zurückgeben.

- Semesterprojekt
- Architektur: Power Apps Code App → Spring-Boot-API → Microsoft Dataverse
- Die gesamte Geschäftslogik liegt im Spring-Boot-Backend

## Aktueller Stand (2026-11-12)

- ✅ Projektstruktur initialisiert (Frontend, Backend, Docs)
- ✅ Fachmodell definiert: `Auto`, `Mitarbeiter`, `Reservierung` (siehe `architecture.puml`)
- ✅ Frontend-Template eingerichtet (React 19, Vite, Tailwind, shadcn/ui, Router, React Query)
- ✅ Backend-Skeleton eingerichtet (Spring Boot, Java 21, Maven)
- ✅ **Domänenmodell implementiert** (Commit `7a30e88`):
  - Entities: `Auto`, `Mitarbeiter`, `Reservierung`
  - Enums: `AutoStatus`, `Kraftstoff`, `Rolle`, `Reservierungsstatus`
  - Package-Struktur: `ch.golders.backend.domain`
  - Immutability durch `final`-Felder (ausser Status)
- ✅ **Mitarbeiter-Entity verschlankt** (nur `entraID` + `rolle`, Personendaten aus Entra ID)
- ✅ Repository-Interfaces entworfen (siehe `repositories.puml`)
- ✅ Repository-Interfaces in Java implementiert (`domain`)
- ✅ In-Memory-Implementierung der Repositories (`infrastructure`)
- ✅ Backend-Starttest zum Laden des Spring-Kontexts vorhanden
- 🔄 Reservierungsservice begonnen: Repository per Konstruktor, zeitlicher
  Vergleich und Prüfung gegen vorhandene Reservierungen als private Methoden
- ⬜ Reservierungen über den Service prüfen und speichern
- ⬜ Fachliche Unit-Tests für die Geschäftslogik
- ⬜ REST API
- ⬜ Dataverse-Anbindung
- ⬜ Frontend zeigt noch Demo-Inhalt

## Nächste Schritte

1. **Backend: Geschäftslogik** – Reservierungsservice:
   - Reservierungszeiträume validieren: Start muss vor Ende liegen
   - Überschneidungsprüfung mit dem Speichern verbinden
   - Behandlung abgeschlossener Reservierungen festlegen
   - Repository und Service für die Anwendung verdrahten
   - Prüfung des Fahrzeugstatus
   - Stornierung, Übernahme, Rückgabe
   - erlaubte/unerlaubte Statuswechsel
2. **Backend: Unit-Tests** für die Geschäftslogik
3. **Backend: REST API** + Swagger/OpenAPI
4. **Dataverse-Anbindung** (Persistenz, OAuth via Entra ID)
5. **Frontend: Fachliche Seiten** (Fahrzeugliste, Reservierung, etc.)
6. **Deployment** auf Azure Container Apps

## Mögliche Erweiterungen (Backlog)

- Vermietbarkeit pro Abteilung einschränken (Idee aus der Regelsammlung,
  bewusst vorerst nicht umgesetzt – YAGNI)

## Meilensteine

| Meilenstein                       | Status                   |
| --------------------------------- | ------------------------ |
| Projektsetup + Fachmodell         | ✅ erreicht              |
| Backend: Domänenmodell            | ✅ erreicht (2026-10-31) |
| Backend: Geschäftslogik mit Tests | ⬜ offen                 |
| Backend: REST API                 | ⬜ offen                 |
| Dataverse-Anbindung               | ⬜ offen                 |
| Frontend: Kernfunktionen          | ⬜ offen                 |
| Deployment                        | ⬜ offen                 |
