package Task2;

class Task_2 {
    private int empid;
    private String empname;
    private double sal;
    private int experience;

    public Task_2(int empid,String empname, double sal, int experience)
    {
        this.empid=empid;
        this.empname=empname;
        this.sal=sal;
        this.experience=experience;

    }
    public String getemployeeDetails()
    {
    return "employee id : "+empid+"\nemployee name: "+empname+"\nemployee salary : "+sal+"\nExperience : "+experience;
    }
    public void setemployeedetails(int empid, String empname,double sal,int experience)
    {
        this.empid=empid;
        this.empname=empname;
        this.sal=sal;
        this.experience=experience;
    }
    public String getLoanEligibility() {
        if (experience > 5) {
            if  (sal >= 1500000)
                return ("eligible for 7 lakhs loan");
            else if (sal >= 1000000)
                return ("eligible for 5 lakhs loan");
            else if(sal >= 600000)
                return ("eligible for 2 lakhs loan");
            else {
                return ("Not eligible for loan");
            }
        } else {
            return ("Work experience shoul be above 5 years!");
        }
    }
    public static void main(String[] args) {
        Task_2 emp = new Task_2(1, "AAA", 1200000, 2);
        System.out.println(emp.getemployeeDetails());
        System.out.println(emp.getLoanEligibility());
    }
}

