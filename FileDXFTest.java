//package www
//AutoCAD Section--ENTITIES
import java.util.*;

/**
*@author David Wu<809758521@qq.com>
*@version 0.5
*/
public class FileDXFTest{

	
	public static void  main(String[] args)  throws Exception{

		FileDXF myFileDXF = new FileDXF();
		
		myFileDXF.AddPoint(2,2);
		myFileDXF.AddPoint(3,3,0);
		myFileDXF.AddLine(0,-80,300,-80);
		myFileDXF.AddCircle(0,0,80);
		myFileDXF.AddLine(0,-80,0,300,-80,0);
		myFileDXF.AddCircle(0,0,120);

		/*
		Others:
		myFileDXF.AddArc(0,0,90,0,90);
		myFileDXF.AddArc(0,0,0,90,0,90);
		myFileDXF.AddText(0,0,8,"Test");
		myFileDXF.AddText(0,0,0,8,"Test");
		
		double[][] mypoints = {{0,0},{5,5},{10,8}};		
		myFileDXF.AddPolyline(mypoints);
		*/
		
		//Add the combined entities,From now restructure to the file FileDXF_ComplexTest
		//myFileDXF.AddRectangle(200,150);
		//myFileDXF.AddSector(new wPoint2D(50,25),50,45,90);
		
		//myFileDXF.secEntities.entities = new  ArrayList<Object>();

		EntLWPolyline myLWPolyline = new EntLWPolyline();

		myLWPolyline.AddVertex(new wPoint(90,50));
		myLWPolyline.AddVertex(new wPoint(80,40));
		myLWPolyline.AddVertex(new wPoint(120,80));
		myLWPolyline.AddVertex(new wPoint(150,100));
		myLWPolyline.AddVertex(new wPoint(180,120));
		myLWPolyline.AddVertex(new wPoint(200,80));
		myFileDXF.secEntities.entities.add(myLWPolyline);
		
		EntPolyline myPolyline = new EntPolyline();

		myPolyline.AddVertex(new EntVertex(90,50));
		myPolyline.AddVertex(new EntVertex(80,40));
		myPolyline.AddVertex(new EntVertex(120,80));
		myPolyline.AddVertex(new EntVertex(150,100));
		myPolyline.AddVertex(new EntVertex(180,120));
		myPolyline.AddVertex(new EntVertex(200,80));
		//myFileDXF.secEntities.entities.add(myPolyline);
		
		//myFileDXF.secEntities.entities.add(new EntVertex(2,2));
		myFileDXF.secEntities.entities.add(new EntLine(-100,40,0,250,150,0));
		
		myFileDXF.secEntities.entities.add(new EntLine(-250,-200,-250,200));
		myFileDXF.secEntities.entities.add(new EntPoint(10,10,12));
		myFileDXF.secEntities.entities.add(new EntCircle(180,-25,250));
		myFileDXF.secEntities.entities.add(new EntArc(10,10,180,0,180));
		
		//myFileDXF.secEntities.entities.add(new EntEllipse(0,0,0,100,0,0,0.6,0.0,2*Math.PI));
		
		myFileDXF.secEntities.entities.add(new EntText(0,0,0,8,"This is mine.÷–Œƒ≤‚ ‘\r\nApache Flink 1.7.0 Release Announcement\nMessage from David Wu\nState schema evolution now works out-of-the-box\rthe integration of complex event processing with streaming SQL "));


        System.out.println("Test toString method: ");
        System.out.println(myFileDXF);
        System.out.println();

        System.out.println("List's Size " + myFileDXF.secEntities.entities.size());
		
		
		for (int i = 0;i<myFileDXF.secEntities.entities.size();i++) {
			System.out.println(myFileDXF.secEntities.entities.get(i)); 
		}
		
	   	List<String []>  myMap = myFileDXF.GetPairData();
        System.out.println("PairData's Size: "+myMap.size());
		for (String [] key : myMap) {
		   System.out.println("key= "+ key[0] + "\t\t\tvalue= " + key[1]);
		}
		System.out.println();
		
		
		System.out.println("");
		System.out.println("DXF file's Content:");
		
        List<String> dxf_str = myFileDXF.GetDXFData();
        for (int i  =  0; i < dxf_str.size(); i++) {
            System.out.println(dxf_str.get(i)); 
        }
		/*
		*/
		//EntLine myLine;
		//myLine = new EntLine(0,50,300,100);
		//myLine.GetDXFData();
		//myLine.GetDXFData();
		
		//myFileDXF.AddLine(myLine);
		//myFileDXF.AddLine(0,0,0,180);
		
		//Test succeed 
		//for (int i=0;i<200000;i++){
		//	myFileDXF.AddLine(0,i,100,i+50);
		//}
		
		myFileDXF.DXF_WRITER();
		//myFileDXF.PNG_WRITER();
    }

}

 