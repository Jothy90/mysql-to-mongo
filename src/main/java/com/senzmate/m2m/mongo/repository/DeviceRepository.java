package com.senzmate.m2m.mongo.repository;

import com.senzmate.m2m.document.DeviceDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends MongoRepository<DeviceDocument, String> {

    DeviceDocument findOneById(String id);

    List<DeviceDocument> findByAccountId(String id);

}
