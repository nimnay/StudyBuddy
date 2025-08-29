package models;
// StudySession.java
import java.util.ArrayList;
import java.util.List;


/**
 * Represents a single study session.
 *
 * Stores information about the session such as:
 * - The host (student who created it)
 * - The course the session is for
 * - The scheduled time
 * - A list of invited students
 *
 * Provides methods to add invites and display session details.
 * This class acts as the "data model" for one study group.
 */

public class StudySession {
    private String host;
    private String course;
    private String time;
    private List<String> invited;

    public StudySession(String host, String course, String time) {
        this.host = host;
        this.course = course;
        this.time = time;
        this.invited = new ArrayList<>();
    }

    public String getHost() {
        return host;
    }

    public String getCourse() {
        return course;
    }

    public String getTime() {
        return time;
    }

    public List<String> getInvited() {
        return invited;
    }

    public void inviteStudent(String studentName) {
        invited.add(studentName);
    }

    @Override
    public String toString() {
        return "Study Session [host=" + host +
                ", course=" + course +
                ", time=" + time +
                ", invited=" + invited + "]";
    }
}
