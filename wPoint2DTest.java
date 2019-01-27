//package www
//AutoCAD Entity--Point
import java.util.*;

/**
* Test the class- wPoint2D
*/
public class wPoint2DTest{

	
	public static void  main(String[] args)  throws Exception{
		wPoint2D point1=new wPoint2D();
		point1.Print2D();
		System.out.println(""); 
		
		wPoint2D point2=new wPoint2D(25,20);
		point2.Print2D();
		System.out.println(""); 
		
		
		wPoint2D point4=new wPoint2D(point2);
		point4.Print2D();
		point4.PrintAll();
		System.out.println(""); 
		
		int xx,yy;
		xx=5;
		yy=7;
		wPoint2D point5=new wPoint2D(xx,yy);
		point5.PrintAll();
		System.out.println(""); 
		
		wPoint2D point6=new wPoint2D(255.01234567890123456789,2545.01234567890123456789);
		point6.PrintAll();
		System.out.println(""); 
		
		System.out.println(point6.toString());
		System.out.println(""); 

		wPoint2D point7=new wPoint2D();
		for (int i = 0; i < 16; i++) {
			point7.x=1000*(new Random().nextDouble());
			point7.y=1000*(new Random().nextDouble());
			point7.Print2D();
		}
		System.out.println(""); 

	   	List<String []>  myMap = point7.GetPairData();
        System.out.println("List's Size: "+myMap.size());
		for (String [] key : myMap) {
		   System.out.println("key= "+ key[0] + "\t\t\tvalue= " + key[1]);
		}
		System.out.println();
		
		for(int i = 0 ; i < myMap.size() ; i++) {
		  System.out.println(myMap.get(i)[0]);
		}
	
		List<String> dxf_str = point7.GetDXFData();
		System.out.println("The point's DXF string:"); 
		for (String s:dxf_str){
			System.out.println(s);
		}		
		
		//To test the radian angle of two points
		double R_Angle,D_Angle;
		point1 = new wPoint2D(0,0);
		point2 = new wPoint2D(10,10);
		R_Angle = point1.Angle2P(point1,point2);
		System.out.println("R_Angle=" + R_Angle);
		D_Angle = point1.Angle2P_D(point1,point2);
		System.out.println("D_Angle=" + D_Angle);
		point2 = new wPoint2D(-10,10);
		R_Angle = point1.Angle2P(point1,point2);
		System.out.println("R_Angle=" + R_Angle);
		D_Angle = point1.Angle2P_D(point1,point2);
		System.out.println("D_Angle=" + D_Angle);
		point2 = new wPoint2D(-10,-10);
		R_Angle = point1.Angle2P(point1,point2);
		System.out.println("R_Angle=" + R_Angle);
		D_Angle = point1.Angle2P_D(point1,point2);
		System.out.println("D_Angle=" + D_Angle);
		point2 = new wPoint2D(10,-10);
		R_Angle = point1.Angle2P(point1,point2);
		System.out.println("R_Angle=" + R_Angle);
		D_Angle = point1.Angle2P_D(point1,point2);
		System.out.println("D_Angle=" + D_Angle);
		
		point2 = new wPoint2D(-10,0);
		R_Angle = point1.Angle2P(point1,point2);
		System.out.println("R_Angle=" + R_Angle);
		D_Angle = point1.Angle2P_D(point1,point2);
		System.out.println("D_Angle=" + D_Angle);
		
		point2 = new wPoint2D(0,10);
		R_Angle = point1.Angle2P(point1,point2);
		System.out.println("R_Angle=" + R_Angle);
		D_Angle = point1.Angle2P_D(point1,point2);
		System.out.println("D_Angle=" + D_Angle);
		
		point2 = new wPoint2D(0,-10);
		R_Angle = point1.Angle2P(point1,point2);
		System.out.println("R_Angle=" + R_Angle);
		D_Angle = point1.Angle2P_D(point1,point2);
		System.out.println("D_Angle=" + D_Angle);
		
	}

}