import guru.nidi.graphviz.attribute.Color;
import guru.nidi.graphviz.attribute.Style;

public class Cls_Link {
    String node1;
    String node2;
    Color node1Color;
    Color node2Color;
    Style arrowStyle;
    Color arrowColor;

    public Cls_Link(String n1, String n2) {
        this.node1 = n1;
        this.node2 = n2;
        this.node1Color = Color.BLACK;
        this.node2Color = Color.BLACK;
        this.arrowStyle = Style.SOLID;
        this.arrowColor = Color.BLACK;
    }

    public Cls_Link(String n1, String n2, Color n1c, Color n2c, Style as, Color ac) {
        this.node1 = n1;
        this.node2 = n2;
        this.node1Color = n1c;
        this.node2Color = n2c;
        this.arrowStyle = as;
        this.arrowColor = ac;
    }

    public String getNode1() { return node1; }
    public String getNode2() { return node2; }
    public Color getNode1Color() { return node1Color; }
    public Color getNode2Color() { return node2Color; }
    public Style getArrowStyle() { return arrowStyle; }
    public Color getArrowColor() { return arrowColor; }

    public void setNode1(String n1) { this.node1 = n1; }
    public void setNode2(String n2) { this.node2 = n2; }
    public void setNode1Color(Color n1c) { this.node1Color = n1c; }
    public void setNode2Color(Color n2c) { this.node2Color = n2c; }
    public void setArrowStyle(Style as) { this.arrowStyle = as; }
    public void setArrowColor(Color ac) { this.arrowColor = ac; }

}
