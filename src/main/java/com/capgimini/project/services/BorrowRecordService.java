package com.capgimini.project.services;

import java.util.List;

import com.capgimini.project.entities.BorrowRecord;

public interface BorrowRecordService {
	List<BorrowRecord> getAllBorrowRecord();

	BorrowRecord getBorrowRecordById(Long id);

	BorrowRecord createBorrowRecord(BorrowRecord record);

	BorrowRecord updateBorrowRecord(Long id, BorrowRecord record);

	BorrowRecord patchBorrowRecord(Long id, BorrowRecord record);

	boolean deleteBorrowRecord(Long id);
}
