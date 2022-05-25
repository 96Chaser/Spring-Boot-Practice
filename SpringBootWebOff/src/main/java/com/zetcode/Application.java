package com.zetcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        new SpringApplicationBuilder(Application.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}

@RestController
class MyController {

    @GetMapping("/")
    public String hello() {

        return "Home page";
    }
}

@Configuration
class MyRoutes {

    @Bean
    RouterFunction<ServerResponse> about() {
        return route(GET("/about"), request -> ok().body(fromValue("About page")));
    }
}

@Component
class MyRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Hello there!");
    }
}