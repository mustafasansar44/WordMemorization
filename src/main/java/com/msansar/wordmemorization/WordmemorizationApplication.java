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

import java.util.Date;
import java.util.List;


@SpringBootApplication
public class WordmemorizationApplication implements CommandLineRunner {


	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(WordmemorizationApplication.class, args);
	}



	// TODO: PRODUCTION'da silinecek!
	@Override
	public void run(String... args) throws Exception {


	}

}