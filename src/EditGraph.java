import javax.swing.*;
import java.awt.event.ActionEvent;

import guru.nidi.graphviz.attribute.Color;
import guru.nidi.graphviz.attribute.Style;
import guru.nidi.graphviz.attribute.Rank.RankDir;

public class EditGraph extends JDialog {
    private JPanel JPanel;
    private JPanel P_GraphFile;
    private JComboBox CB_Dir;
    private JComboBox CB_Font;
    private JLabel L1;
    private JLabel L2;
    private JPanel P_AddLinks;
    private JTextField TF_Add_N1;
    private JTextField TF_Add_N2;
    private JComboBox CB_Add_N1_Color;
    private JComboBox CB_Add_N2_Color;
    private JComboBox CB_Add_A_Color;
    private JComboBox CB_Add_A_Style;
    private JButton B_Set;
    private JButton B_Add;
    private JTabbedPane tabbedPane1;
    private JPanel P_EditLinks;
    private JTextField TF_Edit_N1;
    private JTextField TF_Edit_N2;
    private JComboBox CB_Edit_N1_Color;
    private JComboBox CB_Edit_N2_Color;
    private JComboBox CB_Edit_A_Style;
    private JComboBox CB_Edit_A_Color;
    private JButton B_Edit;
    private JPanel P_RemoveLinks;
    private JTextField TF_Remove_N1;
    private JTextField TF_Remove_N2;
    private JButton B_Remove;
    private Graph[] graph;

    private boolean isEdit = false;

    public EditGraph(Graph[] graph) {
        this.graph = graph;
        init();
        initCB();
        B_Set.addActionListener(this::editGraph);
        B_Add.addActionListener(this::Add);
        B_Edit.addActionListener(this::Edit);
        B_Remove.addActionListener(this::RemoveLink);
    }

    private void init() {
        setContentPane(JPanel);
        this.setBounds(700,300,600,500);
        setModal(true);
    }

    private void initCB() {
        CB_Dir.addItem("LEFT_TO_RIGHT");
        CB_Dir.addItem("RIGHT_TO_LEFT");
        CB_Dir.addItem("TOP_TO_BOTTOM");
        CB_Dir.addItem("BOTTOM_TO_TOP");

        CB_Font.addItem("Arial");
        CB_Font.addItem("Times New Roman");

        CB_Add_A_Style.addItem("solid");
        CB_Add_A_Style.addItem("dotted");
        CB_Add_A_Style.addItem("dashed");

        JComboBox[] Add_CB_Colors = {CB_Add_N1_Color, CB_Add_N2_Color, CB_Add_A_Color};
        for (JComboBox CB_Color : Add_CB_Colors) {
            CB_Color.addItem("black");
            CB_Color.addItem("blue");
            CB_Color.addItem("green");
            CB_Color.addItem("yellow");
            CB_Color.addItem("orange");
            CB_Color.addItem("red");
            CB_Color.addItem("purple");
        }
        CB_Edit_A_Style.addItem("solid");
        CB_Edit_A_Style.addItem("dotted");
        CB_Edit_A_Style.addItem("dashed");

        JComboBox[] Edit_CB_Colors = {CB_Edit_N1_Color, CB_Edit_N2_Color, CB_Edit_A_Color};
        for (JComboBox CB_Color : Edit_CB_Colors) {
            CB_Color.addItem("black");
            CB_Color.addItem("blue");
            CB_Color.addItem("green");
            CB_Color.addItem("yellow");
            CB_Color.addItem("orange");
            CB_Color.addItem("red");
            CB_Color.addItem("purple");
        }
    }

    private void editGraph(ActionEvent actionEvent) {
        RankDir dir = RankDir.valueOf(CB_Dir.getSelectedItem().toString());
        String font = CB_Font.getSelectedItem().toString();
        graph[0].setAttributes(dir, font);
    }

    private void Add(ActionEvent actionEvent) {
        isEdit = false;
        Link();
    }

    private void Edit(ActionEvent actionEvent) {
        isEdit = true;
        Link();
    }

    private void Link() {
        String n1 = TF_Add_N1.getText();
        String n2 = TF_Add_N2.getText();
        Color n1Color = Color.named(CB_Add_N1_Color.getSelectedItem().toString().toUpperCase());
        Color n2Color = Color.named(CB_Add_N2_Color.getSelectedItem().toString().toUpperCase());
        Style aStyle = getStyle(CB_Add_A_Style.getSelectedItem().toString());
        Color aColor = Color.named(CB_Add_A_Color.getSelectedItem().toString().toUpperCase());
        if (isEdit) {
            graph[0].editLink(new Cls_Link(n1, n2, n1Color, n2Color, aStyle, aColor));
        } else {
            graph[0].addLink(new Cls_Link(n1, n2, n1Color, n2Color, aStyle, aColor));
        }
    }

    private void RemoveLink(ActionEvent actionEvent) {
        String n1 = TF_Remove_N1.getText();
        String n2 = TF_Remove_N2.getText();
        graph[0].removeLink(new Cls_Link(n1, n2));
    }

    private Style getStyle(String style) {
        switch (style) {
            case "solid":
                return Style.SOLID;
            case "dashed":
                return Style.DASHED;
            case "dotted":
                return Style.DOTTED;
            default:
                return Style.SOLID;
        }
    }
}