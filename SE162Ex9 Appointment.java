public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String date;

    public Appointment(Patient patient, Doctor doctor, String date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    public void printAppointmentDetails() {
        System.out.println(patient.getDetails());
        System.out.println(doctor.getDetails());
        System.out.println("Date: " + date);
    }
}
