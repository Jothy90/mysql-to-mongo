package com.senzmate.m2m.mongo;

import com.senzmate.m2m.document.HistoryDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends MongoRepository<HistoryDocument, String> {

    List<HistoryDocument> findByDeviceIdAndDateBetween(String deviceId, String from, String to);
}
