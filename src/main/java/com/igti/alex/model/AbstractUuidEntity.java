package com.igti.alex.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractUuidEntity extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID", length = 25)
	public Integer id;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}
}
