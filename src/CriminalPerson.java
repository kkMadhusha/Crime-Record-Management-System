import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class CrimeRecord01 {

    private String crimeType;
    private Date crimeDate;

    // Constructor
    public CrimeRecord01(String crimeType, Date crimeDate) {
        this.crimeType = crimeType;
        this.crimeDate = crimeDate;
    }

    public String getCrimeType() {
        return crimeType;
    }

    public Date getCrimeDate() {
        return crimeDate;
    }
}

class CriminalPerson {

    // Data Requirements
    private String nationalID;
    private String name;
    private Date dateOfBirth;
    private String address;
    private int contactNumber;
    private String gender;
    private List<CrimeRecord01> criminalRecord;

    // Constructor
    public CriminalPerson(String nationalID, String name, Date dateOfBirth,
                          String address, int contactNumber, String gender) {
        this.nationalID = nationalID;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.contactNumber = contactNumber;
        this.gender = gender;
        this.criminalRecord = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Add a crime record
    public void addCrimeRecord(String crimeType, Date crimeDate) {
        CrimeRecord01 newCrimeRecord = new CrimeRecord01(crimeType, crimeDate);
        criminalRecord.add(newCrimeRecord);
        System.out.println("Criminal record added successfully.");
    }

    // View crime history
    public void viewCrimeHistory() {
        System.out.println("Crime History for " + name +
                " (National ID: " + nationalID + "):");

        if (criminalRecord.isEmpty()) {
            System.out.println("No crime records found.");
            return;
        }

        for (CrimeRecord01 record : criminalRecord) {
            System.out.println("Crime Type: " + record.getCrimeType() +
                    ", Date: " + record.getCrimeDate());
        }
    }

    // Display final record
    public void finalRecord() {
        System.out.println("Final Report for " + name +
                " (National ID: " + nationalID + "):");
        viewCrimeHistory();
    }

    // Search for a person by National ID
    public static CriminalPerson searchPerson(
            List<CriminalPerson> personList, String nationalID) {

        for (CriminalPerson person : personList) {
            if (person.getNationalID().equals(nationalID)) {
                return person;
            }
        }

        return null;
    }
}