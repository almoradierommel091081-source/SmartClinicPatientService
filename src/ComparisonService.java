public class ComparisonService {

    public String generateComparison(Patient[] patients) {

        PatientQueue queue = new PatientQueue();
        PriorityPatientQueue priorityQueue =
                new PriorityPatientQueue(patients.length);

        for (Patient patient : patients) {
            queue.enqueue(patient);
            priorityQueue.insert(patient);
        }

        StringBuilder result = new StringBuilder();

        result.append("====================================\n");
        result.append("       ALGORITHM COMPARISON\n");
        result.append("====================================\n\n");

        result.append("QUEUE (FIFO)\n");
        result.append("------------------------------------\n");

        while (!queue.isEmpty()) {
            result.append(queue.dequeue()).append("\n");
        }

        result.append("\nPRIORITY QUEUE\n");
        result.append("------------------------------------\n");

        while (!priorityQueue.isEmpty()) {
            result.append(priorityQueue.remove()).append("\n");
        }

        result.append("\n====================================\n");
        result.append("OPERATION COUNT\n");
        result.append("====================================\n");

        result.append("Queue Operations: ")
                .append(queue.getOperationCount())
                .append("\n");

        result.append("Priority Queue Operations: ")
                .append(priorityQueue.getOperationCount())
                .append("\n");

        result.append("\nTIME COMPLEXITY\n");
        result.append("------------------------------------\n");
        result.append("Queue Enqueue: O(1)\n");
        result.append("Queue Dequeue: O(1)\n");
        result.append("Priority Queue Insert: O(n)\n");
        result.append("Priority Queue Remove: O(1)\n");

        return result.toString();
    }
}