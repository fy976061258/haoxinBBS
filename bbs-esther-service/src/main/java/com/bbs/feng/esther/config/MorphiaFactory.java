package com.bbs.feng.esther.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/02/10 20:07
 * @since JDK 1.8
 */

@Configuration
@ConditionalOnClass(Mongo.class)
public class MorphiaFactory {

    @Autowired
    private Mongo mongo;

    @Autowired
    MongoProperties mongoProperties;

    @Bean(name = "getMongoDB")
    public Datastore getMongoDB() {
        Morphia morphia = new Morphia();
        return morphia.createDatastore((MongoClient) mongo,mongoProperties.getDatabase());
    }

}


