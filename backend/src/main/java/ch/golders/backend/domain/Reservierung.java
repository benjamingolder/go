package ch.golders.backend.domain;
import java.time.LocalDateTime;

public class Reservierung {
    private final String id;
    private final String reservierungsnummer;
    private final LocalDateTime startzeitpunkt;
    private final LocalDateTime endzeitpunkt;
    private Reservierungsstatus reservierungsstatus;
    private final Auto auto;
    private final Mitarbeiter mitarbeiter;

    public Reservierung(String id, String reservierungsnummer, LocalDateTime startzeitpunkt, LocalDateTime endzeitpunkt, Reservierungsstatus reservierungsstatus, Auto auto, Mitarbeiter mitarbeiter) {
        
        if (startzeitpunkt.isAfter(endzeitpunkt)) {
            throw new IllegalArgumentException("Startzeitpunkt muss vor dem Endzeitpunkt liegen");
        }

        this.id = id;
        this.reservierungsnummer = reservierungsnummer;
        this.startzeitpunkt = startzeitpunkt;
        this.endzeitpunkt = endzeitpunkt;
        this.reservierungsstatus = reservierungsstatus;
        this.auto = auto;
        this.mitarbeiter = mitarbeiter;
    }

    public String getId() {
        return id;
    }

    public String getReservierungsnummer() {
        return reservierungsnummer;
    }

    public LocalDateTime getStartzeitpunkt() {
        return startzeitpunkt;
    }

    public LocalDateTime getEndzeitpunkt() {
        return endzeitpunkt;
    }

    public Reservierungsstatus getReservierungsstatus() {
        return reservierungsstatus;
    }


    public Auto getAuto() {
        return auto;
    }

    public Mitarbeiter getMitarbeiter() {
        return mitarbeiter;
    }
}
