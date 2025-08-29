	
package controller;

import models.StudySession;
import models.Student;
import java.util.ArrayList;
import java.util.List;

public class SessionDirectory {
	private List<StudySession> sessions;

	public SessionDirectory() {
		this.sessions = new ArrayList<>();
	}

	/**
	 * Loads some sample study sessions using students from the given StudentDirectory.
	 */
	public void loadSampleSessions(StudentDirectory studentDirectory) {
		Student bob = studentDirectory.findStudentByName("Bob");
		Student charlie = studentDirectory.findStudentByName("Charlie");
		Student dana = studentDirectory.findStudentByName("Dana");
		Student emily = studentDirectory.findStudentByName("Emily");
		Student frank = studentDirectory.findStudentByName("Frank");

		// Session 1: Bob's CPSC 2150 session on Monday 7PM-8PM
		if (bob != null) {
			StudySession s1 = new StudySession(bob, "CPSC 2150", "Monday 7PM-8PM");
			if (charlie != null) s1.addParticipant(charlie);
			if (frank != null) s1.addParticipant(frank);
			sessions.add(s1);
		}

		// Session 2: Emily's BIOL 1030 session on Wednesday 10AM-12PM
		if (emily != null) {
			StudySession s2 = new StudySession(emily, "BIOL 1030", "Wednesday 10AM-12PM");
			if (dana != null) s2.addParticipant(dana);
			sessions.add(s2);
		}

		// Session 3: Frank's ENGR 1410 session on Thursday 1PM-3PM
		if (frank != null) {
			StudySession s3 = new StudySession(frank, "ENGR 1410", "Thursday 1PM-3PM");
			if (bob != null) s3.addParticipant(bob);
			sessions.add(s3);
		}
	}

	public List<StudySession> getSessions() {
		return sessions;
	}

    /**
	 * Prints all study sessions and their participants.
	 */
	public void printSessions() {
		if (sessions.isEmpty()) {
			System.out.println("No study sessions available.");
			return;
		}
		for (StudySession session : sessions) {
			System.out.println("Session for course: " + session.getCourse());
			System.out.println("  Time: " + session.getTime());
			System.out.println("  Creator: " + session.getCreator().getName());
			System.out.println("  Participants:");
			for (models.Student s : session.getParticipants()) {
				System.out.println("    - " + s.getName());
			}
			System.out.println();
		}
	}
}
