package portfolio.com.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portfolio.com.gestion.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
