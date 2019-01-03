//package www
//AutoCAD Entity--Point
import java.util.*;
//import java.util.HashMap;
/**
* Test the class- wPoint
*/

public class wPointTest{

	
	public static void  main(String[] args)  throws Exception{
		wPoint point1=new wPoint();
		point1.Print2D();
		System.out.println(""); 
		
		wPoint point2=new wPoint(25,20);
		point2.Print2D();
		System.out.println(""); 
		
		wPoint point3=new wPoint(12,55,22);
		point3.Print3D();
		point3.Print2D();
		System.out.println(""); 
		
		wPoint point4=new wPoint(point3);
		point4.Print2D();
		point4.Print3D();
		point4.PrintAll();
		System.out.println(""); 
		
		int xx,yy;
		xx=5;
		yy=7;
		wPoint point5=new wPoint(xx,yy);
		point5.PrintAll();
		System.out.println(""); 
		
		wPoint point6=new wPoint(255.01234567890123456789,2545.01234567890123456789,8.01234567890123456789);
		point6.PrintAll();
		System.out.println(""); 
		
		System.out.println(point6.toString());
		System.out.println(""); 

		wPoint point7=new wPoint();
		for (int i = 0; i < 16; i++) {
			point7.x=1000*(new Random().nextDouble());
			point7.y=1000*(new Random().nextDouble());
			point7.z=1000*(new Random().nextDouble());
			point7.Print3D();
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
	}

}