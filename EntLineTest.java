//package www
//AutoCAD Entity--Line
import java.util.*;
//import java.util.HashMap;

/**
*@author David Wu<809758521@qq.com>
*@version 0.5
*/
public class EntLineTest{
 
    public static void  main(String[] args) {
        EntLine myline = new EntLine(10,10,10,50.2314,30.12546,80.01234567890123456789);

        System.out.println("Test toString: ");
        System.out.println(myline);
        System.out.println();

        myline.Print2D();
        myline.Print3D();
        myline.PrintAll();
        System.out.println();

	   	List<String []>  myMap = myline.GetPairData();
        System.out.println("List's Size: "+myMap.size());
		for (String [] key : myMap) {
		   System.out.println("key= "+ key[0] + "\t\t\tvalue= " + key[1]);
		}
		System.out.println();
		
        List<String> dxf_str = myline.GetDXFData();
        System.out.println("DXF's Size: "+dxf_str.size());
        for (int i  =  0; i < dxf_str.size(); i++) {
            System.out.println(dxf_str.get(i)); 
        }
    }

}