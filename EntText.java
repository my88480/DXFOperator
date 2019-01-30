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
     * code  5 - Handle.
     */
    public String Handle[];

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
	public wPoint bPoint;
	
	public wPoint iPoint[];
	
    /**
     * code  40 - Height.
     */
    public    double	height = 0.0;

    /**
     * code   1 - Text value (the string itself).
     */
    public    String	text = null;

	public String[] splitText;

    /**
     * code  50 - Rotation angle (optional; default = 0).
     */
    public    double	rotang          = 0.0;


    /**
     * code  41 - Relative X scale factor.
     *            For fit-type text (optional; default = 1.0).
     */
    public    double	relxscale  = 1.0;


    /**
     * code  51 - Oblique angle (optional default = 0).
     */
    public    double obliqueang = 0.0;


    /**
     * code   7 - Text style name (optional; default = "STANDARD").
     *            Set to style table reference.
     */
    public    String  style="Stardand";


    /**
     * code  71 - Text generation flags.
     * <UL>
     *   <LI>2 = Text is backward    (mirrored in X).
     *   <LI>4 = Text is upside down (mirrored in Y).
     * </UL>
     */
    public    int	textgenflags  = 0;


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
    public    int horzalignflags  = 0;


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
    public    int  vertalignflags  = 0;


    /**
     * code  11,21,31 -
     *      Alignment point.
     *      Present only if 72 or 73 group is present and nonzero.
     *      If the justification is anything other than baseline/left
     *      (groups 72 and 73 both 0), group code 11, 21, and 31 specify the
     *      alignment point (or the second alignment point for Aligned or Fit).
     *      (In OCS).
     */
    public    wPoint  second_point ;
	
	
	/**
	* code  39 - Thickness (optional; default  =  0).
	*/
	public double thickness = 0.0;

	public void SliceText(){
		String lines = this.text; 
		
		lines=lines.replace("\r\n","\n");
		lines=lines.replace("\n\r","\n");
		lines=lines.replace("\r","\n");
		splitText=lines.split("\n");
		//System.out.println("splitText's length: " + splitText.length);
		
		Handle = new String[splitText.length];
		iPoint = new wPoint[splitText.length];
		for (int i=0;i<splitText.length;i++){
			
			Handle[i] = FileDXF.ApplyHandle();
			iPoint[i] = new wPoint(this.bPoint.x,this.bPoint.y - (1.0 + 2.0 / 3.0) * this.height * i,this.bPoint.z);
		}
	}
 
	/**
     * Constructor (empty).
     */
	public EntText(){
		this.bPoint = new wPoint();
		this.second_point = new wPoint();
		this.height = 5.0;
		//this.text = null;
		this.text = "";
		this.SliceText();
	}
	
    /**
     * Constructor (x)
     */
	public EntText(String str){
		this.bPoint = new wPoint();
		this.second_point = new wPoint();
		this.height = 5.0;
		this.text = str;
		this.SliceText();
	}
	
    /**
     * Constructor (x_value,height_value,str)
     * @param x_value
     */
	public EntText(double x_value,double height_value,String str){
		this.bPoint = new wPoint(x_value);
		this.second_point = new wPoint();
		this.height = height_value;
		this.text = str;
		this.SliceText();
	}
	
    /**
     * Constructor (x_value,y_value,height_value,str)
     * @param x_value
     * @param y_value
     */
	public EntText(double x_value,double y_value,double height_value,String str){
		this.bPoint = new wPoint(x_value,y_value);
		this.second_point = new wPoint();
		this.height = height_value;
		this.text = str;
		this.SliceText();
	}
	
    /**
     * Constructor (bPoint,height_value,str)
     * @param bPoint - insert point of the text
     * @param height_value - the height of the text
     * @param str -content of the text
     */
	public EntText(wPoint2D bPoint,double height_value,String str){
		this.bPoint = new wPoint(bPoint);
		this.second_point = new wPoint();
		this.height = height_value;
		this.text = str;
		this.SliceText();
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
		this.bPoint = new wPoint(x_value,y_value,z_value);
		this.second_point = new wPoint();
		this.height = height_value;
		this.text = str;
		this.SliceText();
	}

    /**
     * Constructor (bPoint,height_value,str)
     * @param bPoint - insert point of the text
     * @param height_value - the height of the text
     * @param str -content of the text
     */
	public EntText(wPoint bPoint,double height_value,String str){
		this.bPoint = bPoint;
		this.second_point = new wPoint();
		this.height = height_value;
		this.text = str;
		this.SliceText();
	}
	
    /**
     * Constructor (Class EntText)
     * @param oneText
     */
	public EntText(EntText oneText){
		this.bPoint = new wPoint(oneText.bPoint);
		this.second_point = new wPoint(oneText.second_point);
		
		this.height = oneText.height;
		this.text = oneText.text;
		this.thickness = oneText.thickness;
		this.rotang = oneText.rotang;
		
		this.relxscale = oneText.relxscale;
		this.obliqueang = oneText.obliqueang;
		this.style = oneText.style;
		this.textgenflags = oneText.textgenflags;
		this.horzalignflags = oneText.horzalignflags;
		this.vertalignflags = oneText.vertalignflags;
		this.SliceText();
	}
	
    /**
     * Print2D()
     * Terminal output x,y of the text.
     */
	public void Print2D(){
		if (this.text.length()>0){
			
			for (int i = 0;i < splitText.length && splitText[0].length() > 0 ; i++) {  
				System.out.println("x = " + this.bPoint.x + "   y = " + (this.bPoint.y - (1.0 + 2.0 / 3.0) * this.height * i));
				System.out.println("height = "+this.height);
				System.out.println("TEXT: " + splitText[i]);
			}
			
		}
	}		
	
    /**
     * Print3D()
     * Terminal output x,y,z of the text.
     */
	public void Print3D(){
		if (this.text.length()>0){
			for (int i=0;i<splitText.length;i++) {  
				System.out.println("x = " + this.bPoint.x + "   y = " + (this.bPoint.y - (1.0 + 2.0 / 3.0) * this.height * i) + "   z = "+ this.bPoint.z);
				System.out.println("height = "+this.height);
				System.out.println("TEXT:   " + splitText[i]);
			}
		}		
	}		
	
    /**
     * GetDXFData()
     * @return the dxf data of entity text.
	 * <pre>Output example:
	*   0
	* TEXT
	*   5
	* 113
	* 330
	* 1A7
	* 100
	* AcDbEntity
	*   8
	* 0
	* 100
	* AcDbText
	*  10
	* 0.0
	*  20
	* -194.25
	*  30
	* 0.0
	*  40
	* 27.75
	*   1
	* QUANTITY:10
	* 100
	* AcDbText
	*   0
	* TEXT
	*   5
	* 114
	* 330
	* 1A7
	* 100
	* AcDbEntity
	*   8
	* 0
	* 100
	* AcDbText
	*  10
	* 0.0
	*  20
	* -240.5
	*  30
	* 0.0
	*  40
	* 27.75
	*   1
	* REMARK:Deviation:0.1mm
	* 100
	* AcDbText</pre>
     */
	 public List<String> GetDXFData(){
		List<String> DXF_STR = new ArrayList<>();
		
		if (this.text.length()>0){
			for (int i=0;i<splitText.length;i++) {  
				DXF_STR.add("  0");
				DXF_STR.add(this.EntityName);
				
				DXF_STR.add("  5");
				//DXF_STR.add(this.Handle);
				DXF_STR.add(Handle[i]);

				DXF_STR.add("  100");
				DXF_STR.add(this.ClassLabel);

				DXF_STR.addAll(super.GetDXFData());

				DXF_STR.add("  100");
				DXF_STR.add(this.SubClassLabel);
				
				//DXF_STR.addAll(this.bPoint.GetDXFData());
				/*
				DXF_STR.add("  10");
				DXF_STR.add(Double.toString(iPoint[i].x));
				DXF_STR.add("  20");
				DXF_STR.add(Double.toString(iPoint[i].y));
				DXF_STR.add("  30");
				DXF_STR.add(Double.toString(iPoint[i].z));
				*/
				DXF_STR.addAll(iPoint[i].GetDXFData());
				
				DXF_STR.add("  40");
				DXF_STR.add(Double.toString(this.height));
				DXF_STR.add("  1");
				//DXF_STR.add(this.text);
				DXF_STR.add(splitText[i]);
				
				DXF_STR.add("  39");	
				DXF_STR.add(Double.toString(this.thickness));	
				DXF_STR.add("  50");	
				DXF_STR.add(Double.toString(this.rotang));	

				DXF_STR.add("  100");
				DXF_STR.add(this.SubClassLabel);
			}  
		}
		return DXF_STR;
	}

}