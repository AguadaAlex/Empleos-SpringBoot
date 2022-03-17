package com.javaweb.employservice.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.beans.factory.annotation.Value;
@Configuration
@EnableMongoRepositories({"com.javaweb.employservice.repository"})
public class MongoConfig extends AbstractMongoClientConfiguration {

    private String url;

    public MongoConfig(@Value("${spring.data.mongodb.url}") String url) {
        this.url = url;
    }

    protected String getDatabaseName() {
        return "db01";
    }

    private MongoProperties properties = new MongoProperties();

    @Bean
    public MongoClient mongoClient(){
        return MongoClients.create(url);
    }
}
