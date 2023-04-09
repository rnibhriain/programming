import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

public class HRDepartment implements HRCodes{
	
	public ArrayList <Employee> employeeList = new ArrayList<Employee>();
	
	public void addEmployee (int employeeId, String name, int role) {
		Employee newEmployee = new Employee(employeeId, name, role);
		employeeList.add(newEmployee);
	}
	
	public void addEmployee (Employee theEmployee) {
		employeeList.add(theEmployee);
	}
	
	public void printAllEmployees () {
		for (int count = 0; count < employeeList.size(); count++) {
			Employee currentEmployee = employeeList.get(count);
			System.out.println(currentEmployee.toString());
		}
	}
	
	public Employee findEmployee (int employeeId) {
		for (int count = 0; count < employeeList.size(); count++) {
			Employee currentEmployee = employeeList.get(count);
			if (employeeId == currentEmployee.getEmployeeId()) {
				return currentEmployee;
			}
		}
		return null;
	}
	
	public boolean recordEmployeeAppraisal (int employeeId, Date appraisalDate, int score) {
		Employee currentEmployee = findEmployee(employeeId);
		if (currentEmployee == null) {
			return false;
		}else {
			EmployeeAppraisal theAppraisal = new EmployeeAppraisal(appraisalDate, score);
			ArrayList <EmployeeAppraisal> history = currentEmployee.getAppraisalHistory();
			history.add(theAppraisal);
			currentEmployee.setAppraisalHistory(history);
			addEmployee(currentEmployee);
			deleteDuplicates();
			return true;
		}
	}
	
	public boolean promoteEmployee (int employeeId) {
		Employee currentEmployee = findEmployee(employeeId);
		if (currentEmployee == null) {
			return false;
		}
		else {
			ArrayList <EmployeeAppraisal> history = currentEmployee.getAppraisalHistory();
			if (history.size()>1) {
				if (history.get(history.size()-1).getAppraisalScore()== EXCEEDED_EXPECTATIONS&&history.get(history.size()-2).getAppraisalScore()==EXCEEDED_EXPECTATIONS) {
					Date lastDate = currentEmployee.getPromotionDate();
					Calendar calendar = null;
					Calendar.getInstance();
					calendar.setTime(new Date());;
					calendar.add(Calendar.YEAR, -1);
					Date lastYearsDate = calendar.getTime();
					if (lastYearsDate.after(lastDate)) {
						return false;
					}
					else {
						calendar = null;
						Calendar.getInstance();
						calendar.setTime(new Date());;
						Date currentDate = calendar.getTime();
						if (currentEmployee.getRole()==TESTER) {
							currentEmployee.setRole(DEVELOPER);
							currentEmployee.setPromotionDate(currentDate);
						} else if (currentEmployee.getRole()==DEVELOPER) {
							currentEmployee.setRole(DESIGNER);
							currentEmployee.setPromotionDate(currentDate);
						} else if (currentEmployee.getRole()==DESIGNER) {
							currentEmployee.setRole(MANAGER);
							currentEmployee.setPromotionDate(currentDate);
						} else if (currentEmployee.getRole()==MANAGER) {
							currentEmployee.setRole(EXECUTIVE);
							currentEmployee.setPromotionDate(currentDate);
						} else  {
							return false;
						}
						employeeList.add(currentEmployee);
						deleteDuplicates();
						return true;
					}
				}
				else {
					return false;
				}
			}
			return false;
		}
	}
	
	public void deleteDuplicates () {
		for (int count = 0; count < employeeList.size(); count++) {
			for (int secondCount = count+1; secondCount < employeeList.size(); count++) {
				if (employeeList.get(count).getEmployeeId()==employeeList.get(secondCount).getEmployeeId()) {
					employeeList.remove(count);
				}
			}
		}
	}
	
}
