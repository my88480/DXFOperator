//package www
//AutoCAD Entity--Line
import java.util.*;
//import java.util.HashMap;

/**
*@author David Wu<809758521@qq.com>
*@version 0.5
*/
public class EntLine extends EntBase {
    /**
     * code  0 -Entity name.
     */
    public String EntityName = "LINE";

    /**
     * code  100 -Class Label.
     */
    public String ClassLabel = "AcDbEntity";

    /**
     * code  100 -Sub Class Label.
     */
    public String SubClassLabel = "AcDbLine";

    /**
     * code  10,20,30 -Start Point location (in WCS).
     * code  11,22,31 -End Point location (in WCS).
     */
    wPoint sPoint;
    wPoint ePoint;

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
    public EntLine() {
        this.sPoint = new wPoint();
        this.ePoint = new wPoint();
        /*
        x = 0.0;
        y = 0.0;
        z = 0.0;
        */
    }

    /**
     * Constructor (xs_value,ys_value,xe_value,ye_value)
     * @param xs_value -x of start point;
     * @param ys_value -y of start point;
     * @param xe_value -x of end point;
     * @param ye_value -y of end point;
     */
    public EntLine(double xs_value,double ys_value,double xe_value,double ye_value) {
        this.sPoint = new wPoint(xs_value,ys_value);
        this.ePoint = new wPoint(xe_value,ye_value);

        /*
        x = x_value;
        y = y_value;
        z = 0.0;
        */
    }

    /**
     * Constructor (xs_value,ys_value,xe_value,ye_value)
     * @param xs_value -x of start point;
     * @param ys_value -y of start point;
     * @param zs_value -z of start point;
     * @param xe_value -x of end point;
     * @param ye_value -y of end point;
     * @param ze_value -z of end point;
     */
    public EntLine(double xs_value,double ys_value,double zs_value,double xe_value,double ye_value,double ze_value) {
        this.sPoint = new wPoint(xs_value,ys_value,zs_value);
        this.ePoint = new wPoint(xe_value,ye_value,ze_value);

        /*
        x = x_value;
        y = y_value;
        z = z_value;
        */
    }
	
    /**
     * Constructor (sPoint,ePoint)
     * @param sPoint -x of start point;
     * @param ePoint -y of start point;
     */
    public EntLine(wPoint2D sPoint,wPoint2D ePoint) {
        this.sPoint = new wPoint(sPoint.x,sPoint.y,0.0);
        this.ePoint = new wPoint(ePoint.x,ePoint.y,0.0);
    }

    /**
     * Constructor (sPoint,ePoint)
     * @param sPoint -x of start point;
     * @param ePoint -y of start point;
     */
    public EntLine(wPoint sPoint,wPoint ePoint) {
        this.sPoint = new wPoint(sPoint);
        this.ePoint = new wPoint(ePoint);
    }

    /**
     * Constructor (one_line)
     * @param one_line -one object derived from class EntLine;
     */
    public EntLine(EntLine one_line) {
        this.sPoint = one_line.sPoint;
        this.ePoint = one_line.ePoint;

        this.thickness = one_line.thickness;
        this.xExtrusionDirection = one_line.xExtrusionDirection;
        this.yExtrusionDirection = one_line.yExtrusionDirection;
        this.zExtrusionDirection = one_line.zExtrusionDirection;
    }

    /**
     * Get the vectorial Radian angle of the line. [0 -- 2*PI]
     */
	public double Angle2D(){
		double R_Angle;
		double delta_x,delta_y;
		
		delta_x = this.ePoint.x - this.sPoint.x;
		delta_y = this.ePoint.y - this.sPoint.y;
		R_Angle = Math.atan2(delta_y , delta_x);
		
		if (R_Angle < 0 ){
			R_Angle = 2 * Math.PI + R_Angle;
		}
		
		return R_Angle;
	}
	
    /**
     * Get the vectorial Radian angle of line. [0 -- 360]
     */
	public double Angle2D_D(){
		double R_Angle,D_Angle;

		R_Angle = this.Angle2D();
		
		D_Angle = Math.toDegrees(R_Angle);
		
		return D_Angle;
	}
	 
     /**
     * GetLength()
     * Get the length of the line;
     */
    public double GetLength() {
		double Length = 0.0;
		double dx,dy,dz;
			
		dx = this.ePoint.x - this.sPoint.x;
		dy = this.ePoint.y - this.sPoint.y;
		dz = this.ePoint.z - this.sPoint.z;
			
		Length = Math.sqrt(Math.pow(dx,2) + Math.pow(dy,2) + Math.pow(dz,2));

		return Length;
    }

	 /**
     * Print2D()
     * Terminal output x,y of sPoint and ePoint.(one line for one point)
     */
    public void Print2D() {
        System.out.println("Start point:  "+"x = "+sPoint.x+"   y = "+sPoint.y);
        System.out.println("End point:  "+"x = "+ePoint.x+"   y = "+ePoint.y);
    }

    /**
     * Print3D()
     * Terminal output x,y,z of sPoint and ePoint.(one line for one point)
     */
    public void Print3D() {
        System.out.println("Start point:  "+"x = "+sPoint.x+"   y = "+sPoint.y+"   z = "+sPoint.z);
        System.out.println("End point:  "+"x = "+ePoint.x+"   y = "+ePoint.y+"   z = "+ePoint.z);
    }

    /**
     * GetMapData()
     * @return Map of elements description of Entity LINE.
	 * <pre>Output example:
	 * Map's Size: 10
	 * key= Entity                     value= LINE
	 * key= zExtrusionDirection                        value= 1.0
	 * key= ClassLabel                 value= AcDbEntity
	 * key= xExtrusionDirection                        value= 0.0
	 * key= SubClassLabel                      value= AcDbLine
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

        params.addAll(sPoint.GetPairData());
        params.addAll(ePoint.GetPairData());

        params.add(new String[] {"thickness",Double.toString(thickness)});
        params.add(new String[] {"xExtrusionDirection",Double.toString(xExtrusionDirection)});
        params.add(new String[] {"yExtrusionDirection",Double.toString(yExtrusionDirection)});
        params.add(new String[] {"zExtrusionDirection",Double.toString(zExtrusionDirection)});


        return params;
    }

    /**
     * GetDXFData()
     * @return the dxf data of entity line.
	 * <pre>Output example:
	 * 0
	 * LINE
	 * 100
	 * AcDbEntity
	 * 8
	 * 0
	 * 100
	 * AcDbLine
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
		
		DXF_STR.addAll(sPoint.GetDXFData());
		/*
        DXF_STR.add("10");
        DXF_STR.add(Double.toString(sPoint.x));
        DXF_STR.add("20");
        DXF_STR.add(Double.toString(sPoint.y));
        DXF_STR.add("30");
        DXF_STR.add(Double.toString(sPoint.z));
		*/
        DXF_STR.add("  11");
        DXF_STR.add(Double.toString(ePoint.x));
        DXF_STR.add("  21");
        DXF_STR.add(Double.toString(ePoint.y));
        DXF_STR.add("  31");
        DXF_STR.add(Double.toString(ePoint.z));

        DXF_STR.add("  39");
        DXF_STR.add(Double.toString(thickness));
        DXF_STR.add("  210");
        DXF_STR.add(Double.toString(xExtrusionDirection));
        DXF_STR.add("  220");
        DXF_STR.add(Double.toString(yExtrusionDirection));
        DXF_STR.add("  230");
        DXF_STR.add(Double.toString(zExtrusionDirection));

        return DXF_STR;
    }

}