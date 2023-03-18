package com.example.demo.services;

import com.example.demo.components.ServerUsage;
import com.example.demo.repository.ServerUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service to manage the server usage information.
 */
@Service
public class ServerUsageService {
    @Autowired
    private ServerUsageRepository serverUsageRepository;

    public ServerUsageService() {
    }

    /**
     * Getting all the server usages.
     */
    public List<ServerUsage> getServerUsages() {
        return serverUsageRepository.findAll();
    }

    /**
     * Saving the usage info to database.
     *
     * @param usage new usage to be saved.
     */
    public void save(ServerUsage usage) {
        serverUsageRepository.save(usage);
    }

    /**
     * Deleting server usage information.
     *
     * @param id of the usage to be deleted.
     */
    public void delete(String id) {
        serverUsageRepository.deleteById(id);
    }
}
