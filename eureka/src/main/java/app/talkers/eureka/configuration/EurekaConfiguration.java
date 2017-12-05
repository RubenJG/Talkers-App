package app.talkers.eureka.configuration;

import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"local", "prod"})
@EnableEurekaServer
@Configuration
public class EurekaConfiguration {
}
