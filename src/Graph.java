import guru.nidi.graphviz.attribute.Font;
import guru.nidi.graphviz.attribute.Rank;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static guru.nidi.graphviz.attribute.Rank.RankDir.*;
import static guru.nidi.graphviz.model.Factory.*;

public class Graph {

    private ArrayList<Cls_Link> links;
    private Boolean directed;
    private Rank.RankDir dir;
    private String font;
    private guru.nidi.graphviz.model.MutableGraph g;
    private int HEIGHT = 400;
    private int WIDTH = 700;

    public Graph(){
        links = new ArrayList<>();
        this.directed = true;
        this.dir = LEFT_TO_RIGHT;
        this.font = "Arial";
        updateGraph();
    }

    public void updateGraph(){
        g = mutGraph("example1").setDirected(directed).use((gr, ctx) -> {
            gr.graphAttrs().add(Rank.dir(dir));
            gr.graphAttrs().add(Font.name(font));
            for (Cls_Link LINK : links) {
                nodeAttrs().add(LINK.getNode1Color());
                mutNode(LINK.getNode1()).add(LINK.getNode1Color());
                nodeAttrs().add(LINK.getNode2Color());
                mutNode(LINK.getNode2()).add(LINK.getNode2Color());
                linkAttrs().add(LINK.getArrowColor(), LINK.getArrowStyle());
                mutNode(LINK.getNode1()).addLink(LINK.getNode2());
            }
        });
    }

    public ImageIcon getGraphImage() {
        BufferedImage image;
        if (dir == TOP_TO_BOTTOM || dir == BOTTOM_TO_TOP) {
            image = Graphviz.fromGraph(g).height(HEIGHT).render(Format.PNG).toImage();
        } else {
            image = Graphviz.fromGraph(g).width(WIDTH).render(Format.PNG).toImage();
        }
        return new ImageIcon(image);
    }

    public void addLink(Cls_Link link) {
        boolean linkExists = false;
        for (Cls_Link LINK : links) {
            if (LINK.getNode1().equals(link.getNode1()) && LINK.getNode2().equals(link.getNode2())) {
                linkExists = true;
                break;
            }
        }
        if (!linkExists) {
            links.add(link);
        }
    }

    public void editLink(Cls_Link link) {
        boolean linkExists = false;
        for (Cls_Link LINK : links) {
            if (LINK.getNode1().equals(link.getNode1()) && LINK.getNode2().equals(link.getNode2())) {
                linkExists = true;
                break;
            }
        }
        System.out.println("Link exists: " + linkExists);
        if (!linkExists) {
            links.set(links.indexOf(link), link);
        }

    }

    public void removeLink(Cls_Link link) {
        for (Cls_Link LINK : links) {
            if (LINK.getNode1().equals(link.getNode1()) && LINK.getNode2().equals(link.getNode2())) {
                links.remove(LINK);
                break;
            }
        }
    }

    public void setAttributes(Rank.RankDir dir, String font) {
        this.dir = dir;
        this.font = font;
    }

    public void exportGraph(String path, String name) {
        try {
            Graphviz.fromGraph(g).width(700).render(Format.PNG).toFile(new File(path + name + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveGraph(String path) {

    }
}