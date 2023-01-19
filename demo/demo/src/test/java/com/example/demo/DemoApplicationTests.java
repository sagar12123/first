package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@DataJpaTest
class DemoApplicationTests {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	@Order(1)
	@Rollback(value=false)
	public void SaveEmployeeTest() {
		Employee employee = Employee.
				.firstname("Sanjay")
				.lastname("cs")
				.email("san@123gmail.com")
				.build();
		employeeRepository.save(employee);
		Assertions.assertThat(employee.getId()).isGreaterThan(0);
	}

}
