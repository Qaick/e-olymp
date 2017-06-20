package tetris_demo;

import java.util.HashSet;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by Oleg on 03.08.2016.
 */
public class TBoard {
    private static final Logger log = Logger.getLogger(TBoard.class.getName());

    public int[][] board = new int[20][10];
    public Tetromino tMain;
    public Tetromino tHold;//TODO prob keep only Tetromino
    public Tetromino tNext = new Tetromino(Tetromino.Form.values()[new Random().nextInt(7)]);
    //TODO realize this phantomT
    public Tetromino tPhantom;//TODO prob keep only Y

    public int score = 0;
    public int highScore = 0;
    public boolean gameOver = false;

    public TBoard() {
        createFigure();
    }

    public void newGame() {
        board = new int[20][10];
    }

    public void next() {
        //line completed check
        HashSet<Integer> cleanupLines = new HashSet<Integer>();
        int checkLine = -1;
        for (int i = 0; i < 4; i++) {
            if (checkLine != tMain.y + tMain.pattern[i][0]) {
                checkLine = tMain.y + tMain.pattern[i][0];
                int summ = 0;
                for (int j = 0; j < 10; j++) {
                    if (board[checkLine][j] == 0)
                        break;
                    summ++;
                }
                if (summ == 10) {
                    cleanupLines.add(checkLine);
                }
            }
        }
        //clean full lines
        if (cleanupLines.size() != 0) {
            for (Integer line : cleanupLines) {
                for (int j = 0; j < 10; j++) {
                    board[line][j] = 0;
                }
            }
            //move down
            int tmpLine[];
            for (Integer cleanLine : cleanupLines) {
                tmpLine = board[cleanLine];
                for (int i = cleanLine - 1; i >= 0; i--) {
                    board[i + 1] = board[i];
                }
                board[0] = tmpLine;
            }
            score += cleanupLines.size();
        }
        createFigure();
    }

    private void createFigure() {
        tMain = tNext;
        tNext = new Tetromino(Tetromino.Form.values()[new Random().nextInt(7)]);
        //check for GAME OVER
        for (int i = 0; i < 4; i++) {
            if (board[tMain.y + tMain.pattern[i][0]][tMain.x + tMain.pattern[i][1]] > 0) {
                board = new int[20][10];
                tHold = null;
                if (score > highScore) {
                    highScore = score;
                }
                score = 0;
                break;
            }
        }
        tPhantom = tMain.clone();
        onBoard();
    }

    public void move(int side) {
        boolean allGood = true;
        int left = 4, right = 0, bot = 0;
        for (int i = 0; i < 4; i++) {
            if (tMain.pattern[i][0] > bot)
                bot = tMain.pattern[i][0];
            if (tMain.pattern[i][1] < left)
                left = tMain.pattern[i][1];
            if (tMain.pattern[i][1] > right)
                right = tMain.pattern[i][1];
        }
        //check board edges around tetromino
        if (side == 0) {
            if (tMain.y + bot >= 19) {
                next();
                allGood = false;
            }
        } else if (side == 1) {
            if (tMain.x + right >= 9)
                allGood = false;
        } else if (tMain.x + left < 1) {
            allGood = false;
        }
        //move figure cause it is possible and write it on board
        if (allGood) {
            drop(side);
        }
    }

    public void drop(int down) {
        outBoard();
        boolean moveBack = false;
        if (down <= 1) {
            tMain.move(down);
            //check collisions between figures
            for (int i = 0; i < 4; i++) {
                if (board[tMain.y + tMain.pattern[i][0]][tMain.x + tMain.pattern[i][1]] > 0) {
                    log.fine("can't CryptographyChallenge move");
                    tMain.moveBack();
                    moveBack = true;
                    break;
                }
            }
        } else {
            tMain.y = down;
        }
        onBoard();
        if (down == 0 && moveBack)
            next();
    }

    public void hardDrop() {
        outBoard();
        drop(getDropY(tMain));
        next();
    }

    private int getDropY(Tetromino t) {
        int down = t.y;
        boolean tooDeep = false;
        int bot = 0;
        for (int i = 0; i < 4; i++) {
            if (t.pattern[i][0] > bot)
                bot = t.pattern[i][0];
        }
        while (true) {
            if (down + bot > 19) {
                down--;
                break;
            } else {
                for (int i = 0; i < 4; i++) {
                    if (board[down + t.pattern[i][0]][t.x + t.pattern[i][1]] > 0) {
                        log.fine("hard Drop");
                        tooDeep = true;
                        break;
                    }
                }
            }
            if (tooDeep) {
                down--;
                break;
            }
            down++;
        }
        return down;
    }

    public void rotate(boolean clockwise) {
        log.fine("rotate " + clockwise);
        outBoard();
        tMain.rotate(clockwise);
        //TODO if tetromino out of board move it. 3 conditions(условий)

        int left = 4, right = 0, bot = 0;
        for (int i = 0; i < 4; i++) {
            if (tMain.pattern[i][0] > bot)
                bot = tMain.pattern[i][0];
            if (tMain.pattern[i][1] < left)
                left = tMain.pattern[i][1];
            if (tMain.pattern[i][1] > right)
                right = tMain.pattern[i][1];
        }
        boolean collision = false;
        //check board edges around tetromino
        int newY = tMain.y, newX = tMain.x;
        if (tMain.y + bot > 19) {
            newY--;
        } else if (tMain.x + right > 9) {
            newX = 9 - right;
        } else if (tMain.x + left < 0) {
            newX++;
        }
        for (int i = 0; i < 4; i++) {
            if (board[newY + tMain.pattern[i][0]][newX + tMain.pattern[i][1]] > 0) {
                collision = true;
                break;
            }
        }
        if (collision) {
            tMain.rotate(!clockwise);
        } else {
            tMain.y = newY;
            tMain.x = newX;
        }

        onBoard();
    }

    private void outBoard() {
        for (int i = 0; i < 4; i++) {
            board[tMain.y + tMain.pattern[i][0]][tMain.x + tMain.pattern[i][1]] = 0;
            board[tPhantom.y + tMain.pattern[i][0]][tMain.x + tMain.pattern[i][1]] = 0;
        }
    }

    private void onBoard() {
        //TODO if phantom need update
        tPhantom.y = getDropY(tMain);
        int color = tMain.form.ordinal() + 1;
        for (int i = 0; i < 4; i++) {
            board[tPhantom.y + tMain.pattern[i][0]][tMain.x + tMain.pattern[i][1]] = -color;
        }
        for (int i = 0; i < 4; i++) {
            board[tMain.y + tMain.pattern[i][0]][tMain.x + tMain.pattern[i][1]] = color;
        }
    }

    public void hold() {
        outBoard();
        if (tHold != null) {
            Tetromino tmp = tMain;
            tMain = tHold;
            tHold = tmp;
            tMain.x = 3;
            tMain.y = 0;
            onBoard();
        } else {
            tHold = tMain;
            createFigure();
        }
    }
}
