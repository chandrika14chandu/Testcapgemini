package com.capg.ServiceLayer;
import java.util.List;
import java.util.Random;

import com.Exception.HealthException;
import com.capg.DAOLayer.HealthDao;
import com.capg.DAOLayer.HealthDaoImpl;
import com.capg.DTOLayer.DiagnosticCenter;
import com.capg.DTOLayer.Test;
public class HealthServiceImpl implements HealthService{
	private HealthDao healthDao;
	public HealthServiceImpl()
	{
	 healthDao = new HealthDaoImpl();
	}
	public boolean validateName(String testName) throws HealthException { 
		boolean flag =false;
		flag=testName.matches("[a-zA-Z]+");
		return flag;
		}
	public boolean addCenter(DiagnosticCenter center) throws HealthException { //6
		String name = center.getCenterName(); //get values from bean
		boolean flag =name.matches("[a-zA-Z]+");
		if(!flag)
		{
		throw new HealthException("Center name should contain only alphabets");
		}
		Random random = new Random();         //to generate random numbers
		int centerid = random.nextInt(100);  
		String s=Integer.toString(centerid);   //toString to convert Integer to String
		center.setCenterId(s);                 //set values into bean 7
		healthDao.addCenter(center);           //call method using reference  8
		return false;
	}
	public boolean removeCenter(DiagnosticCenter center) throws HealthException {
		// TODO Auto-generated method stub
		return false;
	}

	public String addTest(String centerName, Test test) throws HealthException {  
		String name = test.getTestName();
		boolean flag = validateName(name); //call validate method
		if(!flag)
		{
		throw new HealthException("Test already exist");
		}
		Random random = new Random();
		int id = random.nextInt(100)+1000;
		test.setTestId(id+"");
		String sid=healthDao.addTest(centerName,test).toString();
		return sid;
	}

	public boolean removeTest(Test test) throws HealthException {
		String name = test.getTestName();
		boolean flag = validateName(name);
		if(!flag)
		{
		throw new HealthException("Test already present");
		}
		Random random = new Random();
		int id = random.nextInt(100)+1000;
		test.setTestId(id+"");
			return false;
	}
	public List<DiagnosticCenter> displaycenter() { //15
		
		return healthDao.displaycenter();
	}
	public List<Test> displaytest() {
		return healthDao.displaytest();
	}

}