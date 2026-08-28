package edu.eci.arsw.blueprints.persistence.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class PointEmbeddable {

    private int x;
    private int y;

    public PointEmbeddable() { }

    public PointEmbeddable(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
}