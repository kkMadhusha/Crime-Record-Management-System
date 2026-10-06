import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Abstract SuspectManager class
public abstract class SuspectManager {

    // Data structure to store suspects
    protected List<Suspect> suspects;

    // Constructor
    public SuspectManager() {
        suspects = new ArrayList<>();
    }

    // Inner class representing a Suspect
    public static class Suspect {
        private String nationalID;
        private String name;
        private String description;
        private String status;
        private boolean arrested;

        // Constructor
        public Suspect(String nationalID, String name, String description) {
            this.nationalID = nationalID;
            this.name = name;
            this.description = description;
            this.status = "Active";
            this.arrested = false;
        }

        // Getters
        public String getNationalID() {
            return nationalID;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String getStatus() {
            return status;
        }

        public boolean isArrested() {
            return arrested;
        }

        // Setters
        public void setArrested(boolean arrested) {
            this.arrested = arrested;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    // Abstract method to add a new suspect
    public abstract void addSuspect(String nationalID, String name, String description);

    // Marks the suspect as arrested
    public void arrestSuspect(String nationalID) {
        for (Suspect suspect : suspects) {
            if (suspect.getNationalID().equals(nationalID)) {
                suspect.setArrested(true);
                break;
            }
        }
    }

    // Update suspect status
    public void updateSuspectStatus(String nationalID, String status) {
        for (Suspect suspect : suspects) {
            if (suspect.getNationalID().equals(nationalID)) {
                suspect.setStatus(status);
                break;
            }
        }
    }

    // View suspects
    public void viewSuspects() {
        if (suspects.isEmpty()) {
            System.out.println("No suspects found.");
            return;
        }

        for (Suspect suspect : suspects) {
            System.out.println("National ID: " + suspect.getNationalID());
            System.out.println("Name: " + suspect.getName());
            System.out.println("Description: " + suspect.getDescription());
            System.out.println("Status: " + suspect.getStatus());
            System.out.println("Arrested: " +
                    (suspect.isArrested() ? "Yes" : "No"));
            System.out.println("-------------");
        }
    }

    // Delete a suspect
    public void deleteSuspects(String nationalID) {
        Iterator<Suspect> iterator = suspects.iterator();

        while (iterator.hasNext()) {
            Suspect suspect = iterator.next();

            if (suspect.getNationalID().equals(nationalID)) {
                iterator.remove();
                break;
            }
        }
    }
}

// Concrete implementation of SuspectManager
class ConcreteSuspectManager extends SuspectManager {

    @Override
    public void addSuspect(String nationalID, String name, String description) {
        Suspect newSuspect =
                new Suspect(nationalID, name, description);

        super.suspects.add(newSuspect);
    }
}