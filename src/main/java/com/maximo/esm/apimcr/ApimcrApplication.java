package com.maximo.esm.apimcr;

import com.maximo.esm.apimcr.domain.entity.Unidade;
import com.maximo.esm.apimcr.domain.entity.Usuario;
import com.maximo.esm.apimcr.domain.enums.PerfilUser;
import com.maximo.esm.apimcr.domain.repository.UnidadeRepository;
import com.maximo.esm.apimcr.domain.repository.UsuarioRepository;
import com.maximo.esm.apimcr.security.utils.SenhaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
@ComponentScan("com.maximo.esm.apimcr")
@SpringBootApplication
public class ApimcrApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApimcrApplication.class, args);
	}

	@Autowired
	private UsuarioRepository repository;
	@Autowired
	private UnidadeRepository unidadeRepository;

	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {
/*
			Unidade unidade =new Unidade();
			unidade = unidadeRepository.findByApartamento(405);
			if (Objects.isNull(unidade)){
				unidade = new Unidade();}

			unidade.setApartamento(405);
			unidade.setContato("719887544520");
			unidade.setEmail("luis@gmail.com");
			unidade.setProprietario("Luis");
			unidade.setTorre("Itapua");
			unidadeRepository.save(unidade);*/

			Usuario usuario = new Usuario();
			usuario = repository.findByUsername("Admin");
			if (Objects.isNull(usuario)){
				usuario = new Usuario();}

			usuario.setPerfil(PerfilUser.ROLE_ADMIN);
			usuario.setUsername("Admin");
			usuario.setSenha(SenhaUtils.gerarBCrypt("123456"));
			//usuario.getUnidade().setId(unidade.getId());
			repository.save(usuario);

			usuario = repository.findByUsername("Usuario");
			if (Objects.isNull(usuario)){
				usuario = new Usuario();}
			usuario.setPerfil(PerfilUser.ROLE_USUARIO);
			usuario.setUsername("Usuario");
			usuario.setSenha(SenhaUtils.gerarBCrypt("654321"));
		//	usuario.getUnidade().setId(unidade.getId());
			repository.save(usuario);

		};
	}
}
