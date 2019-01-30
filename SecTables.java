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
        System.out.println("SectionHeader: " + this.SectionHeader);
        System.out.println("SectionName: " + this.SectionName);
		
        System.out.println("SectionTail: " + this.SectionTail);
    }

    /**
     * GetPairData()
     * @return Map of elements description of Entity LINE.
	 * <pre>Output example:
	 * </pre>
     */
	public List<String []> GetPairData(){
		List<String []> params=new ArrayList<>();

		params.add(new String[] {"  0",this.SectionHeader});
		params.add(new String[] {"  2",this.SectionName});


		
		params.add(new String[] {"  0",this.SectionTail});

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
		
		for (int i=0;i< StdSectionStr_R12.length;i++){
			DXF_STR.add(StdSectionStr_R12[i]);
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

	public String[] StdSectionStr_R12 = {
		"  0",
		"SECTION",
		"  2",
		"TABLES",
		"  0",
		"TABLE",
		"  2",
		"VPORT",
		" 70",
		"     1",
		"  0",
		"VPORT",
		"  2",
		"*ACTIVE",
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
		"399.97558724333362",
		" 22",
		"303.28053349638412",
		" 13",
		"0.0",
		" 23",
		"0.0",
		" 14",
		"1.0",
		" 24",
		"1.0",
		" 15",
		"0.0",
		" 25",
		"0.0",
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
		"805.77452622675605",
		" 41",
		"2.204057279236276",
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
		"     1",
		" 75",
		"     0",
		" 76",
		"     0",
		" 77",
		"     0",
		" 78",
		"     0",
		"  0",
		"ENDTAB",
		"  0",
		"TABLE",
		"  2",
		"LTYPE",
		" 70",
		"     2",
		"  0",
		"LTYPE",
		"  2",
		"CONTINUOUS",
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
		"  2",
		"ACAD_ISO10W100",
		" 70",
		"     0",
		"  3",
		"ISO dash dot __ . __ . __ . __ . __ . __ . __ .",
		" 72",
		"    65",
		" 73",
		"     4",
		" 40",
		"18.0",
		" 49",
		"12.0",
		" 49",
		"-3.0",
		" 49",
		"0.0",
		" 49",
		"-3.0",
		"  0",
		"ENDTAB",
		"  0",
		"TABLE",
		"  2",
		"LAYER",
		" 70",
		"     4",
		"  0",
		"LAYER",
		"  2",
		"0",
		" 70",
		"     0",
		" 62",
		"     7",
		"  6",
		"CONTINUOUS",
		"  0",
		"LAYER",
		"  2",
		"DEFPOINTS",
		" 70",
		"     0",
		" 62",
		"     7",
		"  6",
		"CONTINUOUS",
		"  0",
		"LAYER",
		"  2",
		"CENTER",
		" 70",
		"     0",
		" 62",
		"     1",
		"  6",
		"ACAD_ISO10W100",
		"  0",
		"LAYER",
		"  2",
		"AUXILIARY",
		" 70",
		"     0",
		" 62",
		"     5",
		"  6",
		"CONTINUOUS",
		"  0",
		"ENDTAB",
		"  0",
		"TABLE",
		"  2",
		"STYLE",
		" 70",
		"     3",
		"  0",
		"STYLE",
		"  2",
		"STANDARD",
		" 70",
		"     0",
		" 40",
		"0.0",
		" 41",
		"1.0",
		" 50",
		"0.0",
		" 71",
		"     0",
		" 42",
		"0.2",
		"  3",
		"txt",
		"  4",
		"",
		"  0",
		"STYLE",
		"  2",
		"ANNOTATIVE",
		" 70",
		"     0",
		" 40",
		"0.0",
		" 41",
		"1.0",
		" 50",
		"0.0",
		" 71",
		"     0",
		" 42",
		"0.2",
		"  3",
		"txt",
		"  4",
		"",
		"  0",
		"STYLE",
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
		"0.2",
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
		" 70",
		"     1",
		"  0",
		"ENDTAB",
		"  0",
		"TABLE",
		"  2",
		"UCS",
		" 70",
		"     0",
		"  0",
		"ENDTAB",
		"  0",
		"TABLE",
		"  2",
		"APPID",
		" 70",
		"     7",
		"  0",
		"APPID",
		"  2",
		"ACAD",
		" 70",
		"     0",
		"  0",
		"APPID",
		"  2",
		"ACADANNOTATIVE",
		" 70",
		"     0",
		"  0",
		"APPID",
		"  2",
		"ACAD_MLEADERVER",
		" 70",
		"     0",
		"  0",
		"APPID",
		"  2",
		"ACAD_EXEMPT_FROM_CAD_STANDARDS",
		" 70",
		"     0",
		"  0",
		"APPID",
		"  2",
		"ACAD_DSTYLE_DIMJAG",
		" 70",
		"     0",
		"  0",
		"APPID",
		"  2",
		"ACAD_DSTYLE_DIMTALN",
		" 70",
		"     0",
		"  0",
		"APPID",
		"  2",
		"ACAECLAYERSTANDARD",
		" 70",
		"     0",
		"  0",
		"ENDTAB",
		"  0",
		"TABLE",
		"  2",
		"DIMSTYLE",
		" 70",
		"     2",
		"  0",
		"DIMSTYLE",
		"  2",
		"STANDARD",
		" 70",
		"     0",
		"  3",
		"",
		"  4",
		"",
		"  5",
		"",
		"  6",
		"",
		"  7",
		"",
		" 40",
		"50.0",
		" 41",
		"0.18",
		" 42",
		"0.0625",
		" 43",
		"0.38",
		" 44",
		"0.18",
		" 45",
		"0.0",
		" 46",
		"0.0",
		" 47",
		"0.0",
		" 48",
		"0.0",
		"140",
		"0.18",
		"141",
		"0.09",
		"142",
		"0.0",
		"143",
		"25.399999999999999",
		"144",
		"1.0",
		"145",
		"0.0",
		"146",
		"1.0",
		"147",
		"0.09",
		" 71",
		"     0",
		" 72",
		"     0",
		" 73",
		"     1",
		" 74",
		"     1",
		" 75",
		"     0",
		" 76",
		"     0",
		" 77",
		"     0",
		" 78",
		"     0",
		"170",
		"     0",
		"171",
		"     2",
		"172",
		"     0",
		"173",
		"     0",
		"174",
		"     0",
		"175",
		"     0",
		"176",
		"     6",
		"177",
		"     6",
		"178",
		"     0",
		"  0",
		"DIMSTYLE",
		"  2",
		"ANNOTATIVE",
		" 70",
		"     0",
		"  3",
		"",
		"  4",
		"",
		"  5",
		"",
		"  6",
		"",
		"  7",
		"",
		" 40",
		"1.0",
		" 41",
		"0.18",
		" 42",
		"0.0625",
		" 43",
		"0.38",
		" 44",
		"0.18",
		" 45",
		"0.0",
		" 46",
		"0.0",
		" 47",
		"0.0",
		" 48",
		"0.0",
		"140",
		"0.18",
		"141",
		"0.09",
		"142",
		"0.0",
		"143",
		"25.399999999999999",
		"144",
		"1.0",
		"145",
		"0.0",
		"146",
		"1.0",
		"147",
		"0.09",
		" 71",
		"     0",
		" 72",
		"     0",
		" 73",
		"     1",
		" 74",
		"     1",
		" 75",
		"     0",
		" 76",
		"     0",
		" 77",
		"     0",
		" 78",
		"     0",
		"170",
		"     0",
		"171",
		"     2",
		"172",
		"     0",
		"173",
		"     0",
		"174",
		"     0",
		"175",
		"     0",
		"176",
		"     0",
		"177",
		"     0",
		"178",
		"     0",
		"  0",
		"ENDTAB",
		"  0",
		"ENDSEC"
	};

}

 