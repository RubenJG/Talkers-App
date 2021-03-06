package app.talkers.users.converter;

import app.talkers.users.exception.UserException;

import java.util.ArrayList;
import java.util.List;

public interface Converter<E, D> {

    E entityFromDto(D dto) throws UserException;

    D dtoFromEntity(E entity) throws UserException;

    default List<E> entitiesFromDtos(List<D> dtos) throws UserException {
        List<E> entities = new ArrayList<>(dtos.size());
        for (D dto : dtos) {
            entities.add(entityFromDto(dto));
        }
        return entities;
    }

    default List<D> dtosFromEntities(List<E> entities) throws UserException {
        List<D> dtos = new ArrayList<>(entities.size());
        for (E entity : entities) {
            dtos.add(dtoFromEntity(entity));
        }
        return dtos;
    }
}
