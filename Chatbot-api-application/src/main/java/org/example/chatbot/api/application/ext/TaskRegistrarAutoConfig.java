package org.example.chatbot.api.application.ext;

import org.example.chatbot.api.domain.ai.IOpenAI;
import org.example.chatbot.api.domain.zsxq.IZsxqApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableScheduling
public class TaskRegistrarAutoConfig implements EnvironmentAware, SchedulingConfigurer {

    private Logger logger = LoggerFactory.getLogger(TaskRegistrarAutoConfig.class);

    private Map<String, Map<String, Object>> taskGroupMap = new HashMap<>();

    @Resource
    private IZsxqApi zsxqApi;

    @Resource
    private IOpenAI openAI;

    @Override
    public void setEnvironment(Environment environment) {

    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

    }

    private int[] a = {1, 6, 8, 546, 22, 13, 4788, 59};

    void nn() {
        Arrays.sort(a);
    }
}
