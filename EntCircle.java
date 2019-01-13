//package www
//AutoCAD Entity--Circle
import java.util.*;
//import java.util.HashMap;

/**
*@author David Wu<809758521@qq.com>
*@version 0.5
*/
public class EntCircle extends EntBase {
    /**
     * code  0 -Entity name.
     */
    public String EntityName = "CIRCLE";

    /**
     * code  100 -Class Label.
     */
    public String ClassLabel = "AcDbEntity";

    /**
     * code  100 -Sub Class Label.
     */
    public String SubClassLabel = "AcDbCircle";

    /**
     * code  10,20,30 -Start Point location (in WCS).
     * code  11,22,31 -End Point location (in WCS).
     */
    wPoint center_point;

    /**
     * code  40 - Radius.
     */
    public     double       radius          = 0.0;

	
    /**
    * code  39 - Thickness (optional; default  =  0).
    */
    public double thickness = 0.0;

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
    public EntCircle() {
        this.center_point = new wPoint();
		this.radius = 0.0;
    }

    /**
     * Constructor (double x_value,double y_value,double radius_value)
     * @param x_value -x of the circle's center point;
     * @param y_value -y of the circle's center point;
     * @param radius_value -radius of the circle;
     */
    public EntCircle(double x_value,double y_value,double radius_value) {
        this.center_point = new wPoint(x_value,y_value);
		this.radius = radius_value;
    }

    /**
     * Constructor (double x_value,double y_value,double z_value,double radius_value)
     * @param x_value -x of the circle's center point;
     * @param y_value -y of the circle's center point;
     * @param z_value -z of the circle's center point;
     * @param radius_value -radius of the circle;
     */
    public EntCircle(double x_value,double y_value,double z_value,double radius_value) {
        this.center_point = new wPoint(x_value,y_value,z_value);
		this.radius = radius_value;
    }

    /**
     * Constructor (wPoint2D cPoint,double radius_value)
     * @param cPoint -  center point of the circle;
    * @param radius_value -radius of the circle;
     */
    public EntCircle(wPoint2D cPoint,double radius_value) {
        this.center_point = new wPoint(cPoint.x,cPoint.y);
		this.radius = radius_value;
    }

     /**
     * Constructor (wPoint cPoint,double radius_value)
     * @param cPoint -  center point of the circle;
    * @param radius_value -radius of the circle;
     */
    public EntCircle(wPoint cPoint,double radius_value) {
        this.center_point = cPoint;
		this.radius = radius_value;
    }

    /**
     * Constructor (one_circle)
     * @param one_circle -one object derived from class EntCircle;
     */
    public EntCircle(EntCircle one_circle) {
        this.center_point = one_circle.center_point;
		this.radius = one_circle.radius;
        this.thickness = one_circle.thickness;
        this.xExtrusionDirection = one_circle.xExtrusionDirection;
        this.yExtrusionDirection = one_circle.yExtrusionDirection;
        this.zExtrusionDirection = one_circle.zExtrusionDirection;
    }

    /**
     * Print2D()
     * Terminal output x,y of center_point and end_point.(one circle for one point)
     */
    public void Print2D() {
        System.out.println("Start point:  "+"x = " + this.center_point.x+"   y = " + this.center_point.y);
        System.out.println("radius:  "+"x = " + this.radius);
    }

    /**
     * Print3D()
     * Terminal output x,y,z of center_point and end_point.(one circle for one point)
     */
    public void Print3D() {
        System.out.println("Start point:  "+"x = "+this.center_point.x+"   y = " + this.center_point.y+"   z = " + this.center_point.z);
        System.out.println("radius:  "+"x = " + this.radius);
    }

    /**
     * PrintAll()
     * <pre>Terminal output the description of center_point and end_point.(serveral circles)
	 * Output example:
	 * Entity Type: CIRCLE
	 * ClassLabel: AcDbEntity
	 * SubClassLabel: AcDbCircle
	 * x = 10.0
	 * y = 10.0
	 * z = 10.0
	 * x = 50.2314
	 * y = 30.12546
	 * z = 80.01234567890124
	 * thickness = 0.0
	 * xExtrusionDirection = 0.0
	 * yExtrusionDirection = 0.0
	 * zExtrusionDirection = 1.0</pre>	 
     */
    public void PrintAll() {
        System.out.println("Entity Type: " + this.EntityName);
        System.out.println("ClassLabel: "+this.ClassLabel);
        System.out.println("SubClassLabel: "+this.SubClassLabel);

        center_point.PrintAll();

        System.out.println("radius = " + this.radius);
        System.out.println("thickness = "+this.thickness);
        System.out.println("xExtrusionDirection = "+this.xExtrusionDirection);
        System.out.println("yExtrusionDirection = "+this.yExtrusionDirection);
        System.out.println("zExtrusionDirection = "+this.zExtrusionDirection);
    }

    /**
     * GetPairData()
     * @return Map of elements description of Entity CIRCLE.
	 * <pre>Output example:
	 * Map's Size: 10
	 * key= Entity                     value= CIRCLE
	 * key= zExtrusionDirection                        value= 1.0
	 * key= ClassLabel                 value= AcDbEntity
	 * key= xExtrusionDirection                        value= 0.0
	 * key= SubClassLabel                      value= AcDbCircle
	 * key= thickness                  value= 0.0
	 * key= yExtrusionDirection                        value= 0.0
	 * key= x                  value= 50.2314
	 * key= y                  value= 30.12546
	 * key= z                  value= 80.01234567890124</pre>
     */
	public List<String []> GetPairData(){
		List<String []> params=new ArrayList<>();

        params.add(new String[] {"Entity",this.EntityName});
        params.add(new String[] {"ClassLabel",this.ClassLabel});
        params.add(new String[] {"SubClassLabel",this.SubClassLabel});

        params.addAll(center_point.GetPairData());

        params.add(new String[] {"radius",Double.toString(this.radius)});
        params.add(new String[] {"thickness",Double.toString(thickness)});
        params.add(new String[] {"xExtrusionDirection",Double.toString(xExtrusionDirection)});
        params.add(new String[] {"yExtrusionDirection",Double.toString(yExtrusionDirection)});
        params.add(new String[] {"zExtrusionDirection",Double.toString(zExtrusionDirection)});


        return params;
    }

    /**
     * GetDXFData()
     * @return the dxf data of entity circle.
	 * <pre>Output example:
	 * 0
	 * CIRCLE
	 * 100
	 * AcDbEntity
	 * 8
	 * 0
	 * 100
	 * AcDbCircle
	 * 10
	 * 10.0
	 * 20
	 * 10.0
	 * 30
	 * 10.0
	 * 11
	 * 50.2314
	 * 21
	 * 30.12546
	 * 31
	 * 80.01234567890124
	 * 39
	 * 0.0
	 * 210
	 * 0.0
	 * 220
	 * 0.0
	 * 230
	 * 1.0</pre>
     */
    public List<String> GetDXFData() {
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
		
		DXF_STR.addAll(center_point.GetDXFData());

        DXF_STR.add("  40");
        DXF_STR.add(Double.toString(this.radius));
        DXF_STR.add("  39");
        DXF_STR.add(Double.toString(this.thickness));
        DXF_STR.add("  210");
        DXF_STR.add(Double.toString(this.xExtrusionDirection));
        DXF_STR.add("  220");
        DXF_STR.add(Double.toString(this.yExtrusionDirection));
        DXF_STR.add("  230");
        DXF_STR.add(Double.toString(this.zExtrusionDirection));

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