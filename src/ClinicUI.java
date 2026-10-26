import javax.swing.*;
import java.awt.*;

public class ClinicUI extends JFrame {

    private PatientService patientService;

    private int arrivalCounter = 0;

    private JTextArea queueArea;
    private JTextArea priorityArea;

    private JLabel queueCountLabel;
    private JLabel priorityCountLabel;

    private JLabel queueNextLabel;
    private JLabel priorityNextLabel;

    public ClinicUI() {

        patientService = new PatientService(100);

        setTitle("Smart Clinic Patient Service");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createUI();
    }

    private void createUI() {

        JPanel mainPanel =
                new JPanel(new BorderLayout(15, 15));

        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        20, 20, 20, 20
                )
        );

        // =========================
        // HEADER
        // =========================

        JPanel headerPanel =
                new JPanel(new BorderLayout());

        JLabel titleLabel =
                new JLabel(
                        "SMART CLINIC PATIENT SERVICE",
                        SwingConstants.CENTER
                );

        titleLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        26
                )
        );

        JLabel subtitleLabel =
                new JLabel(
                        "Queue and Priority Queue Comparison System",
                        SwingConstants.CENTER
                );

        subtitleLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        headerPanel.add(
                titleLabel,
                BorderLayout.NORTH
        );

        headerPanel.add(
                subtitleLabel,
                BorderLayout.SOUTH
        );

        mainPanel.add(
                headerPanel,
                BorderLayout.NORTH
        );

        // =========================
        // CENTER
        // =========================

        JPanel centerPanel =
                new JPanel(
                        new GridLayout(
                                1,
                                2,
                                15,
                                0
                        )
                );

        // =========================
        // NORMAL QUEUE
        // =========================

        JPanel queuePanel =
                new JPanel(new BorderLayout(8, 8));

        queuePanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder(
                                "NORMAL QUEUE — FIFO"
                        ),
                        BorderFactory.createEmptyBorder(
                                10, 10, 10, 10
                        )
                )
        );

        queueCountLabel =
                new JLabel("Waiting: 0");

        queueCountLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        queueNextLabel =
                new JLabel("Next: None");

        queueNextLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        13
                )
        );

        JPanel queueInfoPanel =
                new JPanel(
                        new GridLayout(
                                2,
                                1
                        )
                );

        queueInfoPanel.add(
                queueCountLabel
        );

        queueInfoPanel.add(
                queueNextLabel
        );

        queueArea =
                new JTextArea();

        queueArea.setEditable(false);

        queueArea.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        13
                )
        );

        queueArea.setLineWrap(false);

        queuePanel.add(
                queueInfoPanel,
                BorderLayout.NORTH
        );

        queuePanel.add(
                new JScrollPane(queueArea),
                BorderLayout.CENTER
        );

        // =========================
        // PRIORITY QUEUE
        // =========================

        JPanel priorityPanel =
                new JPanel(new BorderLayout(8, 8));

        priorityPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder(
                                "PRIORITY QUEUE"
                        ),
                        BorderFactory.createEmptyBorder(
                                10, 10, 10, 10
                        )
                )
        );

        priorityCountLabel =
                new JLabel("Waiting: 0");

        priorityCountLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        priorityNextLabel =
                new JLabel("Next: None");

        priorityNextLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        13
                )
        );

        JPanel priorityInfoPanel =
                new JPanel(
                        new GridLayout(
                                2,
                                1
                        )
                );

        priorityInfoPanel.add(
                priorityCountLabel
        );

        priorityInfoPanel.add(
                priorityNextLabel
        );

        priorityArea =
                new JTextArea();

        priorityArea.setEditable(false);

        priorityArea.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        13
                )
        );

        priorityArea.setLineWrap(false);

        priorityPanel.add(
                priorityInfoPanel,
                BorderLayout.NORTH
        );

        priorityPanel.add(
                new JScrollPane(priorityArea),
                BorderLayout.CENTER
        );

        centerPanel.add(queuePanel);
        centerPanel.add(priorityPanel);

        mainPanel.add(
                centerPanel,
                BorderLayout.CENTER
        );

        // =========================
        // BUTTONS
        // =========================

        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                10,
                                5
                        )
                );

        JButton addPatientButton =
                new JButton("Add Patient");

        JButton serveQueueButton =
                new JButton("Serve Queue");

        JButton servePriorityButton =
                new JButton("Serve Priority");

        JButton comparisonButton =
                new JButton("Compare");

        addPatientButton.addActionListener(
                e -> showAddPatientDialog()
        );

        serveQueueButton.addActionListener(
                e -> serveFromQueue()
        );

        servePriorityButton.addActionListener(
                e -> serveFromPriorityQueue()
        );

        comparisonButton.addActionListener(
                e -> showControlledComparison()
        );

        buttonPanel.add(
                addPatientButton
        );

        buttonPanel.add(
                serveQueueButton
        );

        buttonPanel.add(
                servePriorityButton
        );

        buttonPanel.add(
                comparisonButton
        );

        mainPanel.add(
                buttonPanel,
                BorderLayout.SOUTH
        );

        setContentPane(mainPanel);

        refreshPatientLists();
    }

    // =========================
    // ADD PATIENT
    // =========================

    private void showAddPatientDialog() {

        JTextField idField =
                new JTextField();

        JTextField nameField =
                new JTextField();

        JTextField ageField =
                new JTextField();

        String[] priorities = {
                "High",
                "Medium",
                "Low"
        };

        JComboBox<String> priorityBox =
                new JComboBox<>(priorities);

        JPanel panel =
                new JPanel(
                        new GridLayout(
                                4,
                                2,
                                8,
                                8
                        )
                );

        panel.add(
                new JLabel("Patient ID:")
        );

        panel.add(idField);

        panel.add(
                new JLabel("Name:")
        );

        panel.add(nameField);

        panel.add(
                new JLabel("Age:")
        );

        panel.add(ageField);

        panel.add(
                new JLabel("Priority:")
        );

        panel.add(priorityBox);

        int result =
                JOptionPane.showConfirmDialog(
                        this,
                        panel,
                        "Add Patient",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE
                );

        if (result != JOptionPane.OK_OPTION) {
            return;
        }

        String patientId =
                idField.getText().trim();

        String name =
                nameField.getText().trim();

        String ageText =
                ageField.getText().trim();

        if (patientId.isEmpty() ||
                name.isEmpty() ||
                ageText.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please complete all fields.",
                    "Missing Information",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        try {

            int age =
                    Integer.parseInt(ageText);

            if (age <= 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Age must be greater than zero.",
                        "Invalid Age",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            int priority =
                    priorityBox.getSelectedIndex() + 1;

            arrivalCounter++;

            Patient patient =
                    new Patient(
                            patientId,
                            name,
                            age,
                            priority,
                            arrivalCounter
                    );

            patientService.addToQueue(
                    patient
            );

            patientService.addToPriorityQueue(
                    patient
            );

            patientService.addPatientRecord(
                    patient
            );

            refreshPatientLists();

            JOptionPane.showMessageDialog(
                    this,
                    "Patient added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid numeric age.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =========================
    // SERVE NORMAL QUEUE
    // =========================

    private void serveFromQueue() {

        if (patientService.isQueueEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "There are no patients in the normal queue.",
                    "Queue Empty",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        Patient patient =
                patientService.serveFromQueue();

        refreshPatientLists();

        JOptionPane.showMessageDialog(
                this,
                "Now serving:\n\n" + patient,
                "Patient Served",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // =========================
    // SERVE PRIORITY QUEUE
    // =========================

    private void serveFromPriorityQueue() {

        if (patientService.isPriorityQueueEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "There are no patients in the priority queue.",
                    "Priority Queue Empty",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        Patient patient =
                patientService.serveFromPriorityQueue();

        refreshPatientLists();

        JOptionPane.showMessageDialog(
                this,
                "Now serving:\n\n" + patient,
                "Patient Served",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // =========================
    // REFRESH LISTS
    // =========================

    private void refreshPatientLists() {

        queueArea.setText(
                patientService.getQueuePatients()
        );

        priorityArea.setText(
                patientService.getPriorityQueuePatients()
        );

        Patient queueNext =
                patientService.viewNextQueuePatient();

        Patient priorityNext =
                patientService.viewNextPriorityPatient();

        if (queueNext == null) {

            queueNextLabel.setText(
                    "Next: None"
            );

        } else {

            queueNextLabel.setText(
                    "Next: " + queueNext
            );
        }

        if (priorityNext == null) {

            priorityNextLabel.setText(
                    "Next: None"
            );

        } else {

            priorityNextLabel.setText(
                    "Next: " + priorityNext
            );
        }

        queueCountLabel.setText(
                "Waiting: " +
                        countPatients(
                                patientService.getQueuePatients()
                        )
        );

        priorityCountLabel.setText(
                "Waiting: " +
                        countPatients(
                                patientService.getPriorityQueuePatients()
                        )
        );
    }

    // =========================
    // COUNT DISPLAYED PATIENTS
    // =========================

    private int countPatients(String text) {

        if (text == null ||
                text.equals("No patients waiting.")) {

            return 0;
        }

        if (text.trim().isEmpty()) {
            return 0;
        }

        return text.trim().split("\\n").length;
    }

    // =========================
    // CONTROLLED COMPARISON
    // =========================

    private void showControlledComparison() {

        Patient[] patients =
                patientService.getPatientRecords();

        if (patients.length == 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "There are no patients to compare.\n\n" +
                            "Please add at least one patient first.",
                    "No Patients",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        ComparisonTest comparisonTest =
                new ComparisonTest();

        ComparisonResult result =
                comparisonTest.runTest(patients);

        StringBuilder display =
                new StringBuilder();

        display.append("====================================\n");
        display.append("       CONTROLLED COMPARISON\n");
        display.append("====================================\n\n");

        display.append("DATASET USED\n");
        display.append("------------------------------------\n");

        for (Patient patient : patients) {

            display.append(patient)
                    .append("\n");
        }

        display.append("\nQUEUE SERVICE ORDER\n");
        display.append("------------------------------------\n");
        display.append(result.getQueueOrder());

        display.append("\nPRIORITY QUEUE SERVICE ORDER\n");
        display.append("------------------------------------\n");
        display.append(result.getPriorityQueueOrder());

        display.append("\nOPERATION COUNT\n");
        display.append("------------------------------------\n");

        display.append("Queue Operations: ")
                .append(result.getQueueOperations())
                .append("\n");

        display.append("Priority Queue Operations: ")
                .append(result.getPriorityQueueOperations())
                .append("\n");

        display.append("\nTIME COMPLEXITY\n");
        display.append("------------------------------------\n");

        display.append("Queue Enqueue: O(1)\n");
        display.append("Queue Dequeue: O(1)\n");
        display.append("Queue Peek: O(1)\n");

        display.append("\n");

        display.append("Priority Queue Insert: O(n)\n");
        display.append("Priority Queue Remove: O(1)\n");
        display.append("Priority Queue Peek: O(1)\n");

        JTextArea comparisonArea =
                new JTextArea(
                        display.toString()
                );

        comparisonArea.setEditable(false);

        comparisonArea.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        13
                )
        );

        JScrollPane scrollPane =
                new JScrollPane(comparisonArea);

        scrollPane.setPreferredSize(
                new Dimension(700, 500)
        );

        JOptionPane.showMessageDialog(
                this,
                scrollPane,
                "Controlled Comparison",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}