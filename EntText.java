//package www
//AutoCAD Entity--Text
import java.util.*;
import java.io.*;

/**
 * @author David Wu <809758521@qq.com>
 * @version V0.2
 * Entity Text of AutoCAD DXF file.
 */
public class EntText extends EntBase{
    /**
     * code  0 -Entity name.
     */
    public String EntityName = "TEXT";

    /**
     * code  100 -Class Label.
     */
	public String ClassLabel = "AcDbEntity";
    
    /**
     * code  100 -Sub Class Label.
     */
	public String SubClassLabel = "AcDbText";

    /**
     * code  10,20,30 -Text location (in WCS).
     */
	public wPoint base_point;
	
    /**
     * code  40 - Height.
     */
    public    double                      height          = 0.0;

    /**
     * code   1 - Text value (the string itself).
     */
    public    String                      text            = null;


    /**
     * code  50 - Rotation angle (optional; default = 0).
     */
    public    double                      rotang          = 0.0;


    /**
     * code  41 - Relative X scale factor.
     *            For fit-type text (optional; default = 1.0).
     */
    public    double                      relxscale       = 1.0;


    /**
     * code  51 - Oblique angle (optional default = 0).
     */
    public    double                      obliqueang      = 0.0;


    /**
     * code   7 - Text style name (optional; default = "STANDARD").
     *            Set to style table reference.
     */
    public    String                style="Stardand";


    /**
     * code  71 - Text generation flags.
     * <UL>
     *   <LI>2 = Text is backward    (mirrored in X).
     *   <LI>4 = Text is upside down (mirrored in Y).
     * </UL>
     */
    public    int                         textgenflags    = 0;


    /**
     * code  72 - Horizontal alignment (optional, default = 0).
     *            Integer codes (not bitcoded).
     * <UL>
     *   <LI>0 = Left
     *   <LI>1 = Center
     *   <LI>2 = Right
     *   <LI>3 = Aligned (if vertical alignment = 0).
     *   <LI>4 = Middle  (if vertical alignment = 0).
     *   <LI>5 = Fit     (if vertical alignment = 0).
     * </UL>
     *      See vertalignflags for clarification.
     */
    public    int                         horzalignflags  = 0;


    /**
     * code  73 - Vertical alignment (optional, default = 0).
     *            Integer codes (not bitcoded)
     * <UL>
     *   <LI>0 = Baseline
     *   <LI>1 = Bottom
     *   <LI>2 = Middle
     *   <LI>3 = Top
     * </UL>
     *       See second_point for clarification.
     */
    public    int                         vertalignflags  = 0;


    /**
     * code  11,21,31 -
     *      Alignment point.
     *      Present only if 72 or 73 group is present and nonzero.
     *      If the justification is anything other than baseline/left
     *      (groups 72 and 73 both 0), group code 11, 21, and 31 specify the
     *      alignment point (or the second alignment point for Aligned or Fit).
     *      (In OCS).
     */
    public    wPoint               second_point ;
	
	
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
	public EntText(){
		this.base_point = new wPoint();
		this.second_point = new wPoint();
		this.height = 5.0;
		//this.text = null;
		this.text = "";
	}
	
    /**
     * Constructor (x)
     */
	public EntText(String str){
		this.base_point = new wPoint();
		this.second_point = new wPoint();
		this.height = 5.0;
		this.text = str;
	}
	
    /**
     * Constructor (x_value,height_value,str)
     * @param x_value
     */
	public EntText(double x_value,double height_value,String str){
		this.base_point = new wPoint(x_value);
		this.second_point = new wPoint();
		this.height = height_value;
		this.text = str;
	}
	
    /**
     * Constructor (x_value,y_value,height_value,str)
     * @param x_value
     * @param y_value
     */
	public EntText(double x_value,double y_value,double height_value,String str){
		this.base_point = new wPoint(x_value,y_value);
		this.second_point = new wPoint();
		this.height = height_value;
		this.text = str;
	}
	
    /**
     * Constructor (bPoint,height_value,str)
     * @param bPoint - insert point of the text
     * @param height_value - the height of the text
     * @param str -content of the text
     */
	public EntText(wPoint2D bPoint,double height_value,String str){
		this.base_point = new wPoint(bPoint);
		this.second_point = new wPoint();
		this.height = height_value;
		this.text = str;
	}
	
    /**
     * Constructor (x_value,y_value,z_value,height_value,str)
     * @param x_value
     * @param y_value
     * @param z_value
     * @param height_value - the height of the text
     * @param str -content of the text
     */
	public EntText(double x_value,double y_value,double z_value,double height_value,String str){
		this.base_point = new wPoint(x_value,y_value,z_value);
		this.second_point = new wPoint();
		this.height = height_value;
		this.text = str;
	}

    /**
     * Constructor (bPoint,height_value,str)
     * @param bPoint - insert point of the text
     * @param height_value - the height of the text
     * @param str -content of the text
     */
	public EntText(wPoint bPoint,double height_value,String str){
		this.base_point = bPoint;
		this.second_point = new wPoint();
		this.height = height_value;
		this.text = str;
	}
	
    /**
     * Constructor (Class EntText)
     * @param onetext
     */
	public EntText(EntText onetext){
		this.base_point = new wPoint(onetext.base_point);
		this.second_point = new wPoint(onetext.second_point);
		
		this.height = onetext.height;
		this.text = onetext.text;
		this.thickness = onetext.thickness;
		this.rotang = onetext.rotang;
		this.xExtrusionDirection = onetext.xExtrusionDirection;
		this.yExtrusionDirection = onetext.yExtrusionDirection;
		this.zExtrusionDirection = onetext.zExtrusionDirection;
		
		this.relxscale = onetext.relxscale;
		this.obliqueang = onetext.obliqueang;
		this.style = onetext.style;
		this.textgenflags = onetext.textgenflags;
		this.horzalignflags = onetext.horzalignflags;
		this.vertalignflags = onetext.vertalignflags;
	}
	
    /**
     * Print2D()
     * Terminal output x,y of the text.
     */
	public void Print2D(){
		if (this.text.length()>0){
			String lines = this.text; 
			
			lines=lines.replace("\r\n","\n");
			lines=lines.replace("\n\r","\n");
			lines=lines.replace("\r","\n");
			String[] splitstr=lines.split("\n");
			//System.out.println("splitstr's length: " + splitstr.length);
			
			for (int i = 0;i < splitstr.length && splitstr[0].length() > 0 ; i++) {  
				System.out.println("x = " + this.base_point.x + "   y = " + (this.base_point.y - (1.0 + 2.0 / 3.0) * this.height * i));
				System.out.println("height = "+this.height);
				System.out.println("TEXT: " + splitstr[i]);
			}
			
		}
	}		
	
    /**
     * Print3D()
     * Terminal output x,y,z of the text.
     */
	public void Print3D(){
		if (this.text.length()>0){
			String lines = this.text; 
			lines=lines.replace("\r\n","\n");
			lines=lines.replace("\n\r","\n");
			lines=lines.replace("\r","\n");
			String[] splitstr=lines.split("\n");

			for (int i=0;i<splitstr.length;i++) {  
				System.out.println("x = " + this.base_point.x+"   y = " + (this.base_point.y - (1.0 + 2.0 / 3.0) * this.height * i) + "   z = "+ this.base_point.z);
				System.out.println("height = "+this.height);
				System.out.println("TEXT:   " + splitstr[i]);
			}
		}		
	}		
	
	public void PrintAll(){
		if (this.text.length()>0){
			String lines = this.text; 
			lines=lines.replace("\r\n","\n");
			lines=lines.replace("\n\r","\n");
			lines=lines.replace("\r","\n");
			String[] splitstr=lines.split("\n");

			for (int i=0;i<splitstr.length;i++) {  

				System.out.println();
				System.out.println("Entity Type: " + this.EntityName);
				System.out.println("ClassLabel: " + this.ClassLabel);
				
				super.PrintAll();
				
				System.out.println("SubClassLabel: " + this.SubClassLabel);
				
				//base_point.PrintAll();
				System.out.println("x = " + this.base_point.x);
				System.out.println("y = " + (this.base_point.y - (1.0 + 2.0 / 3.0) * this.height * i));
				System.out.println("z = " + this.base_point.z);
				
				System.out.println("height = " + this.height);
				//System.out.println("TEXT: "+this.text);
				System.out.println("TEXT: " + splitstr[i]);
				System.out.println("thickness = " +this.thickness);
				System.out.println("rotang = " + this.rotang);
				System.out.println("xExtrusionDirection = " + this.xExtrusionDirection);
				System.out.println("yExtrusionDirection = " + this.yExtrusionDirection);
				System.out.println("zExtrusionDirection = " + this.zExtrusionDirection);
			}
		}	
	}		

	
	public List<String []> GetPairData(){
		List<String []> params=new ArrayList<>();
		if (this.text.length()>0){

			String lines = this.text; 
			lines=lines.replace("\r\n","\n");
			lines=lines.replace("\n\r","\n");
			lines=lines.replace("\r","\n");
			String[] splitstr=lines.split("\n");

			for (int i=0;i<splitstr.length;i++) {  
				params.add(new String[] {"Entity",this.EntityName});
				params.add(new String[] {"ClassLabel",this.ClassLabel});

				params.addAll(super.GetPairData());
				
				
				params.add(new String[] {"SubClassLabel",this.SubClassLabel});
				
				//params.addAll(this.base_point.GetPairData());
				params.add(new String[] {"x",Double.toString(this.base_point.x)});	
				params.add(new String[] {"y",Double.toString(this.base_point.y - (1.0 + 2.0 / 3.0) * this.height * i)});	
				params.add(new String[] {"z",Double.toString(this.base_point.z)});	

				params.add(new String[] {"height",Double.toString(this.height)});	
				params.add(new String[] {"text content",splitstr[i]});	
				params.add(new String[] {"thickness",Double.toString(this.thickness)});	
				params.add(new String[] {"rotang",Double.toString(this.rotang)});	
				params.add(new String[] {"xExtrusionDirection",Double.toString(this.xExtrusionDirection)});	
				params.add(new String[] {"yExtrusionDirection",Double.toString(this.yExtrusionDirection)});	
				params.add(new String[] {"zExtrusionDirection",Double.toString(this.zExtrusionDirection)});	
			}
		}	
		return params;
	}	
	
    /**
     * GetDXFData()
     * @return the dxf data of entity text.
	 * <pre>Output example:
	 * 0
	 * TEXT
	 * 100
	 * AcDbEntity
	 * 8
	 * 0
	 * 100
	 * AcDbText
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
		
		if (this.text.length()>0){
			String lines = this.text; 
			lines=lines.replace("\r\n","\n");
			lines=lines.replace("\n\r","\n");
			lines=lines.replace("\r","\n");
			String[] splitstr=lines.split("\n");

			for (int i=0;i<splitstr.length;i++) {  
		 

				DXF_STR.add("  0");
				DXF_STR.add(this.EntityName);
				DXF_STR.add("  100");
				DXF_STR.add(this.ClassLabel);

				DXF_STR.addAll(super.GetDXFData());

				DXF_STR.add("  100");
				DXF_STR.add(this.SubClassLabel);
				
				//DXF_STR.addAll(this.base_point.GetDXFData());
				DXF_STR.add("  10");
				DXF_STR.add(Double.toString(this.base_point.x));
				DXF_STR.add("  20");
				DXF_STR.add(Double.toString(this.base_point.y - (1.0 + 2.0 / 3.0) * this.height * i));
				DXF_STR.add("  30");
				DXF_STR.add(Double.toString(this.base_point.z));

				DXF_STR.add("  40");
				DXF_STR.add(Double.toString(this.height));
				DXF_STR.add("  1");
				//DXF_STR.add(this.text);
				DXF_STR.add(splitstr[i]);
				
				
				DXF_STR.add("  39");	
				DXF_STR.add(Double.toString(this.thickness));	
				DXF_STR.add("  50");	
				DXF_STR.add(Double.toString(this.rotang));	
				DXF_STR.add("  210");	
				DXF_STR.add(Double.toString(this.xExtrusionDirection));	
				DXF_STR.add("  220");	
				DXF_STR.add(Double.toString(this.yExtrusionDirection));	
				DXF_STR.add("  230");	
				DXF_STR.add(Double.toString(this.zExtrusionDirection));	
			}  
		}
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