class PoliceOfficer {

    private String name;
    private int experience;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }
}


class Witness {
}


class Evidence {
}


class WitnessesEvidence extends PoliceOfficer {

    private String evidenceID;
    private String description;
    private PoliceOfficer collectedBy;
    private String location;
    private Witness witness;
    private Evidence associatedEvidence;

    public WitnessesEvidence(
            String evidenceID,
            String description,
            PoliceOfficer collectedBy,
            String location,
            Witness witness,
            Evidence associatedEvidence) {

        this.evidenceID = evidenceID;
        this.description = description;
        this.collectedBy = collectedBy;
        this.location = location;
        this.witness = witness;
        this.associatedEvidence = associatedEvidence;
    }

    public String getEvidenceID() {
        return evidenceID;
    }

    public Witness getWitness() {
        return witness;
    }

    public Evidence getEvidence() {
        return associatedEvidence;
    }

    public PoliceOfficer getCollectedBy() {
        return collectedBy;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public void updateWitnessEvidence(
            String newDescription,
            String newLocation) {

        this.description = newDescription;
        this.location = newLocation;
    }

    public void viewWitnessEvidence() {

        System.out.println("Witness Evidence Details:");
        System.out.println("Evidence ID: " + evidenceID);
        System.out.println("Description: " + description);
        System.out.println("Collected By: " +
                (collectedBy != null
                        ? collectedBy.getName()
                        : "Not specified"));
        System.out.println("Location: " + location);
    }
}