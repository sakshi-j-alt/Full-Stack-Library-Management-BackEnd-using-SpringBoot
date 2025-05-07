package com.capgimini.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgimini.project.entities.BorrowRecord;
import com.capgimini.project.exceptions.BorrowRecordNotFoundException;
import com.capgimini.project.repositories.BorrowRecordRepo;

import jakarta.validation.Valid;

@Service
public class BorrowRecordServiceImpl implements BorrowRecordService {

	private BorrowRecordRepo borrowRecordRepo;

	@Autowired
	public BorrowRecordServiceImpl(BorrowRecordRepo borrowRecordRepo) {
		this.borrowRecordRepo = borrowRecordRepo;
	}

	@Override
	public List<BorrowRecord> getAllBorrowRecord() {
		return borrowRecordRepo.findAll();
	}

	@Override
	public BorrowRecord getBorrowRecordById(Long id) {
		return borrowRecordRepo.findById(id).orElseThrow(
				() -> new BorrowRecordNotFoundException("Borrow record not found with borrow record id " + id));
	}

	@Override
	public BorrowRecord createBorrowRecord(@Valid BorrowRecord borrowRecord) {
		return borrowRecordRepo.save(borrowRecord);
	}

	@Override
	public BorrowRecord updateBorrowRecord(Long id, BorrowRecord borrowRecord) {
		Optional<BorrowRecord> optional = borrowRecordRepo.findById(id);
		if (optional.isPresent()) {
			BorrowRecord existing = optional.get();
			existing.setRecordID(borrowRecord.getRecordID());
			existing.setUserID(borrowRecord.getUserID());
			existing.setBookID(borrowRecord.getBookID());
			existing.setBorrowDate(borrowRecord.getBorrowDate());
			existing.setReturnDate(borrowRecord.getReturnDate());
			existing.setStatus(borrowRecord.getStatus());
			return borrowRecordRepo.save(existing);
		}
		return null;
	}

	@Override
	public BorrowRecord patchBorrowRecord(Long id, BorrowRecord borrowRecord) {
		Optional<BorrowRecord> optional = borrowRecordRepo.findById(id);
		if (optional.isPresent()) {
			BorrowRecord existing = optional.get();
			if (borrowRecord.getRecordID() != null) {
				existing.setRecordID(borrowRecord.getRecordID());
			}
			if (borrowRecord.getUserID() != null) {
				existing.setUserID(borrowRecord.getUserID());
			}
			if (borrowRecord.getBookID() != null) {
				existing.setBookID(borrowRecord.getBookID());
			}
			if (borrowRecord.getBorrowDate() != null) {
				existing.setBorrowDate(borrowRecord.getBorrowDate());
			}
			if (borrowRecord.getReturnDate() != null) {
				existing.setReturnDate(borrowRecord.getReturnDate());
			}
			if (borrowRecord.getStatus() != null) {
				existing.setStatus(borrowRecord.getStatus());
			}
			return borrowRecordRepo.save(existing);
		}
		return null;
	}

	@Override
	public boolean deleteBorrowRecord(Long id) {
		if (borrowRecordRepo.existsById(id)) {
			borrowRecordRepo.deleteById(id);
			return true;
		}
		return false;
	}
}
