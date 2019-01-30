//package www
//AutoCAD Section -- Classes
import java.util.*;

/**
*@author David Wu<809758521@qq.com>
*@version 0.5
*/
public class SecClasses{

    /**
     * code  0 -Entity section header.
     */
    public String SectionHeader = "SECTION";

    /**
     * code  0 -Entity section name.
     */
    public String SectionName = "CLASSES";

    /**
     * code  0 -Entity section END.
     */
    public String SectionTail = "ENDSEC";

	
    /**
     * Constructor (empty).
     */
    public SecClasses() {
		
    }


    /**
     * Constructor (one_classes_section)
     * @param one_classes_section -one object derived from class SecClasses;
     */
    public SecClasses(SecClasses one_classes_section) {
		/*
        this.start_point = one_classes_section.start_point;
        this.end_point = one_classes_section.end_point;

        this.thickness = one_classes_section.thickness;
        this.xExtrusionDirection = one_classes_section.xExtrusionDirection;
        this.yExtrusionDirection = one_classes_section.yExtrusionDirection;
        this.zExtrusionDirection = one_classes_section.zExtrusionDirection;
		*/
    }

    /**
     * PrintAll()
     * <pre>Terminal output the description of start_point and end_point.(serveral lines)
	 * Output example:
	 * </pre>	 
     */
    public void PrintAll() {
	   	List<String []>  myMap = this.GetPairData();
        System.out.println("Entity List's Size: "+myMap.size());
		for (String [] key : myMap) {
		   System.out.println("key= "+ key[0] + "\t\t\tvalue= " + key[1]);
		}
		System.out.println();		

		/*
		System.out.println("SectionHeader: " + this.SectionHeader);
        System.out.println("SectionName: " + this.SectionName);
		
        System.out.println("SectionTail: " + this.SectionTail);
		*/
    }

    /**
     * GetPairData()
     * @return Map of elements description of Entity LINE.
	 * <pre>Output example:
	 * </pre>
     */
	public List<String []> GetPairData(){
		List<String []> params=new ArrayList<>();
		
		for (int i=0;i< StdSectionStr_R2K.length / 2; i= i + 2){
			params.add(new String[] {StdSectionStr_R2K[i],StdSectionStr_R2K[i+1]});
		}
		/*
		params.add(new String[] {"  0",this.SectionHeader});
		params.add(new String[] {"  2",this.SectionName});
		params.add(new String[] {"  0",this.SectionTail});
		*/
        return params;
    }

    /**
     * GetDXFData()
     * @return the dxf data of entity line.
	 * <pre>Output example:
	 * </pre>
     */
    public List<String> GetDXFData() {

		List<String> DXF_STR = new ArrayList<>();
		/*
        DXF_STR.add("  0");
        DXF_STR.add(this.SectionHeader);
        DXF_STR.add("  2");
        DXF_STR.add(this.SectionName);
            
        DXF_STR.add("  0");
        DXF_STR.add(this.SectionTail);
		*/
		
		for (int i=0;i< StdSectionStr_R2K.length;i++){
			DXF_STR.add(StdSectionStr_R2K[i]);
		}
		
        return DXF_STR;
    }

    public String toString() {
		/* require the jar file --- common-lang3
		List<String> DXF_STR = new ArrayList<>();
		String returnString = new String();
		
        DXF_STR = this.GetDXFData();
		returnString = String.join(",",DXF_STR);
		*/

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

	public String[] StdSectionStr_R2K = {
		"  0",
		"SECTION",
		"  2",
		"CLASSES",
		"  0",
		"CLASS",
		"  1",
		"ACDBDICTIONARYWDFLT",
		"  2",
		"AcDbDictionaryWithDefault",
		"  3",
		"AutoCAD 2000",
		" 90",
		"        0",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"ACDBPLACEHOLDER",
		"  2",
		"AcDbPlaceHolder",
		"  3",
		"AutoCAD 2000",
		" 90",
		"        0",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"LAYOUT",
		"  2",
		"AcDbLayout",
		"  3",
		"AutoCAD 2000",
		" 90",
		"        0",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"ENDSEC"		
	};
}

 