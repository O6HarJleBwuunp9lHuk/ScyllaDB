package com.scylladb.scylla;

import com.scylladb.scylla.generation.RandomDataGenerator;
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
		/*randomDataGenerator.generateRandomUsers(100);
		randomDataGenerator.generateRandomMessages(100);
		randomDataGenerator.generateRandomChat(100);
		randomDataGenerator.generateRandomUserChatLinks(100);*/
	}
}
