package com.saov.playlist_auth.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Bean
    public MongoClient mongoClient(){
        String uri = "mongodb+srv://saov6000_db_user:s2fr34g4op@cluster0.lpe4ybi.mongodb.net/playlist?retryWrites=true&w=majority";
        return MongoClients.create(uri);
    }

    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoClient(), "playlist");
    }
}
