package byog.lab5;

import org.junit.Test;

import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 100;
    private static final int HEIGHT = 100;

    private static class Position {
        public int x;
        public int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * @param world
     * @param s     side length of a Hexagon
     * @param p     the lower left corner
     */
    public static void addHexagon(TETile[][] world, Position p, int s, TETile t) {
        if (s < 2) {
            throw new IllegalArgumentException("Hexagon must be at leat size 2.");
        }

        for (int yi = 0; yi < 2 * s; yi++) {
            int thisRowY = p.y + yi;
            int xRowStart = p.x + hexRowOffset(s, yi);
            Position rowStartP = new Position(xRowStart, thisRowY);
            int rowWidth = hexRowWidth(s, yi);
            addRow(world, rowStartP, rowWidth, t);
        }
    }

    private static void addRow(TETile[][] world, Position p, int width, TETile t) {
        for (int xi = 0; xi < width; xi++) {
            int xCoord = p.x + xi;
            int yCoord = p.y;
            world[xCoord][yCoord] = TETile.colorVariant(t, 32, 32, 32, RANDOM);
        }
    }

    private static int hexRowWidth(int s, int i) {
        int effectiveI = i;
        if (i >= s) {
            effectiveI = 2 * s - 1 - effectiveI;
        }
        return s + 2 * effectiveI;
    }

    private static int hexRowOffset(int s, int i) {
        int effectiveI = i;
        if (i >= s) {
            effectiveI = 2 * s - 1 - effectiveI;
        }
        return -effectiveI;
    }

    private static Position topRightNeighbor(Position p, int s) {
        return new Position(p.x + 2 * s - 1, p.y + s);
    }

    private static Position bottomRightNeighbor(Position p, int s) {
        return new Position(p.x + 2 * s - 1, p.y - s);
    }

    private static Position topNeighbor(Position p, int s) {
        return new Position(p.x, p.y + 2 * s);
    }

    private static void drawRandomVerticalHexes(TETile[][] world, Position p, int s, int n) {

        for (int i = 0; i < n; i++) {
            TETile t = randomTile();
            addHexagon(world, p, s, t);
            p = topNeighbor(p, s);
        }
    }

    private static final long SEED = 555;
    private static final Random RANDOM = new Random(SEED);

    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(5);
        switch (tileNum) {
            case 0:
                return Tileset.WALL;
            case 1:
                return Tileset.FLOWER;
            case 2:
                return Tileset.GRASS;
            case 3:
                return Tileset.SAND;
            case 4:
                return Tileset.TREE;
            default:
                return Tileset.WATER;
        }
    }

    public static void main(String[] args) {
        int side_length = 5;
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        Position p = new Position(30, 30);

        drawRandomVerticalHexes(world, p, side_length, 3);
        p = bottomRightNeighbor(p, side_length);
        drawRandomVerticalHexes(world, p, side_length, 4);
        p = bottomRightNeighbor(p, side_length);
        drawRandomVerticalHexes(world, p, side_length, 5);
        p = topRightNeighbor(p, side_length);
        drawRandomVerticalHexes(world, p, side_length, 4);
        p = topRightNeighbor(p, side_length);
        drawRandomVerticalHexes(world, p, side_length, 3);

        ter.renderFrame(world);
    }
}
