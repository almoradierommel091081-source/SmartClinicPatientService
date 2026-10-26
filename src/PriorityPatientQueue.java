public class PriorityPatientQueue {

    private Patient[] patients;
    private int size;
    private int front;
    private int operationCount = 0;

    public PriorityPatientQueue(int capacity) {

        patients = new Patient[capacity];
        size = 0;
        front = 0;
    }

    // Add patient according to priority
    public void insert(Patient patient) {

        operationCount++;

        if (size == patients.length) {

            operationCount++;

            System.out.println(
                    "Priority queue is full."
            );

            return;
        }

        // If the queue is empty
        if (size == 0) {

            patients[0] = patient;

            front = 0;
            size++;

            operationCount++;

            return;
        }

        /*
         * If there is not enough space at the rear,
         * move the existing patients back to index 0.
         *
         * This prevents the array index from going
         * outside its capacity after repeated removals.
         */
        if (front + size >= patients.length) {

            operationCount++;

            for (int i = 0; i < size; i++) {

                patients[i] =
                        patients[front + i];

                operationCount++;
            }

            // Clear old positions
            for (int i = size; i < front + size; i++) {

                patients[i] = null;

                operationCount++;
            }

            front = 0;

            operationCount++;
        }

        int position =
                front + size;

        operationCount++;

        /*
         * Shift lower-priority patients
         * toward the rear.
         *
         * The '>' keeps equal-priority patients
         * in their original arrival order.
         */
        while (
                position > front &&
                        patients[position - 1]
                                .getPriority()
                                > patient.getPriority()
        ) {

            patients[position] =
                    patients[position - 1];

            position--;

            operationCount++;
        }

        patients[position] = patient;

        size++;

        operationCount++;
    }

    // Remove the highest-priority patient
    public Patient remove() {

        operationCount++;

        if (size == 0) {

            operationCount++;

            return null;
        }

        Patient patient =
                patients[front];

        patients[front] = null;

        front++;
        size--;

        operationCount++;

        // Reset when empty
        if (size == 0) {

            front = 0;

            operationCount++;
        }

        return patient;
    }

    // View the next patient
    public Patient peek() {

        operationCount++;

        if (size == 0) {

            operationCount++;

            return null;
        }

        return patients[front];
    }

    // Check if empty
    public boolean isEmpty() {

        operationCount++;

        return size == 0;
    }

    // Get number of patients
    public int size() {

        return size;
    }

    // Get total counted operations
    public int getOperationCount() {

        return operationCount;
    }

    // Display patients
    public String getPatients() {

        if (size == 0) {

            return "No patients waiting.";
        }

        StringBuilder result =
                new StringBuilder();

        for (
                int i = front;
                i < front + size;
                i++
        ) {

            result.append(patients[i])
                    .append("\n");
        }

        return result.toString();
    }
}