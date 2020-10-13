package de.mat2095.my_slither;

import java.awt.*;

class Food {

    final int x, y; // Coordinates of food
    private final double size; // Relative size of food?
    private final double rsp;
    private final long spawnTime;
    Color color = new Color(0, 0, 0); // Colour of outside
    Color color2 = new Color(0, 0, 0); // Colour of inside
    int red = 0; // Temp variables for colour generation
    int green = 0;
    int blue = 0;

    /**
     * Creates a food entity.
     *
     * @param x         (int) Coordinate
     * @param y         (int) Coordinate
     * @param size      (double) ?
     * @param fastSpawn (long) ?
     */
    Food(int x, int y, double size, boolean fastSpawn) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.rsp = fastSpawn ? 4 : 1;
        spawnTime = System.currentTimeMillis(); // Sets to current time.
        color = setColor(); // Sets to random colours
        color2 = setColor();
        while (color == color2) { // If the colours are the same they are redone.
            color2 = setColor();
        }
    }

    /**
     * Returns the size of the Food.
     *
     * @return (double) The Size.
     */
    double getSize() {
        return size;
    }

    /**
     * Returns the Radius of the Food.
     *
     * @return (double) The Radius.
     */
    double getRadius() {
        double fillRate = rsp * (System.currentTimeMillis() - spawnTime) / 1200;
        if (fillRate >= 1) {
            return size;
        } else {
            return (1 - Math.cos(Math.PI * fillRate)) / 2 * size;
        }
    }

    /**
     * Returns a randomly generated RGB colour.
     *
     * @return (Color) The Random Colour.
     */
    Color setColor() {
        red = (int) ((Math.random() * (255))); // Generates a random number between 0 and 255.
        green = (int) ((Math.random() * (255)));
        blue = (int) ((Math.random() * (255)));
        Color c = new Color(red, green, blue);
        return c;
    }
}
