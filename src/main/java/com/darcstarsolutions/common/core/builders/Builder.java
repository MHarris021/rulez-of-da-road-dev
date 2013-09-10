package com.darcstarsolutions.common.core.builders;

import java.io.Serializable;

public abstract class Builder<Entity extends Serializable> {

	private Entity entity;

	
	/**
	 * @return the entity
	 */
	protected Entity getEntity() {
		return entity;
	}

	/**
	 * @param entity
	 *            the entity to set
	 */
	protected void setEntity(Entity entity) {
		this.entity = entity;
	}

	public Entity build() {
		return entity;
	}

}