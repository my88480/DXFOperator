//package www
//AutoCAD Entity--Circle
import java.util.*;
//import java.util.HashMap;

/**
*@author David Wu<809758521@qq.com>
*@version 0.5
*/
public class EntCircleTest{
 
    public static void  main(String[] args) {
        EntCircle mycircle = new EntCircle(10,10,35);

        System.out.println("Test toString: ");
        System.out.println(mycircle);
        System.out.println();

        mycircle.Print2D();
        mycircle.Print3D();
        mycircle.PrintAll();
        System.out.println();

	   	List<String []>  myMap = mycircle.GetPairData();
        System.out.println("List's Size: "+myMap.size());
		for (String [] key : myMap) {
		   System.out.println("key= "+ key[0] + "\t\t\tvalue= " + key[1]);
		}
		System.out.println();
		
        List<String> dxf_str = mycircle.GetDXFData();
        System.out.println("DXF's Size: "+dxf_str.size());
        for (int i  =  0; i < dxf_str.size(); i++) {
            System.out.println(dxf_str.get(i)); 
        }
		System.out.println("toString method test:");
		System.out.println(mycircle);
    }

}