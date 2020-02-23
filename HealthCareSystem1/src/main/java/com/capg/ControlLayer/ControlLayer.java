package com.capg.ControlLayer;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.Exception.HealthException;
import com.capg.DAOLayer.HealthDaoImpl;
import com.capg.DTOLayer.DiagnosticCenter;
import com.capg.DTOLayer.Test;
import com.capg.ServiceLayer.HealthServiceImpl;
public class ControlLayer {
	static Test test=new Test();
	public static void main(String[] args) throws HealthException {
		HealthServiceImpl healthservice=new HealthServiceImpl();
		HealthDaoImpl h=new HealthDaoImpl();
	 DiagnosticCenter dc=new DiagnosticCenter();
		Scanner scanner=new Scanner(System.in);
		int choice=0;
		while(choice!=5)
		{
		System.out.println("1.Add Center");
		System.out.println("2.Display Center");
		System.out.println("3.Add Test");
		System.out.println("4.Display Test");
		System.out.println("5.Exit");
		System.out.println("Enter choice");
		choice = scanner.nextInt();
		/*try {
			choice = scanner.nextInt();
			}
	catch(InputMismatchException e) {
		System.out.println("Choice should be an Integer");
		break;
	}*/
		switch(choice)
		{
		case 1:
			try
			{
			System.out.println("Enter center name");
			scanner.nextLine();
			String centerName=scanner.nextLine();
			dc.setCenterName(centerName);                      //Bean
			healthservice.addCenter(dc);  
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			break;
		case 2:
			try
			{
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
		try 
		{
		scanner.nextLine();
	System.out.println("Enter center name ");
	String centerName=scanner.nextLine();
	dc.setCenterName(centerName);
	healthservice.validateName1(centerName);
		 System.out.println("Enter test name");
		 String TestName=scanner.nextLine();
		 	test.setTestName(TestName);
		 String sid= healthservice.addTest(centerName, test);
	 System.out.println("Test Id = "+sid);
		}
	catch (HealthException e)
		{
		System.err.println(e.getMessage());
		}
		break;
	case 4:
		
		try
		{
		List<Test> l1=healthservice.displaytest();
		for(Test d:l1)
		{
			String ci1=d.getTestId()+" "+d.getTestName();
			System.out.println(ci1);
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
		case 5:
			break;
	}}}}