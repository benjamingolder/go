package ch.golders.backend.domain;
import java.time.LocalDate;

public class Mitarbeiter {

    private final String entraId;
    private final Rolle rolle;

    public Mitarbeiter(String entraId, Rolle rolle) {
        this.entraId = entraId;
        this.rolle = rolle;
    }

    public String getEntraID() {
        return entraId;
    }

    public Rolle getRolle() {
        return rolle;
    }

}
