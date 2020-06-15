public class NBody{

	public static double readRadius(String fileName){
		In in = new In(fileName);
		int firstItemInFile = in.readInt();
		double secondItemInFile = in.readDouble();
		return secondItemInFile;
	}

	public static Body[] readBodies(String fileName){
		In in = new In(fileName);
		int numberOfPlanets = in.readInt();
		double radiusOfUniverse = in.readDouble();
		Body[] bodies = new Body[numberOfPlanets];

		for(int i = 0; i < numberOfPlanets; i++){
			double xxP = in.readDouble();
			double yyP = in.readDouble();
			double xxV = in.readDouble();
			double yyV = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();
			bodies[i] = new Body(xxP, yyP, xxV, yyV, m, img);
		}
		return bodies;
	}

	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double universeRadius = readRadius(filename);
		Body[] bodies = readBodies(filename);
		int N = bodies.length;

		StdAudio.play("audio/2001.mid");

		StdDraw.setScale(-universeRadius, universeRadius);
		/**
		StdDraw.picture(0, 0, "images/starfield.jpg");
		for(int i = 0;  i < bodies.length; i ++){
			bodies[i].draw();
		}**/

		StdDraw.enableDoubleBuffering();

		for(double time = 0; time < T; time++){
			StdDraw.clear();
			StdDraw.picture(0, 0, "images/starfield.jpg");
			double[] xForces = new double[N];
			double[] yForces = new double[N];
			int iterator = 0;
			for(Body body : bodies){
				xForces[iterator] = body.calcNetForceExertedByX(bodies);
				yForces[iterator] = body.calcNetForceExertedByY(bodies);
				iterator += 1;
			}

			for(int i = 0; i < N; i++){
				bodies[i].update(dt, xForces[i], yForces[i]);
			}

			for(Body body : bodies){
			body.draw();
			}

			StdDraw.show();
			StdDraw.pause(10);
		}

		StdOut.printf("%d\n", bodies.length);
		StdOut.printf("%.2e\n", universeRadius);
		for (int i = 0; i < bodies.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  		bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                  		bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
		}
	}
}