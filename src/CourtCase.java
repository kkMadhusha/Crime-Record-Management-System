import java.util.Date;

// CourtCase class
public class CourtCase {
    // Data Requirements
    private  String caseID;
    private Date courtDate;
    private String judgeInvolved;
    private String lawyerInvolved;
    private String verdict;

    // Constructor
    public CourtCase(String caseID, Date courtDate, String judgeInvolved, String lawyerInvolved, String verdict) {
        this.caseID = caseID;
        this.courtDate = courtDate;
        this.judgeInvolved = judgeInvolved;
        this.lawyerInvolved = lawyerInvolved;
        this.verdict = verdict;
    }

    // Functional Requirement 1: updateCaseDetails
    public void updateCaseDetails(String judgeInvolved, String lawyerInvolved, String verdict) {
        this.judgeInvolved = judgeInvolved;
        this.lawyerInvolved = lawyerInvolved;
        this.verdict = verdict;
    }

    // Functional Requirement 2: getCaseDetails
    public String getCaseDetails() {
        return "Case ID: " + caseID +
                "\nCourt Date: " + courtDate +
                "\nJudge Involved: " + judgeInvolved +
                "\nLawyer Involved: " + lawyerInvolved +
                "\nVerdict: " + verdict;
    }

    // Functional Requirement 3: scheduleNewCourtDate
    public void scheduleNewCourtDate(Date newCourtDate) {

        this.courtDate = newCourtDate;
    }

    // Functional Requirement 4: provideVerdict
    public void provideVerdict(String newVerdict) {

        this.verdict = newVerdict;
    }
}

