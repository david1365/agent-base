package ir.daak.base;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({
        "classpath:base_messages_fa.properties",
        "classpath:base_messages_en.properties",
        "classpath:base_messages.properties"
})
public class BaseBeanConfig {
}
