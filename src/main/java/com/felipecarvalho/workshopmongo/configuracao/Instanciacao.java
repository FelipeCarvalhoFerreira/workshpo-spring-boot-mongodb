package com.felipecarvalho.workshopmongo.configuracao;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.felipecarvalho.workshopmongo.dominio.PublicarConteudo;
import com.felipecarvalho.workshopmongo.dominio.Usuario;
import com.felipecarvalho.workshopmongo.dto.AutorDTO;
import com.felipecarvalho.workshopmongo.dto.ComentarioDTO;
import com.felipecarvalho.workshopmongo.repositorio.PublicarConteudoRepositorio;
import com.felipecarvalho.workshopmongo.repositorio.UsuarioRepositorio;

public class Instanciacao implements CommandLineRunner {

	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private PublicarConteudoRepositorio publicarConteudoRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
		formatarData.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		usuarioRepositorio.deleteAll();
		publicarConteudoRepositorio.deleteAll();
		
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
		usuarioRepositorio.saveAll(Arrays.asList(maria, alex, bob));
		
		
		PublicarConteudo publicacaoNumeroUm = new PublicarConteudo(null, formatarData.parse("21/03/2023"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AutorDTO(maria));
		PublicarConteudo publicacaoNumeroDois = new PublicarConteudo(null, formatarData.parse("21/03/2023"), "Bom dia", "Acordei feliz hoje!", new AutorDTO (maria));
		publicarConteudoRepositorio.saveAll(Arrays.asList(publicacaoNumeroUm, publicacaoNumeroDois));
		
		ComentarioDTO comentarios1 = new ComentarioDTO("Boa viagem mano!", formatarData.parse("21/03/2018"), new AutorDTO(alex));
		ComentarioDTO comentarios2 = new ComentarioDTO("Aproveite", formatarData.parse("22/03/2018"), new AutorDTO(bob));
		ComentarioDTO comentarios3 = new ComentarioDTO("Tenha um ótimo dia!", formatarData.parse("23/03/2018"), new AutorDTO(alex));
		
		publicacaoNumeroUm.getComentarios().addAll(Arrays.asList(comentarios1, comentarios2));
		publicacaoNumeroUm.getComentarios().addAll(Arrays.asList(comentarios3));
		
		maria.getListaPublicacao().addAll(Arrays.asList(publicacaoNumeroUm, publicacaoNumeroDois));
		usuarioRepositorio.save(maria);
	}
}
 