//package www
//AutoCAD Entity--Arc
import java.util.*;
//import java.util.HashMap;

/**
*@author David Wu<809758521@qq.com>
*@version 0.5
*/
public class EntArc extends EntBase {
    /**
     * code  0 -Entity name.
     */
    public String EntityName = "ARC";

    /**
     * code  100 -Class Label.
     */
    public String ClassLabel = "AcDbEntity";

    /**
     * code  100 -Sub Class Label.
     */
    public String SubClassLabel = "AcDbArc";

    /**
     * code  10,20,30 -Center Point location (in WCS).
     */
    wPoint center_point;

    /**
     * code  40 - Radius.
     */
    public     double       radius          = 0.0;

	
    /**
     * code  50 - startAngle.
     */
    public     double       startAngle          = 0.0;

	
    /**
     * code  51 - endAngle.
     */
    public     double       endAngle          = 0.0;

	
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
    public EntArc() {
        this.center_point = new wPoint();
		this.radius = 0.0;
		this.startAngle = 0.0;
		this.endAngle = 0.0;
    }

    /**
     * Constructor (double x_value,double y_value,double radius_value,double start_angle,double end_angle)
     * @param x_value -x of the arc's center point;
     * @param y_value -y of the arc's center point;
     * @param radius_value -radius of the arc;
     * @param start_angle - start angle of the arc;
     * @param end_angle - end angle of the arc;
     */
    public EntArc(double x_value,double y_value,double radius_value,double start_angle,double end_angle) {
        this.center_point = new wPoint(x_value,y_value);
		this.radius = radius_value;
		this.startAngle = start_angle;
		this.endAngle = end_angle;
    }

    /**
     * Constructor (wPoint2D cPoint,double radius_value,double start_angle,double end_angle)
     * @param cPoint - center point of the arc;
     * @param radius_value -radius of the arc;
     * @param start_angle - start angle of the arc;
     * @param end_angle - end angle of the arc;
     */
    public EntArc(wPoint2D cPoint,double radius_value,double start_angle,double end_angle) {
        this.center_point = new wPoint(cPoint);
		this.radius = radius_value;
		this.startAngle = start_angle;
		this.endAngle = end_angle;
    }

    /**
     * Constructor (double x_value,double y_value,double z_value,double radius_value,double start_angle,double end_angle)
     * @param x_value -x of the arc's center point;
     * @param y_value -y of the arc's center point;
     * @param z_value -z of the arc's center point;
     * @param radius_value -radius of the arc;
     * @param start_angle - start angle of the arc;
     * @param end_angle - end angle of the arc;
     */
    public EntArc(double x_value,double y_value,double z_value,double radius_value,double start_angle,double end_angle) {
        this.center_point = new wPoint(x_value,y_value,z_value);
		this.radius = radius_value;
		this.startAngle = start_angle;
		this.endAngle = end_angle;
    }

    /**
     * Constructor (wPoint cPoint,double radius_value,double start_angle,double end_angle)
     * @param cPoint - center point of the arc;
     * @param radius_value -radius of the arc;
     * @param start_angle - start angle of the arc;
     * @param end_angle - end angle of the arc;
     */
    public EntArc(wPoint cPoint,double radius_value,double start_angle,double end_angle) {
        this.center_point = cPoint;
		this.radius = radius_value;
		this.startAngle = start_angle;
		this.endAngle = end_angle;
    }

    /**
     * Constructor (Po,Pa,Pb)
     * @param Po - Center point of the Arc;
     * @param Pa - Start point of the Arc;
     * @param Pb - End point of the Arc;
     */
    public EntArc(wPoint2D Po,wPoint2D Pa,wPoint2D Pb) {
        double radis,start_angle,end_angle;
		double rb;
		
		radius = Math.sqrt(Math.pow(Pa.x-Po.x,2) + Math.pow(Pa.y-Po.y,2));
		rb  = Math.sqrt(Math.pow(Pa.x-Po.x,2) + Math.pow(Pa.y-Po.y,2));
		
		if (Math.abs(rb-radius) > 0.2){
			System.out.println("Invalid input. delta radius=" + Math.abs(rb-radius));
		}
		
		start_angle = Math.toDegrees(Math.atan2((Pa.y - Po.y) , (Pa.x - Po.x)));
		
		end_angle = Math.toDegrees(Math.atan2((Pb.y - Po.y) , (Pb.x - Po.x)));
		
		this.center_point = new wPoint(Po.x,Po.y,0.0);
		this.radius = radius;
		this.startAngle = start_angle;
		this.endAngle = end_angle;
    }

    /**
     * Constructor (one_arc)
     * @param one_arc -one object derived from class EntArc;
     */
    public EntArc(EntArc one_arc) {
        this.center_point = one_arc.center_point;
		this.radius = one_arc.radius;
		this.startAngle = one_arc.startAngle;
		this.endAngle = one_arc.endAngle;
        this.thickness = one_arc.thickness;
        this.xExtrusionDirection = one_arc.xExtrusionDirection;
        this.yExtrusionDirection = one_arc.yExtrusionDirection;
        this.zExtrusionDirection = one_arc.zExtrusionDirection;
    }

    /**
     * MakeStartAngleSmaller (myArc)
     * @param myArc - One Arc to make the startAngle smaller than the end_angle;
    */
    public void MakeStartAngleSmaller(EntArc myArc) {
		
		if (myArc.startAngle > myArc.endAngle){
			double angle;
			angle = myArc.startAngle;
			myArc.startAngle = myArc.endAngle;
			myArc.endAngle = angle;
		}
    }

    /**
     * Print2D()
     * Terminal output x,y of center_point and end_point.(one arc for one point)
     */
    public void Print2D() {
        System.out.println("Start point:  "+"x = " + this.center_point.x+"   y = " + this.center_point.y);
        System.out.println("radius:  "+"x = " + this.radius);
        System.out.println("Start angle=  " + this.startAngle+"   End angle= " + this.endAngle);
    }

    /**
     * Print3D()
     * Terminal output x,y,z of center_point and end_point.(one arc for one point)
     */
    public void Print3D() {
        System.out.println("Start point:  "+"x = "+this.center_point.x+"   y = " + this.center_point.y+"   z = " + this.center_point.z);
        System.out.println("radius:  "+"x = " + this.radius);
        System.out.println("Start angle=  " + this.startAngle+"   End angle= " + this.endAngle);
    }

    /**
     * GetPairData()
     * @return Map of elements description of Entity ARC.
	 * <pre>Output example:
	 * Map's Size: 10
	 * key= Entity                     value= ARC
	 * key= zExtrusionDirection                        value= 1.0
	 * key= ClassLabel                 value= AcDbEntity
	 * key= xExtrusionDirection                        value= 0.0
	 * key= SubClassLabel                      value= AcDbArc
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
        params.add(new String[] {"startAngle",Double.toString(this.startAngle)});
        params.add(new String[] {"endAngle",Double.toString(this.endAngle)});
        params.add(new String[] {"thickness",Double.toString(thickness)});
        params.add(new String[] {"xExtrusionDirection",Double.toString(xExtrusionDirection)});
        params.add(new String[] {"yExtrusionDirection",Double.toString(yExtrusionDirection)});
        params.add(new String[] {"zExtrusionDirection",Double.toString(zExtrusionDirection)});


        return params;
    }

    /**
     * GetDXFData()
     * @return the dxf data of entity arc.
	 * <pre>Output example:
	 * 0
	 * ARC
	 * 100
	 * AcDbEntity
	 * 8
	 * 0
	 * 100
	 * AcDbArc
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
        DXF_STR.add("  50");
        DXF_STR.add(Double.toString(this.startAngle));
        DXF_STR.add("  51");
        DXF_STR.add(Double.toString(this.endAngle));
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