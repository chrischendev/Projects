package com.chris.school.settings;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * YdxApiPassenger
 * com.ydx.consumer.settings
 * Created by Chris Chen
 * 2018/3/5
 * Explain:
 */
@Configuration
public class ConsumerApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {
//    @Autowired
//    ServiceManager sman;
//    @Autowired
//    EntityManager em;
//    @Autowired
//    JdbcTemplate jt;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        RegistryCenter.init().reg(sman).setEntityManager(em).setJdbcTemplete(jt);
    }
}
