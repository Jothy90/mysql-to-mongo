package com.senzmate.m2m.mongo;

import com.senzmate.m2m.document.HistoryDocument;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.List;

public class MongoDataLayer {
    static ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");

    static MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

    public static void save(List<HistoryDocument> historyDocumentList){
        mongoOperation.insert(historyDocumentList,HistoryDocument.class);
    }
}
