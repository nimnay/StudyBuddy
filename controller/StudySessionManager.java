package controller;

import java.util.ArrayList;
import java.util.List;
import models.StudySession;

/**
 * Manages multiple StudySession objects.
 * <p>
 * Responsible for:
 * - Adding new study sessions
 * - Removing existing sessions
 * - Listing all scheduled sessions
 * <p>
 * Acts as the "organizer" of sessions, simplifying how the main program
 * interacts with study groups.
 */

public class StudySessionManager {
    private List<StudySession> sessions;

    public StudySessionManager() {
        this.sessions = new ArrayList<>();
    }

    public void addSession(StudySession session) {
        sessions.add(session);
    }

    public List<StudySession> getSessions() {
        return sessions;
    }

    public void removeSession(StudySession session) {
        sessions.remove(session);
    }

    public void listSessions() {
        if (sessions.isEmpty()) {
            System.out.println("No study sessions scheduled.");
        } else {
            for (int i = 0; i < sessions.size(); i++) {
                System.out.println((i + 1) + ". " + sessions.get(i));
            }
        }
    }
}