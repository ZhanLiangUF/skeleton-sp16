
public class NBody {
	public String file;
	public int T;
	public double dt;
	public static void main(String[] args) {
		int T = Integer.parseInt(args[0]);
		double dt = Double.parseDouble(args[1]);
		String file = args[2];
		
	}

	public  static double readRadius(String file) {
		In in = new In(file);
		int numberofplanets = in.readInt();
		System.out.println(numberofplanets);
		double radius = in.readDouble();
	return radius;
	}
	public static Planet[] readPlanets(String file) {
		In in = new In(file);
		int numberofplanets = in.readInt();
		double radius = in.readDouble();
		Planet[] planets = new Planet[numberofplanets];

		for(int i = 0;i < numberofplanets; i++) {
			Planet p = NBody.getPlanet(in);
			planets[i] = p;
		
		System.out.println(p.xxPos);
		}
		return planets;
	}

	public static Planet getPlanet(In in){

		Planet p = new Planet(0,0,0,0,0,"");
		p.xxPos = in.readDouble();
		p.yyPos = in.readDouble();
		p.xxVel = in.readDouble();
		p.yyVel = in.readDouble();
		p.mass = in.readDouble();
		p.imgFileName = in.readString();
		return p;
}
}