package hello.streams.application;

import java.util.function.Function;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelloStreamApp {

	public static void main(String[] args) {
		//SpringApplication.run(HelloStreamApp.class, args);
		SpringApplication.run(HelloStreamApp.class,
				"--spring.cloud.function.routing-expression="
						//+ "T(java.lang.System).nanoTime() % 2 == 0 ? 'even' : 'odd'");
					+ "headers['hello']");
	}

//	@Bean
//	public Function<String, String> toUpperCase() {
//		return value -> {
//			System.out.println("Uppercasing " + value);
//			return null;
//		};
//	}

	@Bean
	public Consumer<Integer> even() {
		return value -> System.out.println("EVEN: " + value);
	}

	@Bean
	public Consumer<Integer> odd() {
		return value -> System.out.println("ODD: " + value);
	}


}
