import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ClinicUI clinicUI = new ClinicUI();

            clinicUI.setVisible(true);
        });
    }
}