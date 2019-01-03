//package www
//AutoCAD Entity--Vertex test
import java.util.*;

/**
 * @author David Wu <809758521@qq.com>
 * @version V0.2
 * 2018-11-30 Ver 0.1 standlone class  --David Wu
 * 2018-12-2  Ver 0.2 based on wPoint class --David Wu
 * to test Entity Point of AutoCAD DXF file.
 */
public class EntVertexTest{


	public static void  main(String[] args){
		
		EntVertex vertex1 = new EntVertex();
		vertex1.Print2D();
		System.out.println("");
		EntVertex vertex2 = new EntVertex(25,20);
		vertex2.Print2D();
		System.out.println("");
		EntVertex vertex3 = new EntVertex(12,55,22);
		vertex3.Print3D();
		vertex3.Print2D();
		System.out.println("");
		EntVertex vertex4 = new EntVertex(vertex3);
		vertex4.Print2D();
		vertex4.Print3D();
		vertex4.PrintAll();
		System.out.println("");
		int xx,yy;
		xx = 5;
		yy = 7;
		EntVertex vertex5 = new EntVertex(xx,yy);
		vertex5.PrintAll();
		System.out.println("");
		
		EntVertex vertex6 = new EntVertex(5.2314,3.12546,8.01234567890123456789);
		vertex6.PrintAll();
		System.out.println("");

		List<String []> myMap = vertex6.GetPairData();
        System.out.println("Map's Size: "+myMap.size());
		for (String [] key : myMap) {
		   System.out.println("key= "+ key[0] + "\t\t\tvalue= " + key[1]);
		}
		System.out.println();

		List<String> dxf_str = vertex6.GetDXFData();

		for (String s:dxf_str){
			System.out.println(s);
		}
		/*
		for (int i  =  0; i < dxf_str.size(); i++) {
			System.out.println(dxf_str.get(i)); 
		}
		*/
		System.out.println("");
		
		System.out.println(vertex6.toString());
		System.out.println("");
		
		System.out.println(vertex6.layer);
	}

}