package com.darcstarsolutions.common.core;

import java.io.Serializable;

public interface SelectionCriteria<T extends Serializable> {

	public boolean matches(T item);
}
