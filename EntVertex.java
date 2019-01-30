

//package www
//AutoCAD Entity--VERTEX
import java.util.*;
//import java.util.HashMap;

/**
 * @author David Wu <809758521@qq.com>
 * @version V0.2
 * Entity Point of AutoCAD DXF file.
 */
public class EntVertex extends EntBase {
    /**
     * code  0 -Entity name.
     */
    public String EntityName = "VERTEX";

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
    public String SubClassLabel = "AcDbVertex";

    /**
     * code  10,20,30 -Point location (in WCS).
     */
    public wPoint base_point;

    //base_point = new wPoint();  //Should not be here.move to the constructor.


    /**
     * code  40 - Starting width. (optional; default is 0).
     */
    public
    double                      begwidth        = 0.0;
    /**
     * Starting width coded - true if code 40 is not just default.
     */
    public
    boolean                     begwidth_set    = false;
    /**
     * code  41 - Ending width. (optional; default is 0).
     */
    public
    double                      endwidth        = 0.0;
    /**
     *            Ending width coded - true if code 41 is not just default.
     */
    public
    boolean                     endwidth_set    = false;

    /**
     * code  42 - Bulge (optional; default is 0). The bulge is the tangent of
     *            one fourth the included angle for an arc segment made
     *            negative if the arc goes clockwise from the start point to
     *            the endpoint.  A bulge of 0 indicates a straight segment,
     *            and a bulge of 1 is a semicircle.
     */
    public
    double                      bulge           = 0.0;

    /**
     * code  50 - Curve fit tangent direction.
     */
    public
    double                      tandir          = 0.0;

    /**
     * code  70 - Vertex flags.
     * <UL>
     *   <LI>  1 = Extra vertex created by curve-fitting.
     *   <LI>  2 = Curve-fit tangent defined for this vertex.  A curve-fit
     *             tangent direction of 0 may be omitted from DXF output
     *             but is significant if this bit is set.
     *   <LI>  4 = Not used.
     *   <LI>  8 = Spline vertex created by spline-fitting.
     *   <LI> 16 = Spline frame control point.
     *   <LI> 32 = 3D polyline vertex.
     *   <LI> 64 = 3D polygon mesh.
     *   <LI>128 = Polyface mesh vertex.
     * </UL>
     */
    public
    int                         flags           = 0;

    /**
     * code  71 - Polyface mesh vertex index.
     *            Optional. Present only if nonzero.
     */
    public
    int                         meshidx1        = 0;
    /**
     * code  72 - Polyface mesh vertex index.
     *            Optional. Present only if nonzero.
     */
    public
    int                         meshidx2        = 0;
    /**
     * code  73 - Polyface mesh vertex index.
     *            Optional. Present only if nonzero.
     */
    public
    int                         meshidx3        = 0;
    /**
     * code  74 - Polyface mesh vertex index.
     *            Optional. Present only if nonzero.
     */
    public
    int                         meshidx4        = 0;



    /**
     * Constructor (empty).
     */
    public EntVertex() {
        base_point = new wPoint();
        /*
        base_point.x = 0.0;
        base_point.y = 0.0;
        base_point.z = 0.0;
        */
		Handle = FileDXF.ApplyHandle();
    }

    /**
     * Constructor (x)
     * @param x_value
     */
    public EntVertex(double x_value) {
        base_point = new wPoint(x_value);
        /*
        base_point.x = x_value;
        base_point.y = 0.0;
        base_point.z = 0.0;
        */
		Handle = FileDXF.ApplyHandle();
    }

    /**
     * Constructor (x,y)
     * @param x_value
     * @param y_value
     */
    public EntVertex(double x_value,double y_value) {
        base_point = new wPoint(x_value,y_value);
        /*
        base_point.x = x_value;
        base_point.y = y_value;
        base_point.z = 0.0;
        */
		Handle = FileDXF.ApplyHandle();
    }

    /**
     * Constructor (x,y,z)
     * @param x_value
     * @param y_value
     * @param z_value
     */
    public EntVertex(double x_value,double y_value,double z_value) {
        base_point = new wPoint(x_value,y_value,z_value);
        /*
        base_point.x = x_value;
        base_point.y = y_value;
        base_point.z = z_value;
        */
		Handle = FileDXF.ApplyHandle();
    }

    /**
     * Constructor (Class wPoint)
     * @param onepoint
     */
    public EntVertex(EntVertex onepoint) {

		base_point = new wPoint(onepoint.base_point.x,onepoint.base_point.y,onepoint.base_point.z);

		/* the following codes are right.
		base_point = new wPoint();

        this.base_point.x = onepoint.base_point.x;
        this.base_point.y = onepoint.base_point.y;
        this.base_point.z = onepoint.base_point.z;
		*/
		Handle = FileDXF.ApplyHandle();
    }

    /**
     * Print2D()
     * Terminal output x,y of the point.
     */
    public void Print2D() {
        System.out.println("x = " + base_point.x + "   y = "+base_point.y);
    }

    /**
     * Print3D()
     * Terminal output x,y,z of the point.
     */
    public void Print3D() {
        System.out.println("x = "+base_point.x+"   y = "+base_point.y+"   z = "+base_point.z);
    }
	
    /**
     * GetDXFData()
     * @return the dxf data of entity point.
     * <pre>Output example:
     * 0
     * VERTEX
     * 8
     * 0
     * 10
     * 5.2314
     * 20
     * 3.12546
     * 30
     * 8.012345678901234</pre>
     */
    public List<String> GetDXFData() {
        List<String> DXF_STR = new ArrayList<>();

        DXF_STR.add("  0");
        DXF_STR.add(this.EntityName);
        
		DXF_STR.add("  5");
        DXF_STR.add(this.Handle);
        
		DXF_STR.addAll(super.GetDXFData());

        //DXF_STR.add("8");
        //DXF_STR.add(this.layer);

        DXF_STR.addAll(this.base_point.GetDXFData());
		/*
        DXF_STR.add("10");
        DXF_STR.add(Double.toString(base_point.x));
        DXF_STR.add("20");
        DXF_STR.add(Double.toString(base_point.y));
        DXF_STR.add("30");
        DXF_STR.add(Double.toString(base_point.z));
		*/

        return DXF_STR;
    }
	

}