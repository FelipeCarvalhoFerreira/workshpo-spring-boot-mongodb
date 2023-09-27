package com.felipecarvalho.workshopmongo.configuracao;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.felipecarvalho.workshopmongo.dominio.Publicar;
import com.felipecarvalho.workshopmongo.dominio.Usuario;
import com.felipecarvalho.workshopmongo.repositorio.PublicarRepositorio;
import com.felipecarvalho.workshopmongo.repositorio.UsuarioRepositorio;

public class Instanciacao implements CommandLineRunner {

	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private PublicarRepositorio publicarRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
		formatarData.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		usuarioRepositorio.deleteAll();
		publicarRepositorio.deleteAll();
		
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
		
		Publicar publicacaoNumeroUm = new Publicar(null, formatarData.parse("21/03/2023"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
		Publicar publicacaoNumeroDois = new Publicar(null, formatarData.parse("21/03/2023"), "Bom dia", "Acordei feliz hoje!", maria);
		
		usuarioRepositorio.saveAll(Arrays.asList(maria, alex, bob));
		publicarRepositorio.saveAll(Arrays.asList(publicacaoNumeroUm, publicacaoNumeroDois));
		
		
	}
}
 