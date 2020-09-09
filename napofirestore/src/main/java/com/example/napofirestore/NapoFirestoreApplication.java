package com.example.napofirestore;

import com.example.napofirestore.api.common.config.AppConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class NapoFirestoreApplication {
    @Value(value = "${spring.profiles.active}")
    String profile;
    @Value(value = "${spring.datasource.url}")
    String dataSource;

    private final DispatcherServlet servlet;
    private final AppConfig appConfig;

    public NapoFirestoreApplication(DispatcherServlet servlet, AppConfig appConfig) {
        this.servlet = servlet;
        this.appConfig = appConfig;
    }

    public static void main(String[] args) {
        SpringApplication.run(NapoFirestoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner getCommandLineRunner(ApplicationContext context) {
        servlet.setThrowExceptionIfNoHandlerFound(true);
        final String CYAN_BOLD = "\033[1;36m";
        final String YELLOW = "\033[0;33m";


        return args -> {
            String napo = "\n" +
                    "    _ _ __                 - opannapo -                __ _ _    \n" +
                    "   / / / /___  ___    __ _ _ __   _ __   __ _ ___   ___\\ \\ \\ \\   \n" +
                    "  / / / /    \\|  _`\\ / _` | '_  \\| '_  \\/ _` |  _`\\/    \\ \\ \\ \\  \n" +
                    " ( ( ( (  ()    |_) ) (_| | | |    | | | (_| | |_)   ()  ) ) ) ) \n" +
                    "  \\ \\ \\ \\ ___/|  _,/ \\__,_|_| |_||_| |_|\\__,_|  _,/\\___ / / / /  \n" +
                    "   \\_\\_\\_\\====|__============================|__=======/_/_/_/    ";

            System.out.println(CYAN_BOLD + napo + "\n");
            System.out.println(YELLOW + " * Service Running On (Env) :: " + profile);
            System.out.println(YELLOW + " * DataSource :: " + dataSource);
            System.out.println(YELLOW + " * App JwtKey ::" + appConfig.getJwtKey());
            System.out.println(YELLOW + " * App X-App Signature :: " + appConfig.getxAppSignature());
        };
    }
}
