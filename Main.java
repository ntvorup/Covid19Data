public class Main {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.readFile("covid.csv");
        fileHandler.printData();
    }
}