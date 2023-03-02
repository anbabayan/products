package com.example.demo.services;

import com.example.demo.components.Session;
import com.example.demo.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service to manage the session information.
 */
@Service
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    public SessionService() {
    }

    /**
     * Getting all the sessions
     */
    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    /**
     * Saving the session to database.
     *
     * @param session new session to be saved.
     */
    public void save(Session session) {
        sessionRepository.save(session);
    }

    /**
     * Deleting a session.
     *
     * @param userId of the specified session to be deleted
     */
    public void deleteOrder(String userId) {
        sessionRepository.deleteById(userId);
    }
}
