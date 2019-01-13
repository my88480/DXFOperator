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
		
		wPoint2D	Po = new wPoint2D(0.0,0.0);
		wPoint2D	Pa = new wPoint2D(263.36975126607098,2.3957480654137759);
		wPoint2D	Pb = new wPoint2D(2.1626945149204699,263.37176812099699);
		
		EntArc myarc2 = new EntArc(Po,Pa,Pb);
		myarc2.PrintAll();
		
		for (double a=-1.0;a<=1.0;a=a+0.1){
			System.out.println("a=" + a + "  angle=" + Math.acos(a)*180.0/Math.PI);
		}
    }

}