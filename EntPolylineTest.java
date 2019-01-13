//package www
//AutoCAD Entity--Line
import java.util.*;
//import java.util.HashMap;

/**
*@author David Wu<809758521@qq.com>
*@version 0.5
*/
public class EntPolylineTest{

	public static void  main(String[] args) {
		EntPolyline myPolyline = new EntPolyline();

		myPolyline.AddVertex(new EntVertex(2,2));
		myPolyline.AddVertex(new EntVertex(6,8));
		myPolyline.AddVertex(new EntVertex(10,10));
		myPolyline.AddVertex(new EntVertex(15,8));
		myPolyline.AddVertex(new EntVertex(10,5));
		myPolyline.AddVertex(new EntVertex(8,0));
		
		System.out.println( myPolyline);
		System.out.println();
		
		System.out.println("The length of the polyline: " + myPolyline.GetLength());
		System.out.println();
		
		System.out.println("The size of the polyline: " + myPolyline.GetSize());
		System.out.println();
		
        System.out.println("List's Size: " + myPolyline.vertexs.size());

        for (int i  =  0; i < myPolyline.vertexs.size(); i++) {
			System.out.println("NO. " + i);
            System.out.println(myPolyline.vertexs.get(i)); 
            System.out.println(myPolyline.vertexs.get(i).base_point.x); 
            myPolyline.vertexs.get(i).Print3D(); 
            myPolyline.vertexs.get(i).PrintAll(); 
			System.out.println();
       }

	   	List<String []>  myMap = myPolyline.GetPairData();
        System.out.println("List's Size: "+myMap.size());
 	    
		int no = 1;
		for (String [] key : myMap) {
		   System.out.println("no." + no + ":   key= "+ key[0] + "\t\t\tvalue= " + key[1]);
		   no++;
		}
		System.out.println();

        List<String> dxf_str = myPolyline.GetDXFData();
        for (int i  =  0; i < dxf_str.size(); i++) {
            System.out.println(dxf_str.get(i)); 
        }
	
		double[][] points={{20,20,20},{25,30},{30,35}};
	    EntPolyline myPolyline2 = new EntPolyline(points);
		System.out.println("The second Polyline: ");
		System.out.println(myPolyline2);
    }
}