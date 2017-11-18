package app.talkers.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HelloWorldController {

    @GetMapping(value = "/hello", produces = "application/json")
    public ResponseEntity<String> get(@RequestParam(value = "name", required = false) Optional<String> name) {
        String result = String.format("Hello %s!", name.orElse("World"));
        return new ResponseEntity<String>(result, HttpStatus.I_AM_A_TEAPOT);
    }
}
