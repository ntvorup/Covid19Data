public class Covid19Data {
    private String region;
    private String aldersgruppe;
    private Integer bekræftedeTilfælde;
    private Integer døde;
    private Integer indlagteIntensiv;
    private Integer indlagte;
    private String dato;

    public Covid19Data(String region, String aldersgruppe, Integer bekræftedeTilfælde, Integer døde, Integer indlagteIntensiv, Integer indlagte, String dato) {
        this.region = region;
        this.aldersgruppe = aldersgruppe;
        this.bekræftedeTilfælde = bekræftedeTilfælde;
        this.døde = døde;
        this.indlagteIntensiv = indlagteIntensiv;
        this.indlagte = indlagte;
        this.dato = dato;
    }

    public static Covid19Data fromCSV(String csvLine) {
        String[] values = csvLine.split(";");
        String region = values[0];
        String aldersgruppe = values[1];
        Integer bekræftedeTilfælde = parseInteger(values[2]);
        Integer døde = parseInteger(values[3]);
        Integer indlagteIntensiv = parseInteger(values[4]);
        Integer indlagte = parseInteger(values[5]);
        String dato = values[6];

        return new Covid19Data(region, aldersgruppe, bekræftedeTilfælde, døde, indlagteIntensiv, indlagte, dato);
    }

    private static Integer parseInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null; // Return null if parsing fails
        }
    }

    @Override
    public String toString() {
        return "Region: " + region + ", Aldersgruppe: " + aldersgruppe + ", Bekræftede Tilfælde: " + bekræftedeTilfælde +
                ", Døde: " + døde + ", Indlagte Intensiv: " + indlagteIntensiv + ", Indlagte: " + indlagte + ", Dato: " + dato;
    }

    public Object getRegion() {
        return region;
    }

    public Object getAldersgruppe() {
        return aldersgruppe;
    }

    public Object getBekræftedeTilfælde() {
        return bekræftedeTilfælde;
    }

    public Object getDøde() {
        return døde;
    }

    public Object getIndlagteIntensiv() {
        return indlagteIntensiv;
    }

    public Object getIndlagte() {
        return indlagte;
    }

    public Object getDato() {
        return dato;
    }
}
