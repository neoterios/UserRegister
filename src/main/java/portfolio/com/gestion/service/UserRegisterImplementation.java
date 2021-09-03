package portfolio.com.gestion.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import portfolio.com.gestion.controller.UserRegistry;
import portfolio.com.gestion.dtos.UserGetDto;
import portfolio.com.gestion.dtos.UserPostDto;
import portfolio.com.gestion.jwt.JwtManage;
import portfolio.com.gestion.mappers.PortfolioMapper;
import portfolio.com.gestion.model.User;
import portfolio.com.gestion.repository.UsuarioRepository;
import portfolio.com.gestion.utils.SystemMessages;
import portfolio.com.gestion.utils.Utilities;

import java.util.UUID;

@Service
public class UserRegisterImplementation implements UserRegisterService {

    private final Logger log = LoggerFactory.getLogger(UserRegistry.class);

    @Autowired
    private PortfolioMapper portfolioMapper;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public ResponseEntity<?> registrarUsuario(UserPostDto userPostDto) {

        if(!Utilities.validadorCorreo(userPostDto.getEmail())){
            log.error(String.format("[registrarUsuario] %s ", String.format(SystemMessages.BAD_FORMAT_EMAIL.toString(), userPostDto.getEmail())));
            return new ResponseEntity<String>(String.format(SystemMessages.BAD_FORMAT_EMAIL.toString(), userPostDto.getEmail())
                    , HttpStatus.BAD_REQUEST);
        }

        if(!Utilities.validadorPassword(userPostDto.getPassword())){
            log.error(String.format("[registrarUsuario] %s ", SystemMessages.BAD_FORMAT_PASSWORDS.toString()));
            return new ResponseEntity<String>(String.format(SystemMessages.BAD_FORMAT_PASSWORDS.toString())
                    , HttpStatus.BAD_REQUEST);
        }

        User usuario = portfolioMapper.userPostDtoToUser(userPostDto);
        usuario.setToken(JwtManage.createJWT(UUID.randomUUID().toString(),usuario.getEmail(),usuario.getName(),1000));

        try{
            usuario = usuarioRepository.save(usuario);
        }catch (Exception e){
            log.error(String.format("[registrarUsuario] %s ", String.format(SystemMessages.EXISTING_EMAIL.toString(), usuario.getEmail())));
            return new ResponseEntity<String>(String.format(SystemMessages.EXISTING_EMAIL.toString(), usuario.getEmail()), HttpStatus.CONFLICT);
        }

        log.info(String.format("[registrarUsuario] Usuario ingresado satisfactoriamente; ID:  %s ", usuario.getId() ));
        return new ResponseEntity<UserGetDto>(portfolioMapper.userToUserGetDto(usuario), HttpStatus.OK);
    }
}
