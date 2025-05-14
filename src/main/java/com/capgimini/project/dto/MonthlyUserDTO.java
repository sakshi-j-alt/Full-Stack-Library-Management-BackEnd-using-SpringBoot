package com.capgimini.project.dto;

public class MonthlyUserDTO {
    private String month; // format: "YYYY-MM"
    private long activeUsers;

    public MonthlyUserDTO(String month, long activeUsers) {
        this.month = month;
        this.activeUsers = activeUsers;
    }

    public String getMonth() { return month; }
    public void setMonth(String month) { this.month = month; }

    public long getActiveUsers() { return activeUsers; }
    public void setActiveUsers(long activeUsers) { this.activeUsers = activeUsers; }
}
