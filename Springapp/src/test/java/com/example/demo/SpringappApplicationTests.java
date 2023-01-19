package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@SpringBootTest
class SpringbootFirstAppApplicationTests {
	@Autowired
	UserRepository userRepo;
	@Test
	public void testCreate()
	{
		User u=new User();
		u.setId(2L);
		u.setFirstname("Kavya");
		u.setLasttname("shree");
		userRepo.save(u);
		//assertNotNull(userRepo.findById(902L).get());
	}
	@Test
	public void testReadAll()
	{
		List<User> list=userRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	@Test
	public void testUpdate()
	{
		User u=userRepo.findById(52L).get();
		u.setFirstname("Murthy");
		userRepo.save(u);
		assertNotEquals("Niranjan",userRepo.findById(902L).get().getFirstname());
	}
	@Test
	public void testDelete()
	{		
		userRepo.deleteById(852L);
		assertThat(userRepo.existsById(852L)).isFalse();
	}
}

