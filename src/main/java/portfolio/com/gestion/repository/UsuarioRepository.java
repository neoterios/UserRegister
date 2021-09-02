package portfolio.com.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portfolio.com.gestion.model.User;

public interface UsuarioRepository extends JpaRepository<User, Long> {

}
