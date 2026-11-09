package ch.golders.backend.domain;

import java.util.List;

public interface MitarbeiterRepository {
    Mitarbeiter findByEntraId(String entraId);
    void save(Mitarbeiter mitarbeiter);
}
