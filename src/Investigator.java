import java.util.ArrayList;
import java.util.List;

public class Investigator {

    // Data members
    private String name;
    private String specialization;
    private List<String> assignedCases;
    private String experienceLevel;

    // Constructor
    public Investigator(String name, String specialization, String experienceLevel) {
        this.name = name;
        this.specialization = specialization;
        this.experienceLevel = experienceLevel;
        this.assignedCases = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public List<String> getAssignedCases() {
        return assignedCases;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    // Analyse Crime Scene
    public String analyseCrimeScene() {
        return "Observations based on crime scene analysis by Investigator "
                + name + ".";
    }

    // Submit Report
    public void submitReport(String caseID, String report) {
        System.out.println(
                "Report submitted for Case ID " + caseID
                        + " by Investigator " + name + ":\n" + report
        );
    }

    // Update New Cases
    public void updateNewCases(String newCase) {
        assignedCases.add(newCase);

        System.out.println(
                "Investigator " + name
                        + " updated with a new case: " + newCase
        );
    }

    // Assign Case
    public void assignCase(String caseID, List<String> policeOfficers) {

        if (!assignedCases.contains(caseID)) {
            assignedCases.add(caseID);
        }

        System.out.println(
                "Case ID " + caseID
                        + " assigned to Investigator " + name + "."
        );

        System.out.println(
                "Police Officers assigned: " + policeOfficers
        );
    }
}