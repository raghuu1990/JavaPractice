package com.company.flipkart;

import java.util.HashMap;

import com.designpattern.singleton.Singleton;

public class EmployeeDB {
	private static EmployeeDB instance;
	
	HashMap<Integer, Employee> employeDB = new HashMap<Integer, Employee>();
	public static volatile int lastId;

	private EmployeeDB(){}

	public static EmployeeDB getInstance() {
		if(null == instance) {
			synchronized(Singleton.class){
				if(null == instance) {
					instance = new EmployeeDB();
				}
			}
		}
		return instance;
	}

	private Integer createIdForNewEmployee() {
		synchronized(EmployeeDB.class){
			return ++lastId;
		}
	}

	public int saveEmployeIntoDB(Employee employee) {
		if(isValidEmployee(employee)){
			int id = createIdForNewEmployee();
			employee.setId(id);
			employeDB.put(id, employee);
			return id;
		}else{
			throw new IllegalArgumentException("Invalid employee detail");
		}
	}

	private boolean isValidEmployee(Employee employee) {
		return Employee.isValidEmployee(employee);
	}

	public Employee getEmployeById(int id) {
		if(employeDB.containsKey(id)){
			return employeDB.get(id);
		}else{
			return null;
		}
	}
	
	public static void main(String [] args) {
		EmployeeDB admin = EmployeeDB.getInstance();
		System.out.println(admin.getEmployeById(admin.saveEmployeIntoDB(new Employee("EMP1",null,null,10000,4,false))).toString());
		System.out.println(admin.getEmployeById(admin.saveEmployeIntoDB(new Employee("EMP1",null,null,10000,4,false))).toString());
		System.out.println(admin.getEmployeById(admin.saveEmployeIntoDB(new Employee("EMP1",null,null,10000,4,false))).toString());
		System.out.println(admin.getEmployeById(admin.saveEmployeIntoDB(new Employee("EMP1",null,null,10000,4,false))).toString());
		System.out.println(admin.getEmployeById(admin.saveEmployeIntoDB(new Employee("EMP1",null,null,10000,4,false))).toString());
		System.out.println(admin.getEmployeById(admin.saveEmployeIntoDB(new Employee("EMP1",null,null,10000,4,false))).toString());
		System.out.println(admin.getEmployeById(admin.saveEmployeIntoDB(new Employee("EMP1",null,null,10000,4,false))).toString());
		System.out.println(admin.getEmployeById(admin.saveEmployeIntoDB(new Employee("EMP1",null,null,10000,4,false))).toString());
		System.out.println(admin.getEmployeById(admin.saveEmployeIntoDB(new Employee("EMP1",null,null,10000,4,false))).toString());
		System.out.println(admin.getEmployeById(admin.saveEmployeIntoDB(new Employee("EMP1",null,null,10000,4,false))).toString());
		System.out.println(admin.getEmployeById(admin.saveEmployeIntoDB(new Employee("EMP1",null,null,10000,4,false))).toString());
		
/*
		Employee E1 = new Employee(1,"E1",null,null,10000,4,false);
		
		Employee E2 = new Employee(2,"E2",1,null,8000,4,false);
		Employee E3 = new Employee(3,"E3",1,null,7000,4,false);
		Employee E4 = new Employee(4,"E4",1,null,6000,4,false);
		
		Employee E5 = new Employee(5,"E5",2,null,5000,4,false);
		Employee E6 = new Employee(6,"E6",2,null,4500,4,false);
		Employee E7 = new Employee(7,"E7",2,null,4000,4,false);
		Employee E8 = new Employee(8,"E8",2,null,3500,4,false);
		Employee E9 = new Employee(9,"E9",2,null,3000,4,false);
		
		Employee E10 = new Employee(10,"E10",3,null,2500,4,false);
		Employee E11 = new Employee(11,"E11",3,null,2000,4,false);
		Employee E12 = new Employee(12,"E12",3,null,1500,4,false);

*/

	}

}
