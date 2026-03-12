package com.klef.fsad.exam;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Payment")
public class Payment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "name", length = 100, nullable = false)
    private String name;
    
    @Column(name = "date", nullable = false)
    private LocalDate date;
    
    @Column(name = "status", length = 50)
    private String status;
    
    @Column(name = "amount")
    private Double amount;
    
    @Column(name = "description", length = 255)
    private String description;
    
    // Constructors
    public Payment() {
    }
    
    public Payment(String name, LocalDate date, String status, Double amount, String description) {
        this.name = name;
        this.date = date;
        this.status = status;
        this.amount = amount;
        this.description = description;
    }
    
    // Getters and Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public Double getAmount() {
        return amount;
    }
    
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
