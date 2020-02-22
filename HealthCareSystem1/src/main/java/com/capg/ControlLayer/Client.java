package com.capg.ControlLayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.Exception.HealthException;
import com.capg.DTOLayer.DiagnosticCenter;
import com.capg.DTOLayer.Test;
import com.capg.ServiceLayer.HealthService;
import com.capg.ServiceLayer.HealthServiceImpl;
public class Client {
	    public static void main(String[] args) {         //1
		Scanner scanner=new Scanner(System.in);
		HealthService healthservice=new HealthServiceImpl();//ServiceLayer Object
		DiagnosticCenter dc=new DiagnosticCenter();//Bean Object 3
		ArrayList<Test>listofTests =new ArrayList<Test>();
		int choice=0;
		Test test=new Test();
		while(choice!=5)
		{
		System.out.println("1.Add Center");
		System.out.println("2.Display Center");
		System.out.println("3.Add Test");
		System.out.println("4.Display Test");
		System.out.println("5.Remove Test");
		System.out.println("Enter choice");
		choice = scanner.nextInt();
		switch(choice)                                 //2
		{
		case 1:
			try
			{
			System.out.println("Enter center name");
		    scanner.nextLine();
			String centerName=scanner.nextLine();
			dc.setCenterName(centerName);              //set value in the bean using reference 4
			healthservice.addCenter(dc);               //call the method using reference 5
			String centerId=dc.getCenterId();          //get values from bean
			System.out.println("centerid="+centerId);    //11
			System.out.println("Center added sucesfully");  //12
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			break;
		case 2:                                              //13
			try
			{
				scanner.nextLine();
			List<DiagnosticCenter>l=healthservice.displaycenter(); //14
			for(DiagnosticCenter d:l)
			{
				String ci=d.getCenterId()+" "+d.getCenterName();
				System.out.println(ci);
				List<Test> t=d.getListOfTests();
				for(Test y:t)
				{
					String tid=y.getTestId();
					String tname=y.getTestName();
					System.out.println(tid+"."+tname);
				}
			}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			break;
	case 3:
		scanner.nextLine();
	System.out.println("Select center name");
	String centerName=scanner.nextLine();
		 System.out.println("Enter test name");
		 String TestName=scanner.nextLine();
		 test=new Test();  //Bean Object 
		test.setTestName(TestName); 
		try 
		{
	String sid= healthservice.addTest(centerName,test);   
	 System.out.println("Test Id = "+sid);
			}
	catch (HealthException e)
		{
		System.err.println(e.getMessage());
		}
		break;
	case 4:
		healthservice.displaycenter();
		break;
	/*case 4:
		break;
	case 5:
		scanner.nextLine();
	System.out.println("Select center name");
		String cn=scanner.nextLine();
		 System.out.println("Enter test name");
		 String Tn=scanner.nextLine();
		 test=new Test();
		test.setTestName(Tn);
		try 
		{
			String sid= healthservice.addTest(cn,test);
	 System.out.println("Test Id = "+sid);
			}
	catch (HealthException e)
		{
		System.err.println(e.getMessage());
		}
		break;*/
			}
		}
	}
}
