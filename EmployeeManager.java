//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {

    private static String readFile() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("employees.txt")));
        String line = reader.readLine();
        reader.close();
        return line;
    }

    private static void writeFile(String data, boolean append) throws IOException {
        BufferedWriter writer = new BufferedWriter(
                new FileWriter("employees.txt", append));
        writer.write(data);
        writer.close();
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Error: Exactly one argument is required.");
            return;
        }
        // Check arguments
        if (args[0].equals("l")) {
            System.out.println("Loading data ...");
            try {
                String line = readFile();
                String[] employees = line.split(",");
                for (String emp : employees) {
                    System.out.println(emp);
                }
            } catch (Exception exception) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("s")) {
            System.out.println("Loading data ...");
            try {
                String line = readFile();
                System.out.println(line);
                String[] employees = line.split(",");
                Random random = new Random();
                int randomIndex = random.nextInt(employees.length);
                System.out.println(employees[randomIndex]);
            } catch (Exception exception) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                String name = args[0].substring(1);
                writeFile(", " + name, true);
            } catch (Exception exception) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                String line = readFile();
                String[] employees = line.split(",");
                boolean found = false;
                String searchName = args[0].substring(1);
                for (int index = 0; index < employees.length && !found; index++) {
                    if (employees[index].equals(searchName)) {
                        System.out.println("Employee found!");
                        found = true;
                    }
                }
            } catch (Exception exception) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                String line = readFile();
                char[] chars = line.toCharArray();
                boolean inWord = false;
                int count = 0;
                for (char character : chars) {
                    if (character == ' ') {
                        if (!inWord) {
                            count++;
                            inWord = true;
                        } else {
                            inWord = false;
                        }
                    }
                }
                System.out.println(count + " word(s) found " + chars.length);
            } catch (Exception exception) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("u")) {
            System.out.println("Loading data ...");
            try {
                String line = readFile();
                String[] employees = line.split(",");
                String name = args[0].substring(1);
                for (int index = 0; index < employees.length; index++) {
                    if (employees[index].equals(name)) {
                        employees[index] = "Updated";
                    }
                }
                writeFile(String.join(",", employees), false);
            } catch (Exception exception) {
            }
            System.out.println("Data Updated.");
        } else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            try {
                String line = readFile();
                String[] employees = line.split(",");
                String name = args[0].substring(1);
                List<String> list = new ArrayList<>(Arrays.asList(employees));
                list.remove(name);
                writeFile(String.join(",", list), false);
            } catch (Exception exception) {
            }
            System.out.println("Data Deleted.");
        }
    }
}