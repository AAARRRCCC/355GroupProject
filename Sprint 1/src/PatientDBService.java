import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;

//change the multiple methods into one method that varies the string query depending on the menu instruction chosen
//pls ignore how bulky this is, it will be streamlined later
public class PatientDBService {

    public static List<PatientType> searchPatientName(String fName, String lname) throws SQLException {
        List<PatientType> patients = new ArrayList<>();
        String query = "select * from Patients WHERE fname=? AND lname=?";

        try (Connection connect = DatabaseConnection.getConnection();
        PreparedStatement stmt = connect.prepareStatement(query)) {
            stmt.setString(1, fName);
            stmt.setString(2, lname);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    PatientType patient = new PatientType();
                    patient.setMRN(rs.getString("patient_id"));
                    patient.setfname(rs.getString("first_name"));
                    patient.setlname(rs.getString("last_name"));

                    String[] parts = rs.getString("date_of_birth").split("-");
                    int year = Integer.parseInt(parts[0]);
                    patient.setBirthYear(year);
                    int month = Integer.parseInt(parts[1]);
                    patient.setBirthMonth(month);
                    int day = Integer.parseInt(parts[2]);
                    patient.setBirthDay(day);

                    patient.setGender(rs.getString("gender"));

                    parts = rs.getString("admission_date").split("-");
                    year = Integer.parseInt(parts[0]);
                    patient.setAdminYear(year);
                    month = Integer.parseInt(parts[1]);
                    patient.setAdminMonth(month);
                    day = Integer.parseInt(parts[2]);
                    patient.setAdminDay(day);

                    patient.setRoomNumber(rs.getString("room_number"));
                    patient.setPcpString(rs.getString("pcp"));
                    patient.setDiagnosis(rs.getString("diagnosis"));
                    patients.add(patient);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }



        public static List<PatientType> searchPatientByRoom(String roomNumber) throws SQLException{
        List<PatientType> patients = new ArrayList<>();
        String query = "SELECT * FROM Patients WHERE room_number = ?";

        try (Connection connect = DatabaseConnection.getConnection();
        PreparedStatement stmt = connect.prepareStatement(query)) {
            stmt.setString(1, roomNumber);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    PatientType patient = new PatientType();
                    patient.setMRN(rs.getString("patient_id"));
                    patient.setfname(rs.getString("first_name"));
                    patient.setlname(rs.getString("last_name"));

                    String[] parts = rs.getString("date_of_birth").split("-");
                    int year = Integer.parseInt(parts[0]);
                    patient.setBirthYear(year);
                    int month = Integer.parseInt(parts[1]);
                    patient.setBirthMonth(month);
                    int day = Integer.parseInt(parts[2]);
                    patient.setBirthDay(day);

                    patient.setGender(rs.getString("gender"));

                    parts = rs.getString("admission_date").split("-");
                    year = Integer.parseInt(parts[0]);
                    patient.setAdminYear(year);
                    month = Integer.parseInt(parts[1]);
                    patient.setAdminMonth(month);
                    day = Integer.parseInt(parts[2]);
                    patient.setAdminDay(day);

                    patient.setRoomNumber(rs.getString("room_number"));
                    patient.setPcpString(rs.getString("pcp"));
                    patient.setDiagnosis(rs.getString("diagnosis"));
                    patients.add(patient);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

     public static List<PatientType> searchPatientsByMRN(String mrn) throws SQLException {
        List<PatientType> patients = new ArrayList<>();
        String query = "SELECT * FROM Patients WHERE mrn = ?";

        try (Connection connect = DatabaseConnection.getConnection();
        PreparedStatement stmt = connect.prepareStatement(query)) {

            stmt.setString(1, mrn);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    PatientType patient = new PatientType();
                    patient.setMRN(rs.getString("patient_id"));
                    patient.setfname(rs.getString("first_name"));
                    patient.setlname(rs.getString("last_name"));

                    String[] parts = rs.getString("date_of_birth").split("-");
                    int year = Integer.parseInt(parts[0]);
                    patient.setBirthYear(year);
                    int month = Integer.parseInt(parts[1]);
                    patient.setBirthMonth(month);
                    int day = Integer.parseInt(parts[2]);
                    patient.setBirthDay(day);

                    patient.setGender(rs.getString("gender"));

                    parts = rs.getString("admission_date").split("-");
                    year = Integer.parseInt(parts[0]);
                    patient.setAdminYear(year);
                    month = Integer.parseInt(parts[1]);
                    patient.setAdminMonth(month);
                    day = Integer.parseInt(parts[2]);
                    patient.setAdminDay(day);

                    patient.setRoomNumber(rs.getString("room_number"));
                    patient.setPcpString(rs.getString("pcp"));
                    patient.setDiagnosis(rs.getString("diagnosis"));
                    patients.add(patient);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
     }


    public static List<PatientType> searchPatientByPCP(String pcp) throws SQLException {
        List<PatientType> patients = new ArrayList<>();
        String query = "SELECT * FROM Patients WHERE pcp = ?";

        try (Connection connect = DatabaseConnection.getConnection();
             PreparedStatement stmt = connect.prepareStatement(query)) {
            stmt.setString(1, pcp);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    PatientType patient = new PatientType();
                    patient.setMRN(rs.getString("patient_id"));
                    patient.setfname(rs.getString("first_name"));
                    patient.setlname(rs.getString("last_name"));

                    String[] parts = rs.getString("date_of_birth").split("-");
                    int year = Integer.parseInt(parts[0]);
                    patient.setBirthYear(year);
                    int month = Integer.parseInt(parts[1]);
                    patient.setBirthMonth(month);
                    int day = Integer.parseInt(parts[2]);
                    patient.setBirthDay(day);

                    patient.setGender(rs.getString("gender"));

                    parts = rs.getString("admission_date").split("-");
                    year = Integer.parseInt(parts[0]);
                    patient.setAdminYear(year);
                    month = Integer.parseInt(parts[1]);
                    patient.setAdminMonth(month);
                    day = Integer.parseInt(parts[2]);
                    patient.setAdminDay(day);

                    patient.setRoomNumber(rs.getString("room_number"));
                    patient.setPcpString(rs.getString("pcp"));
                    patient.setDiagnosis(rs.getString("diagnosis"));
                    patients.add(patient);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            }
        return patients;
    }

    public static List<PatientType> searchPatientByaddmissionDate(String addmissionDate) throws SQLException {
        List<PatientType> patients = new ArrayList<>();
        String query = "SELECT * FROM Patients WHERE addmission_date = ?";
        //pick up from here and modify all other search functions to incorporate lists to hold multiple returns
        try (Connection connect = DatabaseConnection.getConnection();
        PreparedStatement stmt = connect.prepareStatement(query)) {
            stmt.setString(1, addmissionDate);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    PatientType patient = new PatientType();
                    patient.setMRN(rs.getString("patient_id"));
                    patient.setfname(rs.getString("first_name"));
                    patient.setlname(rs.getString("last_name"));

                    String[] parts = rs.getString("date_of_birth").split("-");
                    int year = Integer.parseInt(parts[0]);
                    patient.setBirthYear(year);
                    int month = Integer.parseInt(parts[1]);
                    patient.setBirthMonth(month);
                    int day = Integer.parseInt(parts[2]);
                    patient.setBirthDay(day);

                    patient.setGender(rs.getString("gender"));

                    parts = rs.getString("admission_date").split("-");
                    year = Integer.parseInt(parts[0]);
                    patient.setAdminYear(year);
                    month = Integer.parseInt(parts[1]);
                    patient.setAdminMonth(month);
                    day = Integer.parseInt(parts[2]);
                    patient.setAdminDay(day);

                    patient.setRoomNumber(rs.getString("room_number"));
                    patient.setPcpString(rs.getString("pcp"));
                    patient.setDiagnosis(rs.getString("diagnosis"));
                    patients.add(patient);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

}
