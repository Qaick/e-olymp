package my.diagramLab.lab3;
import javax.swing.*;
import java.awt.*;

public class FPanel extends JPanel {
    private final int gap = 20;//������
    private final int arrow = 10;
    private final int markLength = 5;
    private int numbOfXIntervals = 5;
    private int numbOfYIntervals = 5;
    private double[] f_p;
    private int N;
    private int T = 5;

    private double scaleX = 20;  //SCALE X

    public FPanel(double[] x, double[] y) {
        this.N = x.length;
        f_p = new double[N];
        for (int i = 0; i < f_p.length; i++) {
            f_p[i] = Generator.A(i, x, T);
        }
    }

    public void paint(Graphics g) {
        numbOfXIntervals = 5;
        numbOfYIntervals = 5;
        drawAxis(g);
        drawPoints(g);
        g.setFont(new Font("sansserif", Font.BOLD, 14));
        g.setColor(Color.GREEN);
        g.drawString("scale = " + scaleX, getWidth() - 5 * gap, gap);
        g.setColor(Color.BLACK);
    }

    private void drawAxis(Graphics g) {
        int heighth = getHeight();
        int width = getWidth();
        //x-axis
        g.drawLine(0, heighth - gap, width - gap, heighth - gap);
        g.drawLine(width - arrow - gap, heighth - gap - arrow, width - gap, heighth - gap);
        g.drawLine(width - arrow - gap, heighth - gap + arrow, width - gap, heighth - gap);
        //y-axis
        g.drawLine(gap * 2, 0, gap * 2, heighth);
        g.drawLine(gap * 2, 0, 2 * gap + arrow, arrow);
        g.drawLine(gap * 2, 0, 2 * gap - arrow, arrow);
        //x-axis marks + inscription
        double kx = (width - 3 * gap) / N;
        kx *= scaleX;
        numbOfXIntervals = (int) (numbOfXIntervals * scaleX);
        for (int i = 0; i < numbOfXIntervals + 1; i++) {
            g.drawLine((int) (gap * 2 + i * N * kx / numbOfXIntervals), heighth -gap - markLength / 2,
                    (int) (gap * 2 + i * N * kx / numbOfXIntervals), heighth -gap + markLength / 2);
            g.drawString("" + (i * N / numbOfXIntervals), (int) (gap * 2 + i * N * kx / numbOfXIntervals), heighth -gap + 3 * markLength);
        }
        //y-axis marks + inscription
        double yinterval = 2 * max(f_p);
        double ky = (heighth / 2 - gap) / yinterval;
        double y = max(f_p);
        double axix_y;
        for (int i = 0; i < numbOfYIntervals * 2 + 1; i++) {
            axix_y = gap + ky * i * yinterval / numbOfYIntervals;
            g.drawLine((int) (2 * gap - markLength / 2), (int) axix_y, (int) (2 * gap + markLength / 2), (int) axix_y);
            g.drawString("" + (Math.round(y * 100) / 100), (int) (2 * gap - 5 * markLength), (int) axix_y);
            y -= yinterval / (2 * numbOfYIntervals);
        }
    }

    private void drawPoints(Graphics g) {
        g.setColor(Color.BLUE);
        double kx = (getWidth() - 3 * gap) / N;
        kx *= scaleX;
        double ky = (getHeight() -gap - gap) / (max(f_p));
        int y0 = (int) (getHeight() -gap);
        for (int i = 0; i < f_p.length; i++) {
            int x = (int) (2 * gap + i * kx);
            int y = (int) (getHeight() -gap - f_p[i] * ky);
            g.drawLine(x, y0, x, y);
        }
    }

    private double max(double[] randomNumbers) {
        double max = Math.abs(randomNumbers[0]);
        for (int i = 0; i < randomNumbers.length; i++) {
            if (max < Math.abs(randomNumbers[i])) {
                max = Math.abs(randomNumbers[i]);
            }
        }
        return max;
    }
}

class Generator {
	public static double A(int p, double[] x, int T) {
        int N = x.length;
        double ReF_p = 0;
        double ImF_p = 0;
        for (int k = 0; k < N; k++) {
            ReF_p += x[k] * W(p, k, N)[0];
            ImF_p += x[k] * W(p, k, N)[1];
        }
        double a_p = Math.sqrt(ReF_p * ReF_p + ImF_p * ImF_p);
        return a_p;
    }

    private static double[] W(int p, int k, int N) {
        double[] coef = new double[2];  // Re, Im
        double Pi = Math.PI;
        coef[0] = Math.cos((2 * Pi / N) * p * k);
        coef[1] = Math.sin((2 * Pi / N) * p * k);
        return coef;
    }
}
