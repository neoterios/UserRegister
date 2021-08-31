package portfolio.com.gestion.service;

import org.springframework.http.ResponseEntity;
import portfolio.com.gestion.model.Usuario;

import java.util.ArrayList;

public interface UserRegisterService {

    public ArrayList<String> listarUsuario();
    public ResponseEntity<?> registrarUsuario(Usuario usuario);

}
