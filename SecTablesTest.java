//package www
//AutoCAD Section -- Tables
import java.util.*;

/**
*@author David Wu<809758521@qq.com>
*@version 0.5
*/
public class SecTablesTest{

	
	public static void  main(String[] args)  throws Exception{
		SecTables mySecTables = new SecTables();

		mySecTables.PrintAll();
		System.out.println();
		
        System.out.println("Test toString method: ");
        System.out.println(mySecTables);
        System.out.println();

	   	List<String []>  myMap = mySecTables.GetPairData();
        System.out.println("PairData's Size: "+myMap.size());
		for (String [] key : myMap) {
		   System.out.println("key= "+ key[0] + "\t\t\tvalue= " + key[1]);
		}
		System.out.println();
		
		
		System.out.println("");
		System.out.println("DXF file's Content:");
		
        List<String> dxf_str = mySecTables.GetDXFData();
        for (int i  =  0; i < dxf_str.size(); i++) {
            System.out.println(dxf_str.get(i)); 
        }
    }

}

 