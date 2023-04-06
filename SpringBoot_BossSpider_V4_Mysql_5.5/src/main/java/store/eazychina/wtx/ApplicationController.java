package store.eazychina.wtx;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//(exclude = {DataSourceAutoConfiguration.class}) 
@SpringBootApplication
@ComponentScan(basePackages = { "store.eazychina.wtx" })
public class ApplicationController {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationController.class, args);
	}
}
