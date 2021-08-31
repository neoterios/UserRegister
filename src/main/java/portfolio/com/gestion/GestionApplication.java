package portfolio.com.gestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class GestionApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate template;

	public static void main(String[] args) {
		SpringApplication.run(GestionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		template.execute("DROP TABLE usuario IF EXISTS");
		template.execute("CREATE TABLE usuario (" +
				"id Integer PRIMARY KEY AUTO_INCREMENT , " +
				"nombre  VARCHAR(50)," +
				"email VARCHAR(50) UNIQUE, " +
				"password  VARCHAR(30), fecha DATETIME DEFAULT NOW() NOT NULL" +
				")"

		);
	}
}
