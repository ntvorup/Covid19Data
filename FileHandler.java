import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {
    private ArrayList<Covid19Data> dataList = new ArrayList<>();

    public void readFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "ISO-8859-1"))) {
            String line;
            br.readLine();  // Skip header line
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue; // skip empty lines
                }
                String[] values = line.split(";");

                if (values.length < 7) {
                    continue; //skip lines that don’t have enough columns
                }

                try {
                    Covid19Data data = new Covid19Data(
                            values[0],
                            values[1],
                            Integer.parseInt(values[2]),
                            Integer.parseInt(values[3]),
                            Integer.parseInt(values[4]),
                            Integer.parseInt(values[5]),
                            values[6]
                    );
                    dataList.add(data);
                } catch (NumberFormatException e) {
                    // skip lines with number format issues
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printData() {
        // Print the table header
        System.out.printf("%-15s %-15s %-20s %-10s %-20s %-15s %-10s\n",
                "Region", "Aldersgruppe", "Bekræftede Tilfælde", "Døde", "Indlagte Intensiv", "Indlagte", "Dato");
        System.out.println("---------------------------------------------------------------------------------------------------------------");

        // Print each row of data
        for (Covid19Data data : dataList) {
            System.out.printf("%-15s %-15s %-20d %-10d %-20d %-15d %-10s\n",
                    data.getRegion(), data.getAldersgruppe(), data.getBekræftedeTilfælde(), data.getDøde(),
                    data.getIndlagteIntensiv(), data.getIndlagte(), data.getDato());
        }
    }
}