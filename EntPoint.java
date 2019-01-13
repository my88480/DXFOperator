

//package www
//AutoCAD Entity--Point
import java.util.*;
//import java.util.HashMap;

/**
 * @author David Wu <809758521@qq.com>
 * @version V0.2
 * Entity Point of AutoCAD DXF file.
 */
public class EntPoint extends EntBase{
    /**
     * code  0 -Entity name.
     */
    public String EntityName = "POINT";

    /**
     * code  100 -Class Label.
     */
	public String ClassLabel = "AcDbEntity";
    
    /**
     * code  100 -Sub Class Label.
     */
	public String SubClassLabel = "AcDbPoint";

    /**
     * code  10,20,30 -Point location (in WCS).
     */
	public wPoint base_point;
	
	//base_point = new wPoint();  //Should not be here.move to the constructor.

	/**
	* code  39 - Thickness (optional; default  =  0).
	*/
	public double thickness = 0.0;
	
    /**
     * code  50 - Angle of the X axis for the UCS in effect when the point
     *            was drawn (optional, default  =  0). Used when PDMODE
     *            is nonzero.
     */
    public     double        xang   =  0.0;

    /**
     * code 210,220,230 -
     *            Extrusion direction. Present if the extrusion direction is
     *            not parallel to the world Z axis.
     */
    public double   xExtrusionDirection = 0;
    public double   yExtrusionDirection = 0;
    public double   zExtrusionDirection = 1;

    /**
     * Constructor (empty).
     */
	public EntPoint(){
		base_point = new wPoint();
		/*
		base_point.x = 0.0;
		base_point.y = 0.0;
		base_point.z = 0.0;
		*/
	}
	
    /**
     * Constructor (x)
     * @param x_value
     */
	public EntPoint(double x_value){
		base_point = new wPoint(x_value);
		/*
		base_point.x = x_value;
		base_point.y = 0.0;
		base_point.z = 0.0;
		*/
	}
	
    /**
     * Constructor (x,y)
     * @param x_value
     * @param y_value
     */
	public EntPoint(double x_value,double y_value){
		base_point = new wPoint(x_value,y_value);
		/*
		base_point.x = x_value;
		base_point.y = y_value;
		base_point.z = 0.0;
		*/
	}
	
    /**
     * Constructor (x,y,z)
     * @param x_value
     * @param y_value
     * @param z_value
     */
	public EntPoint(double x_value,double y_value,double z_value){
		base_point = new wPoint(x_value,y_value,z_value);
		/*
		base_point.x = x_value;
		base_point.y = y_value;
		base_point.z = z_value;
		*/
	}

    /**
     * Constructor (onepoint)
     * @param onepoint
     */
	public EntPoint(wPoint2D onepoint){
		base_point = new wPoint();

		this.base_point.x = onepoint.x;
		this.base_point.y = onepoint.y;
	}
	
    /**
     * Constructor (onepoint)
     * @param onepoint
     */
	public EntPoint(wPoint onepoint){
		base_point = new wPoint();

		this.base_point = onepoint;
	}
	
    /**
     * Constructor (EntPoint)
     * @param onepoint
     */
	public EntPoint(EntPoint onepoint){
		base_point = new wPoint();

		this.base_point.x = onepoint.base_point.x;
		this.base_point.y = onepoint.base_point.y;
		this.base_point.z = onepoint.base_point.z;
		this.thickness = onepoint.thickness;
		this.xang = onepoint.xang;
		this.xExtrusionDirection = onepoint.xExtrusionDirection;
		this.yExtrusionDirection = onepoint.yExtrusionDirection;
		this.zExtrusionDirection = onepoint.zExtrusionDirection;
	}
	
    /**
     * Print2D()
     * Terminal output x,y of the point.
     */
	public void Print2D(){
		System.out.println("x = " + base_point.x + "   y = "+base_point.y);
	}		
	
    /**
     * Print3D()
     * Terminal output x,y,z of the point.
     */
	public void Print3D(){
		System.out.println("x = "+base_point.x+"   y = "+base_point.y+"   z = "+base_point.z);
	}		
	
	public void PrintAll(){
		System.out.println("Entity Type: " + this.EntityName);
		System.out.println("ClassLabel: " + this.ClassLabel);
		System.out.println("SubClassLabel: " + this.SubClassLabel);
		
		base_point.PrintAll();
		
		/*
		System.out.println("x = "+base_point.x);
		System.out.println("y = "+base_point.y);
		System.out.println("z = "+base_point.z);
		*/
		
		System.out.println("thickness = "+this.thickness);
		System.out.println("xang = "+this.xang);
		System.out.println("xExtrusionDirection = "+this.xExtrusionDirection);
		System.out.println("yExtrusionDirection = "+this.yExtrusionDirection);
		System.out.println("zExtrusionDirection = "+this.zExtrusionDirection);
	}		

	
	public List<String []> GetPairData(){
		List<String []> params=new ArrayList<>();

		params.add(new String[] {"Entity",this.EntityName});
		params.add(new String[] {"ClassLabel",this.ClassLabel});
		params.add(new String[] {"SubClassLabel",this.SubClassLabel});
		
		params.addAll(base_point.GetPairData());
		/*
		params.put("x",Double.toString(base_point.x));
		params.put("y",Double.toString(base_point.y));
		params.put("z",Double.toString(base_point.z));
		*/
		params.add(new String[] {"thickness",Double.toString(thickness)});	
		params.add(new String[] {"xang",Double.toString(xang)});	
		params.add(new String[] {"xExtrusionDirection",Double.toString(xExtrusionDirection)});	
		params.add(new String[] {"yExtrusionDirection",Double.toString(yExtrusionDirection)});	
		params.add(new String[] {"zExtrusionDirection",Double.toString(zExtrusionDirection)});	
		
		return params;
	}	
	
    /**
     * GetDXFData()
     * @return the dxf data of entity point.
	 * <pre>Output example:
	 * 0
	 * POINT
	 * 100
	 * AcDbEntity
	 * 8
	 * 0
	 * 100
	 * AcDbPoint
	 * 10
	 * 10.0
	 * 20
	 * 10.0
	 * 30
	 * 10.0
	 * 39
	 * 0.0
	 * 50
	 * 0.0
	 * 210
	 * 0.0
	 * 220
	 * 0.0
	 * 230
	 * 1.0</pre>
     */
	 public List<String> GetDXFData(){
		List<String> DXF_STR = new ArrayList<>();

		DXF_STR.add("  0");
		DXF_STR.add(this.EntityName);
		DXF_STR.add("  100");
		DXF_STR.add(this.ClassLabel);
		//DXF_STR.add("8");
		//DXF_STR.add(this.layer);
		DXF_STR.addAll(super.GetDXFData());

		DXF_STR.add("  100");
		DXF_STR.add(this.SubClassLabel);
		
		DXF_STR.addAll(this.base_point.GetDXFData());
		/*
		DXF_STR.add("10");
		DXF_STR.add(Double.toString(base_point.x));
		DXF_STR.add("20");
		DXF_STR.add(Double.toString(base_point.y));
		DXF_STR.add("30");
		DXF_STR.add(Double.toString(base_point.z));
		*/
		DXF_STR.add("  39");	
		DXF_STR.add(Double.toString(thickness));	
		DXF_STR.add("  50");	
		DXF_STR.add(Double.toString(xang));	
		DXF_STR.add("  210");	
		DXF_STR.add(Double.toString(xExtrusionDirection));	
		DXF_STR.add("  220");	
		DXF_STR.add(Double.toString(yExtrusionDirection));	
		DXF_STR.add("  230");	
		DXF_STR.add(Double.toString(zExtrusionDirection));	

		return DXF_STR;
	}

	public String toString() {

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