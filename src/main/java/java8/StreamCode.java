package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamCode {
	
	static List<Employee> employeeList = Arrays.asList(
		    new Employee(1, "Alice", "IT", 60000),
		    new Employee(2, "Bob", "HR", 50000),
		    new Employee(3, "Charlie", "IT", 70000),
		    new Employee(4, "David", "Finance", 40000),
		    new Employee(5, "Eve", "HR", 55000),
		    new Employee(6, "Frank", "IT", 80000)
		);
	
	
	static List<Student> studentList = Arrays.asList(
		    new Student(101, "Ramu", 899.5, "Telangana", "India"),
		    new Student(252, "Priya", 675.76, "Maharastra", "India"),
		    new Student(635, "Guna", 190, "Orissa", "India"),
		    new Student(872, "Hitrak", 651.2, "Madya Pradesh", "India"),
		    new Student(651, "sheetal", 578.5, "Bengal", "India"),
		    new Student(976, "Mahesh", 998.5, "Himachal", "India"),
		    new Student(912, "Rock", 912.50, "New york", "Usa"),
		    new Student(422, "kim", 391.87, "Okama", "Japan")
		);

	
	public static void getHighestPaidEmployee() {
		Optional<Employee> highestPaid = employeeList.stream()
	    .max(Comparator.comparingDouble(Employee::getSalary));
		System.out.println("highestPaid Employee: " + highestPaid);
	}
	
	public static void getEmployeeByDepartment() {
		Map<String, List<Employee>> deptWise = employeeList.stream()
			    .collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println("deptWise Employee: " + deptWise);
	}
	
	public static void getCountOfEmployeesinEachDepartment() {
		Map<String, Long> countByDept = employeeList.stream()
			    .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("countByDept Employee: " + countByDept);
	}
	
	public static void getAvgSalaryOfEmployeeByDepartment() {
		Map<String, Double> avgSalaryByDept  = employeeList.stream()
			    .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("avgSalaryByDept  Employee: " + avgSalaryByDept );
	}
	
	public static void litAllDepartments() {
		List<String> deptNames = employeeList.stream()
			    .map(Employee::getDepartment)
			    .distinct()
			    .collect(Collectors.toList());
		System.out.println("deptNames : " + deptNames );
	}
	
	public static void sortEmplBysalary() {
		List sortedEmpls =   employeeList.stream()
				.sorted(Comparator.comparingDouble(Employee::getSalary))
				.collect(Collectors.toList());
		System.out.println("sortedEmpls : " + sortedEmpls );
	}
	
	public static void secondHighestsalary() {
		Optional<Double> secondHighest = employeeList.stream()
			    .map(Employee::getSalary)
			    .distinct()
			    .sorted(Comparator.reverseOrder())
			    .skip(1)
			    .findFirst();
		System.out.println("secondHighest : " + secondHighest );
	}
	
	public static void salaryGreaterThan() {
		List highEarners = employeeList.stream()
				.filter(c -> c.getSalary()> 50000 )
				.collect(Collectors.toList());
		System.out.println("highEarners : " + highEarners );
	}
	
	public static void salarySum() {
		double totalSalary = employeeList.stream()
			    .mapToDouble(Employee::getSalary)
			    .sum();

		System.out.println("totalSalary : " + totalSalary );
	}
	
	public static void partitionedEmployeeOnsalary() {
		Map<Boolean, List<Employee>> partitioned = employeeList.stream()
			    .collect(Collectors.partitioningBy(e -> e.getSalary() > 50000));


		System.out.println("partitioned : " + partitioned );
	}
	
	public static void lowestInDeptsalary() {
		Map<String, Optional<Employee>> lowestInDept = employeeList.stream()
			    .collect(Collectors.groupingBy(
			        Employee::getDepartment,
			        Collectors.minBy(Comparator.comparingDouble(Employee::getSalary))
			    ));

		System.out.println("lowestInDept : " + lowestInDept );
	}
	
	public static void maxsalaryInDept() {
		Map<String, Optional<Employee>> maxPerDept = employeeList.stream()
			    .collect(Collectors.groupingBy(
			        Employee::getDepartment,
			        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
			    ));

		System.out.println("maxPerDept : " + maxPerDept );
	}
	
	
	
	public static void  getTop5Rankers() {
		List studentTopRankers =  studentList.stream()
			.distinct()
			.sorted(Comparator.comparingDouble(Student::getRank).reversed())
			.limit(5)
			.collect(Collectors.toList());
		System.out.println("studentTopRankers : " + studentTopRankers );
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		getHighestPaidEmployee();
		getEmployeeByDepartment();
		getCountOfEmployeesinEachDepartment();
		getAvgSalaryOfEmployeeByDepartment();
		litAllDepartments();
		sortEmplBysalary();
		secondHighestsalary();
		salaryGreaterThan();
		salarySum();
		partitionedEmployeeOnsalary();
		lowestInDeptsalary();
		maxsalaryInDept();
		getTop5Rankers();
	}

}


