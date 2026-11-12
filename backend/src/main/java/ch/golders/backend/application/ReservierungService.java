package ch.golders.backend.application;

import ch.golders.backend.domain.ReservierungRepository ;
import ch.golders.backend.domain.Reservierung;
import ch.golders.backend.domain.Auto;
import ch.golders.backend.domain.Reservierungsstatus;
import java.util.List;

public class ReservierungService {

    private final ReservierungRepository reservierungrepository;

    public ReservierungService(ReservierungRepository reservierungrepository) {
        this.reservierungrepository = reservierungrepository;
    }

    List<Reservierung> getReservierungByAuto(Auto auto) {
        return reservierungrepository.findByAuto(auto);
    }

    private boolean ueberschneidung2Reservierungen(Reservierung r1, Reservierung r2) {
        return r1.getEndzeitpunkt().isAfter(r2.getStartzeitpunkt()) && r2.getEndzeitpunkt().isAfter(r1.getStartzeitpunkt());
    }

    private boolean ueberschneidungMitExistierendenReservierungen(Reservierung neueReservierung) {
        List<Reservierung> bestehendeReservierungen = getReservierungByAuto(neueReservierung.getAuto());
        for (Reservierung bestehend : bestehendeReservierungen) {
            if (ueberschneidung2Reservierungen(neueReservierung, bestehend) && bestehend.getReservierungsstatus() != Reservierungsstatus.ABGESAGT) {
                return true;
            }
        }
        return false;
    }

}
