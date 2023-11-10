package com.msansar.wordmemorization;


import com.msansar.wordmemorization.model.User;
import com.msansar.wordmemorization.model.WordGroup;
import com.msansar.wordmemorization.repository.UserRepository;
import com.msansar.wordmemorization.repository.WordGroupRepository;
import com.msansar.wordmemorization.service.UserService;
import com.msansar.wordmemorization.service.WordGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@SpringBootApplication
public class WordmemorizationApplication implements CommandLineRunner {


	@Autowired
	private ApplicationContext context;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(WordmemorizationApplication.class, args);
	}



	// TODO: PRODUCTION'da silinecek!
	@Override
	public void run(String... args) throws Exception {
		User user = new User("username", passwordEncoder.encode("password"), "email");
		userRepository.save(user);







		// DENEMELİK ŞEYLER. Bunları silebilirsin lazım olur diye silmedim.
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRoles().stream()
				.map(role -> authorities.add(new SimpleGrantedAuthority(role.name()))).toList();
		org.springframework.security.core.userdetails.User userDetail = new org.springframework.security.core.userdetails.User("username", "password", authorities);

		System.out.println(userDetail);
	}

}