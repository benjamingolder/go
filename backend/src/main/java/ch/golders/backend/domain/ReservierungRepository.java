package ch.golders.backend.domain;

import java.util.List;

public interface ReservierungRepository {
    void save(Reservierung reservierung);
    Reservierung findById(String id);
    List<Reservierung> findByMitarbeiter(Mitarbeiter mitarbeiter);
    List<Reservierung> findByAuto(Auto auto); 
}
