package cz.uhk.editor;

import cz.uhk.editor.graphics.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class GrafickyEditorFrame extends JFrame {
    private List<AbstractGraphObject> objekty = new ArrayList<>();
    private JToolBar toolBar;
    private JToggleButton btCtverec;
    private JToggleButton btObdelnik;
    private JToggleButton btTrojuhelnik;
    private JToggleButton btKruznice;
    private JToggleButton btSipka;
    private JToggleButton btOdstranit;
    private drwPanel panel;
    private AbstractGraphObject vybranyObjekt;

    public GrafickyEditorFrame() {
        setTitle("Graficky Editor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1024, 800);
        setLocationRelativeTo(null);

        createToolbar();

        initTestData();

        panel = new drwPanel(objekty);
        add(panel, BorderLayout.CENTER);
        MouseAdapter adaMouse = new MouseAdapter() {public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                if (btKruznice.isSelected()) {
                    objekty.add(new Kruznice(new Point(e.getX(), e.getY()), Color.GREEN, 40));
                    repaint();
                } else if (btCtverec.isSelected()) {
                    objekty.add(new Ctverec(new Point(e.getX(), e.getY()), Color.BLUE, 40));
                    repaint();
                } else if (btObdelnik.isSelected()) {
                    objekty.add(new Obdelnik(new Point(e.getX(), e.getY()), Color.RED, 20, 40));
                    repaint();
                } else if (btTrojuhelnik.isSelected()) {
                    objekty.add(new Trojuhelnik(new Point(e.getX(), e.getY()), Color.GREEN, 40));
                    repaint();
                }
            }
        }
            public void mousePressed(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1) {
                    if(btSipka.isSelected()) {
                        vybranyObjekt = null;
                        for(int i = objekty.size() - 1; i >= 0; i--) {
                            if (objekty.get(i).obsahuje(e.getX(), e.getY())) {  
                                vybranyObjekt = objekty.get(i);
                                break;
                            }
                        }
                    }
                    if(btOdstranit.isSelected()) {
                        vybranyObjekt = null;
                        for(int i = objekty.size() - 1; i >= 0; i--) {
                            AbstractGraphObject obj = objekty.get(i);
                            if (obj.obsahuje(e.getX(), e.getY())) {
                                vybranyObjekt = obj;
                                objekty.remove(vybranyObjekt);
                                repaint();
                                break;
                            }
                        }
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
        panel.addMouseMotionListener(adaMouse);
        panel.addMouseListener(adaMouse);
    }

    private void createToolbar() {
        toolBar = new JToolBar(JToolBar.HORIZONTAL);
        add(toolBar, BorderLayout.NORTH);
        btCtverec = new JToggleButton("Ctverec");
        btObdelnik = new JToggleButton("Obdelnik");
        btTrojuhelnik = new JToggleButton("Trojuhlenik");
        btKruznice = new JToggleButton("Kruznice");
        btSipka = new JToggleButton("Sipka");
        btOdstranit = new JToggleButton("Odstranit");
        toolBar.add(btCtverec);
        toolBar.add(btObdelnik);
        toolBar.add(btTrojuhelnik);
        toolBar.add(btKruznice);
        toolBar.add(btSipka);
        toolBar.add(btOdstranit);
        ButtonGroup gr = new ButtonGroup();
        gr.add(btCtverec);
        gr.add(btObdelnik);
        gr.add(btTrojuhelnik);
        gr.add(btKruznice);
        gr.add(btSipka);
        gr.add(btOdstranit);
    }
    private void initTestData(){
        objekty.add(new Trojuhelnik(new Point(206, 400), Color.GREEN, 80));
        objekty.add(new Kruznice(new Point(412, 400), Color.BLUE, 40));
        objekty.add(new Ctverec(new Point(618, 400), Color.PINK, 80));
        objekty.add(new Obdelnik(new Point (824, 400), Color.RED, 60,80));
    }
    public static void main(String[] args) {
        new GrafickyEditorFrame().setVisible(true);
    }
}