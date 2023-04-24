

import java.io.*;



public class RemoveEmptyLines {
    public static void main(String[] args) {
        String directoryPath = "C:\\IN\\softwares\\code\\ChatGPTProjectDownload\\write"; // Change this to the directory path you want to read
        File directory = new File(directoryPath);

        if (!directory.isDirectory()) {
            System.out.println(directoryPath + " is not a directory.");
            return;
        }

        File[] files = directory.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".java");
            }
        });

        for (File file : files) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String firstLine = reader.readLine();
                if (firstLine != null && firstLine.trim().isEmpty()) {
                    // Remove the first line
                    String content = "";
                    String line = "";
                    while ((line = reader.readLine()) != null) {
                        content += line + "\n";
                    }
                    reader.close();

                    // Save the modified content back to the file
                    FileWriter writer = new FileWriter(file);
                    writer.write(content);
                    writer.close();

                    System.out.println("Removed the first line from " + file.getName());
                } else {
                    reader.close();
                    System.out.println("Skipped " + file.getName());
                }
            } catch (IOException e) {
                System.out.println("An error occurred while processing " + file.getName() + ": " + e.getMessage());
            }
        }
    }
}
