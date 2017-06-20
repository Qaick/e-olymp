package my.diagramLab;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class RDrawer extends JPanel{
	private int[] x;
	private int[] y;
	double max_generic;
	
	public RDrawer(double[] signal, int width, int height){
		this.setSize(width, height);
		

		max_generic = Math.max(Math.abs(SignalDrawer.findMax(signal)), Math.abs(SignalDrawer.findMin(signal)));
		
		int xScale = this.getWidth()/signal.length;
		x = new int[signal.length];
		for(int i=0; i<x.length; i++){
			x[i] = i*xScale;
		}
		int zero = this.getHeight()/2;
		double yScale = zero;
		y = new int[x.length];
		for(int i=0; i<y.length; i++){
			y[i] = (int) (zero - signal[i]*yScale);
		}
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
