//package www
//AutoCAD Section--ENTITIES
import java.util.*;
//import java.lang.Object;

//import java.util.stream.Collectors;
//import static java.util.stream.Collectors.*;
//import static java.util.stream.Collectors.joining;


/**
*@author David Wu<809758521@qq.com>
*@version 0.5
*/
public class SecEntities{

    /**
     * code  0 -Entity section header.
     */
    public String SectionHeader = "SECTION";

    /**
     * code  0 -Entity section name.
     */
    public String SectionName = "ENTITIES";

    /**
     * code  0 -Entity section END.
     */
    public String SectionTail = "ENDSEC";

    /**
     * entities - One List of object may contains the classes such as EntPoint,EntLine,EntArc,EntPolyline and so on.
     */
    //public Object[] entities;
    public List<Object> entities;
	
    /**
     * Constructor (empty).
     */
    public SecEntities() {
		this.entities = new  ArrayList<Object>();
		
    }


    /**
     * Constructor (one_entities_section)
     * @param one_entities_section -one object derived from class SecEntities;
     */
    public SecEntities(SecEntities one_entities_section) {
		this.entities = new  ArrayList<Object>();
		/*
        this.start_point = one_entities_section.start_point;
        this.end_point = one_entities_section.end_point;

        this.thickness = one_entities_section.thickness;
        this.xExtrusionDirection = one_entities_section.xExtrusionDirection;
        this.yExtrusionDirection = one_entities_section.yExtrusionDirection;
        this.zExtrusionDirection = one_entities_section.zExtrusionDirection;
		*/
    }

    /**
     * PrintAll()
     * <pre>Terminal output the description of start_point and end_point.(serveral lines)
	 * Output example:
	 * </pre>	 
     */
    public void PrintAll() {
        
		/*
        System.out.println("Entity Type: LINE");
        System.out.println("ClassLabel: "+this.ClassLabel);
        System.out.println("SubClassLabel: "+this.SubClassLabel);

        start_point.PrintAll();
        end_point.PrintAll();

        System.out.println("thickness = "+this.thickness);
        System.out.println("xExtrusionDirection = "+this.xExtrusionDirection);
        System.out.println("yExtrusionDirection = "+this.yExtrusionDirection);
        System.out.println("zExtrusionDirection = "+this.zExtrusionDirection);
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

		params.add(new String[] {"  0",this.SectionHeader});
		params.add(new String[] {"  2",this.SectionName});

		for (int i  =  0; i < this.entities.size(); i++) {
			Object myentity=this.entities.get(i);
			if (myentity instanceof EntLine) {
				EntLine myline= (EntLine) myentity;
				params.addAll(myline.GetPairData());
			}
			else if (myentity instanceof EntPolyline){
				EntPolyline mypolyline = (EntPolyline) myentity;
				params.addAll(mypolyline.GetPairData());
			}
			else if (myentity instanceof EntPoint){
				EntPoint mypoint = (EntPoint) myentity;
				params.addAll(mypoint.GetPairData());
			}
			else if (myentity instanceof EntCircle){
				EntCircle mycircle = (EntCircle) myentity;
				params.addAll(mycircle.GetPairData());
			}
			else if (myentity instanceof EntArc){
				EntArc myarc = (EntArc) myentity;
				params.addAll(myarc.GetPairData());
			}
			else if (myentity instanceof EntText){
				EntText mytext = (EntText) myentity;
				params.addAll(mytext.GetPairData());
			}
			else if (myentity instanceof EntVertex){
			}
        }		
		
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

		for (int i  =  0; i < this.entities.size(); i++) {
			//System.out.println(this.entities.get(i));
			Object myentity=this.entities.get(i);
			if (myentity instanceof EntLine) {
				//System.out.println("I caought a line.Bingo");
				EntLine myline= (EntLine) myentity;
				//myline.PrintAll();
				//myline.GetDXFData();
				DXF_STR.addAll(myline.GetDXFData());
			}
			else if (myentity instanceof EntPolyline){
				EntPolyline mypolyline = (EntPolyline) myentity;
				DXF_STR.addAll(mypolyline.GetDXFData());
			}
			else if (myentity instanceof EntPoint){
				EntPoint mypoint = (EntPoint) myentity;
				DXF_STR.addAll(mypoint.GetDXFData());
			}
			else if (myentity instanceof EntCircle){
				EntCircle mycircle = (EntCircle) myentity;
				DXF_STR.addAll(mycircle.GetDXFData());
			}
			else if (myentity instanceof EntArc){
				EntArc myarc = (EntArc) myentity;
				DXF_STR.addAll(myarc.GetDXFData());
			}
			else if (myentity instanceof EntText){
				EntText mytext = (EntText) myentity;
				DXF_STR.addAll(mytext.GetDXFData());
			}
			else if (myentity instanceof EntVertex){
				//EntVertex should only appeared in objection Polyline, So bypass it.
				//EntVertex myvertex = (EntVertex) myentity;
				//DXF_STR.addAll(myvertex.GetDXFData());
			}
			
			//this.entities.get(i).GetDXFData();
			
			//Method method = this.entities.get(i).getClass().getDeclaredMethod("GetDXFData");
			//method.invoke(this.entities.get(i));
			//System.out.println(this.entities.get(i).PrintAll());
			//DXF_STR.addAll(this.entities.get(i).GetDXFData());
       }		
            
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

    public int GetEntitiesSize() {
		return this.entities.size();
    }
}

 