public class ComparisonResult {

    private int queueOperations;
    private int priorityQueueOperations;

    private String queueOrder;
    private String priorityQueueOrder;

    public ComparisonResult(
            int queueOperations,
            int priorityQueueOperations,
            String queueOrder,
            String priorityQueueOrder
    ) {

        this.queueOperations = queueOperations;
        this.priorityQueueOperations =
                priorityQueueOperations;

        this.queueOrder = queueOrder;
        this.priorityQueueOrder =
                priorityQueueOrder;
    }

    public int getQueueOperations() {
        return queueOperations;
    }

    public int getPriorityQueueOperations() {
        return priorityQueueOperations;
    }

    public String getQueueOrder() {
        return queueOrder;
    }

    public String getPriorityQueueOrder() {
        return priorityQueueOrder;
    }
}