//package www
//AutoCAD Entity--Text
import java.util.*;
//import java.io.*;

/**
 * @author David Wu <809758521@qq.com>
 * @version V0.2
 * 2018-11-30 Ver 0.1 standlone class  --David Wu
 * 2018-12-2  Ver 0.2 based on wText class --David Wu
 * to test Entity Text of AutoCAD DXF file.
 */
public class EntTextTest{
    /** 
     * Title:string2HexString 
     * Description:String to HexString 
     * @param strPart 
     *            String 
     * @return HexString 
     */  
    public static String string2HexString(String strPart) {  
        StringBuffer hexString = new StringBuffer();  
        for (int i = 0; i < strPart.length(); i++) {  
            int ch = (int) strPart.charAt(i);  
            String strHex = Integer.toHexString(ch);  
            hexString.append(strHex);  
        }  
        return hexString.toString();  
    }  
  	
	
	public static void  main(String[] args)  throws Exception{
		
		//EntText text1 = new EntText();
		//text1.Print2D();
		//System.out.println("length: " + text1.text.length());
		//System.out.println("");
		EntText text2 = new EntText(60,0,16,"This is a test for EntText Hight 16.");
		text2.Print2D();
		System.out.println("");
		EntText text3 = new EntText(65,0,0,8,"This is mine.\r\nTo test 3D base point TEXT Construction\rline 3\nline 4");
		text3.Print3D();
		text3.Print2D();
		System.out.println("");

	   	List<String []>  myMap = text3.GetPairData();
        System.out.println("List's Size: "+myMap.size());
		for (String [] key : myMap) {
		   System.out.println("key= "+ key[0] + "\t\t\tvalue= " + key[1]);
		}
		System.out.println();
		
		List<String> dxf_str = text3.GetDXFData();
		System.out.println("DXF Data:");
		for (String s:dxf_str){
			System.out.println(s);
		}

		System.out.println("");
		
		System.out.println(text3.toString());
		System.out.println("");
		
		System.out.println(text3.layer);
		System.out.println(text3.style);
		
		text3.PrintAll();
		
		//System.out.println(string2HexString(System.getProperty("line.separator")+" \r  " + "\n"));
		
		
		String lines = "1\r2\r\n3\n4\r\n5"; 
		lines=lines.replace("\r\n","\n");
		lines=lines.replace("\n\r","\n");
		lines=lines.replace("\r","\n");
		String[] splitstr=lines.split("\n");
		System.out.println();	
		System.out.println(lines);
		
		System.out.println(string2HexString(lines));
		
		System.out.println("splitstr's size:  " + splitstr.length);	
		for (String s:splitstr){
			System.out.println("line:  " + s);
		}

		/*Require throws Exception, discarded the following codes.
		String mystr="This is a test.\r\nnew\rline3\nline4";
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader =  new BufferedReader(new StringReader(mystr));  
		String input;  
		while ((input= reader.readLine()) != null) {  
			System.out.println(input);  
		} 
		*/
	}

}