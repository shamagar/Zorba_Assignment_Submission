package Assignment2;

import java.util.Date;

//Creating Employee class
public class Employee
{
    private int emp_id;
    private String emp_name;
    private String emp_address;
    private int emp_mobile;
    private String department;
    private Date DateOfJoining;
    //Constructor
    public Employee(int emp_id, String emp_name, String emp_address, int emp_mobile, String department, Date dateOfJoining)
    {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_address = emp_address;
        this.emp_mobile = emp_mobile;
        this.department = department;
        DateOfJoining = dateOfJoining;
    }

    //Getter methods to get the information

    public int getEmp_id() {
        return emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public String getEmp_address() {
        return emp_address;
    }

    public int getEmp_mobile() {
        return emp_mobile;
    }

    public String getDepartment() {
        return department;
    }

    public Date getDateOfJoining() {
        return DateOfJoining;
    }

    //To string
    @Override
    public String toString()
    {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", emp_address='" + emp_address + '\'' +
                ", emp_mobile=" + emp_mobile +
                ", department='" + department + '\'' +
                ", DateOfJoining=" + DateOfJoining +
                '}';
    }
}
