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
    wPoint cPoint;

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
        this.cPoint = new wPoint();
		this.radius = 0.0;
    }

    /**
     * Constructor (double x_value,double y_value,double radius_value)
     * @param x_value -x of the circle's center point;
     * @param y_value -y of the circle's center point;
     * @param radius_value -radius of the circle;
     */
    public EntCircle(double x_value,double y_value,double radius_value) {
        this.cPoint = new wPoint(x_value,y_value);
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
        this.cPoint = new wPoint(x_value,y_value,z_value);
		this.radius = radius_value;
    }

    /**
     * Constructor (wPoint2D cPoint,double radius_value)
     * @param cPoint -  center point of the circle;
    * @param radius_value -radius of the circle;
     */
    public EntCircle(wPoint2D cPoint,double radius_value) {
        this.cPoint = new wPoint(cPoint.x,cPoint.y);
		this.radius = radius_value;
    }

     /**
     * Constructor (wPoint cPoint,double radius_value)
     * @param cPoint -  center point of the circle;
    * @param radius_value -radius of the circle;
     */
    public EntCircle(wPoint cPoint,double radius_value) {
        this.cPoint = cPoint;
		this.radius = radius_value;
    }

    /**
     * Constructor (one_circle)
     * @param one_circle -one object derived from class EntCircle;
     */
    public EntCircle(EntCircle one_circle) {
        this.cPoint = one_circle.cPoint;
		this.radius = one_circle.radius;
        this.thickness = one_circle.thickness;
        this.xExtrusionDirection = one_circle.xExtrusionDirection;
        this.yExtrusionDirection = one_circle.yExtrusionDirection;
        this.zExtrusionDirection = one_circle.zExtrusionDirection;
    }

    /**
     * Print2D()
     * Terminal output x,y of cPoint and end_point.(one circle for one point)
     */
    public void Print2D() {
        System.out.println("Start point:  "+"x = " + this.cPoint.x+"   y = " + this.cPoint.y);
        System.out.println("radius:  "+"x = " + this.radius);
    }

    /**
     * Print3D()
     * Terminal output x,y,z of cPoint and end_point.(one circle for one point)
     */
    public void Print3D() {
        System.out.println("Start point:  "+"x = "+this.cPoint.x+"   y = " + this.cPoint.y+"   z = " + this.cPoint.z);
        System.out.println("radius:  "+"x = " + this.radius);
    }
	
    /**Perimeter
     * GetPerimeter()
     * Get the area of the circle
     */
    public double GetPerimeter() {
		double thePerimeter;

		thePerimeter = 2 * Math.PI * radius;
		
		return thePerimeter;
	}
	
    /**
     * GetArea()
     * Get the area of the circle
     */
    public double GetArea() {
		double theArea;

		theArea = Math.PI * Math.pow(radius,2);
		
		return theArea;
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

        params.addAll(cPoint.GetPairData());

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
		
		DXF_STR.addAll(cPoint.GetDXFData());

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

}