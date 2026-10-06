import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CRMSApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n====== Crime Record Management System ======");
            System.out.println("1. Manage Criminal Persons");
            System.out.println("2. Manage Crime Incidents");
            System.out.println("3. View Crime Categories and Reports");
            System.out.println("4. Manage Court Cases");
            System.out.println("5. Manage Investigators and Suspects");
            System.out.println("6. Exit");
            System.out.println("============================================");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                // 1. Criminal Person Management
                case 1:

                    List<CriminalPerson> personList =
                            new ArrayList<>();

                    CriminalPerson person1 = new CriminalPerson(
                            "123456789",
                            "Sample Person",
                            new Date(),
                            "Colombo Road",
                            3325,
                            "Male"
                    );

                    while (true) {

                        System.out.println(
                                "\n--- Criminal Person Management ---"
                        );
                        System.out.println("1. Add Crime Records");
                        System.out.println("2. Add Person to List");
                        System.out.println(
                                "3. Search Person by National ID"
                        );
                        System.out.println(
                                "4. View Witness and Evidence Details"
                        );
                        System.out.println("5. Exit");
                        System.out.print("Enter your choice: ");

                        int personChoice = scanner.nextInt();

                        switch (personChoice) {

                            case 1:
                                person1.addCrimeRecord(
                                        "Theft",
                                        new Date()
                                );

                                person1.addCrimeRecord(
                                        "Assault",
                                        new Date()
                                );

                                System.out.println(
                                        "Crime records added successfully."
                                );
                                break;

                            case 2:
                                if (!personList.contains(person1)) {
                                    personList.add(person1);
                                    System.out.println(
                                            "Person added successfully."
                                    );
                                } else {
                                    System.out.println(
                                            "Person is already in the list."
                                    );
                                }
                                break;

                            case 3:

                                CriminalPerson foundPerson =
                                        CriminalPerson.searchPerson(
                                                personList,
                                                "123456789"
                                        );

                                if (foundPerson != null) {
                                    foundPerson.finalRecord();
                                } else {
                                    System.out.println(
                                            "Person not found."
                                    );
                                }

                                break;

                            case 4:

                                PoliceOfficer officer =
                                        new PoliceOfficer();

                                Witness witness =
                                        new Witness();

                                Evidence evidence =
                                        new Evidence();

                                WitnessesEvidence witnessesEvidence =
                                        new WitnessesEvidence(
                                                "0001",
                                                "Description",
                                                officer,
                                                "Central Park",
                                                witness,
                                                evidence
                                        );

                                witnessesEvidence.viewWitnessEvidence();

                                witnessesEvidence.updateWitnessEvidence(
                                        "Updated Description",
                                        "Kandy Park"
                                );

                                witnessesEvidence.viewWitnessEvidence();

                                String filePath = "Description.txt";

                                try (FileWriter writer =
                                             new FileWriter(filePath)) {

                                    writer.write(
                                            "This is a criminal description example."
                                    );

                                } catch (IOException e) {

                                    System.out.println(
                                            "Error writing to file: "
                                                    + e.getMessage()
                                    );
                                }

                                try (BufferedReader reader =
                                             new BufferedReader(
                                                     new FileReader(filePath)
                                             )) {

                                    String line;

                                    while ((line = reader.readLine()) != null) {
                                        System.out.println(line);
                                    }

                                } catch (IOException e) {

                                    System.out.println(
                                            "Error reading file: "
                                                    + e.getMessage()
                                    );
                                }

                                break;

                            case 5:
                                System.out.println(
                                        "Exiting Criminal Person Management..."
                                );
                                break;

                            default:
                                System.out.println(
                                        "Invalid choice. Please try again."
                                );
                        }

                        if (personChoice == 5) {
                            break;
                        }
                    }

                    break;

                // 2. Crime Incident Management
                case 2:

                    CrimeDepartment policeStation01 =
                            new CrimeDepartment(
                                    "Main Branch",
                                    1,
                                    112453678,
                                    Arrays.asList(
                                            "Officer1",
                                            "Officer2"
                                    )
                            );

                    CrimeRecord crimeRecord =
                            new CrimeRecord();

                    crimeRecord.setCaseNumber("#CR001");
                    crimeRecord.setDate(new Date());
                    crimeRecord.setLocation("Park Avenue");
                    crimeRecord.setDescription("Burglary");
                    crimeRecord.setStatus("Pending");

                    while (true) {

                        System.out.println(
                                "\n--- Crime Incident Management ---"
                        );
                        System.out.println("1. Register Crime");
                        System.out.println("2. Assign Officers");
                        System.out.println("3. Track Case Progress");
                        System.out.println("4. Generate Report");
                        System.out.println("5. Search Case");
                        System.out.println("6. Exit");
                        System.out.print("Enter your choice: ");

                        int crimeChoice = scanner.nextInt();

                        switch (crimeChoice) {

                            case 1:

                                policeStation01.registerCrime(
                                        crimeRecord
                                );

                                break;

                            case 2:

                                List<String> assignedOfficers =
                                        Arrays.asList(
                                                "Officer3",
                                                "Officer4"
                                        );

                                policeStation01.assignOfficers(
                                        crimeRecord,
                                        assignedOfficers
                                );

                                break;

                            case 3:

                                policeStation01.trackCaseProgress(
                                        crimeRecord
                                );

                                break;

                            case 4:

                                policeStation01.generateReports(
                                        crimeRecord
                                );

                                break;

                            case 5:

                                CrimeRecord foundCrime =
                                        policeStation01.searchCase(
                                                "#CR001"
                                        );

                                if (foundCrime != null) {

                                    System.out.println(
                                            "\nFound Crime Record:"
                                    );

                                    System.out.println(
                                            "Case Number: "
                                                    + foundCrime.getCaseNumber()
                                    );

                                    System.out.println(
                                            "Date: "
                                                    + foundCrime.getDate()
                                    );

                                    System.out.println(
                                            "Location: "
                                                    + foundCrime.getLocation()
                                    );

                                    System.out.println(
                                            "Description: "
                                                    + foundCrime.getDescription()
                                    );

                                    System.out.println(
                                            "Status: "
                                                    + foundCrime.getStatus()
                                    );
                                }

                                break;

                            case 6:

                                System.out.println(
                                        "Exiting Crime Incident Management..."
                                );

                                break;

                            default:

                                System.out.println(
                                        "Invalid choice. Please try again."
                                );
                        }

                        if (crimeChoice == 6) {
                            break;
                        }
                    }

                    break;

                // 3. Crime Categories and Reports
                case 3:

                    CrimeCategories theftCategory =
                            new CrimeCategories(
                                    1,
                                    "Theft",
                                    "This category includes crimes such as burglary, robbery, and shoplifting."
                            );

                    CrimeReports report1 =
                            new CrimeReports(
                                    1,
                                    "Stolen vehicle",
                                    "2024-02-11",
                                    "Sample Person",
                                    "Open"
                            );

                    while (true) {

                        System.out.println(
                                "\n--- Crime Category and Report Management ---"
                        );
                        System.out.println("1. View Category Details");
                        System.out.println("2. Generate Crime Report");
                        System.out.println("3. Exit");
                        System.out.print("Choose an option: ");

                        int reportChoice = scanner.nextInt();

                        switch (reportChoice) {

                            case 1:

                                theftCategory.viewCategoryDetails();

                                break;

                            case 2:

                                report1.generateCrimeReport();

                                break;

                            case 3:

                                System.out.println(
                                        "Exiting Crime Category and Report Management..."
                                );

                                break;

                            default:

                                System.out.println(
                                        "Invalid choice. Please try again."
                                );
                        }

                        if (reportChoice == 3) {
                            break;
                        }
                    }

                    break;

                // 4. Court Case Management
                case 4:

                    CourtCase courtCase =
                            new CourtCase(
                                    "123456",
                                    new Date(),
                                    "Sample Judge",
                                    "Sample Lawyer",
                                    "Initial Verdict"
                            );

                    while (true) {

                        System.out.println(
                                "\n--- Court Case Management ---"
                        );
                        System.out.println(
                                "1. Display Initial Case Details"
                        );
                        System.out.println(
                                "2. Update Case Details"
                        );
                        System.out.println(
                                "3. Display Updated Case Details"
                        );
                        System.out.println(
                                "4. Schedule a New Court Date"
                        );
                        System.out.println(
                                "5. Provide a New Verdict"
                        );
                        System.out.println(
                                "6. Display Final Case Details"
                        );
                        System.out.println("7. Exit");
                        System.out.print("Enter your choice: ");

                        int courtChoice = scanner.nextInt();

                        switch (courtChoice) {

                            case 1:

                                System.out.println(
                                        "\nInitial Case Details:"
                                );

                                System.out.println(
                                        courtCase.getCaseDetails()
                                );

                                break;

                            case 2:

                                courtCase.updateCaseDetails(
                                        "New Judge",
                                        "New Lawyer",
                                        "New Verdict"
                                );

                                System.out.println(
                                        "Case details updated successfully."
                                );

                                break;

                            case 3:

                                System.out.println(
                                        "\nUpdated Case Details:"
                                );

                                System.out.println(
                                        courtCase.getCaseDetails()
                                );

                                break;

                            case 4:

                                try {

                                    SimpleDateFormat dateFormat =
                                            new SimpleDateFormat(
                                                    "yyyy-MM-dd"
                                            );

                                    Date newCourtDate =
                                            dateFormat.parse(
                                                    "2024-03-15"
                                            );

                                    courtCase.scheduleNewCourtDate(
                                            newCourtDate
                                    );

                                    System.out.println(
                                            "\nCase Details After Scheduling:"
                                    );

                                    System.out.println(
                                            courtCase.getCaseDetails()
                                    );

                                } catch (ParseException e) {

                                    System.out.println(
                                            "Error parsing date: "
                                                    + e.getMessage()
                                    );
                                }

                                break;

                            case 5:

                                courtCase.provideVerdict(
                                        "Final Verdict"
                                );

                                System.out.println(
                                        "Verdict updated successfully."
                                );

                                break;

                            case 6:

                                System.out.println(
                                        "\nFinal Case Details:"
                                );

                                System.out.println(
                                        courtCase.getCaseDetails()
                                );

                                break;

                            case 7:

                                System.out.println(
                                        "Exiting Court Case Management..."
                                );

                                break;

                            default:

                                System.out.println(
                                        "Invalid choice. Please try again."
                                );
                        }

                        if (courtChoice == 7) {
                            break;
                        }
                    }

                    break;

                // 5. Investigator and Suspect Management
                case 5:

                    Investigator investigator =
                            new Investigator(
                                    "Sample Investigator",
                                    "Forensic Science",
                                    "Senior"
                            );

                    System.out.println(
                            "\n--- Investigation and Suspect Management ---"
                    );

                    String analysisResult =
                            investigator.analyseCrimeScene();

                    System.out.println(analysisResult);

                    investigator.submitReport(
                            "CASE123",
                            "This is the investigation report for CASE123."
                    );

                    investigator.updateNewCases("CASE456");

                    List<String> assignedOfficers =
                            new ArrayList<>();

                    assignedOfficers.add("Officer1");
                    assignedOfficers.add("Officer2");

                    investigator.assignCase(
                            "CASE789",
                            assignedOfficers
                    );

                    ConcreteSuspectManager suspectManager =
                            new ConcreteSuspectManager();

                    while (true) {

                        System.out.println(
                                "\n--- Suspect Management ---"
                        );
                        System.out.println("1. Add Suspects");
                        System.out.println("2. View Suspects");
                        System.out.println(
                                "3. Update Suspect Status"
                        );
                        System.out.println(
                                "4. Arrest a Suspect"
                        );
                        System.out.println(
                                "5. View Updated Suspect List"
                        );
                        System.out.println(
                                "6. Delete a Suspect"
                        );
                        System.out.println(
                                "7. View Final Suspect List"
                        );
                        System.out.println("8. Exit");
                        System.out.print("Enter your choice: ");

                        int suspectChoice = scanner.nextInt();

                        switch (suspectChoice) {

                            case 1:

                                suspectManager.addSuspect(
                                        "123456789",
                                        "Sample Person 1",
                                        "Description 1"
                                );

                                suspectManager.addSuspect(
                                        "987654321",
                                        "Sample Person 2",
                                        "Description 2"
                                );

                                System.out.println(
                                        "Suspects added successfully."
                                );

                                break;

                            case 2:

                                System.out.println(
                                        "\nCurrent List of Suspects:"
                                );

                                suspectManager.viewSuspects();

                                break;

                            case 3:

                                suspectManager.updateSuspectStatus(
                                        "123456789",
                                        "Updated Status"
                                );

                                System.out.println(
                                        "Suspect status updated successfully."
                                );

                                break;

                            case 4:

                                suspectManager.arrestSuspect(
                                        "987654321"
                                );

                                System.out.println(
                                        "Suspect 987654321 arrested."
                                );

                                break;

                            case 5:

                                System.out.println(
                                        "\nUpdated List of Suspects:"
                                );

                                suspectManager.viewSuspects();

                                break;

                            case 6:

                                suspectManager.deleteSuspects(
                                        "123456789"
                                );

                                System.out.println(
                                        "Suspect 123456789 deleted."
                                );

                                break;

                            case 7:

                                System.out.println(
                                        "\nFinal List of Suspects:"
                                );

                                suspectManager.viewSuspects();

                                break;

                            case 8:

                                System.out.println(
                                        "Exiting Suspect Management..."
                                );

                                break;

                            default:

                                System.out.println(
                                        "Invalid choice. Please try again."
                                );
                        }

                        if (suspectChoice == 8) {
                            break;
                        }
                    }

                    break;

                // 6. Exit
                case 6:

                    System.out.println(
                            "Thank you for using the Crime Record Management System."
                    );

                    scanner.close();
                    return;

                default:

                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }
        }
    }
}