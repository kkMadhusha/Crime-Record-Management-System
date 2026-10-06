import java.util.ArrayList;
import java.util.List;

abstract class PoliceStation {

    private String branch;
    private int branchId;
    private int contactNumber;
    private List<String> policeOfficers;

    public PoliceStation(String branch, int branchId, int contactNumber,
                         List<String> policeOfficers) {
        this.branch = branch;
        this.branchId = branchId;
        this.contactNumber = contactNumber;
        this.policeOfficers = policeOfficers;
    }

    public abstract void registerCrime(CrimeRecord crime);
    public abstract void assignOfficers(CrimeRecord crime,
                                        List<String> officers);
    public abstract void trackCaseProgress(CrimeRecord crime);
    public abstract void generateReports(CrimeRecord crime);
}


class CrimeDepartment extends PoliceStation {

    private List<CrimeRecord> crimeRecords;

    public CrimeDepartment(String branch, int branchId, int contactInformation,
                           List<String> policeOfficers) {

        super(branch, branchId, contactInformation, policeOfficers);
        this.crimeRecords = new ArrayList<>();
    }

    @Override
    public void registerCrime(CrimeRecord crime) {
        crimeRecords.add(crime);

        System.out.println(
                "Crime registered successfully. Case Number: "
                        + crime.getCaseNumber()
        );
    }

    @Override
    public void assignOfficers(CrimeRecord crime, List<String> officers) {

        for (CrimeRecord record : crimeRecords) {

            if (record.getCaseNumber().equals(crime.getCaseNumber())) {

                record.setAssignedOfficers(officers);

                System.out.println(
                        "Officers assigned successfully to Case Number: "
                                + crime.getCaseNumber()
                );

                return;
            }
        }

        System.out.println(
                "Error: Crime Record not found for Case Number: "
                        + crime.getCaseNumber()
        );
    }

    @Override
    public void trackCaseProgress(CrimeRecord crime) {

        for (CrimeRecord record : crimeRecords) {

            if (record.getCaseNumber().equals(crime.getCaseNumber())) {

                record.setStatus("In Progress");

                System.out.println(
                        "Case progress updated for Case Number: "
                                + crime.getCaseNumber()
                );

                return;
            }
        }

        System.out.println(
                "Error: Crime Record not found for Case Number: "
                        + crime.getCaseNumber()
        );
    }

    @Override
    public void generateReports(CrimeRecord crime) {

        for (CrimeRecord record : crimeRecords) {

            if (record.getCaseNumber().equals(crime.getCaseNumber())) {

                String report =
                        "Case Number: " + record.getCaseNumber()
                                + "\nDate: " + record.getDate()
                                + "\nLocation: " + record.getLocation()
                                + "\nDescription: " + record.getDescription()
                                + "\nStatus: " + record.getStatus()
                                + "\nReport generated successfully.";

                System.out.println(report);

                return;
            }
        }

        System.out.println(
                "Error: Crime Record not found for Case Number: "
                        + crime.getCaseNumber()
        );
    }

    public CrimeRecord searchCase(String caseNumber) {

        for (CrimeRecord record : crimeRecords) {

            if (record.getCaseNumber().equals(caseNumber)) {
                return record;
            }
        }

        System.out.println(
                "Error: Crime Record not found for Case Number: "
                        + caseNumber
        );

        return null;
    }
}