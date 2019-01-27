# DXFOperator
This Project is to write AutoCAD DXF file  without AutoCAD environment.It is my first java exercise.</br>

It services for enterprise designing tasks, such as lofting, nesting .....</br>

Main File: FileDXF.java</br>
           FileDXFTest.java

EntArcTest</br>
EntBase</br>----
	EntArc</br>----
	EntCircle</br>----
	EntLine</br>----
	EntPoint</br>----
	EntPolyline</br>----
	EntText</br>----
	EntVertex</br>
EntBaseTest</br>
EntCircleTest</br>
EntLineTest</br>
EntPointTest</br>
EntPolylineTest</br>
EntTextTest</br>
EntVertexTest</br>
FileDXF</br>
FileDXFTest</br>
SecBlocks</br>
SecBlocksTest</br>
SecClasses</br>
SecClassesTest</br>
SecEntities</br>
SecEntitiesTest</br>
SecHeader</br>
SecHeaderTest</br>
SecObjects</br>
SecObjectsTest</br>
SecTables</br>
SecTablesTest</br>
wPoint</br>
wPoint2D</br>
wPoint2DTest</br>
wPointTest</br>

Easy to use:
		FileDXF myFileDXF = new FileDXF();
		
		myFileDXF.AddPoint(2,2);
		myFileDXF.AddPoint(3,3,0);
		myFileDXF.AddLine(0,-80,300,-80);
		myFileDXF.AddLine(0,-80,0,300,-80,0);
		myFileDXF.AddCircle(0,0,80);
		myFileDXF.AddCircle(0,0,0,80);

		/*
		Others:
		myFileDXF.AddArc(0,0,90,0,90);
		myFileDXF.AddArc(0,0,0,90,0,90);
		myFileDXF.AddText(0,0,8,"Test");
		myFileDXF.AddText(0,0,0,8,"Test\r\nline 2");
		
		double[][] mypoints = {{0,0},{5,5},{10,8}};		
		myFileDXF.AddPolyline(mypoints);
		*/
		

		myFileDXF.DXF_WRITER();

Then create one DXF file: loft_output_2019_01_03_08_39_06_0.dxf

More complex example:
		wPoint2D PO;
		wPoint2D Pa,Pb,Pc,Pd;
		wPoint2D P1,P2,P3,P4;
		wPoint2D Po1,Po2,Po3,Po4;
		
		PO = new wPoint2D(0,0);
		
		Po1 = new wPoint2D(F + G,Math.sqrt(Math.pow(E / 2 + G,2) - Math.pow(F + G, 2)));
		P1 = new wPoint2D(Po1.x - G,Po1.y);
		Pa = new wPoint2D(Po1.x*((E / 2)/(E/2+G)),Po1.y*((E/2)/(E/2+G)));
		
		Po2 = new wPoint2D(Po1.x,-Po1.y);
		P2 = new wPoint2D(P1.x,-P1.y);
		Pb = new wPoint2D(Pa.x,-Pa.y);
		
		Po3 = new wPoint2D(-Po1.x,-Po1.y);
		P3 = new wPoint2D(-P1.x,-P1.y);
		Pc = new wPoint2D(-Pa.x,-Pa.y);
		
		Po4 = new wPoint2D(-Po1.x,Po1.y);
		P4 = new wPoint2D(-P1.x,P1.y);
		Pd = new wPoint2D(-Pa.x,Pa.y);
		
		this.AddLine(P3.x,P3.y,-F,-C/2);
		this.AddLine(-F,-C/2,-F-A,-C/2);
		this.AddLine(-F-A,-C/2,-F-A,C/2);
		this.AddLine(-F-A,C/2,-F,C/2);
		this.AddLine(-F,C/2,P4.x,P4.y);
		
		this.AddArc(Po4,Pd,P4);
		this.AddArc(PO,Pd,Pc);
		this.AddArc(Po3,P3,Pc);

		this.AddLine(P2.x,P2.y,F,-C/2);
		this.AddLine(F,-C/2,F+H,-C/2);
		this.AddLine(F+H,-C/2,F+H+B,-D/2);
		this.AddLine(F+H+B,-D/2,F+H+B,D/2);
		this.AddLine(F+H+B,D/2,F+H,C/2);
		this.AddLine(F+H,C/2,F,C/2);
		this.AddLine(F,C/2,P1.x,P1.y);

		this.AddArc(Po1,P1,Pa);
		this.AddArc(PO,Pb,Pa);
		this.AddArc(Po2,Pb,P2);


SigmaNest Parts<br>
<img src="examples/Partsall.png" alt="SigmaNest Parts" style="max-width:100%;">

intersection of two Cylinders to expand<br>
<img src="examples/InterSection2Cylinder.png" alt="intersection of two Cylinders" style="max-width:100%;">

intersection lines of Belted Pipe and straight pipe<br>
<img src="examples/parts002.png" alt="intersection lines of Belted Pipe and straight pipe" style="max-width:100%;">

<img src="examples/parts003.png" alt="Part" style="max-width:100%;">

<img src="examples/parts004.png" alt="Part" style="max-width:100%;">

BiArc Curve Fittiing<br>
<img src="examples/BiArc.png" alt="BiArc Curve Fittiing" style="max-width:100%;">

Other jobs:

1.BiArc Curve Fitting  -- DONE<br> 
2.Geometry Lofting -- Completed two types <br>
3.Computer Geometry Base Class -- NOP<br>

*@author David Wu<br>

<809758521@qq.com></br>

*@version 0.5
