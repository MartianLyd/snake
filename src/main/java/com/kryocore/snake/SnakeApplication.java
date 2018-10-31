package com.kryocore.snake;

import com.kryocore.snake.crt.agent.AgentTask;
import com.kryocore.snake.crt.agent.TheAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

//@Configuration
@EnableScheduling
@SpringBootApplication
public class SnakeApplication extends SpringBootServletInitializer
        implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    private static final Logger logger = LoggerFactory.getLogger(SnakeApplication.class);
    @Autowired
    private AgentTask agentTask;

    public static void main(String[] args) {
        SpringApplication.run(SnakeApplication.class, args);
    }

    private void init() {
        logger.info("===========================初始化结束=============================");
        TheAgent.getInstance().register2master(agentTask);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
    }


    @Override
    protected WebApplicationContext run(SpringApplication application) {
        return super.run(application);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return super.configure(builder);
    }

    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        factory.setPort(18880);
        init();
    }
}
