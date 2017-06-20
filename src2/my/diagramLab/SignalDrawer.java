package my.diagramLab;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class SignalDrawer extends JPanel{
	private int[] x;
	private int[] y;
	double max_generic;
	
	public SignalDrawer(double[] signal, int width, int height){
		this.setSize(width, height);
		
		int xScale = this.getWidth()/signal.length;
		x = new int[signal.length];
		for(int i=0; i<x.length; i++){
			x[i] = i*xScale;
		}
		int zero = this.getHeight()/2;
		max_generic = Math.max(Math.abs(findMax(signal)), Math.abs(findMin(signal)));
		double yScale = zero/max_generic;
		y = new int[x.length];
		for(int i=0; i<y.length; i++){
			y[i] = (int) (zero - signal[i]*yScale);
		}
	}
	
	public static double findMax(double[] array){
		double max = 0;
		for(int i=0; i<array.length; i++){
			if(array[i] > 0 && array[i] > max){
				max = array[i];
			}
		}
		return max;
	}
	
	public static double findMin(double[] array){
		double min = 0;
		for(int i=0; i<array.length; i++){
			if(array[i] < 0 && array[i] < min){
				min = array[i];
			}
		}
		return min;
	}

	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());

		g.setColor(Color.BLACK);
		g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
		
		g.drawString(" "+max_generic/2, 0, this.getHeight()/4);
		
		g.drawPolyline(x, y, x.length);
	}
	
}
