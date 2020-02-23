package com.capg.ServiceLayer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.Exception.HealthException;
import com.capg.DAOLayer.HealthDao;
import com.capg.DAOLayer.HealthDaoImpl;
import com.capg.DTOLayer.DiagnosticCenter;
import com.capg.DTOLayer.Test;
public class HealthServiceImpl implements HealthService{
	DiagnosticCenter dc=new DiagnosticCenter();
	private HealthDao healthDao;
	private	HashMap<String,DiagnosticCenter>centerMap;
	public HealthServiceImpl() {
	 healthDao = new HealthDaoImpl();
	}
	public boolean validateName1(String centerName) throws HealthException { 
		boolean flag=false;
		flag=centerName.matches("[a-zA-Z]+");
		if(!flag)
throw new HealthException("Center name should contain only alphabets");
	return flag;
	}
public boolean addCenter(DiagnosticCenter center) throws HealthException { 
		String name = center.getCenterName(); 
		boolean flag =name.matches("[a-zA-Z]+");
		if(!flag)
	{	
throw new HealthException("Center name should contain only alphabets");	
	}
		else
	{
		healthDao.addCenter(center);
	}
		return flag;   
 }
	public String addTest(String centerName, Test test) throws HealthException {  
		String name = test.getTestName(); 
		boolean flag =name.matches("[a-zA-Z]+");
		if(!flag)
	{	
throw new HealthException("	Test name should contain only alphabets");	
	}
		else  
		{
			  Random random = new Random(); int id = random.nextInt(100)+1000;
			  test.setTestId(id+"");
			 String  sid=healthDao.addTest(centerName,test).toString();
		return sid;
		}
	}
	@Override
	public List<DiagnosticCenter> displaycenter() {
		
		return healthDao.displaycenter();
	}
	@Override
	public List<Test> displaytest() {
		return healthDao.displaytest();
	}
}
