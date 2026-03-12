package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class ClientDemo {
    
    public static void main(String[] args) {
        
        // Create SessionFactory
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Payment.class)
                .buildSessionFactory();
        
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        try {
            // I. Insert records using a persistent object
            System.out.println("===== INSERTING RECORDS =====");
            
            Payment payment1 = new Payment("John Doe", LocalDate.of(2024, 1, 15), "Completed", 5000.00, "Monthly Salary");
            Payment payment2 = new Payment("Jane Smith", LocalDate.of(2024, 1, 16), "Pending", 3000.00, "Freelance Work");
            Payment payment3 = new Payment("Bob Johnson", LocalDate.of(2024, 1, 17), "Completed", 7500.00, "Project Payment");
            Payment payment4 = new Payment("Alice Brown", LocalDate.of(2024, 1, 18), "Failed", 2500.00, "Refund");
            
            session.persist(payment1);
            session.persist(payment2);
            session.persist(payment3);
            session.persist(payment4);
            
            transaction.commit();
            System.out.println("Records inserted successfully!\n");
            
            // II. Delete the record based on the ID using HQL with named parameters
            System.out.println("===== DELETING RECORD WITH ID=2 =====");
            
            transaction = session.beginTransaction();
            
            // Delete using HQL with named parameters
            String deleteHQL = "DELETE FROM Payment WHERE id = :paymentId";
            Query<?> deleteQuery = session.createQuery(deleteHQL);
            deleteQuery.setParameter("paymentId", 2);
            
            int deletedCount = deleteQuery.executeUpdate();
            System.out.println("Deleted " + deletedCount + " record(s)\n");
            
            transaction.commit();
            
            // Display all remaining records
            transaction = session.beginTransaction();
            
            System.out.println("===== ALL REMAINING RECORDS =====");
            String selectHQL = "FROM Payment ORDER BY id";
            Query<Payment> selectQuery = session.createQuery(selectHQL, Payment.class);
            List<Payment> payments = selectQuery.getResultList();
            
            for (Payment p : payments) {
                System.out.println(p);
            }
            
            System.out.println("\nTotal records: " + payments.size() + "\n");
            
            transaction.commit();
            
            // Additional HQL operations for demonstration
            System.out.println("===== ADDITIONAL HQL OPERATIONS =====");
            
            // Query by status
            transaction = session.beginTransaction();
            String statusHQL = "FROM Payment WHERE status = :status";
            Query<Payment> statusQuery = session.createQuery(statusHQL, Payment.class);
            statusQuery.setParameter("status", "Completed");
            List<Payment> completedPayments = statusQuery.getResultList();
            System.out.println("Completed payments: " + completedPayments.size());
            
            transaction.commit();
            
            // Count total payments
            transaction = session.beginTransaction();
            String countHQL = "SELECT COUNT(*) FROM Payment";
            Query<Long> countQuery = session.createQuery(countHQL, Long.class);
            Long totalCount = countQuery.uniqueResult();
            System.out.println("Total payments in database: " + totalCount);
            
            transaction.commit();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
