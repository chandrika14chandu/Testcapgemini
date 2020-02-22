package com.capg.ControlLayer;
import java.util.List;
import java.util.Scanner;
import com.Exception.HealthException;
import com.capg.DTOLayer.DiagnosticCenter;
import com.capg.DTOLayer.Test;
import com.capg.ServiceLayer.HealthServiceImpl;
public class ControlLayer {
	public static void main(String[] args) throws HealthException {
		HealthServiceImpl healthservice=new HealthServiceImpl();
		Test test=new Test();
	 DiagnosticCenter dc=new DiagnosticCenter();
		Scanner scanner=new Scanner(System.in);
		int choice=0;
		while(choice!=5)
		{
		System.out.println("1.Add Center");
		System.out.println("2.Display Center");
		System.out.println("3.Add Test");
		System.out.println("4.Display Test");
		System.out.println("Enter choice");
		choice = scanner.nextInt();
		switch(choice)
		{
		case 1:
			try
			{
			System.out.println("Enter center name");
			scanner.nextLine();
			String centerName=scanner.nextLine();
			dc.setCenterName(centerName);
			healthservice.addCenter(dc);            //call to service layer
			String centerId=dc.getCenterId();
			System.out.println("centerid="+centerId);
			System.out.println("Center added sucesfully");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			break;
		case 2:
			try
			{
			scanner.nextLine();
			List<DiagnosticCenter>l=healthservice.displaycenter();
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
			}}
			
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
		 test=new Test();
		 	test.setTestName(TestName);
			try 
		{
		 String sid= healthservice.addTest(centerName, test);
	 System.out.println("Test Id = "+sid);
		}
	catch (HealthException e)
		{
		System.err.println(e.getMessage());
		}
		break;
	case 4:
	healthservice.displayTest(test);
		break;	
	}}}}
		