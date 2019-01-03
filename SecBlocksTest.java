//package www
//AutoCAD Section -- Blocks
import java.util.*;

/**
*@author David Wu<809758521@qq.com>
*@version 0.5
*/
public class SecBlocksTest{

	
	public static void  main(String[] args)  throws Exception{
		SecBlocks mySecBlocks = new SecBlocks();

		mySecBlocks.PrintAll();
		System.out.println();
		
        System.out.println("Test toString method: ");
        System.out.println(mySecBlocks);
        System.out.println();

	   	List<String []>  myMap = mySecBlocks.GetPairData();
        System.out.println("PairData's Size: "+myMap.size());
		for (String [] key : myMap) {
		   System.out.println("key= "+ key[0] + "\t\t\tvalue= " + key[1]);
		}
		System.out.println();
		
		
		System.out.println("");
		System.out.println("DXF file's Content:");
		
        List<String> dxf_str = mySecBlocks.GetDXFData();
        for (int i  =  0; i < dxf_str.size(); i++) {
            System.out.println(dxf_str.get(i)); 
        }
    }

}

 