package com.felipecarvalho.workshopmongo.recurso.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

	public static String decodificarParamentro(String texto) {
		try {
			return URLDecoder.decode(texto, "UTF-8");
		} catch (UnsupportedEncodingException excecao) {
			return "";
		}
	}
}
