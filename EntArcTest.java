//package www
//AutoCAD Entity--Arc
import java.util.*;
//import java.util.HashMap;

/**
*@author David Wu<809758521@qq.com>
*@version 0.5
*/
public class EntArcTest{
 
    public static void  main(String[] args) {
        EntArc myarc = new EntArc(10,10,35,0,90);

        System.out.println("Test toString: ");
        System.out.println(myarc);
        System.out.println();

        myarc.Print2D();
        myarc.Print3D();
        myarc.PrintAll();
        System.out.println();

	   	List<String []>  myMap = myarc.GetPairData();
        System.out.println("List's Size: "+myMap.size());
		for (String [] key : myMap) {
		   System.out.println("key= "+ key[0] + "\t\t\tvalue= " + key[1]);
		}
		System.out.println();
		
        List<String> dxf_str = myarc.GetDXFData();
        System.out.println("DXF's Size: "+dxf_str.size());
        for (int i  =  0; i < dxf_str.size(); i++) {
            System.out.println(dxf_str.get(i)); 
        }
    }

}