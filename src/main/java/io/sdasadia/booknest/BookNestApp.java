// Followed a tutorial by Java Brains on Youtube.
// Link: https://www.youtube.com/watch?v=LxVGFBRpEFM&list=PLKY246dKRk4U

package io.sdasadia.booknest;

import java.nio.file.Path;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import io.sdasadia.booknest.connection.DataStaxAstraProperties;

@SpringBootApplication
@EnableConfigurationProperties(DataStaxAstraProperties.class)
public class BookNestApp {

	public static void main(String[] args) {
		SpringApplication.run(BookNestApp.class, args);
	}

	
	@Bean
    public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties astraProperties) {
        Path bundle = astraProperties.getSecureConnectBundle().toPath();
        return builder -> builder.withCloudSecureConnectBundle(bundle);
    }
	

}
