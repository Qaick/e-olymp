package tetris_demo;

import java.util.Random;

/**
 * Created by Oleg on 31.07.2016.
 */
public class Tetromino implements Cloneable{

    int x = 3, y = 0;//position of left top corner of pattern
    Form form;
    int[][] pattern;//4x2
    private int lastMove = 0;

    /**
     * 6 tetromino forms: I, O, T, J, L, S, Z
     */
    enum Form {
        I, O, T, J, L, S, Z
    }

    Tetromino() {
        this(Form.values()[new Random().nextInt(7)]);
    }

    Tetromino(Form form) {
        this.form = form;
        switch (form) {
            case I:
                pattern = new int[][]{
                        {1, 0},
                        {1, 1},
                        {1, 2},
                        {1, 3}};
                break;
            case O:
                pattern = new int[][]{
                        {0, 1},
                        {0, 2},
                        {1, 1},
                        {1, 2}};
                break;
            case T:
                pattern = new int[][]{
                        {0, 1},
                        {1, 0},
                        {1, 1},
                        {1, 2}};
                break;
            case J:
                pattern = new int[][]{
                        {0, 0},
                        {1, 0},
                        {1, 1},
                        {1, 2}};
                break;
            case L:
                pattern = new int[][]{
                        {0, 2},
                        {1, 0},
                        {1, 1},
                        {1, 2}};
                break;
            case S:
                pattern = new int[][]{
                        {0, 1},
                        {1, 1},
                        {1, 2},
                        {2, 2}};
                break;
            case Z:
                pattern = new int[][]{
                        {0, 2},
                        {1, 1},
                        {1, 2},
                        {2, 1}};
                break;
        }
    }

    boolean move(int side) {
        lastMove = side;
        if (side == 0)
            y++;
        else
            x += side;
        return true;
    }

    void moveBack() {
        if (lastMove == 0)
            y--;
        else
            x -= lastMove;
    }

    void rotate(boolean right) {
        if (form != Form.O)
            if (form == Form.I) {
                if (pattern[0][0] == 1)//horizontal
                    pattern = new int[][]{
                            {0, 1},
                            {1, 1},
                            {2, 1},
                            {3, 1}};
                else
                    pattern = new int[][]{
                            {1, 0},
                            {1, 1},
                            {1, 2},
                            {1, 3}};
            } else {
                int tmp;
                for (int i = 0; i < 4; i++) {
                    if (right) {
                        tmp = pattern[i][0];
                        pattern[i][0] = pattern[i][1];
                        pattern[i][1] = 2 - tmp;
//                            pattern[j][2 - i] = tmpPattern[i][j];//right
                    } else {
                        tmp = pattern[i][1];
                        pattern[i][1] = pattern[i][0];
                        pattern[i][0] = 2 - tmp;
//                            pattern[i][j] = tmpPattern[j][2 - i];//left
                    }
                }
            }
    }

    @Override
    protected Tetromino clone() {
        Tetromino t = null;
        try {
            t = (Tetromino)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return t;
    }
}
