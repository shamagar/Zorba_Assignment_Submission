package Assignment2;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;
//import Employee.java;

public class AssignmentPartA
{
    public static void main(String[] args)
    {
        try
        {
            //Method to from the Excel file and store in an Array
            ReadEmployeeFile();

            //Method to write in to the properties file
            InsertInfoInToPropertiesFile();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }


    //Method for part A(1)
    private static void ReadEmployeeFile() throws IOException
    {
        //File path
        String path = "/Users/shamagar/Desktop/newGit/Batch1017/Zorba_Assignment_Submission/Assignment_12_Mar_2025/src/main/java/Data/employee.xlsx";

        //Load the file
        File file = new File(path);

        //Read the file and convert into byte array
        FileInputStream fileInputStream = new FileInputStream(file);

        //Creating arraylist
        ArrayList<Employee> elist = new ArrayList<>();

        //Read the excel file
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //Iterate over the number of sheets and read the sheet
        for(int i = 0; i < workbook.getNumberOfSheets(); i++)
        {
            //Read the particular sheet
            XSSFSheet sheet = workbook.getSheetAt(i);
            //Iterate each row and get the data
            Iterator<Row> rowIterator = sheet.iterator();
           while(rowIterator.hasNext()) {
               Row row = rowIterator.next();
               //Skiping the 1st row as it is a header row
               if (row.getRowNum() == 0) {
                   continue;
               }
               int emp_id = (int) row.getCell(0).getNumericCellValue();
               String emp_name = row.getCell(1).getStringCellValue();
               String emp_address = row.getCell(2).getStringCellValue();
               int emp_mobile = (int) row.getCell(3).getNumericCellValue();
               String department = row.getCell(4).getStringCellValue();
               Date DateOfJoining = row.getCell(5).getDateCellValue();

               //Adding to the list
               elist.add(new Employee(emp_id, emp_name, emp_address, emp_mobile, department, DateOfJoining));
           }
                //Convert the arraylist into an Array
                Employee[] employees = elist.toArray(new Employee[0]);
                //Displaying the elements
                for(Employee emp : employees)
                {
                    System.out.println(emp);
                }
            //}
        }

    }



    //Methods for Part-A(3)
    public static void InsertInfoInToPropertiesFile()
    {
        //File lacation
        //String path1 = "/Users/shamagar/Desktop/newGit/Batch1017/Zorba_Assignment_Submission/Assignment_12_Mar_2025/src/main/resources/employee.properties";

        //Load the file
       // File file = new File(path1);

        // //Using LinkedHasMap to store the Key and value pair and it preserves the insertion order
        Map<String, String> properties = new LinkedHashMap<>();

        //1st Employee information
        properties.put("empId", "1006");
        properties.put("empName", "Ruby Lama");
        properties.put("empAddress", "San Diego");
        properties.put("empMobile", "3456776532");
        properties.put("department", "Finance");
        properties.put("doj", "2021-12-23");

        //2nd Employee information
        properties.put("empId1", "1007");
        properties.put("empName1", "Danjo");
        properties.put("empAddress1", "Las Vegas");
        properties.put("empMobile1", "7456776532");
        properties.put("department1", "HR");
        properties.put("doj1", "2022-12-21");

        //3rd employee information
        properties.put("empId2", "1008");
        properties.put("empName2", "Jack Sophia");
        properties.put("empAddress2", "Boston");
        properties.put("empMobile2", "8456776532");
        properties.put("department2", "Science");
        properties.put("doj2", "2021-10-25");

        // Writing back to properties file
        try (FileWriter writer = new FileWriter("/Users/shamagar/Desktop/newGit/Batch1017/Zorba_Assignment_Submission/Assignment_12_Mar_2025/src/main/resources/employee.properties"))
        {
            for (Map.Entry<String, String> entry : properties.entrySet())
            {
                writer.write(entry.getKey() + "=" + entry.getValue() + "\n");
            }
            System.out.println("Insertion is Successful.");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    //Methods to read prperties file and populate employee array PART-A(4)

}

























