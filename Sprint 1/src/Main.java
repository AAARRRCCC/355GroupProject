import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

//main class
public class Main {

    //For GUI TEAM: ignore, this was for testing in the run tool
    //method to create main menu that other menus stem from
    public static void showmenu1() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            //Menu options between 1 and 4, and 9 to exit program
            //currently takes numerical keyboard input to select
            System.out.printf("-------------Main Menu---------------\n");
            System.out.printf("What search would you like? \n");
            System.out.printf("1. Basic search...\n");
            System.out.printf("2. Advanced search...\n");
            System.out.printf("3. Print all Patients...\n");
            System.out.printf("4. Call a doctor...\n");
            System.out.printf("9. Exit\n");

            //Takes next input for menu selection
            choice = scanner.nextLine();

            //sub menu for advanced search
            //VVV Need to change this if/else-if structure to a switch structure VVV
            if (choice.equalsIgnoreCase("1")) {
                System.out.printf("--------Basic Search-------------\n");
                System.out.printf("Enter patient first name...\n");
                String firstName = scanner.nextLine();
                System.out.printf("Enter patient last name...\n");
                String lastName = scanner.nextLine();
                //enter method for search algo
                basicPatientSearch(firstName, lastName);

                //If selected opens sub menu for advanced search
            } else if (choice.equalsIgnoreCase("2")) {
                showmenu2();
                //choice = "3";

                //If selection is 3, print entire list of patients
            }else if (choice.equalsIgnoreCase("3")) {
                //AddElements addElements = new AddElements();
                //addElements.execute();
                //Create a function that will print the top 10 patients, and give them the option to print the list of the next 10 patients


                //Gag function for calling doctor, may be replaced by something else later
            }else if (choice.equalsIgnoreCase("4")) {
                System.out.printf("Calling doctor on call");
                callingDr();
            }
        }while (!(choice.equals( "9")));

    }

    //GUI TEAM: ignore this too
    //method for advanced menu, called if choice 2 is selected
    public static void showmenu2() throws SQLException {
        //scanner for taking next keyboard numerical input for choice
        //be sure to add error exception in case of incorrect input
        Scanner scanner = new Scanner(System.in);
        String choice;

        //User may enter 1 - 4 for choice and 9 to go back to previous menu
        do {
            System.out.printf("--------Advanced Search-------------\n");
            System.out.printf("Search by... \n");
            System.out.printf("1. Room number \n");
            System.out.printf("2. Medical Record Number \n");
            System.out.printf("3. Admission Date \n");
            System.out.printf("4. Primary Care Provider \n");
            System.out.printf("9. Exit \n");
            choice = scanner.nextLine();

            //Choice for conducting seach by room number
            if (choice.equalsIgnoreCase("1")) {
                System.out.printf("Enter the room\n");
                String room = scanner.nextLine();

                //call to SQL database via room number goes here, takes one parameter VVV
                roomSearch(room);

            //Choice for conducting search by MRN (Medical Record Number)
            } else if (choice.equalsIgnoreCase("2")) {
                System.out.printf("Enter the MRN\n");
                String MRN = scanner.nextLine();

                //call to SQL database via MRN goes here, takes one parameter
                //mrnSearch(MRN);

            //Choice for conducting search by patient Admission date
            } else if (choice.equalsIgnoreCase("3")) {
                System.out.printf("Enter the Admission Date in day, month, year \n");
                int addDay = scanner.nextInt();
                int addMonth = scanner.nextInt();
                int addYear = scanner.nextInt();

                //call to SQL database via admission date goes here, will take 3 inputs
                //admissionDateSearch(int addDay, int addMonth, int addYear);

            //Choice for conducting search by patient's PCP (Primary Care Providor)
            } else if (choice.equalsIgnoreCase("4")) {
                System.out.printf("Enter the PCP\n");
                String PCP = scanner.nextLine();

                //call to SQL database via PCP object that can be indexed by first and/or last name
                //pcpSearch(PCP);
            }
        }while(!(choice.equals("9")));
    }

    //GUI TEAM: ignore this also
    //gag function pretending to call Dr
    public static void callingDr()
    {
        for (int i = 0; i < 3; i++)
        {
            try {
                Thread.sleep(900);
            } catch (InterruptedException e) {  System.err.println("Interrupted: " + e.getMessage());  }
            System.out.printf(".");
            if (i == 2)
                System.out.printf("\n");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {  System.err.println("Interrupted: " + e.getMessage());  }
        System.out.println("But no one answered...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {  System.err.println("Interrupted: " + e.getMessage());  }
        System.out.println("Good luck lol");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {  System.err.println("Interrupted: " + e.getMessage());  }
    }

    //GUI TEAM: These are the search functions, They take the specific patient search param, finds all matches
    // and then returns a String array of the first and last names of all matches VVVVVVVV
    // changed to now pass back patient id as well
    public static String[] basicPatientSearch(String fname, String lname) throws SQLException {

        List<PatientType> patients = PatientDBService.searchPatientName(fname, lname);
        String[] patientNames = new String[patients.size()];

        if (!patients.isEmpty()) {
            for (int i = 0; i < patients.size(); i++) {
                PatientType patient = patients.get(i);
                String fullname = patient.getPatientFName() + " " + patient.getPatientLName() + " " + patient.getMRN();
                patientNames[i] = fullname;
            }
        }
        return patientNames;
    }

    public static String[] roomSearch(String roomNum) throws SQLException {
        List<PatientType> patients = PatientDBService.searchPatientByRoom(roomNum);
        String[] patientNames = new String[patients.size()];

        if (!patients.isEmpty()) {
            for (int i = 0; i < patients.size(); i++) {
                PatientType patient = patients.get(i);
                String fullname = patient.getPatientFName() + " " + patient.getPatientLName() + " " + patient.getMRN();
                patientNames[i] = fullname;
            }
        }
        return patientNames;
    }

    public static String[] mrnSearch(String MRN) throws SQLException {
        //PatientType patients = PatientDBService.searchPatientByMRN(MRN);
        List<PatientType> patients = PatientDBService.searchPatientsByMRN(MRN);
        String[] patientNames = new String[patients.size()];

        if (!patients.isEmpty()) {
            for (int i = 0; i < patients.size(); i++) {
                PatientType patient = patients.get(i);
                String fullname = patient.getPatientFName() + " " + patient.getPatientLName() + " " + patient.getMRN();
                patientNames[i] = fullname;
            }
        }
        return patientNames;
    }

    public static String[] pcpSearch(String PCP) throws SQLException {
        List<PatientType> patients = PatientDBService.searchPatientByPCP(PCP);
        String[] patientNames = new String[patients.size()];
        if (!patients.isEmpty()){
            //System.out.printf("Patients found at %s\n", search);
            for (int i = 0; i < patients.size(); i++) {
                PatientType patient = patients.get(i);
                String fullname = patient.getPatientFName() + " " + patient.getPatientLName() + " " + patient.getMRN();
                patientNames[i] = fullname;
            }
        }
        return patientNames;
    }

    public static String[] admissionSearch(String search) throws SQLException {
        List<PatientType> patients = PatientDBService.searchPatientByaddmissionDate(search);
        String[] patientNames = new String[patients.size()];
        if (!patients.isEmpty()){
            //System.out.printf("Patients found at %s\n", search);
            for (int i = 0; i < patients.size(); i++) {
                PatientType patient = patients.get(i);
                String fullname = patient.getPatientFName() + " " + patient.getPatientLName() + " " + patient.getMRN();
                patientNames[i] = fullname;
            }
        }
        return patientNames;
    }
    //End of Search functions ^^^^^^^^^

    //FOR GUI TEAM: IMPORTANT VVVVVVVVVVVVVVVVVV
    //This is the function that returns one specific patients information
    //Call this when the user has selected the specific patient from the search results returned in the searchSelect() mehtod
    //listed below this one.
    public static String[] ptnSelected(String ptn) throws SQLException {
        String parts[] = ptn.split(" ",3);
        String mrn = parts[3];
        //PatientType patient = mrnSearch(mrn);
        List<PatientType> patients = PatientDBService.searchPatientsByMRN(mrn);
        PatientType newpatient = patients.get(0);
        String ptnInfo[] = new String[5];
        ptnInfo[0] = newpatient.getPatientLName() + " " + newpatient.getPatientFName();
        ptnInfo[1] = newpatient.getMRN();
        ptnInfo[2] = newpatient.getRoomNumber();
        ptnInfo[3] = newpatient.getPcpString();
        ptnInfo[4] = newpatient.getEvent();
        ptnInfo[5] = newpatient.getChart();
        return ptnInfo;
    }

    //FOR GUI TEAM: IMPORTANT VVVVVVVVVVVVVVVVVV
    //This is the method that allows the user to select which search type they want to use
    public static String[]  searchSelect(String searchType, String searchParam) throws SQLException {
        switch (searchType) {
            case "Last Name First Name":
                String parts[] = searchParam.split(" ", 2);
                String lastName = parts[0];
                String firstName = parts[1];
                return basicPatientSearch(firstName, lastName);
            case "Room Number":
                return roomSearch(searchParam);
            case "Medical Record Number":
                return mrnSearch(searchParam);
            case "Primary Care Provider ":
                return pcpSearch(searchParam);
            case "Admission Date": //Year - month - day
                return admissionSearch(searchParam);
            default:
                return null;
        }
    }

    //main function
    public static void main(String[] args) throws SQLException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        PatientType patient = new PatientType();
        showmenu1();
    }
}