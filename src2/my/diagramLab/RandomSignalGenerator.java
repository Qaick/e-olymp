package my.diagramLab;

public class RandomSignalGenerator {
	private int n;
	private double w_max;
	
	public RandomSignalGenerator(int nunOfHarmonic, double w_max){
		this.n = nunOfHarmonic;
		this.w_max = w_max;
	}
	
	private double singleGenerate(int t){
		double x = 0;
		for(int i=0; i<n; i++){
			double A = Math.random();
			double fi = Math.random()*2*Math.PI;
			double w = w_max/n*(i+1);
			
			x += A*Math.sin(w*t + fi);
		}
		return x;
	}
	
	public double[] generate(int num){
		double[] x = new double[num];
		for(int i=0; i<num; i++){
			x[i] = singleGenerate(i);
		}
		return x;
	}

	public double[] generate_sin(int num){
		double[] x = new double[num];
		for(int i=0; i<num; i++){
			x[i] = Math.sin(i/(num/15.0));
		}
		return x;
	}
	public double[] generate_square(int num){
		double[] x = new double[num];
		int side = 0;
		for(int i=0; i<num; i++){
			x[i] = Math.sin(i/(num/15.0));
			if (x[i]>=0) {
				x[i] = 1;
			}else 
				x[i] = -1;
				
		}
		return x;
	}
	
	
	
	
	
	public double findM(double[] signal){
		double sum = 0;
		for(int i=0; i<signal.length; i++){
			sum += signal[i];
		}
		return sum/signal.length;
	}
	
	public double findD(double[] signal){
		double m = findM(signal);
		double sum = 0;
		for(int i=0; i<signal.length; i++){
			sum += (signal[i] - m)*(signal[i] - m);
		}
		return sum/(signal.length - 1);
	}
	
	public double singleR(double[] firstSignal, double[] secondSignal, int tau){
		double firstM = findM(firstSignal);
		double secondM = findM(secondSignal);
		double sum = 0;
		for(int i=0; i<firstSignal.length/2; i++){
			sum += (firstSignal[i] - firstM)*(secondSignal[i+tau] - secondM);
		}
		return sum/(firstSignal.length/2 - 1);
	}
	
	public double[] generateR(double[] firstSignal, double[] secondSignal){
		double[] x = new double[firstSignal.length/2];
		for(int i=0; i<x.length; i++){
			x[i] = singleR(firstSignal, secondSignal, i);
		}
		return x;
	}
}
