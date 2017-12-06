package app.talkers.users.converter.impl;

import app.talkers.users.converter.Converter;
import app.talkers.users.exception.UserException;
import app.talkers.users.model.dao.User;
import app.talkers.users.model.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<User, UserDTO> {

    private ModelMapper modelMapper;

    public UserConverter() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public User entityFromDto(UserDTO dto) throws UserException {
        return this.modelMapper.map(dto, User.class);
    }

    @Override
    public UserDTO dtoFromEntity(User entity) throws UserException {
        return this.modelMapper.map(entity, UserDTO.class);
    }
}
