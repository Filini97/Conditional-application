package config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import profile.DevProfile;
import profile.ProductionProfile;
import profile.SystemProfile;

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