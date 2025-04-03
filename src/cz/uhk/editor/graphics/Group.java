package cz.uhk.editor.graphics;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Group extends AbstractGraphObject{
    private List<AbstractGraphObject> objekty;

    public Group(Point pozice, Color barva) {
        super(pozice, barva);
        this.objekty = new ArrayList<>();
    }

    public void add(AbstractGraphObject objekt) {
        this.objekty.add(objekt);
    }

    public void remove(AbstractGraphObject objekt) {
        this.objekty.remove(objekt);
    }

    public List<AbstractGraphObject> getObjekty() {
        return objekty;
    }

    @Override
    public void draw(Graphics2D g) {
        for(AbstractGraphObject objekty : objekty){
            objekty.draw(g);
        }
    }

    @Override
    public boolean obsahuje(int x, int y) {
        for (AbstractGraphObject objekt : objekty) {
            if (objekt.obsahuje(x, y)) {
                return true;
            }
        }
        return false;
    }
}