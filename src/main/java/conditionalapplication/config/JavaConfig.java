package conditionalapplication.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import conditionalapplication.profile.DevProfile;
import conditionalapplication.profile.ProductionProfile;
import conditionalapplication.profile.SystemProfile;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "conditionalapplication")
public class JavaConfig {

@Bean
@ConditionalOnProperty(value = "netology.profile.dev", havingValue = "true")
public SystemProfile devProfile() {
        return new DevProfile();
        }

@Bean
@ConditionalOnProperty(value = "netology.profile.dev", havingValue = "false")
public SystemProfile prodProfile() {
        return new ProductionProfile();
        }
}