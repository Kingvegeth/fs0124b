package it.epicode.library.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.Date;

@MappedSuperclass
public class BaseEntity {
	@Id
	@GeneratedValue
	private long id;
	private Date insertedAt = new Date();

	public long getId() {
		return id;
	}

	public Date getInsertedAt() {
		return insertedAt;
	}

}
