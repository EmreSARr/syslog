// SyslogNode.java
public class SyslogNode {
    // Encapsulation (Kapsülleme) prensibi gereği veriler private tutuluyor
    private String timestamp;
    private String hostname;
    private String process;
    private String message;

    // Çift yönlü bağlantı için referans işaretçileri
    SyslogNode prev;
    SyslogNode next;

    // Constructor (Yapıcı Metot)
    public SyslogNode(String timestamp, String hostname, String process, String message) {
        this.timestamp = timestamp;
        this.hostname = hostname;
        this.process = process;
        this.message = message;
        this.prev = null;
        this.next = null;
    }

    // Getter metotları...
    public String getTimestamp() { return timestamp; }
    public String getHostname() { return hostname; }
    public String getProcess() { return process; }
    public String getMessage() { return message; }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + hostname + " " + process + ": " + message;
    }
}