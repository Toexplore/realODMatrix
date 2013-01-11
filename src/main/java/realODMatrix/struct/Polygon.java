package main.java.realODMatrix.struct;

import java.util.ArrayList;

/**
 * @author Jags
 *
 */
public class Polygon {
	public ArrayList<Point> points;
	public double xmin;
	public double xmax;
	public double ymin;
	public double ymax;
	public int count;
	
	public Polygon(ArrayList<Point> points){
		this.points = points;
		this.count = points.size();
		
		this.xmin = Double.MAX_VALUE;
		this.xmax = Double.MIN_VALUE;
		this.ymin = Double.MAX_VALUE;
		this.ymax = Double.MIN_VALUE;
		for (Point p : points) {
			if(p.x>this.xmax)
				this.xmax = p.x;
			if(p.x<this.xmin)
				this.xmin = p.x;
			if(p.y>this.ymax)
				this.ymax = p.y;
			if(p.y<this.ymin)
				this.ymin = p.y;
		}	
	}
	
	public Boolean contains(Point p){
		
		if(p.x>=xmax||p.x<xmin||p.y>=ymax||p.y<ymin)
			return false;
		
		int cn = 0;
		int n = points.size();
		for (int i = 0; i < n - 1; i++) {
			if(points.get(i).y!=points.get(i+1).y&&!((p.y<points.get(i).y)&&(p.y<points.get(i+1).y))&&!((p.y>points.get(i).y)&&(p.y>points.get(i+1).y))){//rule#3: erase the condition of horizonal line
				double uy = 0;
				double by = 0;
				double ux = 0;
				double bx = 0;
				int dir = 0;
				if(points.get(i).y>points.get(i+1).y){
					uy = points.get(i).y;
					by = points.get(i+1).y;
					ux = points.get(i).x;
					bx = points.get(i+1).x;
					dir = 0;//downward
				}else{
					uy = points.get(i+1).y;
					by = points.get(i).y;
					ux = points.get(i+1).x;
					bx = points.get(i).x;
					dir = 1;//upward
				}
				
				double tx = 0;
				if(ux!=bx){
					double k = (uy-by)/(ux-bx);
					double b = ((uy-k*ux)+(by-k*bx))/2;
					tx = (p.y-b)/k;
				}else
					tx = ux;
				
				if(tx>p.x){//rule#4: the insect point should locate the right side of p
					if(dir==1&&p.y!=points.get(i+1).y)//rule#1: upward do not count the last point
						cn++;
					else if(p.y!=points.get(i).y)//rule#2: downward do not count the first point
						cn++;
				}
			}
		}
		if(cn%2==0)
			return false;
		else
			return true;
	}
	
	
	
	
}
