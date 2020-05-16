/* *
* simulating the motion of N objects in a plane, 
* accounting for the gravitational forces mutually affecting each objects.
*
*@autohor Sihui Zhong
*/

public class Planet{
	/**
	* Its current x position.
	*/
	public double xxPos;
	/**
	* Its current y position.
	*/	
	public double yyPos;
	/**
	* Its current velocity in the x direction.
	*/
	public double xxVel;
	/**
	* Its current velocity in the y direction.
	*/
	public double yyVel;
	/**
	* Its mass.
	*/
	public double mass;
	/**
	* The name of the file that corresponds to the image that depicts the planet.
	*/
	String imgFileName;
	/**
	* Gravitational constant.
	*/
	public static double G = 6.67 * Math.pow(10,-11);

	/** Create a Planet. */
	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	/** Take in a Planet object and initialize an identical Planet object. */
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    /** Return a double equal to the distance between the supplied planet and the planet. */
    public double calcDistance(Planet rocinante){
    	double dx = rocinante.xxPos - this.xxPos;
    	double dy = rocinante.yyPos - this.yyPos;
    	double distance = Math.sqrt(dx*dx + dy*dy); /** double distance = Math.hypot(dx,dy) Math.hypot返回参数的平方和的平方根.*/
    	return distance;
    }
    
    /** Returns a double describing the force exerted on this planet by the given planet. */
    public double calcForceExertedBy(Planet rocinante){
    	double force = (G*this.mass*rocinante.mass)/(this.calcDistance(rocinante)*this.calcDistance(rocinante));
    	return force;
    }

    /** Returns the force exerted in the X direction. */
    public double calcForceExertedByX(Planet rocinante){
    	double dx = rocinante.xxPos - this.xxPos;
    	double force = this.calcForceExertedBy(rocinante);
    	double distance = this.calcDistance(rocinante);
    	double forceX = (force*dx)/distance;
    	return forceX;
    }

    /** Returns the force exerted in the Y direction. */
    public double calcForceExertedByY(Planet rocinante){
    	double dy = rocinante.yyPos - this.yyPos;
    	double force = this.calcForceExertedBy(rocinante);
    	double distance = this.calcDistance(rocinante);
    	double forceY = (force*dy)/distance;
    	return forceY;
    }

    /** Take in an array of Planets and calculate the net X 
    * force exerted by all planets in that array upon the current Planet*/
    public double calcNetForceExertedByX(Planet[] allPlanets){
    	double netforceX = 0;
    	for (int i = 0; i < allPlanets.length; i++){
    		if (!this.equals(allPlanets[i])){
    			netforceX = netforceX + this.calcForceExertedByX(allPlanets[i]);
    		}

    	}
    	return netforceX;
    }
    
    /** Take in an array of Planets and calculate the net Y 
    * force exerted by all planets in that array upon the current Planet*/
    public double calcNetForceExertedByY(Planet[] allPlanets){
    	double netforceY = 0;
    	for (int i = 0; i < allPlanets.length; i++){
    		if (!this.equals(allPlanets[i])){
    			netforceY = netforceY + this.calcForceExertedByY(allPlanets[i]);
    		}

    	}
    	return netforceY;
    }

    /** determines how much the forces exerted on the planet will cause that planet to accelerate, 
    * and the resulting change in the planet’s velocity and position in a small period of time*/
    public void update(double t, double forceX, double forceY){
    	double acceX = forceX/this.mass;
    	double acceY = forceY/this.mass;
    	this.xxVel = this.xxVel + acceX*t;
     	this.yyVel = this.yyVel + acceY*t;
     	this.xxPos = this.xxPos + this.xxVel*t;
      	this.yyPos = this.yyPos + this.yyVel*t;
    }

    /** Draw the Planet’s image at the Planet’s position. */
    public void draw(){
    	double xPos = this.xxPos;
     	double yPos = this.yyPos;
   		String name = this.imgFileName;
    	StdDraw.picture(xPos, yPos, "images/" + name);
    }





}
