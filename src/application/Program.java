package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {
	
	public static void main(String[] args) throws ParseException { 
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		int contractNumbers = 0;
		
		Worker worker = createWorker(contractNumbers);
		
		contractPopulate(sdf, contractNumbers, worker);
		
		showResults(sc, worker);
		
		sc.close();
		
	}

	private static void showResults(Scanner sc, Worker worker) {
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		Integer month = Integer.parseInt(monthAndYear.substring(0, 2));
		Integer year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: "+ worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
	}

	private static Worker createWorker(int contractNumbers) {
		List<HourContract> contracts;
		System.out.print("Enter department's name: ");
//		String departmentName = sc.nextLine();
		String departmentName = "a";
		System.out.println("enter worker data:");
		System.out.println("Name: ");
//		String workerName = sc.nextLine();
		String workerName = "a";
		System.out.print("Level: ");
//		String workerLevel = sc.nextLine();
		String workerLevel = "a";
		System.out.print("Base salary:");
//		double baseSalary = sc.nextDouble();
		double baseSalary = 12222;
		System.out.print("How many contracts to this worker? ");
//		int contractNumbers = sc.nextInt();
		contractNumbers = 5;
		contracts = new ArrayList<>(contractNumbers);
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName), contracts);
		return worker;
	}

	private static void contractPopulate(SimpleDateFormat sdf, int contractNumbers, Worker worker) throws ParseException {
//		while (contracts.size() < ns) {
//			HourContract contract = new HourContract();
//			System.out.println("Enter contract #" + contracts.size() + "data:");
//			System.out.print("Data (DD/MM/YYYY): ");
//			contract.setData(sdf.parse(sc.next()));
//			System.out.print("Value per hour: ");
//			contract.setValuePerHour(sc.nextDouble());
//			System.out.print("Duration (hours): ");
//			contract.setHours(sc.nextInt());
//			worker.addContracts(contract);
//		}
		for (int i=1; i<=contractNumbers; i++) {
			HourContract contract = new HourContract();
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Data (DD/MM/YYYY): ");
//			contract.setData(sdf.parse(sc.next()));
			contract.setData(sdf.parse("12/0"+i+"/2022"));
			System.out.print("Value per hour: ");
//			contract.setValuePerHour(sc.nextDouble());
			contract.setValuePerHour(i*123.32);
			System.out.print("Duration (hours): ");
//			contract.setHours(sc.nextInt());
			contract.setHours(i*i);
			worker.addContracts(contract);
		}
	}
	
	

}
