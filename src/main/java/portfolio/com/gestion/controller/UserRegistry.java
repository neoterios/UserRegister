package portfolio.com.gestion.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portfolio.com.gestion.model.Usuario;
import portfolio.com.gestion.service.UserRegisterService;

@RestController
@RequestMapping(path = "/usuario")
@CrossOrigin(origins = "http://localhost")
public class UserRegistry {

    @Autowired
    private UserRegisterService userRegisterService;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String ListarUsuario(){

        userRegisterService.listarUsuario();

        //JSONParser parser = new JSONParser("");
        //JSONObject json = (JSONObject) parser.parse(parser);

        if (userRegisterService.listarUsuario().isEmpty()){
            return "{\"message\":\"no fue hallado ningun cliente\"}";
        }
        return userRegisterService.listarUsuario().get(1).toString();

    }

    //@RequestMapping(value = "/usuario", method = RequestMethod.POST)
    @PostMapping(value =  "/ingresar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> ingresarUsuario(@RequestBody Usuario usuario){

        //Usuario usuario = service.create(student);

        if(usuario == null){
            return new ResponseEntity<String>("{\"message\":\"no fue hallado ningun cliente\"}", HttpStatus.OK);
        }

        return userRegisterService.registrarUsuario(usuario);

    }
}
