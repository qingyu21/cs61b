public class Planet {

    // gravitational constant
    private static final double G = 6.67e-11;

    // current position
    public double xxPos;
    public double yyPos;
    // current velocity
    public double xxVel;
    public double yyVel;
    // mass
    public double mass;

    // The name of the file that corresponds to the image that depicts the planet
    public String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double dx = p.xxPos - xxPos;
        double dy = p.yyPos - yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Planet p) {
        double r = calcDistance(p);
        return G * mass * p.mass / (r * r);
    }

    public double calcForceExertedByX(Planet p) {
        double F = calcForceExertedBy(p);
        double dx = p.xxPos - xxPos;
        double r = calcDistance(p);
        return F * dx / r;
    }

    public double calcForceExertedByY(Planet p) {
        double F = calcForceExertedBy(p);
        double dy = p.yyPos - yyPos;
        double r = calcDistance(p);
        return F * dy / r;
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double result = 0;
        for (Planet planet : planets) {
            if (!equals(planet)) {
                result += calcForceExertedByX(planet);
            }
        }

        return result;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double result = 0;
        for (Planet planet : planets) {
            if (!equals(planet)) {
                result += calcForceExertedByY(planet);
            }
        }

        return result;
    }

    public void update(double dt, double Fx, double Fy) {
        double ax = Fx / mass;
        double ay = Fy / mass;
        xxVel = xxVel + dt * ax;
        yyVel = yyVel + dt * ay;
        xxPos = xxPos + dt * xxVel;
        yyPos = yyPos + dt * yyVel;
    }

    public void draw() {
        String filepath = "./images/" + imgFileName;
        StdDraw.picture(xxPos, yyPos, filepath);
    }

}
