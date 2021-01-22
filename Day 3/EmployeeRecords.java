import java.util.*;

public class EmployeeRecords 
{
	public static void main(String args[])
	{
		ArrayList<Employee> employees=new ArrayList<Employee>();
		ArrayList<Invoice> invoices=new ArrayList<>();
		
		Scanner sc=new Scanner(System.in);
		int option=1;
		
		while(option!=0)
		{
			System.out.println("Choose Option: ");
			System.out.println("0. Exit");
			System.out.println("1. Add Salaried Employee: ");
			System.out.println("2. Add Hourly Employee: ");
			System.out.println("3. Add Commission Employee: ");
			System.out.println("4. Calculate Salary for an employee: ");
			System.out.println("5. Increase Salary by a percentage for an employee: ");
			System.out.println("6. Set Rate for an employee: ");
			System.out.println("7. Add invoice");
			System.out.println("8. Get Payment Info: ");
			
			option=sc.nextInt();
			sc.nextLine();
			
			if(option==0)
				break;
			
			else if(option==1)
			{
				String empName;
				int empId;
				double weeklySalary;
				
				System.out.println("Enter employee name: ");
				empName=sc.nextLine();
				System.out.println("Enter employee ID: ");
				empId=sc.nextInt();
				System.out.println("Enter employee weekly salary");
				weeklySalary=sc.nextDouble();
				
				employees.add(new SalariedEmployee(empName, empId, weeklySalary));
			}
			
			else if(option==2)
			{
				String empName;
				int empId, numOfHoursWorked;
				double hourlyRate;
				
				System.out.println("Enter employee name: ");
				empName=sc.nextLine();
				System.out.println("Enter employee ID: ");
				empId=sc.nextInt();
				System.out.println("Enter hourly rate: ");
				hourlyRate=sc.nextDouble();
				System.out.println("Enter number of hours worked: ");
				numOfHoursWorked=sc.nextInt();
				
				employees.add(new HourlyEmployee(empName, empId, numOfHoursWorked, hourlyRate));
			}
			
			else if(option==3)
			{
				String empName;
				int empId;
				double commissionPercentage, weeklySales;
				
				System.out.println("Enter employee name: ");
				empName=sc.nextLine();
				System.out.println("Enter employee ID: ");
				empId=sc.nextInt();
				System.out.println("Enter weekly sales: ");
				weeklySales=sc.nextDouble();
				System.out.println("Enter commission percentage: ");
				commissionPercentage=sc.nextInt();
				
				employees.add(new CommissionEmployee(empName, empId, commissionPercentage, weeklySales));
			}
			
			else if(option==4)
			{
				String empName;
				
				System.out.println("Enter employee name: ");
				empName=sc.nextLine();
				
				boolean empFound=false;
				
				for(int i=0;i<employees.size();i++)
				{
					
					if(empName.equals(employees.get(i).getEmpName()))
					{
						empFound=true;
						System.out.println("Salary for "+empName+ " is: ");
						System.out.println(employees.get(i).calculateSalary());
					}
				}
				if(empFound==false)
					System.out.println("Employee not found");
			}
			
			else if(option==5)
			{
				String empName;
				System.out.println("Enter employee name: ");
				empName=sc.nextLine();
				
				double incrementPercentage;
				boolean empFound=false;
				
				for(int i=0;i<employees.size();i++)
				{
					if(empName.equals(employees.get(i).getEmpName()))
					{
						empFound=true;
						System.out.println("Enter increment percentage: ");
						incrementPercentage=sc.nextDouble();
						employees.get(i).increaseSalary(incrementPercentage);
					}
				}
				if(empFound==false)
					System.out.println("Employee not found");
				
			}
			
			else if(option==6)
			{
				String empName;
				System.out.println("Enter employee name: ");
				empName=sc.nextLine();
				
				boolean empFound=false;
				double newRate;
				
				for(int i=0;i<employees.size();i++)
				{
					if(empName.equals(employees.get(i).getEmpName()))
					{
						empFound=true;
						
						System.out.println("Enter new rate: ");
						newRate=sc.nextDouble();
						
						employees.get(i).setNewRate(newRate);
					}
				}
				
				if(empFound==false)
					System.out.println("Employee not found");
				
				
			}
			
			else if(option==7)
			{
				String partNum;
				String partDescription;
				int quantity;
				double pricePerItem;
				
				System.out.println("Enter part number: ");
				partNum=sc.nextLine();
				System.out.println("Enter part description: ");
				partDescription=sc.nextLine();
				System.out.println("Enter quantity: ");
				quantity=sc.nextInt();
				System.out.println("Enter price per item: ");
				pricePerItem=sc.nextDouble();
				
				invoices.add(new Invoice(partNum, partDescription, quantity, pricePerItem));
			}
			else if(option==8)
			{
				int choice;
				System.out.println("Choose:");
				System.out.println("1.Get payment info for employee.");
				System.out.println("2.Get payment info for invoice. ");
				choice=sc.nextInt();
				sc.nextLine();
				if(choice==1)
				{
					String empName;
					System.out.println("Enter employee name: ");
					empName=sc.nextLine();
				
					boolean empFound=false;
				
					for(int i=0;i<employees.size();i++)
					{
						if(empName.equals(employees.get(i).getEmpName()));
						{
							double totalPayment;
							empFound=true;
							totalPayment=employees.get(i).getPayment();
							System.out.println("Total Payment: "+String.valueOf(totalPayment));
						}
					}
				
					if(empFound==false)
						System.out.println("Employee not found");
				}
				
				else if(choice==2)
				{
					String partNum;
					boolean invoiceFound=false;
					System.out.println("Enter part number: ");
					partNum=sc.nextLine();
					
					for(int i=0;i<invoices.size();i++)
					{
						if(partNum.equals(invoices.get(i).getPartNum()))
						{
							invoiceFound=true;
							double totalPayment=invoices.get(i).getPayment();
							System.out.println("Total Payment: "+String.valueOf(totalPayment));
						}
					}
					if(invoiceFound==false)
						System.out.println("Invoice not found");
				}
				
				else
					System.out.println("Invalid option");
			}
			else
			{
				System.out.println("Invalid option");
			}
		}
		
		
		sc.close();
	}
}
