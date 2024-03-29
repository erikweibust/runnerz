package net.weibust.runnerz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


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
