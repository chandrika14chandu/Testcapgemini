package com.capg.DAOLayer;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import com.capg.DTOLayer.DiagnosticCenter;
class HealthTest {
	List<Test>list=new ArrayList<Test>();
	DiagnosticCenter center= new DiagnosticCenter("tesla","8001", null,null);
	@Test
	    public void addcenter(){
	       String expectedName = "tesla";
	        assertEquals(expectedName, center.getCenterName());
	 }
	}