package portfolio.com.gestion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portfolio.com.gestion.dtos.UserPostDto;
import portfolio.com.gestion.service.UserRegisterService;

@RestController
@RequestMapping(path = "/usuario")
@CrossOrigin(origins = "http://localhost")
public class UserRegistry {

    private final Logger log = LoggerFactory.getLogger(UserRegistry.class);

    @Autowired
    private UserRegisterService userRegisterService;

    @PostMapping(value =  "/ingresar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> ingresarUsuario(@RequestBody UserPostDto userPostDto){
        log.info("[ingresarUsuario] Ejecucion EndPoint: /Ingresar ");
        return userRegisterService.registrarUsuario(userPostDto);
    }
}
