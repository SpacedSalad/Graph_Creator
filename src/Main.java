import java.io.IOException;
import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.File;

// one node link is of this type: [node1 {String}, node2 {String}, [attributes]]

public class Main {
    public static void main(String[] args) throws IOException {
        GUI gui = new GUI();
        gui.setVisible(true);

        /*
        Desktop desktop = null;
        // on Windows, retrieve the path of the "Program Files" folder
        File file = new File(System.getenv("programfiles"));

        try {
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
                desktop.open(file);
            } else {
                System.out.println("desktop is not supported");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }
}
