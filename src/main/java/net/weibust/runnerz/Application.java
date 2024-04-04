package net.weibust.runnerz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import net.weibust.runnerz.user.UserRestClient;
import net.weibust.runnerz.user.*;


@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		/* Basic logging setup */
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		log.info("Application has started successfully");

		//WelcomeMessage welcomeMessage = new WelcomeMessage();
		//System.out.println(welcomeMessage.getWelcomeMessage());

		/* Basic example of Spring finding bean and instantiating it */
		Object welcomeBean = context.getBean("welcomeMessage");
		String welcomeMessage2 = ((WelcomeMessage) welcomeBean).getWelcomeMessage();
		System.out.println(welcomeMessage2);

		Object runRepo = context.getBean("runRepository");
		System.out.println(runRepo);
	}

	@Bean
	UserHttpClient userHttpClient() {
		RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com/");
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();

		return factory.createClient(UserHttpClient.class);
	}

	@Bean
	CommandLineRunner runner(UserHttpClient client) {
	//CommandLineRunner runner(UserRestClient client) {
		return args -> {

			List<User> users = client.findAll();
			System.out.println(users);

		};
	}

	// create test Run record to prove model out
	// @Bean
	// CommandLineRunner runner(RunRepository runRepository) {
	// 	return args -> {
	// 		Run run = new Run(1,
	// 					"First Run",
	// 					LocalDateTime.now(),
	// 					LocalDateTime.now().plus(1, ChronoUnit.HOURS),
	// 					5,
	// 					Location.OUTDOOR);

	// 		runRepository.create(run);
	// 	};

		// Initial run; not sure where this was used; this was before In-Memory RunRepo
		// We did not need to pass the RunRepo into the runner() for this; that was added for db
		// version of Repo
		// return args -> {
		// 	Run run = new Run(1,
		// 				"First Run",
		// 				LocalDateTime.now(),
		// 				LocalDateTime.now().plus(1, ChronoUnit.HOURS),
		// 				5,
		// 				Location.OUTDOOR);
		// 	log.info("Run: " + run);
		
		// };
	//}

}
