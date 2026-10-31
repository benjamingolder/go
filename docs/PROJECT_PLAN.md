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
- ⬜ Keine Geschäftslogik implementiert
- ⬜ Keine REST API
- ⬜ Keine Dataverse-Anbindung
- ⬜ Frontend zeigt noch Demo-Inhalt

## Nächste Schritte

1. **Backend: Domänenmodell** – Java-Klassen für Auto, Mitarbeiter, Reservierung inkl. Enums
2. **Backend: Geschäftslogik** – Reservierungsservice:
   - Prüfung von Reservierungszeiträumen
   - Verhinderung überschneidender Reservierungen
   - Prüfung des Fahrzeugstatus
   - Stornierung, Übernahme, Rückgabe
   - erlaubte/unerlaubte Statuswechsel
3. **Backend: Unit-Tests** für die Geschäftslogik
4. **Backend: REST API** + Swagger/OpenAPI
5. **Dataverse-Anbindung** (Persistenz, OAuth via Entra ID)
6. **Frontend: Fachliche Seiten** (Fahrzeugliste, Reservierung, etc.)
7. **Deployment** auf Azure Container Apps

## Meilensteine

| Meilenstein | Status |
|---|---|
| Projektsetup + Fachmodell | ✅ erreicht |
| Backend: Geschäftslogik mit Tests | ⬜ offen |
| Backend: REST API | ⬜ offen |
| Dataverse-Anbindung | ⬜ offen |
| Frontend: Kernfunktionen | ⬜ offen |
| Deployment | ⬜ offen |
