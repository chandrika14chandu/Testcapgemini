package com.capg.DAOLayer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import com.Exception.HealthException;
import com.capg.DTOLayer.Appointment;
import com.capg.DTOLayer.DiagnosticCenter;
import com.capg.DTOLayer.Test;
public class HealthDaoImpl implements HealthDao {
	private Map<String,Test> map;
	private	HashMap<String,DiagnosticCenter> centerMap;
	private	HashMap<String,Appointment> appointmentMap;
		public HealthDaoImpl()
		{
			centerMap=new HashMap<String,DiagnosticCenter>();
			DiagnosticCenter center= new DiagnosticCenter("tesla","8001", null,null);
			List<Test>list=new ArrayList<Test>();
			Test test=new Test();
			test.setTestId("1000");
			test.setTestName("blood test");
			list.add(test);
			Test test1=new Test();
			test1.setTestId("1001");
			test1.setTestName("blood group");
			list.add(test1);
			Test test2=new Test();
			test2.setTestId("1002");
			test2.setTestName("blood pressure");
			list.add(test2);
			center.setListOfTests(list);
			centerMap.put(center.getCenterName(), center);
			}
	public boolean addCenter(DiagnosticCenter center) throws HealthException {  //9
		{
			if(centerMap.containsKey(center.getCenterName()))//10 to check center is already exist or not 
			{
				throw new HealthException("center already exist");
			}
			else
			{
				centerMap.put(center.getCenterId(), center);
		}
	return true; 
		}
	}
	public boolean removeCenter(DiagnosticCenter center) throws HealthException {
		return false;
	}

	public String addTest(String centerName, Test test) throws HealthException { 
		//List<DiagnosticCenter> list=center.stream().filter(p->p.getcenterId==centerId?true:false).map(p->p.getListOfTests());
				Set<String> s=centerMap.keySet();
				String s1=test.getTestName();
				for (String i :s) {
					boolean flag =s1.equals(i);
					if(flag)
					{
					throw new HealthException("test already exist");
					}
					Collection<DiagnosticCenter> list=centerMap.values();
Collection<DiagnosticCenter> dc= list.stream().filter(p->p.getCenterName().equals(centerName)).collect(Collectors.toList());
				    List<DiagnosticCenter>  ldc = new ArrayList<DiagnosticCenter>(dc);
				   // ldc.get(0).getListOfTests().add(test);
				}
				return test.getTestId();
				
				}
	public boolean removeTest(Test testId) throws HealthException {
		boolean flag = map.containsKey(testId) ;
		if(flag)
		{
		testId = map.remove(testId);
		}
		else
		{
		throw new HealthException(testId+" not found");
		}
		return flag;
		}

	public List<DiagnosticCenter> displaycenter() {  //16
	Collection<DiagnosticCenter> col=centerMap.values();
		List<DiagnosticCenter> list=new ArrayList<DiagnosticCenter>(col);
		return list;
	}
	@Override
	public List<Test> displaytest(){
		
		return null;
	}
}
		
	