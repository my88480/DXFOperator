//package www
//AutoCAD Section--ENTITIES
import java.util.*;

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
 		for (int i  =  0; i < this.entities.size(); i++) {
			Object myEntity=this.entities.get(i);
			if (myEntity instanceof EntLine) {
				EntLine myLine= (EntLine) myEntity;
				myLine.PrintAll();
			}
			else if (myEntity instanceof EntPolyline){
				EntPolyline myPolyline = (EntPolyline) myEntity;
				myPolyline.PrintAll();
			}
			else if (myEntity instanceof EntPoint){
				EntPoint myPoint = (EntPoint) myEntity;
				myPoint.PrintAll();
			}
			else if (myEntity instanceof EntCircle){
				EntCircle myCircle = (EntCircle) myEntity;
				myCircle.PrintAll();
			}
			else if (myEntity instanceof EntArc){
				EntArc myArc = (EntArc) myEntity;
				myArc.PrintAll();
			}
			else if (myEntity instanceof EntText){
				EntText myText = (EntText) myEntity;
				myText.PrintAll();
			}
			else if (myEntity instanceof EntVertex){
				EntVertex myVertex = (EntVertex) myEntity;
				myVertex.PrintAll();
			}
        }		       
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
			Object myEntity=this.entities.get(i);
			if (myEntity instanceof EntLine) {
				EntLine myLine= (EntLine) myEntity;
				params.addAll(myLine.GetPairData());
			}
			else if (myEntity instanceof EntPolyline){
				EntPolyline myPolyline = (EntPolyline) myEntity;
				params.addAll(myPolyline.GetPairData());
			}
			else if (myEntity instanceof EntPoint){
				EntPoint myPoint = (EntPoint) myEntity;
				params.addAll(myPoint.GetPairData());
			}
			else if (myEntity instanceof EntCircle){
				EntCircle myCircle = (EntCircle) myEntity;
				params.addAll(myCircle.GetPairData());
			}
			else if (myEntity instanceof EntArc){
				EntArc myArc = (EntArc) myEntity;
				params.addAll(myArc.GetPairData());
			}
			else if (myEntity instanceof EntText){
				EntText myText = (EntText) myEntity;
				params.addAll(myText.GetPairData());
			}
			else if (myEntity instanceof EntVertex){
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
			Object myEntity=this.entities.get(i);
			if (myEntity instanceof EntLine) {
				EntLine myLine= (EntLine) myEntity;
				DXF_STR.addAll(myLine.GetDXFData());
			}
			else if (myEntity instanceof EntPolyline){
				EntPolyline myPolyline = (EntPolyline) myEntity;
				DXF_STR.addAll(myPolyline.GetDXFData());
			}
			else if (myEntity instanceof EntPoint){
				EntPoint myPoint = (EntPoint) myEntity;
				DXF_STR.addAll(myPoint.GetDXFData());
			}
			else if (myEntity instanceof EntCircle){
				EntCircle myCircle = (EntCircle) myEntity;
				DXF_STR.addAll(myCircle.GetDXFData());
			}
			else if (myEntity instanceof EntArc){
				EntArc myArc = (EntArc) myEntity;
				DXF_STR.addAll(myArc.GetDXFData());
			}
			else if (myEntity instanceof EntText){
				EntText myText = (EntText) myEntity;
				DXF_STR.addAll(myText.GetDXFData());
			}
			else if (myEntity instanceof EntVertex){
				//EntVertex should only appeared in objection Polyline, So bypass it.
				//EntVertex myvertex = (EntVertex) myEntity;
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

 