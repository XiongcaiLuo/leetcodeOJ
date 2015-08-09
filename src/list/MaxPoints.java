package oj;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

 class Point {
	      int x;
	      int y;
	      Point() { x = 0; y = 0; }
	      Point(int a, int b) { x = a; y = b; }
	  }
public class MaxPoints {

	/**
	 * @param args
	 */
	public static int getMax(Point[]points,Point ax){
		int originx=ax.x;
		int originy=ax.y;
		 HashMap<Double,Integer > slops=new HashMap<Double,Integer >();
		 int zeroNum=0;
		 int len=points.length;
		 for(int i=0;i<len;i++){
			 if(points[i].x==originx && points[i].y==originy) {
				 zeroNum++;
				 continue;
			 }
			 
			 if(points[i].x==originx){
				 if(slops.containsKey(Double.MAX_VALUE)){
					 int count=slops.get(Double.MAX_VALUE);
					 slops.put(Double.MAX_VALUE, count+1);
				 }
				 else slops.put(Double.MAX_VALUE, 1);
			 }
			 else{
				 double slop=1.0*(points[i].y-originy)/(points[i].x-originx);
				 if(slops.containsKey(slop)){
					 int count=slops.get(slop);
					 slops.put(slop, count+1);
				 }
				 else slops.put(slop, 1);
			 }				 
		 }
		 

		 int max=0;
		 Iterator<Entry<Double, Integer>> ite=slops.entrySet().iterator();
		 while(ite.hasNext()){
			 Entry entry=ite.next();
			 int value=(Integer) entry.getValue();
			 if(value>max)
				 max=value;
		 }
		 return max+zeroNum;
		 
	}
	 public static int maxPoints(Point[] points) {
		 if(points==null)return 0;
		 else if(points.length==0) return 0;
		 else if(points.length==1) return 1;
		 else if(points.length==2) return 2;
		 int max=0;
		 for(int i=0;i<points.length;i++){
			 int temp=getMax(points,points[i]);
			 if(temp>max)
				 max=temp;
		 }
		 return max;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] a=new Point[3];
		a[0]=new Point(2,0);
		a[1]=new Point(1,0);
		a[2]=new Point(3,0);
		System.out.println(maxPoints(a));
		

	}

}
