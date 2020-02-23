package com.capg.DAOLayer;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import com.capg.DTOLayer.DiagnosticCenter;
class HealthTest1{
	HealthDaoImpl dao=new HealthDaoImpl();
	com.capg.DTOLayer.Test t=new com.capg.DTOLayer.Test ("100","150");
	DiagnosticCenter dc=new DiagnosticCenter("100","150",null,null);
	@Test
	public void addTest() {
		String testId=t.getTestId();
		int a=Integer.parseInt(testId);
		assertTrue(a>0);
	}
	@Test
	public void addCenter() {
		String centerId=dc.getCenterId();
		int b=Integer.parseInt(centerId);
		assertTrue(b>0);
	}
	@Test
	public void removeTest() {
		String testId=dc.getCenterId();
		int b=Integer.parseInt(testId);
		assertTrue(b>0);
	}
	 }
	