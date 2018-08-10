package itsol.nguyenbanh.demospringsecurity;

import itsol.nguyenbanh.config.WebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import({WebSecurityConfig.class})
public class DemospringsecurityApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemospringsecurityApplication.class, args);
    }
}
