package app.talkers.tawks.converter;

import app.talkers.tawks.exception.TawkException;

import java.util.ArrayList;
import java.util.List;

public interface Converter<E, D> {

    E entityFromDto(D dto) throws TawkException;

    D dtoFromEntity(E entity) throws TawkException;

    default List<E> entitiesFromDtos(List<D> dtos) throws TawkException {
        List<E> entities = new ArrayList<>(dtos.size());
        for (D dto : dtos) {
            entities.add(entityFromDto(dto));
        }
        return entities;
    }

    default List<D> dtosFromEntities(List<E> entities) throws TawkException {
        List<D> dtos = new ArrayList<>(entities.size());
        for (E entity : entities) {
            dtos.add(dtoFromEntity(entity));
        }
        return dtos;
    }
}
