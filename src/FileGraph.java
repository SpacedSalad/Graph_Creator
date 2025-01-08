import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class FileGraph extends JDialog {
    private JTabbedPane JTabbedPane1;
    private JPanel JPanel;
    private JPanel P_LoadGraph;
    private JTextField TF_L_FilePath;
    private JButton B_L_Explorer;
    private JButton B_Load;
    private JPanel P_SaveGraph;
    private JTextField TF_S_FilePath;
    private JButton B_S_Explorer;
    private JButton B_Save;
    private JPanel P_ExportGraph;
    private JTextField TF_E_FilePath;
    private JButton B_E_Explorer;
    private JButton B_Export;
    private Graph[] graph;

    public FileGraph(Graph[] graph) {
        this.graph = graph;
        init();
        initB();
    }

    private void init() {
        setContentPane(JPanel);
        this.setBounds(700,300,600,500);
        setModal(true);
    }
    
    private void initB() {
        B_L_Explorer.addActionListener(this::OpenExplorerLoad);
        B_S_Explorer.addActionListener(this::OpenExplorerSave);
        B_E_Explorer.addActionListener(this::OpenExplorerExport);
        
        B_Load.addActionListener(this::LoadGraph);
        B_Save.addActionListener(this::SaveGraph);
        B_Export.addActionListener(this::ExportGraph);

        TF_L_FilePath.setText(new File("").getAbsolutePath());
        TF_S_FilePath.setText(new File("").getAbsolutePath());
        TF_E_FilePath.setText(new File("").getAbsolutePath());
    }

    private void OpenExplorerLoad(ActionEvent actionEvent) {
        File file = OpenDialog(TF_L_FilePath.getText());
        if (file != null) {
            TF_L_FilePath.setText(file.getAbsolutePath());
        }
    }
    
    private void OpenExplorerSave(ActionEvent actionEvent) {
        File file = SaveDialog(TF_S_FilePath.getText());
        if (file != null) {
            TF_S_FilePath.setText(file.getAbsolutePath());
        }
    }
    
    private void OpenExplorerExport(ActionEvent actionEvent) {
        File file = SaveDialog(TF_E_FilePath.getText());
        if (file != null) {
            TF_E_FilePath.setText(file.getAbsolutePath());
        }
    }
    
    private File OpenDialog(String path) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(path));
        File file = null;
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }
        return file;
    }
    
    private File SaveDialog(String path) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(path));
        File file = null;
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }
        return file;
    }
    
    private void LoadGraph(ActionEvent actionEvent) {
        File file = new File(TF_L_FilePath.getText());
            graph[0].loadGraph(file.getAbsolutePath());
    }
    
    private void SaveGraph(ActionEvent actionEvent) {
        File file = new File(TF_S_FilePath.getText());
        graph[0].saveGraph(file.getAbsolutePath());
    }
    
    private void ExportGraph(ActionEvent actionEvent) {
        File file = new File(TF_E_FilePath.getText());
        graph[0].exportGraph(file.getAbsolutePath());
    }
}
