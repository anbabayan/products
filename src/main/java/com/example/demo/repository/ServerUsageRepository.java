package com.example.demo.repository;

import com.example.demo.components.ServerUsage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerUsageRepository extends MongoRepository<ServerUsage, String> {

}
