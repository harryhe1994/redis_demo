package com.harry.redis_demo.config;

import com.harry.redis_demo.service.RedisReceiver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
public class RedisListenerConfig {

    @Bean
    RedisMessageListenerContainer container (RedisConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);

        container.addMessageListener(listenerAdapter, new PatternTopic("index"));

        return container;

    }

    @Bean
    MessageListenerAdapter listenerAdapter(RedisReceiver redisReceiver) {
        System.out.println("into message adapter!");
        return new MessageListenerAdapter(redisReceiver, "receiveMessage");
    }

}
