package com.capgimini.project.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class BorrowRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long borrowRecordId;

	@NotNull
	private Long recordID;

	@NotNull
	private Long userID;

	@NotNull
	private Long bookID;

	@NotNull
	private LocalDate borrowDate;

	@NotNull
	private LocalDate returnDate;

	@NotNull
	private String status;

	public BorrowRecord() {
	}

	public BorrowRecord(Long recordID, Long userID, Long bookID, LocalDate borrowDate, LocalDate returnDate,
			String status) {
		this.recordID = recordID;
		this.userID = userID;
		this.bookID = bookID;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.status = status;
	}

	public Long getBorrowRecordId() {
		return borrowRecordId;
	}

	public void setBorrowRecordId(Long borrowRecordId) {
		this.borrowRecordId = borrowRecordId;
	}

	public Long getRecordID() {
		return recordID;
	}

	public void setRecordID(Long recordID) {
		this.recordID = recordID;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public Long getBookID() {
		return bookID;
	}

	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}

	public LocalDate getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(LocalDate borrowDate) {
		this.borrowDate = borrowDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BorrowRecord{" + "borrowRecordId=" + borrowRecordId + ", recordID=" + recordID + ", userID=" + userID
				+ ", bookID=" + bookID + ", borrowDate=" + borrowDate + ", returnDate=" + returnDate + ", status='"
				+ status + '\'' + '}';
	}
}
