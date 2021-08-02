public class NBody {

    public static double readRadius(String planetsTxtPath) {
        In in = new In(planetsTxtPath);
        in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String planetsTxtPath) {
        In in = new In(planetsTxtPath);

        int planetsNum = in.readInt();
        in.readDouble();

        Planet[] planets = new Planet[planetsNum];
        for (int i = 0; i < planetsNum; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }

        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.enableDoubleBuffering();

        // set scale
        StdDraw.setScale(-radius, radius);

        StdDraw.clear();

        double t = 0.0;
        while (t <= T) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            // draw
            StdDraw.picture(0, 0, "./images/starfield.jpg", radius * 2, radius * 2);
            for (Planet planet : planets) {
                String filepath = "./images/" + planet.imgFileName;
                StdDraw.picture(planet.xxPos, planet.yyPos, filepath);
            }
            StdDraw.show();
            StdDraw.pause(10);
            t += dt;
        }

    }

}
