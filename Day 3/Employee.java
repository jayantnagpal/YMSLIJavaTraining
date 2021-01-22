
public abstract class Employee implements Payable
{
	private String empName;
	private int empId;
	
	Employee()
	{
		
	}
	
	Employee(String empName, int empId)
	{
		this.empName=empName;
		this.empId=empId;
	}

	public String getEmpName() 
	{
		return empName;
	}

	public void setEmpName(String empName) 
	{
		this.empName = empName;
	}

	public int getEmpId() 
	{
		return empId;
	}
	
	abstract public double calculateSalary();
	abstract public void increaseSalary(double incrementPercentage);
	abstract public void setNewRate(double newRate);
}

class SalariedEmployee extends Employee
{
	private double weeklySalary;
	
	SalariedEmployee()
	{
		super();
	}
	
	SalariedEmployee(String empName, int empId, double weeklySalary)
	{
		super(empName, empId);
		this.weeklySalary=weeklySalary;
	}

	public double getWeeklySalary() 
	{
		return weeklySalary;
	}

	public void setWeeklySalary(double weeklySalary) 
	{
		this.weeklySalary = weeklySalary;
	}
	
	@Override
	public double calculateSalary()
	{
		return weeklySalary;
	}
	
	@Override
	public void increaseSalary(double incrementPercentage)
	{
		this.weeklySalary=this.weeklySalary+(incrementPercentage*weeklySalary/100);
	}
	
	@Override
	public void setNewRate(double newRate)
	{
		this.setWeeklySalary(newRate);
	}
	
	@Override
	public String toString()
	{
		return "Employee Name: "+this.getEmpName()+" Employee ID: "+String.valueOf(this.getEmpId())+" Weekly Salary: "+String.valueOf(this.weeklySalary);
	}
	@Override
	public double getPayment()
	{
		System.out.println(this);
		return weeklySalary;
	}
}

class HourlyEmployee extends Employee
{
	private int numOfHoursWorked;
	private double hourlyRate;
	
	HourlyEmployee()
	{
		super();
	}
	
	HourlyEmployee(String empName, int empId, int numOfHoursWorked, double hourlyRate)
	{
		super(empName, empId);
		this.numOfHoursWorked=numOfHoursWorked;
		this.hourlyRate=hourlyRate;
	}

	public int getNumOfHoursWorked() 
	{
		return numOfHoursWorked;
	}

	public void setNumOfHoursWorked(int numOfHoursWorked) 
	{
		this.numOfHoursWorked = numOfHoursWorked;
	}

	public double getHourlyRate() 
	{
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) 
	{
		this.hourlyRate = hourlyRate;
	}
	
	@Override
	public double calculateSalary()
	{
		return numOfHoursWorked*hourlyRate;
	}
	
	@Override
	public void increaseSalary(double incrementPercentage)
	{
		this.hourlyRate=this.hourlyRate+(this.hourlyRate*incrementPercentage/100);
	}
	
	@Override
	public void setNewRate(double newRate)
	{
		this.setHourlyRate(newRate);
	}
	
	@Override
	public String toString()
	{
		return "Employee Name: "+this.getEmpName()+" Employee ID: "+String.valueOf(this.getEmpId())+" Hourly Rate: "+String.valueOf(this.hourlyRate)+" Number of hours worked: "+String.valueOf(numOfHoursWorked);
	}
	
	@Override
	public double getPayment()
	{
		System.out.println(this);
		return hourlyRate*numOfHoursWorked;
	}
}

class CommissionEmployee extends Employee
{
	private double commissionPercentage;
	private double weeklySale;
	
	CommissionEmployee()
	{
		super();
	}
	
	CommissionEmployee(String empName, int empId, double commissionPercentage, double weeklySale)
	{
		super(empName, empId);
		this.commissionPercentage=commissionPercentage;
		this.weeklySale=weeklySale;
	}

	public double getCommissionPercentage() 
	{
		return commissionPercentage;
	}

	public void setCommissionPercentage(double commissionPercentage) 
	{
		this.commissionPercentage = commissionPercentage;
	}

	public double getWeeklySale() 
	{
		return weeklySale;
	}

	public void setWeeklySale(double weeklySale) 
	{
		this.weeklySale = weeklySale;
	}
	
	@Override
	public double calculateSalary()
	{
		return (weeklySale*commissionPercentage)/100;
	}
	
	@Override
	public void increaseSalary(double incrementPercentage)
	{
		this.commissionPercentage=this.commissionPercentage+(this.commissionPercentage*incrementPercentage/100);
	}
	
	@Override
	public void setNewRate(double newRate)
	{
		this.setCommissionPercentage(newRate);
	}
	
	@Override
	public String toString()
	{
		return "Employee Name: "+this.getEmpName()+" Employee ID: "+String.valueOf(this.getEmpId())+" Commission Percentage: "+String.valueOf(this.commissionPercentage)+" Weekly Sale: "+String.valueOf(weeklySale);
	}
	
	@Override
	public double getPayment()
	{
		System.out.println(this);
		return this.calculateSalary();
	}
	
}
