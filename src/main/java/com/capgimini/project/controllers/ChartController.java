package com.capgimini.project.controllers;

import com.capgimini.project.entities.Book;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgimini.project.dto.GenreChartDTO;
import com.capgimini.project.dto.MonthlyUserDTO;
import com.capgimini.project.entities.BorrowRecord;
import com.capgimini.project.repositories.BookRepo;
import com.capgimini.project.repositories.BorrowRecordRepo;

@RestController
@RequestMapping("/api/charts")
public class ChartController {

    @Autowired
    private BookRepo bookRepository;

    @Autowired
    private BorrowRecordRepo borrowRecordRepository;

    @GetMapping("/genre-distribution")
    public List<GenreChartDTO> getGenreDistribution() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
            .collect(Collectors.groupingBy(Book::getGenre, Collectors.counting()))
            .entrySet().stream()
            .map(entry -> new GenreChartDTO(entry.getKey(), entry.getValue()))
            .collect(Collectors.toList());
    }

    @GetMapping("/monthly-active-users")
    public List<MonthlyUserDTO> getMonthlyActiveUsers() {
        List<BorrowRecord> records = borrowRecordRepository.findAll();
        Map<String, Set<Long>> monthToUsers = new HashMap<>();

        for (BorrowRecord record : records) {
            LocalDate date = record.getBorrowDate();
            String key = date.getYear() + "-" + String.format("%02d", date.getMonthValue());
            monthToUsers.computeIfAbsent(key, k -> new HashSet<>()).add(record.getUserID());
        }

        return monthToUsers.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .map(e -> new MonthlyUserDTO(e.getKey(), e.getValue().size()))
            .collect(Collectors.toList());
    }
}
