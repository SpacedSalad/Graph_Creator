import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.*;

public class GUI extends JFrame{
    private JPanel panel1;
    private JTextField TF_Node1;
    private JPanel P_QuickAdd;
    private JTextField TF_Node2;
    private JButton B_AddLink;
    private JPanel P_Graph;
    private JLabel L1;
    private JLabel L2;
    private JPanel P_Image;
    private JButton B_Refresh;
    private final JMenuBar menuBar = new JMenuBar();
    private final JMenu Menu = new JMenu("Menu");
    private JMenuItem File = new JMenuItem("File");
    private JMenuItem Edit = new JMenuItem("Edit");
    private Graph[] graph = new Graph[1];
    private final FileGraph fileGraph = new FileGraph(graph);
    private final EditGraph editGraph = new EditGraph(graph);

    public GUI(){
        init();
        initMenu();
        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                displayGraphImage();
            }
        });
    }

    private void init() {
        setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(600,200,800,600);
        this.setVisible(true);
    }

    private void initMenu() {
        this.graph[0] = new Graph();
        this.setJMenuBar(menuBar);
        menuBar.add(Menu);
        Menu.add(File);
        Menu.add(Edit);

        File.addActionListener(this::openFileGraph);
        Edit.addActionListener(this::openEditGraph);

        B_AddLink.addActionListener(this::quickAdd);
        B_Refresh.addActionListener(this::displayGraphImage);

        fileGraph.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                displayGraphImage();
            }
        });
        editGraph.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                displayGraphImage();
            }
        });
    }

    private void openFileGraph(ActionEvent actionEvent) {
        this.fileGraph.setVisible(true);
    }

    private void openEditGraph(ActionEvent actionEvent) {
        this.editGraph.setVisible(true);
    }

    private void quickAdd(ActionEvent actionEvent) {
        String n1 = TF_Node1.getText();
        String n2 = TF_Node2.getText();

        graph[0].addLink(new Cls_Link(n1, n2));
        displayGraphImage();
    }

    private void displayGraphImage() {
        graph[0].updateGraph();
        ImageIcon graphImage = graph[0].getGraphImage();
        Graphics g = P_Image.getGraphics();
        g.clearRect(0, 0, P_Image.getWidth(), P_Image.getHeight());
        g.drawImage(graphImage.getImage(), 0, 0, null);
    }

    private void displayGraphImage(ActionEvent actionEvent) {
        graph[0].updateGraph();
        ImageIcon graphImage = graph[0].getGraphImage();
        Graphics g = P_Image.getGraphics();
        g.clearRect(0, 0, P_Image.getWidth(), P_Image.getHeight());
        g.drawImage(graphImage.getImage(), 0, 0, null);
    }
}
