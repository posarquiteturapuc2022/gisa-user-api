package br.com.posarquiteturapuc2022;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.posarquiteturapuc2022.domain.Usuario;
import br.com.posarquiteturapuc2022.repositories.UsuarioRepository;

@SpringBootApplication
public class GisaUserApiApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepositoy;

	public static void main(String[] args) {
		SpringApplication.run(GisaUserApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		usuarioRepositoy.saveAll(List.of(new Usuario(null, "KArol Morais", "karol.s.morais@gmail.com", "123")));
	}

}
