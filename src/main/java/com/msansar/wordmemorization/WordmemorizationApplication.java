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
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Date;
import java.util.List;


@SpringBootApplication
@EnableMongoRepositories
@EnableMongoAuditing	// Bu anotasyon ile save ederken tarihlerin null olma durumunu kaldırdık.
public class WordmemorizationApplication implements CommandLineRunner {

	private final MongoDatabaseFactory mongoTemplate;
	private WordGroupService wordGroupService;
	private UserRepository userRepository;
	private UserService userService;
	private WordGroupRepository wordGroupRepository;
	@Autowired
	private ApplicationContext context;

	public WordmemorizationApplication(MongoDatabaseFactory mongoTemplate, WordGroupService wordGroupService, UserRepository userRepository, UserService userService, WordGroupRepository wordGroupRepository) {
		this.mongoTemplate = mongoTemplate;
		this.wordGroupService = wordGroupService;
		this.userRepository = userRepository;
		this.userService = userService;
		this.wordGroupRepository = wordGroupRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(WordmemorizationApplication.class, args);
	}



	// TODO: PRODUCTION'da silinecek!
	@Override
	public void run(String... args) throws Exception {
		// Veritabanını temizle
		mongoTemplate.getMongoDatabase("test").drop();
		User user = new User("id", new Date(), new Date(), "username", "password", "email");
		WordGroup wordGroup = new WordGroup("foreign", "local", true);
		user.setWordGroupList(List.of(wordGroup));
		userRepository.save(user);
		System.out.println("SA");
	}

}