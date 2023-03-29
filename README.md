# UI Test Automation

- Binance sitesine ait hazırlanan caseleri içerir.

### Run at local

- CMD ile mvn olup olmadığı mvn -v komutu ile kontrol edilir , yoksa kurulum yapılır
- BDD framework olarak eklenen gauge için pom.xml üzerinde dependency eklenir ve gauge init java komutu ile çalıştırılır.
- Spec içerisindeki test senaryoları run edilir.

### Run at SeleniumGrid
- Paralel test koşumları için selenium grid resmi web sitesinden indirilir.(https://www.selenium.dev/downloads/))
- Terminal açılır ve sunucunun bulunduğu klasöre gidilerek java -jar selenium-server-standalone-2.41.0.jar -role hub komutu çalıştırılır.
- Default local arayüzü http://localhost:4444/grid/console üzerinden kontrol edilebilir.
- Daha sonra node'ların kurulacağı server'a yönlenilerek java -jar selenium-server-standalone-2.41.0.jar -role node -hub http://localhost:4444/grid/register -port xxxx komutu çalıştırılır.
- Node’ları başlatmak için selenium sürücüsünü diğer serverlarda çalıştırmaya başlarız.
- İlgili tarayıcılar seçilerek ihtiyaca yönelik test koşumları planlanır.

