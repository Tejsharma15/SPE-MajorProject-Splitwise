<<<<<<< HEAD
package com.example.MiniSplitwise;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
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
import java.util.UUID;
import java.util.List;
import java.util.Optional;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.example.MiniSplitwise.MiniSplitwiseApplication;
import com.example.MiniSplitwise.model.Bill;
import com.example.MiniSplitwise.model.User;
import com.example.MiniSplitwise.model.PersonalBill;
import com.example.MiniSplitwise.model.BillMapping;
import com.example.MiniSplitwise.repository.BillMappingRepository;
import com.example.MiniSplitwise.repository.BillRepository;
import com.example.MiniSplitwise.repository.PersonalBillRepository;
import com.example.MiniSplitwise.repository.UserRepository;
import com.example.MiniSplitwise.service.BillService;
import com.example.MiniSplitwise.service.PersonalBillService;
import com.example.MiniSplitwise.service.UserService;
import com.example.MiniSplitwise.controller.AuthenticationController;
import com.example.MiniSplitwise.controller.BillController;
import com.example.MiniSplitwise.controller.PersonalBillController;
import com.example.MiniSplitwise.controller.UserController;

@SpringBootTest(classes = MiniSplitwiseApplication.class)
// @WebMvcTest(SubmissionController.class)
@AutoConfigureMockMvc
public class MiniSplitwiseApplicationTests {
     @Mock
    private UserRepository userRepository;

    @Mock
    private BillRepository billRepository;

    @Mock
    private PersonalBillRepository personalBillRepository;

    @Mock
    private BillMappingRepository billMappingRepository;

    @Mock
    private UserService userService;

    @Mock
    private BillService billService;

    @Mock
    private PersonalBillService personalBillService;

    @InjectMocks
    private UserController userController;

    @InjectMocks
    private PersonalBillController personalBillController;

    @InjectMocks
    private AuthenticationController authenticationController;

    @InjectMocks
    private BillController billController;
    // Initialize mocks
    public void MiniSplitwiseApplicationTests() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers() {
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
        user1.setUserId(UUID.fromString("b9c7eb21-9ea5-4e89-b601-8b24b1eef3a1"));
        user1.setName("user1");
        user1.setAccPassword("password1");
        user1.setPersonalEmail("email1@gmail.com");
        user1.setContact("1111111111");

        User user2 = new User();
        user2.setUserId(UUID.fromString("b9c7eb21-9ea5-4e89-b601-8b24b1eef3a2"));
        user2.setName("user2");
        user2.setAccPassword("password2");
        user2.setPersonalEmail("email2@gmail.com");
        user2.setContact("1111111112");

        List<User> mockUserList = Arrays.asList(user1, user2);

        // Mock the behavior of the employeeRepository
        when(userService.getAllUsers()).thenReturn(mockUserList);

        ResponseEntity<List<User>> responseEntity = userController.getUsers();

        // Handle the case where the body is null
        List<User> result = Optional.ofNullable(responseEntity.getBody()).orElse(Collections.emptyList());
        // User test = userController.getUserById(UUID.fromString("1"));
        // Verify the result
        assertEquals(mockUserList.size(), result.size());
        assertEquals(mockUserList.get(0).getName(), result.get(0).getName());
        assertEquals(mockUserList.get(1).getPersonalEmail(), result.get(1).getPersonalEmail());
        // Add more assertions as needed
        // assertEquals(user1.getPersonalEmail(), test.getPersonalEmail());

	}

    @Test
    void testGetBillsByUserId() {
        User user1 = new User();
        user1.setUserId(UUID.fromString("b9c7eb21-9ea5-4e89-b601-8b24b1eef3a1"));
        user1.setName("user1");
        user1.setAccPassword("password1");
        user1.setPersonalEmail("email1@gmail.com");
        user1.setContact("1111111111");

        User user2 = new User();
        user2.setUserId(UUID.fromString("b9c7eb21-9ea5-4e89-b601-8b24b1eef3a2"));
        user2.setName("user2");
        user2.setAccPassword("password2");
        user2.setPersonalEmail("email2@gmail.com");
        user2.setContact("1111111112");

        PersonalBill bill1 = new PersonalBill();
        bill1.setBillId(UUID.fromString("b9c7eb21-9ea5-4e89-b601-8b24b1eef3a3"));
        bill1.setBillName("bill1");
        bill1.setUserId(UUID.fromString("b9c7eb21-9ea5-4e89-b601-8b24b1eef3a1"));
        bill1.setAmount(1000.0f);

        PersonalBill bill2 = new PersonalBill();
        bill2.setBillId(UUID.fromString("b9c7eb21-9ea5-4e89-b601-8b24b1eef3a3"));
        bill2.setBillName("bill2");
        bill2.setUserId(UUID.fromString("b9c7eb21-9ea5-4e89-b601-8b24b1eef3a4"));
        bill2.setAmount(1000.0f);
        List<PersonalBill> mockPersonalBillList = Arrays.asList(bill1, bill2);

        when(personalBillService.getBillByUserId(UUID.fromString("b9c7eb21-9ea5-4e89-b601-8b24b1eef3a1")))
            .thenReturn(Optional.of(mockPersonalBillList));
        when(userService.findUserByEmail("email1@gmail.com")).thenReturn(user1);

        ResponseEntity<List<PersonalBill>> response = personalBillController
                .getBillByUserId("email1@gmail.com");

        List<PersonalBill> results = response.getBody();


        // Handle the case where the body is null
        // List<PersonalBill> results = Optional.ofNullable(response.getBody()).orElse(Collections.emptyList());
        // Verify the result
        assertEquals(mockPersonalBillList.size(), results.size());
        System.out.println(mockPersonalBillList.get(1).getBillName());
        System.out.println(results.get(1).getBillName());
        assertEquals(mockPersonalBillList.get(0).getBillId(), results.get(0).getBillId());
        assertEquals(mockPersonalBillList.get(1).getBillId(), results.get(1).getBillId());
    }

 @Test
    void testGetBillsById() {
        User user1 = new User();
        user1.setUserId(UUID.fromString("b9c7eb21-9ea5-4e89-b601-8b24b1eef3a1"));
        user1.setName("user1");
        user1.setAccPassword("password1");
        user1.setPersonalEmail("email1@gmail.com");
        user1.setContact("1111111111");

        User user2 = new User();
        user2.setUserId(UUID.fromString("b9c7eb21-9ea5-4e89-b601-8b24b1eef3a2"));
        user2.setName("user2");
        user2.setAccPassword("password2");
        user2.setPersonalEmail("email2@gmail.com");
        user2.setContact("1111111112");

        PersonalBill bill1 = new PersonalBill();
        bill1.setBillId(UUID.fromString("b9c7eb21-9ea5-4e89-b601-8b24b1eef3a2"));
        bill1.setBillName("bill1");
        bill1.setUserId(UUID.fromString("b9c7eb21-9ea5-4e89-b601-8b24b1eef3a1"));
        bill1.setAmount(1000.0f);

        PersonalBill bill2 = new PersonalBill();
        bill2.setBillId(UUID.fromString("b9c7eb21-9ea5-4e89-b601-8b24b1eef3a4"));
        bill2.setBillName("bill2");
        bill2.setUserId(UUID.fromString("b9c7eb21-9ea5-4e89-b601-8b24b1eef3a1"));
        bill2.setAmount(1000.0f);
        // List<PersonalBill> mockPersonalBillList = Arrays.asList(bill1, bill2);

        when(personalBillService.getBillById(UUID.fromString("b9c7eb21-9ea5-4e89-b601-8b24b1eef3a2")))
            .thenReturn(Optional.of(bill1));
        // when(userService.findUserByEmail("email1@gmail.com")).thenReturn(user1);

        ResponseEntity<PersonalBill> response = personalBillController
                .getBillById(UUID.fromString("b9c7eb21-9ea5-4e89-b601-8b24b1eef3a2"));

        PersonalBill result = response.getBody();


        // Handle the case where the body is null
        // List<PersonalBill> results = Optional.ofNullable(response.getBody()).orElse(Collections.emptyList());
        // Verify the result
        // assertEquals(mockPersonalBillList.size(), results.size());
        assertEquals(bill1.getBillId(), result.getBillId());
    }

}
=======
//package com.example.MiniSplitwise;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.test.web.servlet.MockMvc;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import java.util.Arrays;
//import java.util.List;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import com.example.MiniSplitwise.MiniSplitwise;
//import com.example.model.Bill;
//import com.example.model.User;
//import com.example.model.PersonalBill;
//import com.example.model.BillMapping;
//import com.example.repository.BillMappingRepository;
//import com.example.repository.BillRepository;
//import com.example.repository.PersonalBillRepository;
//import com.example.repository.UserRepository;
//import com.example.service.BillService;
//import com.example.service.PersonalBillService;
//import com.example.service.UserService;
//import com.example.controller.AuthenticationController;
//import com.example.controller.BillController;
//import com.example.controller.PersonalBillController;
//import com.example.controller.UserController;
//
//@SpringBootTest(classes = MiniSplitwiseApplication.class)
//// @WebMvcTest(SubmissionController.class)
//@AutoConfigureMockMvc
//public class MiniSplitwiseApplicationTests {
//    @Mock
//    private UserRepository userRepository;
//    private BillRepository billRepository;
//    private PersonalBillRepository personalBillRepository;
//    private BillMappingRepository billMappingRepository;
//
//    @InjectMocks
//    private UserController userController;
//    private PersonalBillController personalBillController;
//    private AuthenticationController authenticationController;
//    private BillController billController;
//
//    // Initialize mocks
//    public void MiniSplitwiseApplicationTests() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testGetAllEmployees() {
//        // Mock data
//
//        // Employee employee1 = new Employee();
//        // employee1.setId(1L);
//        // employee1.setFirstName("John");
//        // employee1.setLastName("Doe");
//        // employee1.setEmailId("john.doe@example.com");
//
//        // Employee employee2 = new Employee();
//        // employee2.setId(2L);
//        // employee2.setFirstName("Jane");
//        // employee2.setLastName("Doe");
//        // employee2.setEmailId("jane.doe@example.com");
//
//        User user1 = new User();
//        user1.setId("");
//        user1.setName("user1");
//        user1.setAccPassword("password1");
//        user1.setEmail("email1@gmail.com");
//        user1.setContact(1111111111);
//
//        User user2 = new User();
//        user2.setId("");
//        user2.setName("user1");
//        user1.setAccPassword("password1");
//        user1.setEmail("email1@gmail.com");
//        user1.setContact(1111111111);
//
//        List<Employee> mockEmployeeList = Arrays.asList(employee1, employee2);
//
//        // Mock the behavior of the employeeRepository
//        when(employeeRepository.findAll()).thenReturn(mockEmployeeList);
//
//        // Call the controller method
//        List<Employee> result = employeeController.getAllEmployees();
//
//        // Verify the result
//        assertEquals(mockEmployeeList.size(), result.size());
//        assertEquals(mockEmployeeList.get(0).getFirstName(), result.get(0).getFirstName());
//        assertEquals(mockEmployeeList.get(1).getEmailId(), result.get(1).getEmailId());
//        // Add more assertions as needed
//
//	}
//}
>>>>>>> 6961577c1916630ce6c119236bb674f944d16b92
