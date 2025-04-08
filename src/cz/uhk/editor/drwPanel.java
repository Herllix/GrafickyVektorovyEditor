package cz.uhk.editor;
import cz.uhk.editor.graphics.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class drwPanel extends JPanel {
    List<AbstractGraphObject> objekty;

    public drwPanel(List<AbstractGraphObject> objekty){this.objekty = objekty;}

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (AbstractGraphObject objekty : objekty) {
            objekty.draw(g2d);
        }
    }
}


