package ir.daak.base;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({
        "classpath:messages_fa.properties",
        "classpath:messages_en.properties",
        "classpath:messages.properties"
})
public class BaseBeanConfig {
}
