package com.capgimini.project.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.capgimini.project.entities.BorrowRecord;
import com.capgimini.project.services.BorrowRecordService;

import jakarta.validation.Valid;
@CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
@RequestMapping("/api/borrowrecords")
@Validated
public class BorrowRecordController {

	private BorrowRecordService borrowRecordService;

	@Autowired
	public BorrowRecordController(BorrowRecordService borrowRecordService) {
		this.borrowRecordService = borrowRecordService;
	}

	@GetMapping
	public ResponseEntity<List<BorrowRecord>> getAllBorrowRecords() {
		List<BorrowRecord> borrowRecords = borrowRecordService.getAllBorrowRecord();
		return ResponseEntity.status(HttpStatus.OK).body(borrowRecords);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BorrowRecord> getBorrowRecord(@PathVariable Long id) {
		BorrowRecord borrowRecord = borrowRecordService.getBorrowRecordById(id);
		return ResponseEntity.status(HttpStatus.OK).body(borrowRecord);
	}

	@PostMapping
	public ResponseEntity<BorrowRecord> createBorrowRecord(@Valid @RequestBody BorrowRecord borrowRecord) {
		BorrowRecord savedBorrowRecord = borrowRecordService.createBorrowRecord(borrowRecord);
		return ResponseEntity.status(HttpStatus.CREATED)
				.location(URI.create("/api/borrow-records/" + savedBorrowRecord.getId()))
				.body(savedBorrowRecord);
	}

	@PutMapping("/{id}")
	public ResponseEntity<BorrowRecord> updateBorrowRecord(@PathVariable Long id,
			@Valid @RequestBody BorrowRecord borrowRecord) {
		BorrowRecord updatedBorrowRecord = borrowRecordService.updateBorrowRecord(id, borrowRecord);
		if (updatedBorrowRecord != null) {
			return ResponseEntity.status(HttpStatus.OK).body(updatedBorrowRecord);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PatchMapping("/{id}")
	public ResponseEntity<BorrowRecord> patchBorrowRecord(@PathVariable Long id,
			@Valid @RequestBody BorrowRecord borrowRecord) {
		BorrowRecord updatedBorrowRecord = borrowRecordService.patchBorrowRecord(id, borrowRecord);
		if (updatedBorrowRecord != null) {
			return ResponseEntity.status(HttpStatus.OK).body(updatedBorrowRecord);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBorrowRecord(@PathVariable Long id) {
		boolean deleted = borrowRecordService.deleteBorrowRecord(id);
		if (deleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
