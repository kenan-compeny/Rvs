package programmieraufgaben;
/**
 * Hier sollen die Nutzereingaben sowie die Resultate gespeichert werden.
 * Die Struktur der Klasse und die Variablen können frei gewählt werden.
 */
public class DataPackage {
    //maximale Datenteil-Länge
    private int dataPackageLength;
    public int version;
    public String absender;
    public String empfänger;
    public String nachricht;
    /**
     * Erzeugt ein DataPackage Objekt und speichert beim erzeugen die maximale Datenteil-Länge
     * @param dataPackageLength
     */
    public DataPackage(int dataPackageLength) {
        this.absender ="";
        this.empfänger="";
        this.nachricht="";
        int Version = 0 ;
        this.dataPackageLength = dataPackageLength;
    }

    /**
     * Gibt die maximale Datenteil-Länge zurück
     * @return maximale Datenteil-Länge
     */
    public int getDataPackageLength() {
        return dataPackageLength;
    }



        /**
         * Setzt die maximale Datenteil-Länge
         * @param dataPackageLength
         */
    public void setDataPackageLength(int dataPackageLength) {
        this.dataPackageLength = dataPackageLength;
    }
}
