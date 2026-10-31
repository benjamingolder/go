package ch.golders.backend.domain;
import java.time.LocalDate;

public class Reservierung {
    private final String id;
    private final String reservierungsnummer;
    private final LocalDate startdatum;
    private final LocalDate enddatum;
    private Reservierungsstatus reservierungsstatus;
    private final Auto auto;
    private final Mitarbeiter mitarbeiter;

    public Reservierung(String id, String reservierungsnummer, LocalDate startdatum, LocalDate enddatum, Reservierungsstatus reservierungsstatus, Auto auto, Mitarbeiter mitarbeiter) {
        this.id = id;
        this.reservierungsnummer = reservierungsnummer;
        this.startdatum = startdatum;
        this.enddatum = enddatum;
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

    public LocalDate getStartdatum() {
        return startdatum;
    }

    public LocalDate getEnddatum() {
        return enddatum;
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
