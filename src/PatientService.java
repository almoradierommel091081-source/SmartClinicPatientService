import java.util.ArrayList;

public class PatientService {

    private PatientQueue queue;
    private PriorityPatientQueue priorityQueue;

    private ArrayList<Patient> patientRecords;

    public PatientService(int capacity) {

        queue = new PatientQueue();

        priorityQueue =
                new PriorityPatientQueue(capacity);

        patientRecords =
                new ArrayList<>();
    }

    // Add a patient to the normal Queue
    public void addToQueue(Patient patient) {

        queue.enqueue(patient);
    }

    // Add a patient to the Priority Queue
    public void addToPriorityQueue(Patient patient) {

        priorityQueue.insert(patient);
    }

    // Store the patient in the master record
    public void addPatientRecord(Patient patient) {

        patientRecords.add(patient);
    }

    // Serve from normal Queue
    public Patient serveFromQueue() {

        return queue.dequeue();
    }

    // Serve from Priority Queue
    public Patient serveFromPriorityQueue() {

        return priorityQueue.remove();
    }

    // View next patient in Queue
    public Patient viewNextQueuePatient() {

        return queue.peek();
    }

    // View next patient in Priority Queue
    public Patient viewNextPriorityPatient() {

        return priorityQueue.peek();
    }

    // Check if Queue is empty
    public boolean isQueueEmpty() {

        return queue.isEmpty();
    }

    // Check if Priority Queue is empty
    public boolean isPriorityQueueEmpty() {

        return priorityQueue.isEmpty();
    }

    // Get Queue operation count
    public int getQueueOperations() {

        return queue.getOperationCount();
    }

    // Get Priority Queue operation count
    public int getPriorityQueueOperations() {

        return priorityQueue.getOperationCount();
    }

    // Get patients for display
    public String getQueuePatients() {

        return queue.getPatients();
    }

    public String getPriorityQueuePatients() {

        return priorityQueue.getPatients();
    }

    // Get all registered patients
    public Patient[] getPatientRecords() {

        return patientRecords.toArray(
                new Patient[0]
        );
    }
}