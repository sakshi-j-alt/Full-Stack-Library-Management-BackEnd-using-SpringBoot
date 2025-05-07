package com.capgimini.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgimini.project.entities.BorrowRecord;

public interface BorrowRecordRepo extends JpaRepository<BorrowRecord, Long> {

}
