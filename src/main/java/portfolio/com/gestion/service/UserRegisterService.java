package portfolio.com.gestion.service;

import org.springframework.http.ResponseEntity;
import portfolio.com.gestion.dtos.UserPostDto;

public interface UserRegisterService {

    //public ArrayList<String> listarUsuario();
    //public ResponseEntity<?> registrarUsuario(User usuario);
    public ResponseEntity<?> registrarUsuario(UserPostDto usuario);


}
