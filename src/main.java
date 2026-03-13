// Main.java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        SyslogDoublyLinkedList logList = new SyslogDoublyLinkedList();
        String filePath = "syslog.txt"; // Okunacak örnek log dosyası

        // Try-with-resources yapısı kullanılarak bellek sızıntısı (memory leak) önlenmiştir.
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Dosya akışından (stream) satır satır okuma yapılıyor
            while ((line = br.readLine()) != null) {
                // ÖRNEK BİR PARSING (Ayrıştırma) İŞLEMİ
                // Gerçek log formatına göre regex veya split operasyonları düzenlenmelidir.
                // Örnek Syslog: "Oct 12 10:22:34 server1 sshd[123]: Failed password for root"

                String[] parts = line.split(" ", 5);
                if(parts.length >= 5) {
                    // İlk 3 parça genelde tarih ve saattir (Oct 12 10:22:34)
                    String timestamp = parts[0] + " " + parts[1] + " " + parts[2];
                    String hostname = parts[3];

                    // Kalan string'i process ve mesaj olarak tekrar ayırıyoruz
                    String[] processAndMsg = parts[4].split(":", 2);
                    String process = processAndMsg[0];
                    String message = processAndMsg.length > 1 ? processAndMsg[1].trim() : "";

                    // Heap üzerinde dinamik tahsisat yapılarak listeye ekleniyor
                    logList.appendNode(timestamp, hostname, process, message);
                }
            }
        } catch (IOException e) {
            System.err.println("Dosya okuma (I/O) hatası meydana geldi: " + e.getMessage());
        }

        // Operasyon testleri
        logList.printForward();
        // logList.printReverse(); // Sistemin en güncel logdan eskiye doğru analizini simüle eder
    }
}