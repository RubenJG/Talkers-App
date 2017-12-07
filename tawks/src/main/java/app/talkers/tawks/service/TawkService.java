package app.talkers.tawks.service;

import app.talkers.tawks.exception.TawkException;
import app.talkers.tawks.model.dao.Tawk;

import java.util.List;

public interface TawkService {

    List<Tawk> getAll() throws TawkException;

    Tawk getById(Integer id) throws TawkException;

    Tawk create(Tawk tawk) throws TawkException;
}
