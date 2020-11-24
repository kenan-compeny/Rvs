package programmieraufgaben;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class PackageCreator {

    Scanner input = new Scanner(System.in);

    String v= input.nextLine();
    String s= input.nextLine();
    String r= input.nextLine();
    String m= input.nextLine();

    /**
     * Hier sollen die Kommandozeilen-Abfragen abgefragt und die Antworten
     * gespeichert werden
     * Es sollte auf Fehlerbehandlung geachtet werden (falsche Eingaben, ...)
     *
     * @param dataPackage Hier wird das Objekt übergeben in das die abgefragten Werte gespeichert werden sollen
     * @return Gibt das als Parameter übergebene Objekt, dass mit den abgefragten Werten befüllt wurde zurück
     */
    public DataPackage fillParameters(DataPackage dataPackage) {
        dataPackage.version=Integer.parseInt(v);
        dataPackage.absender=s;
        dataPackage.empfänger=r;

        dataPackage.nachricht=m;


        return dataPackage;

    }

    /**
     * Aus dem als Parameter übergebenen Paket sollen die Informationen
     * ausgelesen und in einzelne Datenpakete aufgeteilt werden
     *
     * @param dataPackage Hier wird das Objekt übergeben in das das Resultat gespeichert werden soll
     * @return Gibt das als Parameter übergebene Objekt mit den aufgeteiltet Datenpaketen zurück
     */
    public List<DataPackage> splitPackage(DataPackage dataPackage) {
        fillParameters(dataPackage);
        List<DataPackage> dataPackages = new LinkedList<>();

        String str = dataPackage.nachricht;
        String words[] = str.split("(?!^)\\b");
        StringBuffer sb = new StringBuffer("");
        ArrayList<String> result = new ArrayList<>();
        int count=0;
        for(int i = 0; i<words.length; i++) {
            count=sb.length()+words[i].length();
            if (words[i].equals(""))
            {
                count=count+2;
            }
            if(sb.indexOf(" ")==0)
            {
                count=0;
                sb = new StringBuffer("");
            }
            if(count <= dataPackage.getDataPackageLength()) {
                sb.append(words[i]);
            }
            else {
                result.add(sb.toString());
                sb = new StringBuffer(words[i]);
                count = words[i].length();
                if(i==words.length-1)
                {
                    result.add(sb.toString());
                }
            }
        }

        for (String i:result)
         {
            DataPackage Massage = new DataPackage(dataPackage.getDataPackageLength());
            Massage.nachricht = i;
            Massage.absender=s;
            Massage.empfänger=r;
            Massage.version=Integer.parseInt(v);
            dataPackages.add(Massage);
        }
        return dataPackages;
    }

    /**
     * Diese Methode gibt den Inhalt der empfangenen Pakete in der Komandozeile aus
     *
     * @param dataPackages Hier wird die Liste übergeben, deren Elemente in die Kommandozeile ausgegeben werden sollen
     */
    public void printOutPackage(List<DataPackage> dataPackages) {
        System.out.println("Version:  " + v);
        System.out.println("Absender:  " + s);
        System.out.println("Empfänger : "+ r);
        System.out.println("Nachricht :");
        System.out.println(m);
        int count = 1 ;
        System.out.println("Aufteilung in " +dataPackages.size() +"  Pakete:");
        for (DataPackage i :dataPackages) {
            System.out.println("Version:  " + i.version);
            System.out.println("Absender:  " + i.absender);
            System.out.println("Empfänger : "+ i.empfänger);
            System.out.println("Paketlaufnummer : "+count++);
            System.out.println("Datenteil-Länge: "+ (i.nachricht.length()-1));
            System.out.println("Datenteil: "+ i.nachricht);

        }


    }
}
