import javax.swing.*;

public class FileGraph extends JDialog {
    private JTabbedPane JTabbedPane1;
    private JPanel JPanel;
    private JPanel P_NewGraph;
    private JPanel P_SaveGraph;
    private JPanel P_LoadGraph;
    private JButton B_Create;
    private JButton B_Save;
    private JTextField textField2;
    private JTextField textField3;
    private JButton explorerButton;
    private JButton B_Load;
    private JTextField textField5;
    private JButton explorerButton1;
    private JButton B_Export;
    private JTextField textField6;
    private JTextField textField7;
    private JButton explorerButton2;
    private JPanel P_ExportGraph;
    Graph[] graph;

    public FileGraph(Graph[] graph) {
        this.graph = graph;
        init();
    }

    private void init() {
        setContentPane(JPanel);
        this.setBounds(100,100,800,600);
        setModal(true);
        pack();
    }
}
