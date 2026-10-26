public class Patient {

    private String patientId;
    private String name;
    private int age;
    private int priority;
    private int arrivalOrder;

    public Patient(String patientId, String name, int age, int priority, int arrivalOrder) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.priority = priority;
        this.arrivalOrder = arrivalOrder;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getPriority() {
        return priority;
    }

    public int getArrivalOrder() {
        return arrivalOrder;
    }

    @Override
    public String toString() {
        return patientId + " | "
                + name + " | Age: "
                + age + " | Priority: "
                + priority + " | Arrival: "
                + arrivalOrder;
    }
}