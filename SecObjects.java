//package www
//AutoCAD Section -- Objects
import java.util.*;

/**
*@author David Wu<809758521@qq.com>
*@version 0.5
*/
public class SecObjects{

    /**
     * code  0 -Entity section header.
     */
    public String SectionHeader = "SECTION";

    /**
     * code  0 -Entity section name.
     */
    public String SectionName = "OBJECTS";

    /**
     * code  0 -Entity section END.
     */
    public String SectionTail = "ENDSEC";

	
    /**
     * Constructor (empty).
     */
    public SecObjects() {
		
    }


    /**
     * Constructor (one_objects_section)
     * @param one_objects_section -one object derived from class SecObjects;
     */
    public SecObjects(SecObjects one_objects_section) {
		/*
        this.start_point = one_objects_section.start_point;
        this.end_point = one_objects_section.end_point;

        this.thickness = one_objects_section.thickness;
        this.xExtrusionDirection = one_objects_section.xExtrusionDirection;
        this.yExtrusionDirection = one_objects_section.yExtrusionDirection;
        this.zExtrusionDirection = one_objects_section.zExtrusionDirection;
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
		"OBJECTS",
		"  0",
		"DICTIONARY",
		"  5",
		"C",
		"330",
		"0",
		"100",
		"AcDbDictionary",
		"281",
		"     1",
		"  3",
		"ACAD_GROUP",
		"350",
		"D",
		"  3",
		"ACAD_PLOTSTYLENAME",
		"350",
		"E",
		"  3",
		"ACAD_MLINESTYLE",
		"350",
		"17",
		"  3",
		"ACAD_PLOTSETTINGS",
		"350",
		"19",
		"  3",
		"ACAD_LAYOUT",
		"350",
		"1A",
		"  0",
		"DICTIONARY",
		"  5",
		"D",
		"102",
		"{ACAD_REACTORS",
		"330",
		"C",
		"102",
		"}",
		"330",
		"C",
		"100",
		"AcDbDictionary",
		"281",
		"     1",
		"  0",
		"ACDBDICTIONARYWDFLT",
		"  5",
		"E",
		"102",
		"{ACAD_REACTORS",
		"330",
		"C",
		"102",
		"}",
		"330",
		"C",
		"100",
		"AcDbDictionary",
		"281",
		"     1",
		"  3",
		"Normal",
		"350",
		"F",
		"100",
		"AcDbDictionaryWithDefault",
		"340",
		"F",
		"  0",
		"DICTIONARY",
		"  5",
		"17",
		"102",
		"{ACAD_REACTORS",
		"330",
		"C",
		"102",
		"}",
		"330",
		"C",
		"100",
		"AcDbDictionary",
		"281",
		"     1",
		"  3",
		"Standard",
		"350",
		"18",
		"  0",
		"DICTIONARY",
		"  5",
		"19",
		"102",
		"{ACAD_REACTORS",
		"330",
		"C",
		"102",
		"}",
		"330",
		"C",
		"100",
		"AcDbDictionary",
		"281",
		"     1",
		"  0",
		"DICTIONARY",
		"  5",
		"1A",
		"102",
		"{ACAD_REACTORS",
		"330",
		"C",
		"102",
		"}",
		"330",
		"C",
		"100",
		"AcDbDictionary",
		"281",
		"     1",
		"  3",
		"Layout1",
		"350",
		"1E",
		"  3",
		"Model",
		"350",
		"22",
		"  3",
		"Layout2",
		"350",
		"26",
		"  0",
		"ACDBPLACEHOLDER",
		"  5",
		"F",
		"102",
		"{ACAD_REACTORS",
		"330",
		"E",
		"102",
		"}",
		"330",
		"E",
		"  0",
		"MLINESTYLE",
		"  5",
		"18",
		"102",
		"{ACAD_REACTORS",
		"330",
		"17",
		"102",
		"}",
		"330",
		"17",
		"100",
		"AcDbMlineStyle",
		"  2",
		"STANDARD",
		" 70",
		"     0",
		"  3",
		"",
		" 62",
		"   256",
		" 51",
		"90.0",
		" 52",
		"90.0",
		" 71",
		"     2",
		" 49",
		"0.5",
		" 62",
		"   256",
		"  6",
		"BYLAYER",
		" 49",
		"-0.5",
		" 62",
		"   256",
		"  6",
		"BYLAYER",
		"  0",
		"LAYOUT",
		"  5",
		"1E",
		"102",
		"{ACAD_REACTORS",
		"330",
		"1A",
		"102",
		"}",
		"330",
		"1A",
		"100",
		"AcDbPlotSettings",
		"  1",
		"",
		"  2",
		"Microsoft XPS Document Writer",
		"  4",
		"",
		"  6",
		"",
		" 40",
		"0.0",
		" 41",
		"0.0",
		" 42",
		"0.0",
		" 43",
		"0.0",
		" 44",
		"0.0",
		" 45",
		"0.0",
		" 46",
		"0.0",
		" 47",
		"0.0",
		" 48",
		"0.0",
		" 49",
		"0.0",
		"140",
		"0.0",
		"141",
		"0.0",
		"142",
		"1.0",
		"143",
		"1.0",
		" 70",
		"   688",
		" 72",
		"     0",
		" 73",
		"     0",
		" 74",
		"     5",
		"  7",
		"",
		" 75",
		"    16",
		"147",
		"1.0",
		"148",
		"0.0",
		"149",
		"0.0",
		"100",
		"AcDbLayout",
		"  1",
		"Layout1",
		" 70",
		"     1",
		" 71",
		"     1",
		" 10",
		"0.0",
		" 20",
		"0.0",
		" 11",
		"420.0",
		" 21",
		"297.0",
		" 12",
		"0.0",
		" 22",
		"0.0",
		" 32",
		"0.0",
		" 14",
		"1.000000000000000E+20",
		" 24",
		"1.000000000000000E+20",
		" 34",
		"1.000000000000000E+20",
		" 15",
		"-1.000000000000000E+20",
		" 25",
		"-1.000000000000000E+20",
		" 35",
		"-1.000000000000000E+20",
		"146",
		"0.0",
		" 13",
		"0.0",
		" 23",
		"0.0",
		" 33",
		"0.0",
		" 16",
		"1.0",
		" 26",
		"0.0",
		" 36",
		"0.0",
		" 17",
		"0.0",
		" 27",
		"1.0",
		" 37",
		"0.0",
		" 76",
		"     0",
		"330",
		"1B",
		"  0",
		"LAYOUT",
		"  5",
		"22",
		"102",
		"{ACAD_REACTORS",
		"330",
		"1A",
		"102",
		"}",
		"330",
		"1A",
		"100",
		"AcDbPlotSettings",
		"  1",
		"",
		"  2",
		"Microsoft XPS Document Writer",
		"  4",
		"",
		"  6",
		"",
		" 40",
		"0.0",
		" 41",
		"0.0",
		" 42",
		"0.0",
		" 43",
		"0.0",
		" 44",
		"0.0",
		" 45",
		"0.0",
		" 46",
		"0.0",
		" 47",
		"0.0",
		" 48",
		"0.0",
		" 49",
		"0.0",
		"140",
		"0.0",
		"141",
		"0.0",
		"142",
		"1.0",
		"143",
		"1.0",
		" 70",
		"  1712",
		" 72",
		"     0",
		" 73",
		"     0",
		" 74",
		"     0",
		"  7",
		"",
		" 75",
		"     0",
		"147",
		"1.0",
		"148",
		"0.0",
		"149",
		"0.0",
		"100",
		"AcDbLayout",
		"  1",
		"Model",
		" 70",
		"     1",
		" 71",
		"     0",
		" 10",
		"0.0",
		" 20",
		"0.0",
		" 11",
		"12.0",
		" 21",
		"9.0",
		" 12",
		"0.0",
		" 22",
		"0.0",
		" 32",
		"0.0",
		" 14",
		"0.0",
		" 24",
		"0.0",
		" 34",
		"0.0",
		" 15",
		"0.0",
		" 25",
		"0.0",
		" 35",
		"0.0",
		"146",
		"0.0",
		" 13",
		"0.0",
		" 23",
		"0.0",
		" 33",
		"0.0",
		" 16",
		"1.0",
		" 26",
		"0.0",
		" 36",
		"0.0",
		" 17",
		"0.0",
		" 27",
		"1.0",
		" 37",
		"0.0",
		" 76",
		"     0",
		"330",
		"1F",
		"  0",
		"LAYOUT",
		"  5",
		"26",
		"102",
		"{ACAD_REACTORS",
		"330",
		"1A",
		"102",
		"}",
		"330",
		"1A",
		"100",
		"AcDbPlotSettings",
		"  1",
		"",
		"  2",
		"Microsoft XPS Document Writer",
		"  4",
		"",
		"  6",
		"",
		" 40",
		"0.0",
		" 41",
		"0.0",
		" 42",
		"0.0",
		" 43",
		"0.0",
		" 44",
		"0.0",
		" 45",
		"0.0",
		" 46",
		"0.0",
		" 47",
		"0.0",
		" 48",
		"0.0",
		" 49",
		"0.0",
		"140",
		"0.0",
		"141",
		"0.0",
		"142",
		"1.0",
		"143",
		"1.0",
		" 70",
		"   688",
		" 72",
		"     0",
		" 73",
		"     0",
		" 74",
		"     5",
		"  7",
		"",
		" 75",
		"    16",
		"147",
		"1.0",
		"148",
		"0.0",
		"149",
		"0.0",
		"100",
		"AcDbLayout",
		"  1",
		"Layout2",
		" 70",
		"     1",
		" 71",
		"     2",
		" 10",
		"0.0",
		" 20",
		"0.0",
		" 11",
		"12.0",
		" 21",
		"9.0",
		" 12",
		"0.0",
		" 22",
		"0.0",
		" 32",
		"0.0",
		" 14",
		"0.0",
		" 24",
		"0.0",
		" 34",
		"0.0",
		" 15",
		"0.0",
		" 25",
		"0.0",
		" 35",
		"0.0",
		"146",
		"0.0",
		" 13",
		"0.0",
		" 23",
		"0.0",
		" 33",
		"0.0",
		" 16",
		"1.0",
		" 26",
		"0.0",
		" 36",
		"0.0",
		" 17",
		"0.0",
		" 27",
		"1.0",
		" 37",
		"0.0",
		" 76",
		"     0",
		"330",
		"23",
		"  0",
		"ENDSEC"
	};
}

 