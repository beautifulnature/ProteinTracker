package com.simpleprogrammer;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class AuditInterceptor extends EmptyInterceptor {

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		
		System.out.println("saving an entity");
		return false;
	}

	@Override
	public void preFlush(Iterator entities) {
		System.out.println("after an entity saved");
	}

}
