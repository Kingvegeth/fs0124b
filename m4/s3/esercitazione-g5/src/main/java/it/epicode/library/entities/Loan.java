package it.epicode.library.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity
public class Loan extends BaseEntity {
	@ManyToOne
	private User user;

	@ManyToOne
	private LibraryItem item;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	private Date expectedReturnDate;

	@Temporal(TemporalType.DATE)
	private Date actualReturnDate;

	public Loan() {}
	public Loan(User user, LibraryItem item, Date startDate, Date expectedReturnDate, Date actualReturnDate) {
		this.user = user;
		this.item = item;
		this.startDate = startDate;
		this.expectedReturnDate = expectedReturnDate;
		this.actualReturnDate = actualReturnDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LibraryItem getItem() {
		return item;
	}

	public void setItem(LibraryItem item) {
		this.item = item;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getExpectedReturnDate() {
		return expectedReturnDate;
	}

	public void setExpectedReturnDate(Date expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}

	public Date getActualReturnDate() {
		return actualReturnDate;
	}

	public void setActualReturnDate(Date actualReturnDate) {
		this.actualReturnDate = actualReturnDate;
	}

	@Override
	public String toString() {
		return "Loan{" +
				"user=" + user +
				", item=" + item +
				", startDate=" + startDate +
				", expectedReturnDate=" + expectedReturnDate +
				", actualReturnDate=" + actualReturnDate +
				'}';
	}
}
