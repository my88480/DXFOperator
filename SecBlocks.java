//package www
//AutoCAD Section -- Blocks
import java.util.*;

/**
*@author David Wu<809758521@qq.com>
*@version 0.5
*/
public class SecBlocks{

    /**
     * code  0 -Entity section header.
     */
    public String SectionHeader = "SECTION";

    /**
     * code  0 -Entity section name.
     */
    public String SectionName = "BLOCKS";

    /**
     * code  0 -Entity section END.
     */
    public String SectionTail = "ENDSEC";

	
    /**
     * Constructor (empty).
     */
    public SecBlocks() {
		
    }


    /**
     * Constructor (one_Blocks_section)
     * @param one_Blocks_section -one object derived from class SecBlocks;
     */
    public SecBlocks(SecBlocks one_Blocks_section) {
		/*
        this.start_point = one_Blocks_section.start_point;
        this.end_point = one_Blocks_section.end_point;

        this.thickness = one_Blocks_section.thickness;
        this.xExtrusionDirection = one_Blocks_section.xExtrusionDirection;
        this.yExtrusionDirection = one_Blocks_section.yExtrusionDirection;
        this.zExtrusionDirection = one_Blocks_section.zExtrusionDirection;
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

        DXF_STR.add("  0");
        DXF_STR.add(this.SectionHeader);
        DXF_STR.add("  2");
        DXF_STR.add(this.SectionName);

            
        DXF_STR.add("  0");
        DXF_STR.add(this.SectionTail);

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

}

 