package museum.exhibition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ExhibitionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExhibitionApplication.class, args);
	}

}
