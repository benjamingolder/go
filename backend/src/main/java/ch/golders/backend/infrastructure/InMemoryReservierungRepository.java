package ch.golders.backend.infrastructure;
import ch.golders.backend.domain.Reservierung;
import ch.golders.backend.domain.ReservierungRepository;
import ch.golders.backend.domain.Mitarbeiter;
import ch.golders.backend.domain.Auto;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryReservierungRepository implements ReservierungRepository {

    private HashMap<String, Reservierung> reservierungen = new HashMap<>();

    @Override
    public void save(Reservierung reservierung) {
        reservierungen.put(reservierung.getId(), reservierung);
    }

    @Override
    public Reservierung findById(String id) {
        return reservierungen.get(id);
    }

    @Override
    public List<Reservierung> findByAuto(Auto auto) {
        List<Reservierung> result = new ArrayList<>();
        for (Reservierung reservierung : reservierungen.values()) {
            if (reservierung.getAuto().getId().equals(auto.getId())) {
                result.add(reservierung);
            }
        }
        return result;
    }

    @Override
    public List<Reservierung> findByMitarbeiter(Mitarbeiter mitarbeiter) {
        List<Reservierung> result = new ArrayList<>();
        for (Reservierung reservierung : reservierungen.values()) {
            if (reservierung.getMitarbeiter().getEntraID().equals(mitarbeiter.getEntraID())) {
                result.add(reservierung);
            }
        }
        return result;
    }

}
