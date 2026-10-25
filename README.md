# GO

**GO** ist ein firmeninternes Autovermietungs-System für Golders.ch. Mitarbeitende können Firmenfahrzeuge finden, reservieren, übernehmen und zurückgeben.

## Architektur

```text
Power Apps Code App
        ↓
Spring-Boot-API
        ↓
Microsoft Dataverse
```

Die gesamte Geschäftslogik liegt im Spring-Boot-Backend. Das Frontend greift nicht direkt auf Dataverse zu.

## Technologien

### Frontend

- Power Apps Code App
- React
- TypeScript
- Vite
- Node.js und npm

### Backend

- Java 21
- Spring Boot
- Maven
- REST API
- Swagger / OpenAPI

### Plattform

- Azure Container Apps
- Microsoft Dataverse
- Microsoft Entra ID
- GitHub

## Projektstruktur

```text
golders-go/
├── frontend/ # React / Power Apps Code App
├── backend/ # Java / Spring Boot / Maven
├── docs/ # Technische Dokumentation
├──.gitignore
└── README.md
```

## Voraussetzungen

Für die lokale Entwicklung werden folgende Werkzeuge benötigt:

- Git
- Visual Studio Code
- Java 21
- Node.js als LTS-Version
- npm
- Power Apps CLI
- Zugriff auf eine Power-Platform-Entwicklungsumgebung

## Installation

### Repository klonen

```powershell
git clone <REPOSITORY-URL>
cd golders-go
```

### Backend installieren und starten

Das Backend verwendet den im Repository enthaltenen Maven Wrapper. Eine separate Maven-Installation ist deshalb normalerweise nicht erforderlich.

```powershell
cd backend
.\mvnw.cmd spring-boot:run
```

Das Backend läuft standardmäßig unter:

```text
http://localhost:8080
```

### Frontend installieren

```powershell
cd frontend
npm install
```

Die Power-Apps-Werkzeuge müssen nur einmal pro Computer global installiert werden:

```powershell
npm install --global @microsoft/power-apps-cli
npm install --global @microsoft/power-apps
```

Wenn dieser Befehl bereits eine Version ausgibt, können die beiden Installationsbefehle übersprungen werden:

```powershell
pa --version
```

### Power Apps Code App initialisieren

Dieser Schritt ist nur erforderlich, wenn das Projekt noch nicht mit einer Power-Platform-Umgebung verbunden wurde.

```powershell
pa app init --display-name "GO" --environment-id <ENVIRONMENT-ID>
```

### Frontend starten

```powershell
pa app run
```

Anschließend die ausgegebene **Local Play**-Adresse im selben Browserprofil öffnen, das für die Anmeldung bei Power Apps verwendet wird.

## Tests

### Backend-Tests ausführen

```powershell
cd backend
.\mvnw.cmd test
```

Die Unit-Tests befinden sich unter:

```text
backend/src/test/
```

Der Schwerpunkt der Tests liegt auf der Geschäftslogik, insbesondere auf:

- Prüfung von Reservierungszeiträumen
- Verhinderung überschneidender Reservierungen
- Prüfung des Fahrzeugstatus
- Stornierung von Reservierungen
- Fahrzeugübernahme und Rückgabe
- erlaubten und unerlaubten Statuswechseln

### Frontend-Tests

Frontend-Tests werden später mit Vitest und React Testing Library ergänzt, sobald die ersten fachlichen Komponenten und Benutzerabläufe umgesetzt sind.

## Konfiguration

Lokale Zugangsdaten und Geheimnisse dürfen nicht ins Git-Repository eingecheckt werden.

Dazu gehören insbesondere:

- Dataverse-URL
- Microsoft-Entra-Tenant-ID
- Client-ID
- Client Secret
- lokale API-Adressen
- persönliche Zugangstokens

Für benötigte Variablen sollen Dateien wie `.env.example` oder Beispielkonfigurationen mit leeren Platzhaltern verwendet werden.

## Dokumentation

Die technische Dokumentation befindet sich im Ordner `docs/`.

Geplante Inhalte:

- `architecture.md` – Softwarearchitektur
- `setup-guide.md` – Installations- und Einrichtungsanleitung
- `technologies.md` – verwendete Technologien
- Swagger UI – Dokumentation der REST API

## Deployment

Das Spring-Boot-Backend wird später in **Azure Container Apps** bereitgestellt. Das Frontend wird als **Power Apps Code App** veröffentlicht.

Die Daten werden in Microsoft Dataverse gespeichert. Der Backend-Zugriff auf Dataverse wird über OAuth und Microsoft Entra ID abgesichert.

## Projektstatus

Das Projekt befindet sich aktuell in der initialen Einrichtungs- und Planungsphase.

## Projekt

Semesterprojekt: Autovermietungs-System
Projektname: **GO**
Unternehmen: **Golders.ch**
