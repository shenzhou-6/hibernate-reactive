package org.hibernate.rx.impl;

import org.hibernate.engine.spi.SessionImplementor;

import java.io.Serializable;
import java.util.function.Function;

public class SessionUtil {

	public static void throwEntityNotFound(SessionImplementor session, String entityName, Serializable identifier) {
		session.getFactory().getEntityNotFoundDelegate().handleEntityNotFound( entityName, identifier );
	}

	public static <T> T checkEntityFound(SessionImplementor session, String entityName, Serializable identifier, T optional) {
		if ( optional==null ) {
			throwEntityNotFound(session, entityName, identifier);
		}
		return optional;
	}

	public static <T> Function<T, T> checkEntityFound(SessionImplementor session, String entityName, Serializable identifier) {
		return optional -> checkEntityFound(session, entityName, identifier, optional);
	}

}
