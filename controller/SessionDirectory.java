	
package controller;

import models.StudySession;
import models.Student;
import java.util.ArrayList;
import java.util.List;

/**
 * The SessionDirectory class manages a collection of study sessions.
 */
public class SessionDirectory {
	/**
     * List to store all study sessions in the directory.
     */
	private List<StudySession> sessions;


	/**
	 * Constructor initializes the sessions list.
	 */
	public SessionDirectory() {
		this.sessions = new ArrayList<>();
	}

	/**
	 * Loads some sample study sessions using students from the given StudentDirectory.
	 * @param studentDirectory The directory containing student data.
	 */
	public void loadSampleSessions(StudentDirectory studentDirectory) {
		// Retrieve students by name from the directory
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


	/**
	 * Returns the list of all study sessions.
	 * @return List of StudySession objects.
	 */
	public List<StudySession> getSessions() {
		return sessions;
	}


	/**
	 * Adds a new study session to the directory.
	 * @param session The StudySession to add.
	 */
	public void addSession(StudySession session) {
		this.sessions.add(session);
	}

	/**
	 * Prints all study sessions and their participants in a readable format.
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
