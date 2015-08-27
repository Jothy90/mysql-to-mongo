package com.senzmate.m2m.mongo.repository;

import com.senzmate.m2m.document.AccountDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<AccountDocument, String> {

    AccountDocument findOneByName(String name);
}
