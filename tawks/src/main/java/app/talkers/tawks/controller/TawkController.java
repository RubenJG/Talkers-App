package app.talkers.tawks.controller;

import app.talkers.tawks.converter.impl.TawkConverter;
import app.talkers.tawks.exception.TawkException;
import app.talkers.tawks.model.dao.Tawk;
import app.talkers.tawks.model.dto.TawkDTO;
import app.talkers.tawks.service.TawkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TawkController {

    private static final Logger log = LoggerFactory.getLogger(TawkController.class);

    @Autowired
    private TawkService tawkService;

    @Autowired
    private TawkConverter tawkConverter;

    @GetMapping
    private ResponseEntity<List<TawkDTO>> getTawks() throws TawkException {
        log.info("GET /tawks");
        List<Tawk> tawks = this.tawkService.getAll();
        List<TawkDTO> tawkDTOs = this.tawkConverter.dtosFromEntities(tawks);
        return new ResponseEntity<>(tawkDTOs, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    private ResponseEntity<TawkDTO> getTawksById(@PathVariable Integer id) throws TawkException {
        log.info("GET /tawks/{}", id);
        Tawk tawk = this.tawkService.getById(id);
        TawkDTO tawkDTO = this.tawkConverter.dtoFromEntity(tawk);
        return new ResponseEntity<>(tawkDTO, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<TawkDTO> postTawks(@RequestBody TawkDTO tawkDTO) throws TawkException {
        log.info("POST /tawks");
        Tawk tawk = this.tawkConverter.entityFromDto(tawkDTO);
        tawk = this.tawkService.create(tawk);
        tawkDTO = this.tawkConverter.dtoFromEntity(tawk);
        return new ResponseEntity<>(tawkDTO, HttpStatus.CREATED);
    }
}
