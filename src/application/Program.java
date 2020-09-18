package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Tax payer #" + i + " data: ");
			System.out.print("Individual or company (i/c)? ");
			char c = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Annual income: ");
			double annualIncome = sc.nextDouble();
			if(c == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, annualIncome, healthExpenditures));
			}
			else {
				System.out.print("Number of employees: ");
				int nEmployees = sc.nextInt();
				list.add(new Company(name, annualIncome, nEmployees));
			}
		}
		
		
		System.out.println();
		System.out.println("Taxes paid: ");
		double sum = 0.0;
		for(TaxPayer t : list) {
			System.out.printf("%s: $ %.2f \n", t.getName(), t.taxes());
			sum += t.taxes();
		}
		System.out.println();
		System.out.println("Total taxes paid: $" + String.format("%.2f", sum));
		
		sc.close();
	}

}
