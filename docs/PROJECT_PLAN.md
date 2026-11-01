# Projektplan GO

## Projektziel

Firmeninternes Autovermietungs-System für Golders.ch. Mitarbeitende können
Firmenfahrzeuge finden, reservieren, übernehmen und zurückgeben.

- Semesterprojekt
- Architektur: Power Apps Code App → Spring-Boot-API → Microsoft Dataverse
- Die gesamte Geschäftslogik liegt im Spring-Boot-Backend

## Aktueller Stand (2026-10-31)

- ✅ Projektstruktur initialisiert (Frontend, Backend, Docs)
- ✅ Fachmodell definiert: `Auto`, `Mitarbeiter`, `Reservierung` (siehe `architecture.puml`)
- ✅ Frontend-Template eingerichtet (React 19, Vite, Tailwind, shadcn/ui, Router, React Query)
- ✅ Backend-Skeleton eingerichtet (Spring Boot, Java 21, Maven)
- ✅ **Domänenmodell implementiert** (Commit `7a30e88`):
  - Entities: `Auto`, `Mitarbeiter`, `Reservierung`
  - Enums: `AutoStatus`, `Kraftstoff`, `Rolle`, `Reservierungsstatus`
  - Package-Struktur: `ch.golders.backend.domain`
  - Immutability durch `final`-Felder (ausser Status)
- ⬜ Repository-Interfaces + In-Memory-Implementierung
- ⬜ Geschäftslogik (Reservierungsservice)
- ⬜ REST API
- ⬜ Dataverse-Anbindung
- ⬜ Frontend zeigt noch Demo-Inhalt

## Nächste Schritte

1. ✅ **Backend: Domänenmodell** – Java-Klassen für Auto, Mitarbeiter, Reservierung inkl. Enums
2. **Backend: Repository-Interfaces** – Abstraktion der Persistenz (In-Memory zuerst)
3. **Backend: Geschäftslogik** – Reservierungsservice:
   - Prüfung von Reservierungszeiträumen
   - Verhinderung überschneidender Reservierungen
   - Prüfung des Fahrzeugstatus
   - Stornierung, Übernahme, Rückgabe
   - erlaubte/unerlaubte Statuswechsel
4. **Backend: Unit-Tests** für die Geschäftslogik
5. **Backend: REST API** + Swagger/OpenAPI
6. **Dataverse-Anbindung** (Persistenz, OAuth via Entra ID)
7. **Frontend: Fachliche Seiten** (Fahrzeugliste, Reservierung, etc.)
8. **Deployment** auf Azure Container Apps

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
