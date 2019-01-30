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
    public    String   acadver = "AC1015";                // code   1
                                    

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
	   	List<String []>  myMap = this.GetPairData();
        System.out.println("Entity List's Size: "+myMap.size());
		for (String [] key : myMap) {
		   System.out.println("key= "+ key[0] + "\t\t\tvalue= " + key[1]);
		}
		System.out.println();		
		/*
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
		*/
		
    }

    /**
     * GetPairData()
     * @return Map of elements description of Entity LINE.
	 * <pre>Output example:
	 * </pre>
     */
	public List<String []> GetPairData(){
		List<String []> params=new ArrayList<>();

		for (int i=0;i< StdSectionStr_R2K01.length / 2; i= i + 2){
			params.add(new String[] {StdSectionStr_R2K01[i],StdSectionStr_R2K01[i+1]});
		}

		//List<String []>  myMap = mySecHeader.GetPairData();
        //System.out.println("PairData's Size: "+myMap.size());
		//for (String [] key : myMap) {
		//   System.out.println("key= "+ key[0] + "\t\t\tvalue= " + key[1]);
		//}

		/*
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
		*/

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
		
		for (int i=0;i< StdSectionStr_R2K01.length;i++){
			DXF_STR.add(StdSectionStr_R2K01[i]);
		}
		
		DXF_STR.add(FileDXF.hex_handle );
		
		for (int i=0;i< StdSectionStr_R2K02.length;i++){
			DXF_STR.add(StdSectionStr_R2K02[i]);
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
	
	public String[] StdSectionStr_R2K01 = {
		"  0",
		"SECTION",
		"  2",
		"HEADER",
		"  9",
		"$ACADVER",
		"  1",
		"AC1015",
		"  9",
		"$ACADMAINTVER",
		" 70",
		"     6",
		"  9",
		"$DWGCODEPAGE",
		"  3",
		"ANSI_1251",
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
		"1.000000000000000E+20",
		" 20",
		"1.000000000000000E+20",
		" 30",
		"1.000000000000000E+20",
		"  9",
		"$EXTMAX",
		" 10",
		"-1.000000000000000E+20",
		" 20",
		"-1.000000000000000E+20",
		" 30",
		"-1.000000000000000E+20",
		"  9",
		"$LIMMIN",
		" 10",
		"0.0",
		" 20",
		"0.0",
		"  9",
		"$LIMMAX",
		" 10",
		"420.0",
		" 20",
		"297.0",
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
		"$LTSCALE",
		" 40",
		"1.0",
		"  9",
		"$ATTMODE",
		" 70",
		"     1",
		"  9",
		"$TEXTSIZE",
		" 40",
		"350.0",
		"  9",
		"$TRACEWID",
		" 40",
		"1.0",
		"  9",
		"$TEXTSTYLE",
		"  7",
		"Standard",
		"  9",
		"$CLAYER",
		"  8",
		"0",
		"  9",
		"$CELTYPE",
		"  6",
		"ByLayer",
		"  9",
		"$CECOLOR",
		" 62",
		"   256",
		"  9",
		"$CELTSCALE",
		" 40",
		"1.0",
		"  9",
		"$DISPSILH",
		" 70",
		"     0",
		"  9",
		"$DIMSCALE",
		" 40",
		"0.05",
		"  9",
		"$DIMASZ",
		" 40",
		"200.0",
		"  9",
		"$DIMEXO",
		" 40",
		"2.0",
		"  9",
		"$DIMDLI",
		" 40",
		"100.0",
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
		"200.0",
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
		"350.0",
		"  9",
		"$DIMCEN",
		" 40",
		"2.5",
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
		"     0",
		"  9",
		"$DIMTOH",
		" 70",
		"     0",
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
		"     1",
		"  9",
		"$DIMZIN",
		" 70",
		"     8",
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
		"     3",
		"  9",
		"$DIMALTF",
		" 40",
		"0.03937007874016",
		"  9",
		"$DIMLFAC",
		" 40",
		"1.0",
		"  9",
		"$DIMTOFL",
		" 70",
		"     1",
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
		"ISO-25",
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
		"     6",
		"  9",
		"$DIMTFAC",
		" 40",
		"1.0",
		"  9",
		"$DIMGAP",
		" 40",
		"100.0",
		"  9",
		"$DIMJUST",
		" 70",
		"     0",
		"  9",
		"$DIMSD1",
		" 70",
		"     0",
		"  9",
		"$DIMSD2",
		" 70",
		"     0",
		"  9",
		"$DIMTOLJ",
		" 70",
		"     0",
		"  9",
		"$DIMTZIN",
		" 70",
		"     8",
		"  9",
		"$DIMALTZ",
		" 70",
		"     0",
		"  9",
		"$DIMALTTZ",
		" 70",
		"     0",
		"  9",
		"$DIMUPT",
		" 70",
		"     0",
		"  9",
		"$DIMDEC",
		" 70",
		"     1",
		"  9",
		"$DIMTDEC",
		" 70",
		"     1",
		"  9",
		"$DIMALTU",
		" 70",
		"     2",
		"  9",
		"$DIMALTTD",
		" 70",
		"     3",
		"  9",
		"$DIMTXSTY",
		"  7",
		"Standard",
		"  9",
		"$DIMAUNIT",
		" 70",
		"     0",
		"  9",
		"$DIMADEC",
		" 70",
		"     0",
		"  9",
		"$DIMALTRND",
		" 40",
		"0.0",
		"  9",
		"$DIMAZIN",
		" 70",
		"     0",
		"  9",
		"$DIMDSEP",
		" 70",
		"    46",
		"  9",
		"$DIMATFIT",
		" 70",
		"     3",
		"  9",
		"$DIMFRAC",
		" 70",
		"     0",
		"  9",
		"$DIMLDRBLK",
		"  1",
		"",
		"  9",
		"$DIMLUNIT",
		" 70",
		"     2",
		"  9",
		"$DIMLWD",
		" 70",
		"    -2",
		"  9",
		"$DIMLWE",
		" 70",
		"    -2",
		"  9",
		"$DIMTMOVE",
		" 70",
		"     0",
		"  9",
		"$LUNITS",
		" 70",
		"     2",
		"  9",
		"$LUPREC",
		" 70",
		"     3",
		"  9",
		"$SKETCHINC",
		" 40",
		"1.0",
		"  9",
		"$FILLETRAD",
		" 40",
		"10.0",
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
		"$CHAMFERA",
		" 40",
		"10.0",
		"  9",
		"$CHAMFERB",
		" 40",
		"10.0",
		"  9",
		"$CHAMFERC",
		" 40",
		"20.0",
		"  9",
		"$CHAMFERD",
		" 40",
		"0.0",
		"  9",
		"$SKPOLY",
		" 70",
		"     0",
		"  9",
		"$TDCREATE",
		" 40",
		"2455022.887359514",
		"  9",
		"$TDUCREATE",
		" 40",
		"2455022.637359514",
		"  9",
		"$TDUPDATE",
		" 40",
		"2456833.780451389",
		"  9",
		"$TDUUPDATE",
		" 40",
		"2456833.530451389",
		"  9",
		"$TDINDWG",
		" 40",
		"0.0",
		"  9",
		"$TDUSRTIMER",
		" 40",
		"2456833.52087963",
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
		"$HANDSEED",
		"  5"
	};
	
	public String[] StdSectionStr_R2K02 = {
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
		"$UCSBASE",
		"  2",
		"",
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
		"$UCSORTHOREF",
		"  2",
		"",
		"  9",
		"$UCSORTHOVIEW",
		" 70",
		"     0",
		"  9",
		"$UCSORGTOP",
		" 10",
		"0.0",
		" 20",
		"0.0",
		" 30",
		"0.0",
		"  9",
		"$UCSORGBOTTOM",
		" 10",
		"0.0",
		" 20",
		"0.0",
		" 30",
		"0.0",
		"  9",
		"$UCSORGLEFT",
		" 10",
		"0.0",
		" 20",
		"0.0",
		" 30",
		"0.0",
		"  9",
		"$UCSORGRIGHT",
		" 10",
		"0.0",
		" 20",
		"0.0",
		" 30",
		"0.0",
		"  9",
		"$UCSORGFRONT",
		" 10",
		"0.0",
		" 20",
		"0.0",
		" 30",
		"0.0",
		"  9",
		"$UCSORGBACK",
		" 10",
		"0.0",
		" 20",
		"0.0",
		" 30",
		"0.0",
		"  9",
		"$PUCSBASE",
		"  2",
		"",
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
		"$PUCSORTHOREF",
		"  2",
		"",
		"  9",
		"$PUCSORTHOVIEW",
		" 70",
		"     0",
		"  9",
		"$PUCSORGTOP",
		" 10",
		"0.0",
		" 20",
		"0.0",
		" 30",
		"0.0",
		"  9",
		"$PUCSORGBOTTOM",
		" 10",
		"0.0",
		" 20",
		"0.0",
		" 30",
		"0.0",
		"  9",
		"$PUCSORGLEFT",
		" 10",
		"0.0",
		" 20",
		"0.0",
		" 30",
		"0.0",
		"  9",
		"$PUCSORGRIGHT",
		" 10",
		"0.0",
		" 20",
		"0.0",
		" 30",
		"0.0",
		"  9",
		"$PUCSORGFRONT",
		" 10",
		"0.0",
		" 20",
		"0.0",
		" 30",
		"0.0",
		"  9",
		"$PUCSORGBACK",
		" 10",
		"0.0",
		" 20",
		"0.0",
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
		"$PINSBASE",
		" 10",
		"0.0",
		" 20",
		"0.0",
		" 30",
		"0.0",
		"  9",
		"$PLIMCHECK",
		" 70",
		"     0",
		"  9",
		"$PEXTMIN",
		" 10",
		"1.000000000000000E+20",
		" 20",
		"1.000000000000000E+20",
		" 30",
		"1.000000000000000E+20",
		"  9",
		"$PEXTMAX",
		" 10",
		"-1.000000000000000E+20",
		" 20",
		"-1.000000000000000E+20",
		" 30",
		"-1.000000000000000E+20",
		"  9",
		"$PLIMMIN",
		" 10",
		"0.0",
		" 20",
		"0.0",
		"  9",
		"$PLIMMAX",
		" 10",
		"0.0",
		" 20",
		"0.0",
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
		"  9",
		"$TREEDEPTH",
		" 70",
		"  3020",
		"  9",
		"$CMLSTYLE",
		"  2",
		"Standard",
		"  9",
		"$CMLJUST",
		" 70",
		"     0",
		"  9",
		"$CMLSCALE",
		" 40",
		"20.0",
		"  9",
		"$PROXYGRAPHICS",
		" 70",
		"     1",
		"  9",
		"$MEASUREMENT",
		" 70",
		"     1",
		"  9",
		"$CELWEIGHT",
		"370",
		"    -1",
		"  9",
		"$ENDCAPS",
		"280",
		"     0",
		"  9",
		"$JOINSTYLE",
		"280",
		"     0",
		"  9",
		"$LWDISPLAY",
		"290",
		"     0",
		"  9",
		"$INSUNITS",
		" 70",
		"     4",
		"  9",
		"$HYPERLINKBASE",
		"  1",
		"",
		"  9",
		"$STYLESHEET",
		"  1",
		"",
		"  9",
		"$XEDIT",
		"290",
		"     1",
		"  9",
		"$CEPSNTYPE",
		"380",
		"     0",
		"  9",
		"$PSTYLEMODE",
		"290",
		"     1",
		"  9",
		"$FINGERPRINTGUID",
		"  2",
		"{EC6BB858-51AA-46EC-B484-6C9CC7AB3E2E}",
		"  9",
		"$VERSIONGUID",
		"  2",
		"{FAEB1C32-E019-11D5-929B-00C0DF256EC4}",
		"  9",
		"$EXTNAMES",
		"290",
		"     1",
		"  9",
		"$PSVPSCALE",
		" 40",
		"0.0",
		"  9",
		"$OLESTARTUP",
		"290",
		"     0",
		"  0",
		"ENDSEC"
	};
}

