//package www
//AutoCAD Section -- Tables
import java.util.*;

/**
*@author David Wu<809758521@qq.com>
*@version 0.5
*/
public class SecTables{

    /**
     * code  0 -Entity section header.
     */
    public String SectionHeader = "SECTION";

    /**
     * code  0 -Entity section name.
     */
    public String SectionName = "TABLES";

    /**
     * code  0 -Entity section END.
     */
    public String SectionTail = "ENDSEC";

	
    /**
     * Constructor (empty).
     */
    public SecTables() {
		
    }


    /**
     * Constructor (one_Tables_section)
     * @param one_Tables_section -one object derived from class SecTables;
     */
    public SecTables(SecTables one_Tables_section) {
		/*
        this.start_point = one_Tables_section.start_point;
        this.end_point = one_Tables_section.end_point;

        this.thickness = one_Tables_section.thickness;
        this.xExtrusionDirection = one_Tables_section.xExtrusionDirection;
        this.yExtrusionDirection = one_Tables_section.yExtrusionDirection;
        this.zExtrusionDirection = one_Tables_section.zExtrusionDirection;
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
		"TABLES",
		"  0",
		"TABLE",
		"  2",
		"VPORT",
		"  5",
		"8",
		"330",
		"0",
		"100",
		"AcDbSymbolTable",
		" 70",
		"     3",
		"  0",
		"VPORT",
		"  5",
		"31",
		"330",
		"8",
		"100",
		"AcDbSymbolTableRecord",
		"100",
		"AcDbViewportTableRecord",
		"  2",
		"*Active",
		" 70",
		"     0",
		" 10",
		"0.0",
		" 20",
		"0.0",
		" 11",
		"1.0",
		" 21",
		"1.0",
		" 12",
		"250.5538020086083",
		" 22",
		"148.5",
		" 13",
		"0.0",
		" 23",
		"0.0",
		" 14",
		"10.0",
		" 24",
		"10.0",
		" 15",
		"10.0",
		" 25",
		"10.0",
		" 16",
		"0.0",
		" 26",
		"0.0",
		" 36",
		"1.0",
		" 17",
		"0.0",
		" 27",
		"0.0",
		" 37",
		"0.0",
		" 40",
		"297.0",
		" 41",
		"1.687230989956958",
		" 42",
		"50.0",
		" 43",
		"0.0",
		" 44",
		"0.0",
		" 50",
		"0.0",
		" 51",
		"0.0",
		" 71",
		"     0",
		" 72",
		"   100",
		" 73",
		"     1",
		" 74",
		"     3",
		" 75",
		"     0",
		" 76",
		"     0",
		" 77",
		"     0",
		" 78",
		"     0",
		"281",
		"     0",
		" 65",
		"     1",
		"110",
		"0.0",
		"120",
		"0.0",
		"130",
		"0.0",
		"111",
		"1.0",
		"121",
		"0.0",
		"131",
		"0.0",
		"112",
		"0.0",
		"122",
		"1.0",
		"132",
		"0.0",
		" 79",
		"     0",
		"146",
		"0.0",
		"  0",
		"ENDTAB",
		"  0",
		"TABLE",
		"  2",
		"LTYPE",
		"  5",
		"5",
		"330",
		"0",
		"100",
		"AcDbSymbolTable",
		" 70",
		"     4",
		"  0",
		"LTYPE",
		"  5",
		"14",
		"330",
		"5",
		"100",
		"AcDbSymbolTableRecord",
		"100",
		"AcDbLinetypeTableRecord",
		"  2",
		"ByBlock",
		" 70",
		"     0",
		"  3",
		"",
		" 72",
		"    65",
		" 73",
		"     0",
		" 40",
		"0.0",
		"  0",
		"LTYPE",
		"  5",
		"15",
		"330",
		"5",
		"100",
		"AcDbSymbolTableRecord",
		"100",
		"AcDbLinetypeTableRecord",
		"  2",
		"ByLayer",
		" 70",
		"     0",
		"  3",
		"",
		" 72",
		"    65",
		" 73",
		"     0",
		" 40",
		"0.0",
		"  0",
		"LTYPE",
		"  5",
		"16",
		"330",
		"5",
		"100",
		"AcDbSymbolTableRecord",
		"100",
		"AcDbLinetypeTableRecord",
		"  2",
		"Continuous",
		" 70",
		"     0",
		"  3",
		"Solid line",
		" 72",
		"    65",
		" 73",
		"     0",
		" 40",
		"0.0",
		"  0",
		"LTYPE",
		"  5",
		"2D",
		"330",
		"5",
		"100",
		"AcDbSymbolTableRecord",
		"100",
		"AcDbLinetypeTableRecord",
		"  2",
		"CENTER",
		" 70",
		"     0",
		"  3",
		"Center ____ _ ____ _ ____ _ ____ _ ____ _ ____",
		" 72",
		"    65",
		" 73",
		"     4",
		" 40",
		"50.8",
		" 49",
		"31.75",
		" 74",
		"     0",
		" 49",
		"-6.349999999999999",
		" 74",
		"     0",
		" 49",
		"6.349999999999999",
		" 74",
		"     0",
		" 49",
		"-6.349999999999999",
		" 74",
		"     0",
		"  0",
		"LTYPE",
		"  5",
		"2E",
		"330",
		"5",
		"100",
		"AcDbSymbolTableRecord",
		"100",
		"AcDbLinetypeTableRecord",
		"  2",
		"DASHED",
		" 70",
		"     0",
		"  3",
		"Dashed __ __ __ __ __ __ __ __ __ __ __ __ __ _",
		" 72",
		"    65",
		" 73",
		"     2",
		" 40",
		"19.04999999999999",
		" 49",
		"12.7",
		" 74",
		"     0",
		" 49",
		"-6.349999999999999",
		" 74",
		"     0",
		"  0",
		"LTYPE",
		"  5",
		"2F",
		"330",
		"5",
		"100",
		"AcDbSymbolTableRecord",
		"100",
		"AcDbLinetypeTableRecord",
		"  2",
		"PHANTOM",
		" 70",
		"     0",
		"  3",
		"Phantom ______  __  __  ______  __  __  ______",
		" 72",
		"    65",
		" 73",
		"     6",
		" 40",
		"63.5",
		" 49",
		"31.75",
		" 74",
		"     0",
		" 49",
		"-6.349999999999999",
		" 74",
		"     0",
		" 49",
		"6.349999999999999",
		" 74",
		"     0",
		" 49",
		"-6.349999999999999",
		" 74",
		"     0",
		" 49",
		"6.349999999999999",
		" 74",
		"     0",
		" 49",
		"-6.349999999999999",
		" 74",
		"     0",
		"  0",
		"ENDTAB",
		"  0",
		"TABLE",
		"  2",
		"LAYER",
		"  5",
		"2",
		"330",
		"0",
		"100",
		"AcDbSymbolTable",
		" 70",
		"     1",
		"  0",
		"LAYER",
		"  5",
		"10",
		"330",
		"2",
		"100",
		"AcDbSymbolTableRecord",
		"100",
		"AcDbLayerTableRecord",
		"  2",
		"0",
		" 70",
		"     0",
		" 62",
		"     7",
		"  6",
		"Continuous",
		"370",
		"    -3",
		"390",
		"F",
		"  0",
		"ENDTAB",
		"  0",
		"TABLE",
		"  2",
		"STYLE",
		"  5",
		"3",
		"330",
		"0",
		"100",
		"AcDbSymbolTable",
		" 70",
		"     2",
		"  0",
		"STYLE",
		"  5",
		"11",
		"330",
		"3",
		"100",
		"AcDbSymbolTableRecord",
		"100",
		"AcDbTextStyleTableRecord",
		"  2",
		"Standard",
		" 70",
		"     0",
		" 40",
		"0.0",
		" 41",
		"0.65",
		" 50",
		"0.0",
		" 71",
		"     0",
		" 42",
		"2.5",
		"  3",
		"txt",
		"  4",
		"",
		"  0",
		"STYLE",
		"  5",
		"2C",
		"330",
		"3",
		"100",
		"AcDbSymbolTableRecord",
		"100",
		"AcDbTextStyleTableRecord",
		"  2",
		"",
		" 70",
		"     1",
		" 40",
		"0.0",
		" 41",
		"1.0",
		" 50",
		"0.0",
		" 71",
		"     0",
		" 42",
		"2.5",
		"  3",
		"ltypeshp.shx",
		"  4",
		"",
		"  0",
		"ENDTAB",
		"  0",
		"TABLE",
		"  2",
		"VIEW",
		"  5",
		"6",
		"330",
		"0",
		"100",
		"AcDbSymbolTable",
		" 70",
		"     0",
		"  0",
		"ENDTAB",
		"  0",
		"TABLE",
		"  2",
		"UCS",
		"  5",
		"7",
		"330",
		"0",
		"100",
		"AcDbSymbolTable",
		" 70",
		"     0",
		"  0",
		"ENDTAB",
		"  0",
		"TABLE",
		"  2",
		"APPID",
		"  5",
		"9",
		"330",
		"0",
		"100",
		"AcDbSymbolTable",
		" 70",
		"     1",
		"  0",
		"APPID",
		"  5",
		"12",
		"330",
		"9",
		"100",
		"AcDbSymbolTableRecord",
		"100",
		"AcDbRegAppTableRecord",
		"  2",
		"ACAD",
		" 70",
		"     0",
		"  0",
		"ENDTAB",
		"  0",
		"TABLE",
		"  2",
		"DIMSTYLE",
		"  5",
		"A",
		"330",
		"0",
		"100",
		"AcDbSymbolTable",
		" 70",
		"     1",
		"100",
		"AcDbDimStyleTable",
		" 71",
		"     0",
		"  0",
		"DIMSTYLE",
		"105",
		"27",
		"330",
		"A",
		"100",
		"AcDbSymbolTableRecord",
		"100",
		"AcDbDimStyleTableRecord",
		"  2",
		"ISO-25",
		" 70",
		"     0",
		" 41",
		"2.5",
		" 42",
		"0.625",
		" 43",
		"3.75",
		" 44",
		"1.25",
		" 73",
		"     0",
		" 74",
		"     0",
		" 77",
		"     1",
		" 78",
		"     8",
		"140",
		"2.5",
		"141",
		"2.5",
		"143",
		"0.03937007874016",
		"147",
		"0.625",
		"171",
		"     3",
		"172",
		"     1",
		"271",
		"     2",
		"272",
		"     2",
		"274",
		"     3",
		"278",
		"    44",
		"283",
		"     0",
		"284",
		"     8",
		"340",
		"11",
		"  0",
		"ENDTAB",
		"  0",
		"TABLE",
		"  2",
		"BLOCK_RECORD",
		"  5",
		"1",
		"330",
		"0",
		"100",
		"AcDbSymbolTable",
		" 70",
		"     1",
		"  0",
		"BLOCK_RECORD",
		"  5",
		"1F",
		"330",
		"1",
		"100",
		"AcDbSymbolTableRecord",
		"100",
		"AcDbBlockTableRecord",
		"  2",
		"*Model_Space",
		"340",
		"22",
		"  0",
		"BLOCK_RECORD",
		"  5",
		"1B",
		"330",
		"1",
		"100",
		"AcDbSymbolTableRecord",
		"100",
		"AcDbBlockTableRecord",
		"  2",
		"*Paper_Space",
		"340",
		"1E",
		"  0",
		"BLOCK_RECORD",
		"  5",
		"23",
		"330",
		"1",
		"100",
		"AcDbSymbolTableRecord",
		"100",
		"AcDbBlockTableRecord",
		"  2",
		"*Paper_Space0",
		"340",
		"26",
		"  0",
		"ENDTAB",
		"  0",
		"ENDSEC"
	};

}

 