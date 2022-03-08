class Solution {

    double radius;
    double x;
    double y;
    
    public Solution(double radius, double x_center, double y_center) {
        this.radius=radius;
        this.x=x_center;
        this.y=y_center;
    }
    
    public double[] randPoint() {
        double len= Math.sqrt(Math.random())*radius;
        double radians=Math.random()*2.0*Math.PI;
        double x_1 = this.x + Math.sin(radians)*len;//this.radius;
        double y_1 = this.y + Math.cos(radians)*len;//this.radius;
        double[] ans = new double[2];
        ans[0]=x_1;
        ans[1]=y_1;
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */