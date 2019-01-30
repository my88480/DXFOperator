

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
     * code  5 - Handle.
     */
    public String Handle;

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
	public wPoint bPoint;
	
	//bPoint = new wPoint();  //Should not be here.move to the constructor.

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
		bPoint = new wPoint();
		Handle = FileDXF.ApplyHandle();
		/*
		bPoint.x = 0.0;
		bPoint.y = 0.0;
		bPoint.z = 0.0;
		*/
	}
	
    /**
     * Constructor (x)
     * @param x_value
     */
	public EntPoint(double x_value){
		bPoint = new wPoint(x_value);
		Handle = FileDXF.ApplyHandle();
		/*
		bPoint.x = x_value;
		bPoint.y = 0.0;
		bPoint.z = 0.0;
		*/
	}
	
    /**
     * Constructor (x,y)
     * @param x_value
     * @param y_value
     */
	public EntPoint(double x_value,double y_value){
		bPoint = new wPoint(x_value,y_value);
		Handle = FileDXF.ApplyHandle();
		/*
		bPoint.x = x_value;
		bPoint.y = y_value;
		bPoint.z = 0.0;
		*/
	}
	
    /**
     * Constructor (x,y,z)
     * @param x_value
     * @param y_value
     * @param z_value
     */
	public EntPoint(double x_value,double y_value,double z_value){
		bPoint = new wPoint(x_value,y_value,z_value);
		Handle = FileDXF.ApplyHandle();
		/*
		bPoint.x = x_value;
		bPoint.y = y_value;
		bPoint.z = z_value;
		*/
	}

    /**
     * Constructor (onepoint)
     * @param onepoint
     */
	public EntPoint(wPoint2D onepoint){
		bPoint = new wPoint();

		this.bPoint.x = onepoint.x;
		this.bPoint.y = onepoint.y;
		Handle = FileDXF.ApplyHandle();
	}
	
    /**
     * Constructor (onepoint)
     * @param onepoint
     */
	public EntPoint(wPoint onepoint){
		bPoint = new wPoint();

		this.bPoint = onepoint;
		Handle = FileDXF.ApplyHandle();
	}
	
    /**
     * Constructor (EntPoint)
     * @param onepoint
     */
	public EntPoint(EntPoint onepoint){
		bPoint = new wPoint();

		this.bPoint.x = onepoint.bPoint.x;
		this.bPoint.y = onepoint.bPoint.y;
		this.bPoint.z = onepoint.bPoint.z;
		this.thickness = onepoint.thickness;
		this.xang = onepoint.xang;
		this.xExtrusionDirection = onepoint.xExtrusionDirection;
		this.yExtrusionDirection = onepoint.yExtrusionDirection;
		this.zExtrusionDirection = onepoint.zExtrusionDirection;
		Handle = FileDXF.ApplyHandle();
	}
	
    /**
     * Print2D()
     * Terminal output x,y of the point.
     */
	public void Print2D(){
		System.out.println("x = " + bPoint.x + "   y = "+bPoint.y);
	}		
	
    /**
     * Print3D()
     * Terminal output x,y,z of the point.
     */
	public void Print3D(){
		System.out.println("x = "+bPoint.x+"   y = "+bPoint.y+"   z = "+bPoint.z);
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

        DXF_STR.add("  5");
        DXF_STR.add(this.Handle);
		
		//DXF_STR.add("8");
		//DXF_STR.add(this.layer);
		DXF_STR.addAll(super.GetDXFData());

		DXF_STR.add("  100");
		DXF_STR.add(this.SubClassLabel);
		
		DXF_STR.addAll(this.bPoint.GetDXFData());
		/*
		DXF_STR.add("10");
		DXF_STR.add(Double.toString(bPoint.x));
		DXF_STR.add("20");
		DXF_STR.add(Double.toString(bPoint.y));
		DXF_STR.add("30");
		DXF_STR.add(Double.toString(bPoint.z));
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

}