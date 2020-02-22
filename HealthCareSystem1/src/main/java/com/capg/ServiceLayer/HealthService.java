package com.capg.ServiceLayer;
import java.util.List;
import com.Exception.HealthException;
import com.capg.DTOLayer.DiagnosticCenter;
import com.capg.DTOLayer.Test;
public interface HealthService {
	public	boolean validateName(String testName) throws HealthException;
	 public	boolean addCenter(DiagnosticCenter center) throws HealthException;
	 public	boolean removeCenter(DiagnosticCenter center) throws HealthException;
	 public	String addTest(String centerName,Test test) throws HealthException;
	 public	boolean removeTest(Test test) throws HealthException;
	 public List<DiagnosticCenter>displaycenter();
	public List<Test> displaytest();
}
