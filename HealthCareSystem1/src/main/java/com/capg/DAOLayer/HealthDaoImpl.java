package com.capg.DAOLayer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
	HashMap<String,DiagnosticCenter>centerMap=new HashMap<String,DiagnosticCenter>();
	Map<String,Test> map=new HashMap<String,Test> ();
		public HealthDaoImpl()
		{
            DiagnosticCenter center= new DiagnosticCenter("care","8795",null,null);
            List<Test>list=new ArrayList<Test>();
			Test test=new Test();
			test.setTestId("1000");
			test.setTestName("blood test");
			list.add(test);
			Test test1=new Test();
			test1.setTestId("1001");
			test1.setTestName("blood group");
			list.add(test);
			Test test2=new Test();
			test2.setTestId("1002");
			test2.setTestName("blood pressure");
			list.add(test2);
			center.setListOfTests(list);
			centerMap.put(center.getCenterName(),center);
			}
	public boolean addCenter(DiagnosticCenter center) throws HealthException {  //9
		{
			if(centerMap.containsKey(center.getCenterName()))
			try {
				throw new HealthException("center already exist");
			}
			catch(HealthException e)
			{
				e.printStackTrace();
			}
			else
			{
				DiagnosticCenter dc=new DiagnosticCenter();
				Random random = new Random();         
				int centerid = random.nextInt(100);
				String s=Integer.toString(centerid); 
				System.out.println("centerid="+s); 
				center.setCenterId(s);   
				centerMap.put(center.getCenterId(), center);
				System.out.println("Center added sucesfully");
		}
		}
	return true; 
	}
	public String addTest(String centerName, Test test) throws HealthException { 
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
				   //ldc.get(0).getListOfTests().add(test);
				    
				    Random random = new Random();
					int id = random.nextInt(100)+1000;
					test.setTestId(id+"");
					//String sid=healthDao.addTest(centerName,test).toString();
				    
				}
				return test.getTestId();
				
				}
	public List<DiagnosticCenter> displaycenter() { 
	Collection<DiagnosticCenter> col=centerMap.values();
	List<DiagnosticCenter> list=new ArrayList<DiagnosticCenter>(col);
		return list;
	}
	public List<Test> displaytest() {
		Collection<Test> col1=map.values();
		List<Test> list1=new ArrayList<Test>(col1);
			return list1;
	}
	}

	