package ch.golders.backend.domain;
import java.time.LocalDate;

public class Mitarbeiter {

    private final String entraID;
    private final String name;
    private final String vorname;
    private final LocalDate geburtsdatum;
    private final String personalnummer;
    private final String abteilung;
    private final Rolle rolle;

    public Mitarbeiter(String entraID, String name, String vorname, LocalDate geburtsdatum, String personalnummer, String abteilung, Rolle rolle) {
        this.entraID = entraID;
        this.name = name;
        this.vorname = vorname;
        this.geburtsdatum = geburtsdatum;
        this.personalnummer = personalnummer;
        this.abteilung = abteilung;
        this.rolle = rolle;
    }

    public String getEntraID() {
        return entraID;
    }

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    public LocalDate getGeburtsdatum() {
        return geburtsdatum;
    }

    public String getPersonalnummer() {
        return personalnummer;
    }

    public String getAbteilung() {
        return abteilung;
    }

    public Rolle getRolle() {
        return rolle;
    }

}
