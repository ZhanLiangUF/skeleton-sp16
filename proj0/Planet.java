public class Planet {
public double xxPos;
public double yyPos;
public double xxVel;
public double yyVel;
public double mass;
public String imgFileName;
public double yPosition;
public double xPosition;
public double G = 6.67e-11;
public double netforce;
public double xNetForce;
public double yNetForce;
public double xAcceleration;
public double yAcceleration;
public double xVelocity;
public double yVelocity;
public double second;
public double xxForce;
public double yyForce;
public double xxPosition;
public double yyPosition;

public static void main(String[] args) {
        
    }

public Planet(double xxPos, double yP, double xV, double yV, double m, String img ){
this.xxPos = xxPos;
System.out.println(xxPos);
yyPos = yP;
System.out.println(yP);
System.out.println(yyPos);
xxVel = xV;
yyVel = yV;
mass = m;
imgFileName = img;
}
public Planet(Planet p) {
xxPos = p.xxPos;
yyPos = p.yyPos;
xxVel = p.xxVel;
yyVel = p.yyVel;
mass = p.mass;
imgFileName = p.imgFileName;
}

public double calcDistance(Planet p){
	yPosition = ((this.yyPos - p.yyPos)*(this.yyPos - p.yyPos));
	xPosition = ((this.xxPos - p.xxPos)*(this.xxPos - p.xxPos));
	return Math.sqrt((xPosition)+(yPosition));

}

public double calcForceExertedBy(Planet p){
	double r = calcDistance(p);
	return ((G*this.mass*p.mass)/(r*r));

}
public double calcForceExertedByX(Planet p){
	double positionx = (p.xxPos - this.xxPos);
	double r = calcDistance(p);
	double f = calcForceExertedBy(p);
	return ((f*positionx)/(r));
}

public double calcForceExertedByY(Planet p){
	double positiony = (p.yyPos - this.yyPos);
	double r = calcDistance(p);
	double f = calcForceExertedBy(p);
	return ((f*positiony)/(r));
}

public double calcNetForceExertedByX(Planet[] p){
	xNetForce = 0;
	for (Planet planet : p) {
		if (planet.xxPos == this.xxPos) {
			//do nothing
		} else {
			xNetForce += calcForceExertedByX(planet);
		}
	}
	return xNetForce;
}
public double calcNetForceExertedByY(Planet[] p) {
	yNetForce = 0;
	for (Planet planet : p) {
		if (planet.yyPos == this.yyPos) {
			//do nothing
		} else {
			xNetForce += calcForceExertedByY(planet);
		}
	}
	return yNetForce;
}

	
public double update(double second, double xxForce, double yyForce ) {
	this.second = second;
	this.xxForce = xxForce;
	this.yyForce = yyForce;
	System.out.println(xxForce);
	System.out.println(yyForce);
	System.out.println(second); /* Up to this point I was able
								* to grab inputed seconds, xxForce, and 
								*yyForce */
	
	
	xAcceleration = (xxForce/this.mass);
	yAcceleration = (yyForce/this.mass);
	xVelocity = (this.xxVel) + (second*xAcceleration);
	yVelocity = (this.yyVel) + (second*yAcceleration);
	xxPosition = (this.xxPos +(second*xVelocity));
	yyPosition = (this.yyPos +(second*yVelocity));
	

	this.xxVel = xVelocity;
	this.yyVel = yVelocity;
	this.xxPos = xxPosition;
	this.yyPos = yyPosition;
	return this.xxVel;
}

}