class CrimeReports {
    private int reportID;
    private String crimeDetails;
    private String date;
    private String requestedPerson;
    private String status;

    public CrimeReports(int reportID, String crimeDetails, String date, String requestedPerson, String status) {
        this.reportID = reportID;
        this.crimeDetails = crimeDetails;
        this.date = date;
        this.requestedPerson = requestedPerson;
        this.status = status;
    }

    // Getters and setters
    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public String getCrimeDetails() {
        return crimeDetails;
    }

    public void setCrimeDetails(String crimeDetails) {
        this.crimeDetails = crimeDetails;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRequestedPerson() {
        return requestedPerson;
    }

    public void setRequestedPerson(String requestedPerson) {
        this.requestedPerson = requestedPerson;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Method to generate crime report
    public void generateCrimeReport() {
        System.out.println("Report ID: " + reportID);
        System.out.println("Crime Details: " + crimeDetails);
        System.out.println("Date: " + date);
        System.out.println("Requested Person: " + requestedPerson);
        System.out.println("Status: " + status);
    }
}