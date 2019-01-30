//package www
//AutoCAD Entity--Line
import java.util.*;
//import java.util.HashMap;

/**
*@author David Wu<809758521@qq.com>
*@version 0.5
*/
public class EntLWPolyline extends EntBase {
    /**
     * code  0 -Entity name.
     */
    public String EntityName = "LWPOLYLINE";

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
    public String SubClassLabel = "AcDbPolyline";

    /**
     * code  10,20,30
     *            A "dummy" point. The X and Y coordinates are always 0,
     *            and the Z coordinate is the LWPolyline's elevation (in OCS
     *            when 2D, WCS when 3D).
     */
    public  wPoint     DummyPoint;
	
    /**
     * code  10,20,30 -Start Point location (in WCS).
     * code  11,22,31 -End Point location (in WCS).
     */
    //public List<wPoint> vertexs;
 	public List<wPoint> Vertexs;
	
    /**
    * code  39 - Thickness (optional; default  =  0).
    */
    public double thickness = 0.0;

    /**
     * code  40 - Starting width (optional; default is 0).
     */
    public    double  begwidth        = 0.0;
    /**
     *            Starting width coded - true if code 40 is not just default.
     */
    public    boolean   begwidth_set    = false;
    /**
     * code  41 - Ending width (optional; default is 0).
     */
    public    double   endwidth        = 0.0;
    /**
     *            Ending width coded - true if code 41 is not just default.
     */
    public    boolean   endwidth_set    = false;

    /**
     * code  43 - Ending width (optional; default is 0).
     */
    public    double   fixedwidth        = 0.0;

    /**
     * code  70 - LWPolyline flag (bit-coded); default is 0.
     * <UL>
     *   <LI>  1 = This is a closed LWPolyline (or a polygon mesh closed in
     *             the M directtion).
     *   <LI>  2 = Curve-fit vertices have been added.
     *   <LI>  4 = Spline-fit vertices have been added.
     *   <LI>  8 = This is a 3D LWPolyline.
     *   <LI> 16 = This is a 3D polygon mesh.
     *   <LI> 32 = The polygon mesh is closed in the N direction.
     *   <LI> 64 = The LWPolyline is a polyface mesh.
     *   <LI>128 = The linetype pattern is generated continuously
     *             around the vertices of this LWPolyline.
     * </UL>
     */
    public    int TypeFlag           = 0;

    /**
     * code  71 - Polygon mesh M vertex count (optional; default = 0).
     */
    public    int  meshcntM        = 0;
    /**
     * code  72 - Polygon mesh N vertex count (optional; default = 0).
     */
    public    int   meshcntN        = 0;

    /**
     * code  73 - Smooth surface M density (optional; default = 0).
     */
    public    int  smoothM         = 0;
    /**
     * code  74 - Smooth surface N density (optional; default = 0).
     */
    public    int  smoothN         = 0;

    /**
     * code  75 - Curves and smooth surface type (optional; default = 0).
     * <UL>
     *   <LI>0 = No smooth surface fitted.
     *   <LI>5 = Quadratic B-spline surface.
     *   <LI>6 = Cubic B-spline surface.
     *   <LI>8 = Bezier surface.
     * </UL>
     */
    public    int  surfType        = 0;
	
	
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
    public EntLWPolyline() {
		this.Vertexs = new ArrayList<>();
		Handle = FileDXF.ApplyHandle();
    }

    /**
     * Constructor (x_value,y_value)
     * @param x_value -x of start vertex;
     * @param y_value -y of start vertex;
     */
    public EntLWPolyline(double x_value,double y_value) {
		this.Vertexs = new ArrayList<>();

		this.Vertexs.add(new wPoint(x_value,y_value));
		Handle = FileDXF.ApplyHandle();
    }

    /**
     * Constructor (x_value,y_value,z_value)
     * @param x_value -x of start vertex;
     * @param y_value -y of start vertex;
     * @param z_value -z of start vertex;
     */
    public EntLWPolyline(double x_value,double y_value,double z_value) {
		this.Vertexs = new ArrayList<>();
		this.Vertexs.add(new wPoint(x_value,y_value,z_value));
		Handle = FileDXF.ApplyHandle();
    }
	
    /**
     * Constructor (points)
     * @param points - two dimensions array of double, x - points[i][0], y - points[i][1];
     */
    public EntLWPolyline(double[][] points) {
		this.Vertexs = new ArrayList<>();
		
		for (int i=0;i < points.length;i++){
			if (points[i].length == 2){
				this.Vertexs.add(new wPoint(points[i][0],points[i][1]));
			}
			else if (points[i].length == 3){
				this.Vertexs.add(new wPoint(points[i][0],points[i][1],points[i][2]));
			}
		}
		Handle = FileDXF.ApplyHandle();
    }
	
	

    /**
     * AddVertex(one_point)
     * @param one_point -one vertex to add class EntLWPolyline;
     */
    public void AddVertex(wPoint one_point) {
		/*
		if (this.Vertexs.size() < 1){
			this.Vertexs = new ArrayList<>();
		}
		*/
		this.Vertexs.add(one_point);
    }

    /**
     * Constructor (one_LWPolyline)
     * @param one_LWPolyline -one object derived from class EntLWPolyline;
     */
    public EntLWPolyline(EntLWPolyline one_LWPolyline) {
		this.EntityName = one_LWPolyline.EntityName;
		this.ClassLabel = one_LWPolyline.ClassLabel;
		this.SubClassLabel = one_LWPolyline.SubClassLabel;
		
		this.DummyPoint = new wPoint(one_LWPolyline.DummyPoint);

		this.Vertexs = new ArrayList<>();
		//this works ok.
		//this.Vertexs.addAll(one_LWPolyline.Vertexs);
		for(int i=0;i<one_LWPolyline.Vertexs.size();i++)
		{
			this.Vertexs.add(one_LWPolyline.Vertexs.get(i));
		}
		
		this.thickness = one_LWPolyline.thickness;
		this.begwidth = one_LWPolyline.begwidth;
		this.begwidth_set = one_LWPolyline.begwidth_set;
		this.endwidth = one_LWPolyline.endwidth;
		this.endwidth_set = one_LWPolyline.endwidth_set;
		//this.vtxFollow = one_LWPolyline.vtxFollow;
		this.TypeFlag = one_LWPolyline.TypeFlag;
		this.meshcntM = one_LWPolyline.meshcntM;
		this.meshcntN = one_LWPolyline.meshcntN;
		this.smoothM = one_LWPolyline.smoothM;
		this.smoothN = one_LWPolyline.smoothN;
		this.surfType = one_LWPolyline.surfType;
		this.xExtrusionDirection = one_LWPolyline.xExtrusionDirection;
		this.yExtrusionDirection = one_LWPolyline.yExtrusionDirection;
		this.zExtrusionDirection = one_LWPolyline.zExtrusionDirection;
		
		Handle = FileDXF.ApplyHandle();
    }

     /**
     * GetSize()
     * Get the number of the Vertexs of the LWPolyline;
     */
    public int GetSize() {
		return this.Vertexs.size();
    }

     /**
     * GetLength()
     * Get the total length of the LWPolyline;
     */
    public double GetLength() {
		double Length = 0.0;
		
		for (int i = 1; i < this.Vertexs.size();i++){
			//Length = Math.pow(Vertexs.get(i).x-Vertexs.get(i-1).x);
			//Length = Math.sqrt(Math.pow(Vertexs.get(i).x-Vertexs.get(i-1).x));
			double dx,dy,dz;
			
			dx = this.Vertexs.get(i).x - this.Vertexs.get(i-1).x;
			dy = this.Vertexs.get(i).y - this.Vertexs.get(i-1).y;
			dz = this.Vertexs.get(i).z - this.Vertexs.get(i-1).z;
			
			Length = Length + Math.sqrt(Math.pow(dx,2) + Math.pow(dy,2) + Math.pow(dz,2) );
		}
		return Length;
    }

   /**
     * Print2D()
     * Terminal output x,y of start_point and end_point.(one line for one point)
     */
    public void Print2D() {
        //System.out.println("Start point:  "+"x = "+start_point.x+"   y = "+start_point.y);
        //System.out.println("End point:  "+"x = "+end_point.x+"   y = "+end_point.y);
    }

    /**
     * Print3D()
     * Terminal output x,y,z of start_point and end_point.(one line for one point)
     */
    public void Print3D() {
        //System.out.println("Start point:  "+"x = "+start_point.x+"   y = "+start_point.y+"   z = "+start_point.z);
        //System.out.println("End point:  "+"x = "+end_point.x+"   y = "+end_point.y+"   z = "+end_point.z);
    }

    /**
     * GetDXFData()
     * @return the dxf data of entity line.
	 * <pre>Output example:
	 *  0
	 *LWPOLYLINE
	 *  5
	 *11F
	 *330
	 *1F
	 *100
	 *AcDbEntity
	 *  8
	 *0
	 *100
	 *AcDbPolyline
	 * 90
	 *		5
	 * 70
	 *	 0
	 * 43
	 *0.0
	 * 10
	 *119.7353186055764
	 * 20
	 *110.9407893663185
	 * 10
	 *233.6033914477323
	 * 20
	 *167.3881582605076
	 * 10
	 *359.205959182741
	 * 20
	 *179.111842292698
	 * 10
	 *453.0819258055823
	 * 20
	 *107.9013159332341
	 * 10
	 *610.4110946527582
	 * 20
	 *155.6644735368104</pre>
     */
    public List<String> GetDXFData() {

		List<String> DXF_STR = new ArrayList<>();

        DXF_STR.add("  0");
        DXF_STR.add(this.EntityName);
        
		DXF_STR.add("  5");
        DXF_STR.add(this.Handle);
		
        DXF_STR.add("  100");
        DXF_STR.add(this.ClassLabel);

		DXF_STR.addAll(super.GetDXFData());

        DXF_STR.add("  100");
        DXF_STR.add(this.SubClassLabel);

        DXF_STR.add("  90");
        DXF_STR.add(Integer.toString(this.Vertexs.size()));

        DXF_STR.add("  70");
        DXF_STR.add(Integer.toString(this.TypeFlag));
		DXF_STR.add("  43");
        DXF_STR.add(Double.toString(this.fixedwidth));
		
        for (int i  =  0; i < this.Vertexs.size(); i++) {
			DXF_STR.addAll(this.Vertexs.get(i).GetDXFData());
       }		

        //DXF_STR.add("  0");
        //DXF_STR.add("SEQEND");

        return DXF_STR;
    }

}