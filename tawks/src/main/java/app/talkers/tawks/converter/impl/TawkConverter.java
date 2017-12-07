package app.talkers.tawks.converter.impl;

import app.talkers.tawks.converter.Converter;
import app.talkers.tawks.exception.TawkException;
import app.talkers.tawks.model.dao.Tawk;
import app.talkers.tawks.model.dto.TawkDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class TawkConverter implements Converter<Tawk, TawkDTO> {

    private ModelMapper modelMapper;

    public TawkConverter() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public Tawk entityFromDto(TawkDTO dto) throws TawkException {
        return this.modelMapper.map(dto, Tawk.class);
    }

    @Override
    public TawkDTO dtoFromEntity(Tawk entity) throws TawkException {
        return this.modelMapper.map(entity, TawkDTO.class);
    }
}
