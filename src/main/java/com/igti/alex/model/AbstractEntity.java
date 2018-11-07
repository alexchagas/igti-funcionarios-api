package com.igti.alex.model;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

/**
 * Base class to derive entity classes from.
 * 
 * @author Oliver Gierke
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable{


	private static final long serialVersionUID = 1L;

	/**
	 * Returns the identifier of the entity.
	 * 
	 * @return the id
	 */
	public abstract Integer getId();

    public abstract void setId(Integer id);

    /*
                 * (non-Javadoc)
                 * @see java.lang.Object#equals(java.lang.Object)
                 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (this.getId() == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
			return false;
		}

		AbstractEntity that = (AbstractEntity) obj;

		return this.getId().equals(that.getId());
	}

	/* 
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return getId() == null ? 0 : getId().hashCode();
	}
}
