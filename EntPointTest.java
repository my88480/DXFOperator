//package www
//AutoCAD Entity--Point
import java.util.*;

/**
 * @author David Wu <809758521@qq.com>
 * @version V0.2
 * 2018-11-30 Ver 0.1 standlone class  --David Wu
 * 2018-12-2  Ver 0.2 based on wPoint class --David Wu
 * to test Entity Point of AutoCAD DXF file.
 */
public class EntPointTest{


	public static void  main(String[] args){
		
		EntPoint point1 = new EntPoint();
		point1.Print2D();
		System.out.println("");
		EntPoint point2 = new EntPoint(25,20);
		point2.Print2D();
		System.out.println("");
		EntPoint point3 = new EntPoint(12,55,22);
		point3.Print3D();
		point3.Print2D();
		System.out.println("");
		EntPoint point4 = new EntPoint(point3);
		point4.Print2D();
		point4.Print3D();
		point4.PrintAll();
		System.out.println("");
		int xx,yy;
		xx = 5;
		yy = 7;
		EntPoint point5 = new EntPoint(xx,yy);
		point5.PrintAll();
		System.out.println("");
		
		EntPoint point6 = new EntPoint(5.2314,3.12546,8.01234567890123456789);
		point6.PrintAll();
		System.out.println("");

	   	List<String []>  myMap = point6.GetPairData();
        System.out.println("List's Size: "+myMap.size());
		for (String [] key : myMap) {
		   System.out.println("key= "+ key[0] + "\t\t\tvalue= " + key[1]);
		}
		System.out.println();
		
		List<String> dxf_str = point6.GetDXFData();
		System.out.println("DXF Data:");
		for (String s:dxf_str){
			System.out.println(s);
		}
		/*
		for (int i  =  0; i < dxf_str.size(); i++) {
			System.out.println(dxf_str.get(i));  //.get(index)
		}
		*/
		System.out.println("");
		
		System.out.println(point6.toString());
		System.out.println("");
		
		System.out.println(point6.layer);
	}

}