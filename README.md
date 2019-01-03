# DXFOperator
This Project is to write AutoCAD DXF file  without AutoCAD environment.It is my first java exercise.

Main File: FileDXF.java</br>
           FileDXFTest.java

EntArcTest</br>
EntBase</br>
EntArc</br>
EntCircle</br>
EntLine</br>
EntPoint</br>
EntPolyline</br>
EntText</br>
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
		myFileDXF.AddText(0,0,0,8,"Test");
		
		double[][] mypoints = {{0,0},{5,5},{10,8}};		
		myFileDXF.AddPolyline(mypoints);
		*/
		

		myFileDXF.DXF_WRITER();
