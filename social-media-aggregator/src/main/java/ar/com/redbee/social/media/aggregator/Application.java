package ar.com.redbee.social.media.aggregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(scanBasePackages = { "ar.com.redbee" })
public class Application {

  public static void main(final String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
