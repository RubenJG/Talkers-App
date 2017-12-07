package app.talkers.tawks.service.impl;

import app.talkers.tawks.exception.TawkException;
import app.talkers.tawks.model.dao.Tawk;
import app.talkers.tawks.service.TawkService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TawkServiceImpl implements TawkService {

    private Map<Integer, Tawk> tawksMap = new HashMap<>();
    private Integer count = 1;

    @Override
    public List<Tawk> getAll() throws TawkException {
        return new ArrayList<>(tawksMap.values());
    }

    @Override
    public Tawk getById(Integer id) throws TawkException {
        return Optional.ofNullable(tawksMap.get(id))
                .orElseThrow(() -> new TawkException(String.format("Tawk with id %d was not found!", id)));
    }

    @Override
    public Tawk create(Tawk tawk) throws TawkException {
        int id = count++;
        tawksMap.put(id, tawk);
        tawk.setId(id);
        return tawk;
    }
}
