package br.edu.atitus.greeting_service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.atitus.greeting_service.configs.GreetingConfig;

@RestController
@RequestMapping("greeting")
public class GreetingController {

    private final GreetingConfig config;

    public GreetingController(GreetingConfig config) {
        super();
        this.config = config;
    }

    public static class NameRequest {
        private String name;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }

    @PostMapping
    public ResponseEntity<String> greetPost(@RequestBody NameRequest request) {
        String greetingReturn = config.getGreeting();
        String nameReturn = request.getName() != null ? request.getName() : config.getDefaultName();
        String textReturn = String.format("%s, %s!!!", greetingReturn, nameReturn);

        return ResponseEntity.ok(textReturn);
    }
}
