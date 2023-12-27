package conditionalapplication.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import conditionalapplication.profiles.DevProfile;
import conditionalapplication.profiles.ProductionProfile;
import conditionalapplication.profiles.SystemProfile;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
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