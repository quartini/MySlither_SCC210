package de.mat2095.my_slither;

import java.awt.*;

class Food {

    final int x, y;
    private final double size;
    private final double rsp;
    private final long spawnTime;
    Color color = new Color(0, 0, 0);
    Color color2 = new Color(0, 0, 0);
    int red = 0;
    int green = 0;
    int blue = 0;

    Food(int x, int y, double size, boolean fastSpawn) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.rsp = fastSpawn ? 4 : 1;
        spawnTime = System.currentTimeMillis();
        color = setColor();
        color2 = setColor();
        while (color == color2) {
            color2 = setColor();
        }
    }

    double getSize() {
        return size;
    }

    double getRadius() {
        double fillRate = rsp * (System.currentTimeMillis() - spawnTime) / 1200;
        if (fillRate >= 1) {
            return size;
        } else {
            return (1 - Math.cos(Math.PI * fillRate)) / 2 * size;
        }
    }

    Color setColor() {
        red = (int) ((Math.random() * (255)));
        green = (int) ((Math.random() * (255)));
        blue = (int) ((Math.random() * (255)));
        Color c = new Color(red, green, blue);
        return c;
    }
}
