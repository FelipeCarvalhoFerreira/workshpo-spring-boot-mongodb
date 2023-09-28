package com.felipecarvalho.workshopmongo.recurso.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {

	public static String decodificarParamentro(String texto) {
		try {
			return URLDecoder.decode(texto, "UTF-8");
		} catch (UnsupportedEncodingException excecao) {
			return "";
		}
	}

	public static Date converterDataParaString(String dataFormatoTexto, Date valorPadrao) {
		SimpleDateFormat formatarData = new SimpleDateFormat("yyyy/MM/dd");
		formatarData.setTimeZone(TimeZone.getTimeZone("GMT"));
		try {
			return formatarData.parse(dataFormatoTexto);
		} catch (ParseException excecao) {
			return valorPadrao;
		}
	}
}