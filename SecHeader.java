//This Version support AC1009,the dxf file created can be imported into all the versions of AutoCAD

import java.util.*;

/**
 * HEADER section.
 * @author David wu - Sunpower Corp.
 * thanks to  Ed Karlo - Y Systems, LLC for the variables definition
 */
public class SecHeader
{
     /**
     * code  0 -Entity section header.
     */
    public String SectionHeader = "SECTION";

    /**
     * code  0 -Entity section name.
     */
    public String SectionName = "HEADER";

    /**
     * code  0 -Entity section END.
     */
    public String SectionTail = "ENDSEC";

   /**
     * The AutoCAD drawing database version number.
     * <UL>
     *   <LI>MC0.0 - DWG from Rel. 1.1
     *   <LI>AC1.2 - DWG from Rel. 1.2
     *   <LI>AC1.4 - DWG from Rel. 1.4
     *   <LI>AC1.50 - DWG from Rel. 2.0
     *   <LI>AC2.10 - DWG from Rel. 2.10
     *   <LI>AC1002 - DWG from Rel. 2.5
     *   <LI>AC1003 - DWG from Rel. 2.6
     *   <LI>AC1004 - DWG from Rel.9
     *   <LI>AC1006 = R10
     *   <LI>AC1009 = R11 and R12
     *   <LI>AC1011 = R13
     *   <LI>AC1006 - DWG from Rel.10
     *   <LI>AC1009 - DWG from Rel.11/12 (or LT R1/R2)
     *   <LI>AC1012 - DWG from Rel.13 (or LT95)
     *   <LI>AC1014 - DWG from Rel.14, 14.01 (or LT97/LT98)
     *   <LI>AC1015 - DWG from AutoCAD 2000/2001/2002 (or LT, Map or relative Desktop version)
     *   <LI>AC1018 - DWG from AutoCAD 2004/2005/2006 (or other product in the "2004", "2005" or "2006" family)
     *   <LI>AC1021 - DWG from AutoCAD 2007/2008/2009 (or other product of the "2007", "2008" and "2009" families)
     *   <LI>AC1024 - DWG from AutoCAD 2010 (or other product of the "2010" family)	 
     *   <LI>AC1027 - CAD2013 2014 2015 2016 version.
     * </UL>
     */
    public    String                      acadver = "AC1009";                // code   1
                                    

    /**
     * Insert BasePoint.
     * <UL>
     *   <LI>10 = axis x value
     *   <LI>20 = axis y value
     *   <LI>30 = axis z value
     * </UL>
     */
    public    wPoint                         inserBasePoint  ;            
                                   
    /**
     * Units format for angles.
     * <UL>
     *   <LI>0 = decimal degrees
     *   <LI>1 = degrees / minutes / seconds
     *   <LI>2 = grads
     *   <LI>3 = radians
     *   <LI>4 = surveyor's units
     * </UL>
     */
    public    int                         aunits    = 0;               // code  70
                                   

    /**
     * Current entity color number.
     * <UL>
     *   <LI>0 = BYBLOCK
     *   <LI>256 = BYLAYER
     * </UL>
     */
    public    int                         cecolor    = 7;             // code  62
                                    

    /**
     * Current layer name.
     */
    public    String                      clayer    = "0";              // code   8
                                    

    /**
     * Current entity linetype name, or BYBLOCK or BYLAYER.
     */
    public    String                      celtype   = "0";              // code   6
                                    

    /**
     * code  10,20,30<br>
     *            X, Y, and Z drawing extents lower-left corner (in WCS).
     */
    public    wPoint2D               extmin ;

    /**
     * code  10,20,30<br>
     *            X, Y, and Z drawing extents upper-right corner (in WCS).
     */
    public    wPoint2D               extmax ;



    /**
     * Fill mode for solids.
     * <UL>
     *   <LI>0 = off - Objects are not filled.
     *   <LI>1 = on  - Objects are filled.
     * </UL>
     */
    public    int                         fillmode   = 1;             // code  70
                                    


    /**
     * code  10,20<br>
     *            X, Y drawing limits lower-left corner (in WCS).
     */
    public    wPoint2D               limmin;

    /**
     * code  10,20
     */
    public    wPoint2D               limmax ;


    /**
     * Global linetype scale factor.
     */
    public    double                      ltscale   = 1.0;              // code  40
                                    

	/**
     * Spline control polygon display.
     * <br>
     * 0 = Off
     * <UL>
     *   <LI>Does not display the control polygon for splines and spline-fit polylines.<br>
     *   <LI>Display the fit surface of a polygon mesh, not the defining mesh.
     *   <LI>Does not display the invisible edges of 3D faces or polyface meshes.
     * </UL>
     * 1 = On.
     * <UL>
     *   <LI>Displays the control polygon for splines and spline-fit polylines.
     *   <LI>Only the defining mesh of a surface-fit polygon mesh is displayed 
     *       (not the fit surface).
     *   <LI>Invisible edges of 3D faces or polyface meshes are displayed.
     *</UL>
     */
    public    int                         splframe   = 0;             // code  70
                                    

    /**
     * Viewport tilemode.
     * <br>
     * [From <I>AutoCAD DXF docs</I>]<br>
     * <UL>
     *    <LI>1 for previous release compatibility mode, <LI>0 otherwise.
     * </UL>
     * <br>
     * [From <I>AutoCAD programming in C/C++</I>]<br>
     * Sets how viewports can be arranged:
     * <UL>
     *   <LI>0 = (see book).
     *   <LI>1 = Viewports have to be tiled, ie they cover the whole
     *           graphics area and do not overlap.
     *   <LI>2 = Viewports in paperspace can be separate and/or overlap each 
     *           other.
     * </UL>
     */
    public    int                         tilemode    = 1;             // code  70
 


    /**
     * Constructor (empty)
     */
    public   SecHeader()
    {
		this.inserBasePoint = new wPoint(0.0,0.0,0.0);
		
		this.extmin = new wPoint2D(-800.0,-800.0);
		this.extmax = new wPoint2D(800.0,800.0);
		
		this.limmin = new wPoint2D(-800.0,-800.0);
		this.limmax = new wPoint2D(800.0,800.0);
    }


    /**
     * PrintAll()
     * <pre>Terminal output the description of start_point and end_point.(serveral lines)
	 * Output example:
	 * </pre>	 
     */
    public void PrintAll() {
        System.out.println("SectionHeader: " + this.SectionHeader);
        System.out.println("SectionName: " + this.SectionName);
        System.out.println("$ACADVER: " + this.acadver);

        System.out.println("$INSBASE: ");
        this.inserBasePoint.PrintAll();

        System.out.println("$EXTMIN: ");
        this.extmin.PrintAll();

        System.out.println("$EXTMAX: ");
        this.extmax.PrintAll();

        System.out.println("$LIMMIN: ");
        this.limmin.PrintAll();

        System.out.println("$LIMMAX: ");
        this.limmax.PrintAll();
		
        System.out.println("SectionTail: " + this.SectionTail);
		
    }

    /**
     * GetPairData()
     * @return Map of elements description of Entity LINE.
	 * <pre>Output example:
	 * </pre>
     */
	public List<String []> GetPairData(){
		List<String []> params=new ArrayList<>();

		params.add(new String[] {"  0",this.SectionHeader});
		params.add(new String[] {"  2",this.SectionName});

		params.add(new String[] {"  9","$ACADVER"});
		params.add(new String[] {"  1",this.acadver});

		params.add(new String[] {"  9","$INSBASE"});
        params.addAll(this.inserBasePoint.GetPairData());

		params.add(new String[] {"  9","$EXTMIN"});
        params.addAll(this.extmin.GetPairData());

		params.add(new String[] {"  9","$EXTMAX"});
        params.addAll(this.extmax.GetPairData());

		params.add(new String[] {"  9","$LIMMIN"});
        params.addAll(this.limmin.GetPairData());

		params.add(new String[] {"  9","$LIMMAX"});
        params.addAll(this.limmax.GetPairData());
		
		params.add(new String[] {"  0",this.SectionTail});

        return params;
    }

    /**
     * GetDXFData()
     * @return the dxf data of entity line.
	 * <pre>Output example:
	 * 1.0</pre>
     */
    public List<String> GetDXFData() {

		List<String> DXF_STR = new ArrayList<>();
		/*
        DXF_STR.add("  0");
        DXF_STR.add(this.SectionHeader);
        DXF_STR.add("  2");
        DXF_STR.add(this.SectionName);

        DXF_STR.add("  9");
        DXF_STR.add("$ACADVER");
        DXF_STR.add("  1");
        DXF_STR.add(this.acadver);

        DXF_STR.add("  9");
        DXF_STR.add("$INSBASE");
        DXF_STR.addAll(this.inserBasePoint.GetDXFData());

        DXF_STR.add("  9");
        DXF_STR.add("$EXTMIN");
        DXF_STR.addAll(this.extmin.GetDXFData());

        DXF_STR.add("  9");
        DXF_STR.add("$EXTMAX");
        DXF_STR.addAll(this.extmax.GetDXFData());

        DXF_STR.add("  9");
        DXF_STR.add("$LIMMIN");
        DXF_STR.addAll(this.limmin.GetDXFData());

        DXF_STR.add("  9");
        DXF_STR.add("$LIMMAX");
        DXF_STR.addAll(this.limmax.GetDXFData());

		
        DXF_STR.add("  0");
        DXF_STR.add(this.SectionTail);
		*/
		
		for (int i=0;i< StdSectionStr_R12.length;i++){
			DXF_STR.add(StdSectionStr_R12[i]);
		}
		
        return DXF_STR;
    }

    public String toString() {
		/* require the jar file --- common-lang3
		List<String> DXF_STR = new ArrayList<>();
		String returnString = new String();
		
        DXF_STR = this.GetDXFData();
		returnString = String.join(",",DXF_STR);
		*/

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
	
	public String[] StdSectionStr_R12 = {
		"  0",
		"SECTION",
		"  2",
		"HEADER",
		"  9",
		"$ACADVER",
		"  1",
		"AC1009",
		"  9",
		"$INSBASE",
		" 10",
		"0.0",
		" 20",
		"0.0",
		" 30",
		"0.0",
		"  9",
		"$EXTMIN",
		" 10",
		"-0.0488251447111452",
		" 20",
		"-0.0530499242577207",
		" 30",
		"-0.0000000349181948",
		"  9",
		"$EXTMAX",
		" 10",
		"500.0274691497832",
		" 20",
		"49.085886408848182",
		" 30",
		"0.0000000814935747",
		"  9",
		"$LIMMIN",
		" 10",
		"0.0",
		" 20",
		"0.0",
		"  9",
		"$LIMMAX",
		" 10",
		"800.0",
		" 20",
		"800.0",
		"  9",
		"$ORTHOMODE",
		" 70",
		"     0",
		"  9",
		"$REGENMODE",
		" 70",
		"     1",
		"  9",
		"$FILLMODE",
		" 70",
		"     1",
		"  9",
		"$QTEXTMODE",
		" 70",
		"     0",
		"  9",
		"$MIRRTEXT",
		" 70",
		"     0",
		"  9",
		"$DRAGMODE",
		" 70",
		"     2",
		"  9",
		"$LTSCALE",
		" 40",
		"1.0",
		"  9",
		"$OSMODE",
		" 70",
		"    37",
		"  9",
		"$ATTMODE",
		" 70",
		"     1",
		"  9",
		"$TEXTSIZE",
		" 40",
		"0.2",
		"  9",
		"$TRACEWID",
		" 40",
		"0.05",
		"  9",
		"$TEXTSTYLE",
		"  7",
		"STANDARD",
		"  9",
		"$CLAYER",
		"  8",
		"0",
		"  9",
		"$CELTYPE",
		"  6",
		"CONTINUOUS",
		"  9",
		"$CECOLOR",
		" 62",
		"   256",
		"  9",
		"$DIMSCALE",
		" 40",
		"50.0",
		"  9",
		"$DIMASZ",
		" 40",
		"0.18",
		"  9",
		"$DIMEXO",
		" 40",
		"0.0625",
		"  9",
		"$DIMDLI",
		" 40",
		"0.38",
		"  9",
		"$DIMRND",
		" 40",
		"0.0",
		"  9",
		"$DIMDLE",
		" 40",
		"0.0",
		"  9",
		"$DIMEXE",
		" 40",
		"0.18",
		"  9",
		"$DIMTP",
		" 40",
		"0.0",
		"  9",
		"$DIMTM",
		" 40",
		"0.0",
		"  9",
		"$DIMTXT",
		" 40",
		"0.18",
		"  9",
		"$DIMCEN",
		" 40",
		"0.09",
		"  9",
		"$DIMTSZ",
		" 40",
		"0.0",
		"  9",
		"$DIMTOL",
		" 70",
		"     0",
		"  9",
		"$DIMLIM",
		" 70",
		"     0",
		"  9",
		"$DIMTIH",
		" 70",
		"     1",
		"  9",
		"$DIMTOH",
		" 70",
		"     1",
		"  9",
		"$DIMSE1",
		" 70",
		"     0",
		"  9",
		"$DIMSE2",
		" 70",
		"     0",
		"  9",
		"$DIMTAD",
		" 70",
		"     0",
		"  9",
		"$DIMZIN",
		" 70",
		"     0",
		"  9",
		"$DIMBLK",
		"  1",
		"",
		"  9",
		"$DIMASO",
		" 70",
		"     1",
		"  9",
		"$DIMSHO",
		" 70",
		"     1",
		"  9",
		"$DIMPOST",
		"  1",
		"",
		"  9",
		"$DIMAPOST",
		"  1",
		"",
		"  9",
		"$DIMALT",
		" 70",
		"     0",
		"  9",
		"$DIMALTD",
		" 70",
		"     2",
		"  9",
		"$DIMALTF",
		" 40",
		"25.399999999999999",
		"  9",
		"$DIMLFAC",
		" 40",
		"1.0",
		"  9",
		"$DIMTOFL",
		" 70",
		"     0",
		"  9",
		"$DIMTVP",
		" 40",
		"0.0",
		"  9",
		"$DIMTIX",
		" 70",
		"     0",
		"  9",
		"$DIMSOXD",
		" 70",
		"     0",
		"  9",
		"$DIMSAH",
		" 70",
		"     0",
		"  9",
		"$DIMBLK1",
		"  1",
		"",
		"  9",
		"$DIMBLK2",
		"  1",
		"",
		"  9",
		"$DIMSTYLE",
		"  2",
		"STANDARD",
		"  9",
		"$DIMCLRD",
		" 70",
		"     6",
		"  9",
		"$DIMCLRE",
		" 70",
		"     6",
		"  9",
		"$DIMCLRT",
		" 70",
		"     0",
		"  9",
		"$DIMTFAC",
		" 40",
		"1.0",
		"  9",
		"$DIMGAP",
		" 40",
		"0.09",
		"  9",
		"$LUNITS",
		" 70",
		"     2",
		"  9",
		"$LUPREC",
		" 70",
		"     4",
		"  9",
		"$SKETCHINC",
		" 40",
		"0.1",
		"  9",
		"$FILLETRAD",
		" 40",
		"0.0",
		"  9",
		"$AUNITS",
		" 70",
		"     0",
		"  9",
		"$AUPREC",
		" 70",
		"     0",
		"  9",
		"$MENU",
		"  1",
		".",
		"  9",
		"$ELEVATION",
		" 40",
		"0.0",
		"  9",
		"$PELEVATION",
		" 40",
		"0.0",
		"  9",
		"$THICKNESS",
		" 40",
		"0.0",
		"  9",
		"$LIMCHECK",
		" 70",
		"     0",
		"  9",
		"$BLIPMODE",
		" 70",
		"     0",
		"  9",
		"$CHAMFERA",
		" 40",
		"0.0",
		"  9",
		"$CHAMFERB",
		" 40",
		"0.0",
		"  9",
		"$SKPOLY",
		" 70",
		"     0",
		"  9",
		"$TDCREATE",
		" 40",
		"2458513.6223174538",
		"  9",
		"$TDUPDATE",
		" 40",
		"2458513.6479018871",
		"  9",
		"$TDINDWG",
		" 40",
		"0.006358912",
		"  9",
		"$TDUSRTIMER",
		" 40",
		"0.0063584954",
		"  9",
		"$USRTIMER",
		" 70",
		"     1",
		"  9",
		"$ANGBASE",
		" 50",
		"0.0",
		"  9",
		"$ANGDIR",
		" 70",
		"     0",
		"  9",
		"$PDMODE",
		" 70",
		"     0",
		"  9",
		"$PDSIZE",
		" 40",
		"0.0",
		"  9",
		"$PLINEWID",
		" 40",
		"0.0",
		"  9",
		"$COORDS",
		" 70",
		"     1",
		"  9",
		"$SPLFRAME",
		" 70",
		"     0",
		"  9",
		"$SPLINETYPE",
		" 70",
		"     6",
		"  9",
		"$SPLINESEGS",
		" 70",
		"     8",
		"  9",
		"$ATTDIA",
		" 70",
		"     0",
		"  9",
		"$ATTREQ",
		" 70",
		"     1",
		"  9",
		"$HANDLING",
		" 70",
		"     1",
		"  9",
		"$SURFTAB1",
		" 70",
		"     6",
		"  9",
		"$SURFTAB2",
		" 70",
		"     6",
		"  9",
		"$SURFTYPE",
		" 70",
		"     6",
		"  9",
		"$SURFU",
		" 70",
		"     6",
		"  9",
		"$SURFV",
		" 70",
		"     6",
		"  9",
		"$UCSNAME",
		"  2",
		"",
		"  9",
		"$UCSORG",
		" 10",
		"0.0",
		" 20",
		"0.0",
		" 30",
		"0.0",
		"  9",
		"$UCSXDIR",
		" 10",
		"1.0",
		" 20",
		"0.0",
		" 30",
		"0.0",
		"  9",
		"$UCSYDIR",
		" 10",
		"0.0",
		" 20",
		"1.0",
		" 30",
		"0.0",
		"  9",
		"$PUCSNAME",
		"  2",
		"",
		"  9",
		"$PUCSORG",
		" 10",
		"0.0",
		" 20",
		"0.0",
		" 30",
		"0.0",
		"  9",
		"$PUCSXDIR",
		" 10",
		"1.0",
		" 20",
		"0.0",
		" 30",
		"0.0",
		"  9",
		"$PUCSYDIR",
		" 10",
		"0.0",
		" 20",
		"1.0",
		" 30",
		"0.0",
		"  9",
		"$USERI1",
		" 70",
		"     0",
		"  9",
		"$USERI2",
		" 70",
		"     0",
		"  9",
		"$USERI3",
		" 70",
		"     0",
		"  9",
		"$USERI4",
		" 70",
		"     0",
		"  9",
		"$USERI5",
		" 70",
		"     0",
		"  9",
		"$USERR1",
		" 40",
		"0.0",
		"  9",
		"$USERR2",
		" 40",
		"0.0",
		"  9",
		"$USERR3",
		" 40",
		"0.0",
		"  9",
		"$USERR4",
		" 40",
		"0.0",
		"  9",
		"$USERR5",
		" 40",
		"0.0",
		"  9",
		"$WORLDVIEW",
		" 70",
		"     1",
		"  9",
		"$SHADEDGE",
		" 70",
		"     3",
		"  9",
		"$SHADEDIF",
		" 70",
		"    70",
		"  9",
		"$TILEMODE",
		" 70",
		"     1",
		"  9",
		"$MAXACTVP",
		" 70",
		"    64",
		"  9",
		"$PLIMCHECK",
		" 70",
		"     0",
		"  9",
		"$PEXTMIN",
		" 10",
		"1.0000000000000000E+020",
		" 20",
		"1.0000000000000000E+020",
		" 30",
		"1.0000000000000000E+020",
		"  9",
		"$PEXTMAX",
		" 10",
		"-1.0000000000000000E+020",
		" 20",
		"-1.0000000000000000E+020",
		" 30",
		"-1.0000000000000000E+020",
		"  9",
		"$PLIMMIN",
		" 10",
		"0.0",
		" 20",
		"0.0",
		"  9",
		"$PLIMMAX",
		" 10",
		"12.0",
		" 20",
		"9.0",
		"  9",
		"$UNITMODE",
		" 70",
		"     0",
		"  9",
		"$VISRETAIN",
		" 70",
		"     1",
		"  9",
		"$PLINEGEN",
		" 70",
		"     0",
		"  9",
		"$PSLTSCALE",
		" 70",
		"     1",
		"  0",
		"ENDSEC"
	};
}

