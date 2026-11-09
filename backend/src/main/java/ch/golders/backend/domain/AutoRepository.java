package ch.golders.backend.domain;

import java.util.List;

public interface AutoRepository {
    void save(Auto auto);
    Auto findById(String id);
    List<Auto> findAll();
    void delete(Auto auto);
}
