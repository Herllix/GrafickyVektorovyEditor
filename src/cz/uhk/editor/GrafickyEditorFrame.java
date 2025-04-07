package cz.uhk.editor;

import cz.uhk.editor.graphics.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class GrafickyEditorFrame extends JFrame {
    private JToolBar toolBar;
    private JToggleButton btCtverec;
    private JToggleButton btObdelnik;
    private JToggleButton btTrojuhelnik;
    private JToggleButton btKruznice;
    private JToggleButton btSipka;
    private AbstractGraphObject vybranyObjekt;
    private int poziceX, poziceY;

    public GrafickyEditorFrame() {
        setTitle("Graficky Editor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1024, 800);
        setLocationRelativeTo(null);

        createToolbar();

        drwPanel panel = new drwPanel();
        panel.initTestData();

        add(panel, BorderLayout.CENTER);
        MouseAdapter xd = new MouseAdapter() {public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                if (btKruznice.isSelected()) {
                    panel.addKruznice(new Kruznice(new Point(e.getX(), e.getY()), Color.GREEN, 40));
                } else if (btCtverec.isSelected()) {
                    panel.addCtverec(new Ctverec(new Point(e.getX(), e.getY()), Color.BLUE, 40));
                } else if (btObdelnik.isSelected()) {
                    panel.addObdelnik(new Obdelnik(new Point(e.getX(), e.getY()), Color.RED, 20, 40));
                } else if (btTrojuhelnik.isSelected()) {
                    panel.addTrojuhelnik(new Trojuhelnik(new Point(e.getX(), e.getY()), Color.GREEN, 40));
                }
            }
        }
            public void mousePressed(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1) {
                    if(btSipka.isSelected()) {
                        vybranyObjekt = panel.obsahuje(e.getX(), e.getY());
                    }
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if(vybranyObjekt !=null && btSipka.isSelected()) {
                    vybranyObjekt.setPozice(new Point(e.getX(), e.getY() ));
                    repaint();
                }
            }
        };
        panel.addMouseMotionListener(xd);
        panel.addMouseListener(xd);

    }

    private void createToolbar() {
        toolBar = new JToolBar(JToolBar.HORIZONTAL);
        add(toolBar, BorderLayout.NORTH);
        btCtverec = new JToggleButton("Ctverec");
        btObdelnik = new JToggleButton("Obdelnik");
        btTrojuhelnik = new JToggleButton("Trojuhlenik");
        btKruznice = new JToggleButton("Kruznice");
        btSipka = new JToggleButton("Sipka");
        toolBar.add(btCtverec);
        toolBar.add(btObdelnik);
        toolBar.add(btTrojuhelnik);
        toolBar.add(btKruznice);
        toolBar.add(btSipka);
        ButtonGroup gr = new ButtonGroup();
        gr.add(btCtverec);
        gr.add(btObdelnik);
        gr.add(btTrojuhelnik);
        gr.add(btKruznice);
        gr.add(btSipka);
    }

    public static void main(String[] args) {
        new GrafickyEditorFrame().setVisible(true);
    }
}