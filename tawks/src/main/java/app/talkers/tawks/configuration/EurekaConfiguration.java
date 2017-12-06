package app.talkers.tawks.configuration;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"local", "prod"})
@EnableDiscoveryClient
@Configuration
public class EurekaConfiguration {
}
