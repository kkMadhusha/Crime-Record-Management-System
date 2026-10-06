import java.util.Date;
import java.util.List;

// CrimeRecord class definition
class CrimeRecord {

    private String caseNumber;
    private Date date;
    private String location;
    private String description;
    private String status;
    private List<String> assignedOfficers;

    // Default constructor
    public CrimeRecord() {
    }

    // Constructor
    public CrimeRecord(String caseNumber, Date date, String location,
                       String description, String status) {
        this.caseNumber = caseNumber;
        this.date = date;
        this.location = location;
        this.description = description;
        this.status = status;
    }

    // Getter and setter for Case Number
    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    // Getter and setter for Date
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // Getter and setter for Location
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Getter and setter for Description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and setter for Status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getter and setter for assignedOfficers
    public List<String> getAssignedOfficers() {
        return assignedOfficers;
    }

    public void setAssignedOfficers(List<String> assignedOfficers) {
        this.assignedOfficers = assignedOfficers;
    }
}