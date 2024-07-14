package Model;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Arma {
    public Rectangle2D shape; // Tornando público
    public int length; // Tornando público
    public Color color; // Tornando público
    public int[][] offsets; // Tornando público

    public Arma(Rectangle2D shape, int length, Color color, int[][] offsets) {
        this.shape = shape;
        this.length = length;
        this.color = color;
        this.offsets = offsets;
    }
}