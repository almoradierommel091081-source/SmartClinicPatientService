public class PatientQueue {

    private Node front;
    private Node rear;
    private int operationCount = 0;

    private class Node {
        Patient patient;
        Node next;

        Node(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    // Add a patient to the rear
    public void enqueue(Patient patient) {

        operationCount++;

        Node newNode = new Node(patient);

        if (rear == null) {
            operationCount++;

            front = newNode;
            rear = newNode;

        } else {
            operationCount++;

            rear.next = newNode;
            rear = newNode;
        }
    }

    // Remove and return the patient at the front
    public Patient dequeue() {

        operationCount++;

        if (front == null) {
            operationCount++;
            return null;
        }

        Patient patient = front.patient;

        operationCount++;
        front = front.next;

        if (front == null) {
            operationCount++;
            rear = null;
        }

        return patient;
    }

    // View the patient at the front
    public Patient peek() {

        operationCount++;

        if (front == null) {
            operationCount++;
            return null;
        }

        return front.patient;
    }

    // Check if the queue is empty
    public boolean isEmpty() {

        operationCount++;

        return front == null;
    }

    // Get the total number of counted operations
    public int getOperationCount() {
        return operationCount;
    }
    public String getPatients() {

        if (front == null) {
            return "No patients waiting.";
        }

        StringBuilder result = new StringBuilder();

        Node current = front;

        while (current != null) {

            result.append(current.patient)
                    .append("\n");

            current = current.next;
        }

        return result.toString();
    }
}