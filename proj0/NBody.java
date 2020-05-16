/** Run your simulation.
*
*@author Sihui Zhong
*/



public class NBody {

    /** 
     * Return the radius of the universe reading from the file 
     */
    public static double readRadius(String fileName) {
        In in = new In(fileName);
        in.readInt();
        double Radius = in.readDouble();

        return Radius;
    }
    /** 
     * Return an array of Planets corresponding to the planets in the file.
     */
    public static Planet[] readPlanets(String fileName){
    	In in = new In(fileName);
    	int num = in.readInt();
    	in.readDouble();
    	Planet[] planets = new Planet[num];
    	for (int i = 0; i < num; i++){
    		double xPod = in.readDouble();
    		double yPod = in.readDouble();
    		double xVel = in.readDouble();
    		double yVel = in.readDouble();
    		double mass = in.readDouble();
    		String name = in.readString();
    		planets[i] = new Planet(xPod, yPod, xVel, yVel, mass, name);
    	}
    	return planets;
    }

    public static void main(String[] args){
    	/** Get data. */
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
    	String fileName = args[2];
    	double radius = NBody.readRadius(fileName);
    	Planet[] planets = NBody.readPlanets(fileName);

    	/** Draw the background. */
    	StdDraw.setScale(-radius, radius);
    	StdDraw.clear();
    	StdDraw.picture(0, 0, "images/starfield.jpg");

    	/** Draw planets. */
    	for (int i = 0; i < planets.length; i++){
    		planets[i].draw();
    	}

        /** Enable double buffering. */
        StdDraw.enableDoubleBuffering();

        /**
         * Set up a loop to loop until time variable reaches T
         */
        for (double t0 = 0; t0 < T; t0+=dt){
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            /**
             * Calculate the net forces for every planet
             */
            for (int i = 0; i < planets.length; i++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            /** Updates each of the planets. */
            for (int i = 0; i < planets.length; i++){
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            /** Draw the background image. */
            StdDraw.picture(0, 0, "images/starfield.jpg");
            /** Draw all of the planets. */
            for (int i = 0; i < planets.length; i++){
                planets[i].draw();
            }
            /** for (Planet planet : planets){
                planet.draw();
            }
            */

            /** Show the offscreen buffer. */
            StdDraw.show();
            /** Pause the animation for 10 milliseconds. */
            StdDraw.pause(10);

            
            }

            /** Prints out the final state of the universe in the same format as the input. */
            StdOut.printf("%d\n", planets.length);
            StdOut.printf("%.2e\n", radius);
            for (int i = 0; i < planets.length; i++){
                StdOut.printf("%11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel, 
                    planets[i].yyVel, planets[i].imgFileName);




        }

    }


}