package my.diagramLab;

import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Main {
	public static void main(String[] args){
		int NUM = 32;
		int numOfHarmonic = 7;
		int w_max = 1000;
		
		RandomSignalGenerator gen = new RandomSignalGenerator(numOfHarmonic, w_max);
		
		double[] x = gen.generate(NUM);
		double[] y = gen.generate(NUM);
//		double[] x = gen.generate_sin(NUM);
//		double[] y = gen.generate_square(NUM);
		
		System.out.println("X: M = " + gen.findM(x) + "; D = " + gen.findD(x));

		System.out.println("Y: M = " + gen.findM(y) + "; D = " + gen.findD(y));
		double[] rxx = gen.generateR(x, x);
		double[] ryy = gen.generateR(y, y);
		double[] rxy = gen.generateR(x, y);
		
		JFrame frame = new JFrame();
		frame.setSize(1024, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		System.out.println(Arrays.toString(rxx));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("X", new SignalDrawer(x, 1024, 500));
		tabbedPane.addTab("Y", new SignalDrawer(y, 1024, 500));
		tabbedPane.addTab("Rxx", new RDrawer(rxx, 1024, 500));
		tabbedPane.addTab("Ryy", new RDrawer(ryy, 1024, 500));
		tabbedPane.addTab("Rxy", new RDrawer(rxy, 1024, 500));

		frame.add(tabbedPane);
		
		frame.setVisible(true);
	}
}
