package portfolio.com.gestion.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import portfolio.com.gestion.jwt.JwtManage;
import portfolio.com.gestion.utils.SystemMessages;
import portfolio.com.gestion.model.Usuario;
import portfolio.com.gestion.repository.UsuarioRepository;
import portfolio.com.gestion.utils.Utilities;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class UserRegisterImplementation implements UserRegisterService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public ArrayList<String> listarUsuario() {
        /*
        List<Usuario> usuarios  =  dao.listarUsuario();

        ArrayList<String> listaUsuarios = new ArrayList<String>();

        for (Usuario usuario: usuarios) {
            listaUsuarios.add(usuario.toString());
        }

        return listaUsuarios;*/
        return null;
    }

    @Override
    public ResponseEntity<?> registrarUsuario(Usuario usuario) {

        if(!Utilities.validadorCorreo(usuario.getEmail())){
            return new ResponseEntity<String>(String.format(SystemMessages.BAD_FORMAT_EMAIL.toString(), usuario.getEmail())
                    , HttpStatus.OK);
        }

        if(!Utilities.validadorPassword(usuario.getPassword())){
            return new ResponseEntity<String>(String.format(SystemMessages.BAD_FORMAT_PASSWORDS.toString())
                    , HttpStatus.OK);
        }

        usuario.setToken(JwtManage.createJWT(UUID.randomUUID().toString(),usuario.getEmail(),usuario.getName(),1000));
        Usuario user;

        try{
            user  = usuarioRepository.save(usuario);
        } catch (Exception e) {

            String mensaje = String.format(SystemMessages.EXISTING_EMAIL.toString(), usuario.getEmail());
            return new ResponseEntity<String>(mensaje, HttpStatus.OK);
        }

        return new ResponseEntity<Usuario>(user, HttpStatus.OK);

    }
}
