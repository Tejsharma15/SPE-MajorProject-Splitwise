package com.example.MiniSplitwise;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.example.MiniSplitwise.MiniSplitwise;
import com.example.model.Bill;
import com.example.model.User;
import com.example.model.PersonalBill;
import com.example.model.BillMapping;
import com.example.repository.BillMappingRepository;
import com.example.repository.BillRepository;
import com.example.repository.PersonalBillRepository;
import com.example.repository.UserRepository;
import com.example.service.BillService;
import com.example.service.PersonalBillService;
import com.example.service.UserService;
import com.example.controller.AuthenticationController;
import com.example.controller.BillController;
import com.example.controller.PersonalBillController;
import com.example.controller.UserController;

@SpringBootTest(classes = MiniSplitwiseApplication.class)
// @WebMvcTest(SubmissionController.class)
@AutoConfigureMockMvc
public class MiniSplitwiseApplicationTests {
    @Mock
    private UserRepository userRepository;
    private BillRepository billRepository;
    private PersonalBillRepository personalBillRepository;
    private BillMappingRepository billMappingRepository;

    @InjectMocks
    private UserController userController;
    private PersonalBillController personalBillController;
    private AuthenticationController authenticationController;
    private BillController billController;

    // Initialize mocks
    public void MiniSplitwiseApplicationTests() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEmployees() {
        // Mock data

        // Employee employee1 = new Employee();
        // employee1.setId(1L);
        // employee1.setFirstName("John");
        // employee1.setLastName("Doe");
        // employee1.setEmailId("john.doe@example.com");

        // Employee employee2 = new Employee();
        // employee2.setId(2L);
        // employee2.setFirstName("Jane");
        // employee2.setLastName("Doe");
        // employee2.setEmailId("jane.doe@example.com");

        User user1 = new User();
        user1.setId("");
        user1.setName("user1");
        user1.setAccPassword("password1");
        user1.setEmail("email1@gmail.com");
        user1.setContact(1111111111);

        User user2 = new User();
        user2.setId("");
        user2.setName("user1");
        user1.setAccPassword("password1");
        user1.setEmail("email1@gmail.com");
        user1.setContact(1111111111);

        List<Employee> mockEmployeeList = Arrays.asList(employee1, employee2);

        // Mock the behavior of the employeeRepository
        when(employeeRepository.findAll()).thenReturn(mockEmployeeList);

        // Call the controller method
        List<Employee> result = employeeController.getAllEmployees();

        // Verify the result
        assertEquals(mockEmployeeList.size(), result.size());
        assertEquals(mockEmployeeList.get(0).getFirstName(), result.get(0).getFirstName());
        assertEquals(mockEmployeeList.get(1).getEmailId(), result.get(1).getEmailId());
        // Add more assertions as needed
    
	}
}
