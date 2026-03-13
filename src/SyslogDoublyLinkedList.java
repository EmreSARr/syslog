// SyslogDoublyLinkedList.java
public class SyslogDoublyLinkedList {
    private SyslogNode head;
    private SyslogNode tail;

    public SyslogDoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Listeye kuyruktan (sondan) eleman ekleme metodumuz -> O(1) Karmaşıklık
    public void appendNode(String timestamp, String hostname, String process, String message) {
        SyslogNode newNode = new SyslogNode(timestamp, hostname, process, message);

        if (head == null) {
            // Liste boşsa ilk düğüm hem head hem tail olur
            head = newNode;
            tail = newNode;
        } else {
            // Liste doluysa, yeni düğümü mevcut tail'in sonuna bağla
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode; // Tail işaretçisini güncelle
        }
    }

    // Zamanda geriye doğru (sondan başa) okuma simülasyonu
    public void printReverse() {
        SyslogNode current = tail;
        System.out.println("--- Loglar Sondan Başa Okunuyor (Reverse Traversal) ---");
        while (current != null) {
            System.out.println(current.toString());
            current = current.prev;
        }
    }

    // Baştan sona okuma
    public void printForward() {
        SyslogNode current = head;
        System.out.println("--- Loglar Baştan Sona Okunuyor (Forward Traversal) ---");
        while (current != null) {
            System.out.println(current.toString());
            current = current.next;
        }
    }
}