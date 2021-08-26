package com.luchoauth.springbootauth.utilidades.excepciones;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcepcionesPersonalizadas extends Exception {

	private static final long serialVersionUID = 1L;
	
	public static final Logger logger = LoggerFactory.getLogger(ExcepcionesPersonalizadas.class);
	
	/**
	 * 
	 * @param msg .
	 */
	public ExcepcionesPersonalizadas(String msg) {
		super(msg);
		logger.error(msg);
	}

	/**
	 * 
	 * @param .
	 * @param 
	 */
	public ExcepcionesPersonalizadas(String msg, Throwable cause) {
		super(msg, cause);
		logger.error(msg, cause);
	}

}
