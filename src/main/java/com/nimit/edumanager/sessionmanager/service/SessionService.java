package com.nimit.edumanager.sessionmanager.service;

import com.nimit.edumanager.sessionmanager.entity.Session;
import com.nimit.edumanager.sessionmanager.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    @Autowired
    SessionRepository sessionRepository;

    public Session create(Session session) {
        return sessionRepository.save(session);
    }
}

