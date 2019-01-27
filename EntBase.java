//package www
//AutoCAD Entity base class
import java.util.*;
//import java.util.HashMap;
/**
 * @author David Wu <809758521@qq.com>
 * @version V0.2
 * Base Entity's Class Definition of layer,so far.
 */
public class EntBase{
    /**
     * code  8 -Layer.Default layer ----  "0"
     */
	public String layer = "0";

	public EntBase(){

	}
	
	public EntBase(String layer_value){
		layer = layer_value;
	}
	
	public void PrintAll(){
	   	List<String []>  myMap = this.GetPairData();
        System.out.println("Entity List's Size: "+myMap.size());
		for (String [] key : myMap) {
		   System.out.println("key= "+ key[0] + "\t\t\tvalue= " + key[1]);
		}
		System.out.println();		
		//System.out.println("Entity Base");
		//System.out.println("layer: "+this.layer);
	}		
	
	public List<String []> GetPairData(){
		List<String []> params=new ArrayList<>();

		params.add(new String[] {"Entity","BASE"});
		params.add(new String[] {"layer",this.layer});
		
		return params;
	}	
	
	public List<String> GetDXFData(){
		List<String> DXF_STR = new ArrayList<>();

		DXF_STR.add("  8");
		DXF_STR.add(layer);

		return DXF_STR;
	}	

	public String toString(){

		List<String> DXF_STR = new ArrayList<>();
		String returnString = new String();
			
		DXF_STR = this.GetDXFData();
			
		if (null != DXF_STR && DXF_STR.size() > 0) {
			String[] mListArray = DXF_STR.toArray(new String[DXF_STR.size()]);
			for (int i = 0; i < mListArray.length; i++) {
				if (i < mListArray.length - 1) {
					returnString += mListArray[i] + "\r\n";
				} else {
					returnString += mListArray[i];
			}
		}
    }
	
    return returnString;
    }
}