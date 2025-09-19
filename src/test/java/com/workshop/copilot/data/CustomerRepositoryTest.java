package com.workshop.copilot.data;

import com.workshop.copilot.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Minimal test coverage for CustomerRepository
 * Only tests the findById method
 * Missing tests for other methods and edge cases
 */
@DataJpaTest
public class CustomerRepositoryTest {
    
    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Test
    public void testFindById_ExistingCustomer() {
        // Given
        Customer customer = new Customer();
        customer.setCustomerId("TEST-001");
        customer.setCustomerName("Test Customer");
        customer.setEmail("test@example.com");
        customer.setCreatedDate(new Date());
        
        entityManager.persistAndFlush(customer);
        
        // When
        Optional<Customer> found = customerRepository.findById("TEST-001");
        
        // Then
        assertTrue(found.isPresent());
        assertEquals("Test Customer", found.get().getCustomerName());
        assertEquals("test@example.com", found.get().getEmail());
    }
    
    // Missing tests for:
    // - findByEmail()
    // - findByCustomerNameContaining()
    // - CustomerRepositoryImpl methods
    // - Non-existent customer scenarios
    // - Invalid data scenarios
    // - N+1 query problems
    // - Concurrent access issues
    // - Large dataset performance
}