public class ComparisonTest {

    public ComparisonResult runTest(Patient[] patients) {

        PatientQueue queue =
                new PatientQueue();

        PriorityPatientQueue priorityQueue =
                new PriorityPatientQueue(
                        patients.length
                );

        // Use the exact same patients
        // for both data structures.
        for (Patient patient : patients) {

            queue.enqueue(patient);
            priorityQueue.insert(patient);
        }

        // Record Queue service order
        StringBuilder queueOrder =
                new StringBuilder();

        while (!queue.isEmpty()) {

            queueOrder
                    .append(queue.dequeue())
                    .append("\n");
        }

        // Record Priority Queue service order
        StringBuilder priorityQueueOrder =
                new StringBuilder();

        while (!priorityQueue.isEmpty()) {

            priorityQueueOrder
                    .append(priorityQueue.remove())
                    .append("\n");
        }

        return new ComparisonResult(
                queue.getOperationCount(),
                priorityQueue.getOperationCount(),
                queueOrder.toString(),
                priorityQueueOrder.toString()
        );
    }
}