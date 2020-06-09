public class Body{

	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	String imgFileName;

	public static double gravitationalConstant = 6.67e-11;

	public Body(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Body(Body b){
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}

	public double calcDistance(Body b){
		return Math.pow((Math.pow(this.xxPos - b.xxPos, 2) + Math.pow(this.yyPos - b.yyPos, 2)), 0.5);
	}

	public double calcForceExertedBy(Body b){
		return (this.mass * b.mass * Body.gravitationalConstant) / Math.pow(this.calcDistance(b), 2);
	}

	public double calcForceExertedByX(Body b){
		return this.calcForceExertedBy(b) * (b.xxPos - this.xxPos) / this.calcDistance(b);
	}
	
	public double calcForceExertedByY(Body b){
		return this.calcForceExertedBy(b) * (b.yyPos - this.yyPos) / this.calcDistance(b);
	}

	public double calcNetForceExertedByX(Body[] ab){
		double sumForce = 0;
		for(Body b : ab){
			if(this.equals(b)){
				continue;
			} else{
				sumForce += this.calcForceExertedByX(b);
			}
		}
		return sumForce;
	}

	public double calcNetForceExertedByY(Body[] ab){
		double sumForce = 0;
		for(Body b : ab){
			if(this.equals(b)){
				continue;
			} else{
				sumForce += this.calcForceExertedByY(b);
			}
		}
		return sumForce;
	}

	public void update(double dt, double fX, double fY){
		double axx = fX / this.mass;
		double ayy = fY / this.mass;
		this.xxVel += axx * dt;
		this.yyVel += ayy * dt;
		this.xxPos += this.xxVel * dt;
		this.yyPos += this.yyVel * dt;
	}

	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos, "images/" + imgFileName);
	}


}