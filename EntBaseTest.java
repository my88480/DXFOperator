//package www
//AutoCAD Entity--Point
import java.util.*;
//import java.util.HashMap;
/**
 * @author David Wu <809758521@qq.com>
 * @version V0.2
 * to test Base Entity's Class Definition of layer,so far.
 */
public class EntBaseTest{

	public static void  main(String[] args){
		EntBase ent_base;
		
		ent_base = new EntBase();

        System.out.println("Test toString: ");
        System.out.println(ent_base);
        System.out.println();
		
		ent_base.PrintAll();
		System.out.println("");

	   	List<String []>  myMap = ent_base.GetPairData();
        System.out.println("List's Size: "+myMap.size());
		for (String [] key : myMap) {
		   System.out.println("key= "+ key[0] + "\t\t\tvalue= " + key[1]);
		}
		System.out.println();

		
		List<String> dxf_str = ent_base.GetDXFData();
		System.out.println(dxf_str);
		System.out.println("");


		for (int i  =  0; i < dxf_str.size(); i++) {
			System.out.println(dxf_str.get(i)); 
		}
		
		ent_base.PrintAll();

	}

}