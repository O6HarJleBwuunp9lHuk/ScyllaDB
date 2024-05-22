package com.scylladb.scylla;

import com.scylladb.scylla.generation.RandomDataGenerator;
import com.scylladb.scylla.service.UserJPAService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.context.ConfigurableApplicationContext;
@SpringBootApplication
@EnableCassandraRepositories
public class ScyllaApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(ScyllaApplication.class, args);
		RandomDataGenerator randomDataGenerator = context.getBean(RandomDataGenerator.class);

		randomDataGenerator.generateRandomUsers(1000000);
		randomDataGenerator.generateRandomMessages(1000000);
		randomDataGenerator.generateRandomChat(1000000);
		randomDataGenerator.generateRandomUserChatLinks(1000000);
		//UserJPAService userService = context.getBean(UserJPAService.class);
		//userService.migrateUsers();
	}
}
