
//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {

    // Read employee data from the file
    private static String readEmployeeFile() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(Constants.EMPLOYEE_FILE)));
        String employeeData = reader.readLine();
        reader.close();
        return employeeData;
    }

    // Write employee data to the file
    private static void writeEmployeeFile(String employeeData, boolean append) throws IOException {
        BufferedWriter writer = new BufferedWriter(
                new FileWriter(Constants.EMPLOYEE_FILE, append));
        writer.write(employeeData);
        writer.close();
    }

    public static void main(String[] args) {

        // Check the number of command-line arguments
        if (args.length != 1) {
            System.out.println("Error: Exactly one argument is required.");
            return;
        }

        // Check arguments
        if (args[0].equals("l")) {

            // Display all employees
            System.out.println("Loading data ...");
            try {
                String employeeData = readEmployeeFile();
                String[] employees = employeeData.split(",");
                for (String employee : employees) {
                    System.out.println(employee);
                }
            } catch (Exception exception) {
            }
            System.out.println("Data Loaded.");

        } else if (args[0].equals("s")) {

            // Display a random employee
            System.out.println("Loading data ...");
            try {
                String employeeData = readEmployeeFile();
                System.out.println(employeeData);
                String[] employees = employeeData.split(",");
                Random random = new Random();
                int selectedIndex = random.nextInt(employees.length);
                System.out.println(employees[selectedIndex]);
            } catch (Exception exception) {
            }
            System.out.println("Data Loaded.");

        } else if (args[0].contains("+")) {

            // Add a new employee
            System.out.println("Loading data ...");
            try {
                String employeeName = args[0].substring(1);
                writeEmployeeFile(", " + employeeName, true);
            } catch (Exception exception) {
            }
            System.out.println("Data Loaded.");

        } else if (args[0].contains("?")) {

            // Search for an employee
            System.out.println("Loading data ...");
            try {
                String employeeData = readEmployeeFile();
                String[] employees = employeeData.split(",");
                String searchName = args[0].substring(1);

                if (Arrays.asList(employees).contains(searchName)) {
                    System.out.println("Employee found!");
                } else {
                    System.out.println("Employee not found!");
                }
            } catch (Exception exception) {
            }
            System.out.println("Data Loaded.");

        } else if (args[0].contains("c")) {

            // Count the words in employee data
            System.out.println("Loading data ...");
            try {
                String employeeData = readEmployeeFile();
                int wordCount = new StringTokenizer(employeeData).countTokens();

                System.out.println(wordCount + " word(s) found " + employeeData.length());
            } catch (Exception exception) {
            }
            System.out.println("Data Loaded.");

        } else if (args[0].contains("u")) {

            // Update an employee name
            System.out.println("Loading data ...");
            try {
                String employeeData = readEmployeeFile();
                String[] employees = employeeData.split(",");
                String employeeName = args[0].substring(1);

                for (int index = 0; index < employees.length; index++) {
                    if (employees[index].equals(employeeName)) {
                        employees[index] = "Updated";
                    }
                }
                writeEmployeeFile(String.join(",", employees), false);
            } catch (Exception exception) {
            }
            System.out.println("Data Updated.");

        } else if (args[0].contains("d")) {

            // Delete an employee
            System.out.println("Loading data ...");
            try {
                String employeeData = readEmployeeFile();
                String[] employees = employeeData.split(",");
                String employeeName = args[0].substring(1);
                List<String> employeeList = new ArrayList<>(Arrays.asList(employees));
                employeeList.remove(employeeName);
                writeEmployeeFile(String.join(",", employeeList), false);
            } catch (Exception exception) {
            }
            System.out.println("Data Deleted.");

        } else {

            // Display an error for invalid arguments
            System.out.println("Error: Invalid argument.");
        }
    }
}