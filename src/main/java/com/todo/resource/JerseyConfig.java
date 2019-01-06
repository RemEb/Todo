package com.todo.resource;

import com.todo.service.impl.EmailServiceImpl;

import com.todo.service.impl.UserServiceImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * @author Lcy
 * @date 2018/12/26 18:09
 */
@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(UserServiceImpl.class);
        register(EmailServiceImpl.class);
    }
}
