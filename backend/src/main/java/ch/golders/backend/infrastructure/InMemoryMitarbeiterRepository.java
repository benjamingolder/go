package ch.golders.backend.infrastructure;

import ch.golders.backend.domain.Mitarbeiter;
import ch.golders.backend.domain.MitarbeiterRepository;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryMitarbeiterRepository implements MitarbeiterRepository {
    private HashMap<String, Mitarbeiter> mitarbeiters = new HashMap<>();
    private HashMap<String, Mitarbeiter> mitarbeitersByEntraID = new HashMap<>();

    @Override
    public Mitarbeiter findByEntraId(String entraId) {
        return mitarbeitersByEntraID.get(entraId);
    }

    @Override
    public void save(Mitarbeiter mitarbeiter) {
        mitarbeitersByEntraID.put(mitarbeiter.getEntraID(), mitarbeiter);
    }

}
