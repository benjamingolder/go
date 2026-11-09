package ch.golders.backend.infrastructure;
import ch.golders.backend.domain.Auto;
import ch.golders.backend.domain.AutoRepository;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryAutoRepository implements AutoRepository {
    private  HashMap<String, Auto> autos = new HashMap<>();

    @Override
    public void save(Auto auto) {
        autos.put(auto.getId(), auto);
    }

    @Override
    public Auto findById(String id) {
        return autos.get(id);
    }

    @Override
    public List<Auto> findAll() {
        return new ArrayList<>(autos.values());
    }

    @Override
    public void delete(Auto auto) {
        autos.remove(auto.getId());
    }
}
