import Controller.GameController;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameController controller = GameController.getInstance();
            // A tela de menu será iniciada automaticamente pelo GameController
        });
    }
}
