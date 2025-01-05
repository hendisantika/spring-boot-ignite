package id.my.hendisantika.ignite.config;

import org.apache.ignite.cache.spring.SpringCacheManager;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-ignite
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 05/01/25
 * Time: 09.34
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableCaching
public class IgniteCacheConfig {

    @Bean
    public SpringCacheManager cacheManager() {
        SpringCacheManager mgr = new SpringCacheManager();
        mgr.setConfiguration(new IgniteConfiguration().setIgniteInstanceName("Ignite Cache Node").setMetricsLogFrequency(0));
        return mgr;
    }
}
