package my.tetris_demo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.*;

/**
 * Tetris Component with main that can be run. Frame inside main method
 */
public class TComponent extends JComponent implements Runnable{
    public static final Color color_black = new Color(0, 0, 0, 255);

    private final Color[] tmp = new Color[]{
            new Color(219, 96, 207),
            new Color(211, 58, 185),
            new Color(197, 41, 166),
            new Color(175, 41, 138),
            new Color(154, 33, 131),
            new Color(102, 0, 102),
            new Color(26, 183, 151)
    };

    Color color_shade = new Color(138, 72, 191, 60);
    Color color_grey = new Color(191, 191, 191);
    Color color_dark_grey = new Color(172, 172, 172);

    // I, O, T, J, L, S, Z
    private static final Color[] colors_v1 = new Color[]{
            new Color(15, 155, 215, 150),
            new Color(227, 159, 2, 230),
            new Color(175, 41, 138),
            new Color(33, 65, 198, 230),
            new Color(227, 91, 2, 150),
            new Color(89, 177, 1, 230),
            new Color(215, 15, 55, 230)};
    private static final Color[] colors_v2 = new Color[]{
            new Color(9, 174, 247, 150),
            new Color(255, 182, 24, 230),
            new Color(197, 41, 166),
            new Color(33, 89, 222, 230),
            new Color(255, 121, 0, 150),
            new Color(99, 199, 16, 230),
            new Color(247, 32, 57, 230)};
    private static final Color[] colors_v3 = new Color[]{
            new Color(135, 208, 225),
            new Color(200, 214, 91),
            new Color(152, 118, 169),
            new Color(26, 124, 188),
            new Color(247, 146, 42),
            new Color(164, 211, 137),
            new Color(211, 137, 164)};

    private static Font monoFont = new Font("Monospaced", Font.BOLD, 20);

    private static Thread gameThread = null;

    private volatile boolean drop = false;

    private final int bottom = 400;//height
    private final int right = 200;//weight
    private final int top = 50;
    private final int left = 20;
    private int step = bottom / 20;

    private TBoard tBoard = new TBoard();

    private boolean playing = true;

    private int speed = 1;
    private final int maxSpeed = 10;
    private int lvlUpScore = 10;
    private int prevLvlScore;
    private final int lvl1 = 1100;
    static long timerTime = System.currentTimeMillis();

    public TComponent() {
        setFocusable(true);
        JLabel improve = new JLabel("IMPROVE");
        improve.setFont(new Font(Font.SANS_SERIF,Font.BOLD,50));
        improve.setBounds(130,0,500,50);
        add(improve);

        this.addKeyListener(new KeyAdapter() {
            HashSet<Integer> pressedKeys = new HashSet<Integer>();
            //TODO don't like Timer creating only 1 time
            Timer timer = new Timer((lvl1 - speed * 100) / 6, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
//                    System.out.println("timer action: "+(System.currentTimeMillis()-timerTime));
                    timerTime = System.currentTimeMillis();
                    if (!pressedKeys.isEmpty()) {
                        Iterator<Integer> i = pressedKeys.iterator();
                        while (i.hasNext()) {
                            switch (i.next()) {
                                case KeyEvent.VK_DOWN:
                                    drop = true;
                                    break;
                                case KeyEvent.VK_RIGHT:
                                    tBoard.move(1);
                                    break;
                                case KeyEvent.VK_LEFT:
                                    tBoard.move(-1);
                                    break;
                            }
                        }
                        repaint();
                    }
                }
            });

            @Override
            public void keyReleased(KeyEvent event) {
                //Remove key from hashset when released
                int keyCode = event.getKeyCode();
                pressedKeys.remove(keyCode);
                if (!pressedKeys.contains(KeyEvent.VK_LEFT)
                        && !pressedKeys.contains(KeyEvent.VK_RIGHT)
                        && !pressedKeys.contains(KeyEvent.VK_DOWN)
                        && timer.isRunning()) {
                    timer.stop();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //Add key to hashSet when pressed
                int keyCode = e.getKeyCode();
                if (!pressedKeys.contains(keyCode)) {
                    pressedKeys.add(keyCode);

                    switch (keyCode) {
                        //TODO this control should react after key pressed and every 0.1 sec passed. Now it work only in update 0.1 sec, so you can press key and nothing happend
                        case KeyEvent.VK_LEFT:
                            if (!timer.isRunning()) {
                                tBoard.move(-1);
                                timer.start();
                            }
                            break;
                        case KeyEvent.VK_RIGHT:
                            if (!timer.isRunning()) {
                                tBoard.move(1);
                                timer.start();
                            }
                            break;
                        case KeyEvent.VK_DOWN:
                            if (!timer.isRunning()) {
                                drop = true;
                                timer.start();
                            }
                            break;

                        case KeyEvent.VK_UP:
                            //TODO timer update after rotate to wait
                            tBoard.rotate(true);
                            break;
                        case KeyEvent.VK_SPACE:
                            tBoard.hardDrop();
                            break;
                        case KeyEvent.VK_C:
                        case KeyEvent.VK_SHIFT:
                            tBoard.hold();
                            break;
                        case KeyEvent.VK_Z:
                            tBoard.rotate(false);
                            break;
                        case KeyEvent.VK_ESCAPE:
                            Component component = (Component) e.getSource();
                            JFrame frame = (JFrame) SwingUtilities.getRoot(component);
                            frame.dispose();//releases all resources used by this Window
                            System.exit(0);//close jvm
                            break;
                        case KeyEvent.VK_P:
                            if (playing) {
                                System.out.println("paused");
                                playing = false;
                                try {
                                    gameThread.join();
                                } catch (InterruptedException e1) {
                                    e1.printStackTrace();
                                }
                            } else {
                                playing = true;
                                System.out.println("unpaused Start thread from P");
                                //TODO it's ok to create new thread after pause???
                                gameThread = new Thread(tComponent);
                                gameThread.start();
                            }
                            //TODO pause, you can't CryptographyChallenge move figures left and rotate!!!
                            break;
                    }
                    repaint();
                }
            }
        });
    }

    @Override
    public void run() {
        while (playing) {
            System.out.println(Thread.currentThread());
            drop = true;
            repaint();
            // Capture the current time in milliseconds in startFrameTime
            long startFrameTime = System.currentTimeMillis();
            try {
                if (speed >= maxSpeed) {
                    speed = maxSpeed;
                }
//                System.out.println("sleep");
                gameThread.sleep(lvl1 - speed * 100);
//                System.out.println("get up");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void drawPlayBoard(Graphics g) {
        long drawBoard = System.nanoTime();
        g.setColor(color_grey);
        g.fillRect(left, top, right, bottom);

        int tmp;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                tmp = tBoard.board[i][j];
                if (tmp < 0) {
                    //TODO same color, more transparent
                    g.setColor(color_shade);
                    g.fillRect(left + step * j, top + step * i, step, step);
                } else if (tmp > 0) {
                    g.setColor(colors_v1[tmp - 1]);
                    g.fillRect(left + step * j, top + step * i, step, step);
                }
            }
        }
//        System.out.println("drawPlayBoard time: "+(System.nanoTime()-drawBoard));
/*
        g.setColor(color_dark_grey);
        for (int i = 0; i < 9; i++) {
            g.drawLine(left + step * (i + 1), top, left + step * (i + 1), bottom + top-1);
        }
        for (int i = 0; i < 19; i++) {
            g.drawLine(left, top + step * (i + 1), right + left-1, top + step * (i + 1));
        }*/
    }

    // Draw the newly updated scene
    public void draw1(Graphics g) {
//        System.out.println("draw1");
        if (drop) {
            tBoard.move(0);
            drop = false;
        }
        drawPlayBoard(g);

        // Choose the brush color for drawing
        g.setColor(color_black);
        g.setFont(monoFont);

        //TODO bad place to do this calculations
        if (tBoard.score == 0) {
            prevLvlScore = 0;
            speed = 1;
        }
        if (lvlUpScore <= tBoard.score -prevLvlScore) {
            prevLvlScore = tBoard.score;
            lvlUpScore += 2;
            speed++;
        }
        //score
        g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        g.drawString("SCORE: "+tBoard.score, left, 40);
        g.drawString("LEVEL: " + speed, left + right + 10, 65);
        g.drawString("GOAL: " + (lvlUpScore-tBoard.score + prevLvlScore), left + right + 10, 90);
        g.drawString("NEXT: " + tBoard.tNext.form, left + right + 10, 115);
        Tetromino hold = tBoard.tHold;
        g.drawString("HOLD: "+(hold != null ? hold.form : "-"), left + right + 10, 230);
        g.drawString("HIGH SCORE: "+tBoard.highScore, left, top + bottom + 20);

        Tetromino next = tBoard.tNext;
        g.setColor(colors_v1[next.form.ordinal()]);
        for (int i = 0; i < 4; i++) {
            g.fillRect(left + right + 10 + next.pattern[i][1] * step, 140 + next.pattern[i][0] * step, step, step);
        }

        if (hold != null) {
            g.setColor(colors_v1[hold.form.ordinal()]);
            for (int i = 0; i < 4; i++) {
                g.fillRect(left + right + 10 + hold.pattern[i][1] * step, 255 + hold.pattern[i][0] * step, step, step);
            }
        }
    }

    static long lastPaintTime = System.currentTimeMillis();
    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
        lastPaintTime = System.nanoTime();
        draw1(g);
//        System.out.println("pC "+(System.nanoTime()- lastPaintTime));
    }

    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    static TComponent tComponent;

    public static void main(String args[]) {
        System.out.println(Thread.currentThread());
        //поток диспетчеризации событий. Поток управления, которые передает ГУИ нажатия на клавиши и мышь
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
                JFrame mainFrame = new JFrame("Tetris demo");
                tComponent = new TComponent();
                mainFrame.getContentPane().add(tComponent);
                mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                mainFrame.setSize(400, 530);
                mainFrame.setVisible(true);

                gameThread = new Thread(tComponent);
                gameThread.start();
            }
        });
    }
}