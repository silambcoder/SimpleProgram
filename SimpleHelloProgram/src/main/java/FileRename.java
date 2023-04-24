
import java.io.*;

public class FileRename {
    public static void main(String[] args) {
        String directory = "C:\\IN\\softwares\\code\\ChatGPTProjectDownload\\write"; // Replace with the path to your directory
        File dir = new File(directory);
        
        for (File file : dir.listFiles()) {
            if (file.getName().endsWith(".txt")) {
                String className = "";
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        if (line.startsWith("public class")) {
                            className = line.substring(line.indexOf("class") + 6, line.indexOf("{")).trim();
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
                if (!className.isEmpty()) {
                    String newFileName = className + ".java";
                    File newFile = new File(file.getParent(), newFileName);
                    if (file.renameTo(newFile)) {
                        System.out.println("File renamed successfully: " + file.getName() + " -> " + newFile.getName());
                    } else {
                        System.out.println("Failed to rename file: " + file.getName());
                    }
                }
                else
                {
                	String newFileName = "pom.xml";
                    File newFile = new File(file.getParent(), newFileName);
                    if (file.renameTo(newFile)) {
                        System.out.println("File renamed successfully: " + file.getName() + " -> " + newFile.getName());
                    } else {
                        System.out.println("Failed to rename file: " + file.getName());
                    }
                	
                }
            }
        }
    }
}
