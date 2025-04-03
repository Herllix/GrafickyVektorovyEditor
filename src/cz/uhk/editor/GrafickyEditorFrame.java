package cz.uhk.editor;

import javax.swing.*;
import java.awt.*;

public class GrafickyEditorFrame extends JFrame {
    private drwPanel panel;

    public GrafickyEditorFrame() {
        setTitle("Graficky Editor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1024, 800);
        setLocationRelativeTo(null);

        panel = new drwPanel();
        panel.initTestData();

        add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new GrafickyEditorFrame().setVisible(true);
    }
}