package com.senzmate.m2m.app;

import com.senzmate.m2m.document.HistoryDocument;
import com.senzmate.m2m.mongo.MongoDataLayer;
import com.senzmate.m2m.mysql.MySqlDataLayer;
import com.senzmate.m2m.table.History;
import com.senzmate.m2m.util.Mapper;

import java.util.List;

public class Boot {

    public static void main(String[] args) throws Exception {
        logStartedMessage();
        migrate();
        logStoppedMessage();
    }

    private static void migrate() {
        List<History> historyList= MySqlDataLayer.getAllHistory();
        List<HistoryDocument> historyDocumentList= Mapper.convertHistoryTableToDocumentList(historyList);
        MongoDataLayer.save(historyDocumentList);
    }

    private static void logStartedMessage() {
        System.out.println("#############################################################");
        System.out.println("##              MySql-Mongo Started Successfully           ##");
        System.out.println("#############################################################");
    }

    private static void logStoppedMessage() {
        System.out.println("#############################################################");
        System.out.println("##             MySql-Mongo Migrated Successfully           ##");
        System.out.println("#############################################################");
    }

}
