# Linux Syslog Verilerinin Çift Yönlü Bağlı Liste ile Yönetimi

Bu proje, Linux işletim sistemlerinde üretilen sistem günlüklerini (syslog) ayrıştırarak, dinamik bellek yönetimi prensipleriyle RAM üzerinde depolamak ve analiz etmek amacıyla geliştirilmiştir.

## 📌 Proje Amacı ve Teknik Detaylar
Log dosyalarındaki verileri analiz etmek için standart dizi (array) yapıları yerine **Çift Yönlü Bağlı Liste (Doubly Linked List)** veri yapısı kullanılmıştır. 

Syslog kayıtları kronolojik sırayla dosyaya yazılır. Ancak sistem yöneticileri hata analizi yaparken genellikle en güncel olaydan geçmişe doğru (sondan başa) okuma ihtiyacı duyar. Çift yönlü bağlı liste mimarisi, içerdiği `prev` ve `next` işaretçileri sayesinde `O(1)` adım maliyetiyle her iki yönde de (forward ve reverse traversal) gezinmeye olanak tanır. Bu mimari karar, sistemin esnekliğini ve arama operasyonlarındaki verimliliğini maksimize etmektedir.

## 🚀 Kullanılan Teknolojiler
* **Programlama Dili:** Java (JDK 21+)
* **Veri Yapısı:** Doubly Linked List (Çift Yönlü Bağlı Liste)
* **Geliştirme Ortamı:** IntelliJ IDEA

## ⚙️ Sınıf Mimarisi
Proje nesne yönelimli programlama (OOP) kapsülleme (encapsulation) prensiplerine uygun olarak 3 ana sınıftan oluşmaktadır:
1. `SyslogNode`: Tekil bir log kaydını temsil eden, zaman damgası, sunucu adı, process ve mesaj verilerini kapsülleyen düğüm sınıfı.
2. `SyslogDoublyLinkedList`: Düğümlerin bellekte dinamik olarak tahsis edilmesini ve `O(1)` karmaşıklığı ile listeye eklenmesini sağlayan ana veri yapısı sınıfı.
3. `Main`: Disk üzerindeki `syslog.txt` dosyasını `BufferedReader` kullanarak okuyan, verileri `String.split()` ile ayrıştıran (parse eden) ve bağlı listeyi başlatan kontrol sınıfı.

## 🛠️ Kurulum ve Çalıştırma
1. Repoyu bilgisayarınıza klonlayın.
2. Projenin ana dizinine (root) analiz edilmek istenen günlükleri içeren `syslog.txt` dosyasını ekleyin.
3. `Main.java` sınıfını çalıştırarak ayrıştırılmış log kayıtlarını konsol üzerinden inceleyebilirsiniz.