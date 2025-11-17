# REST Assured API Test Demo

Bu repo,küçük bir REST Assured projesi.  
ReqRes API’sine GET istekleri atıp hem pozitif hem de basit negatif senaryoları doğruluyorum.

## Neler var?
- Maven + Java 17
- RestAssured 5.5.6
- JUnit Jupiter 6 (JUnit 5 gibi kullanılıyor)
- ConfigReader ile properties yönetimi (base URI, API key vb.)
- Endpoint’ler için `ApiEndpoints` sınıfı
- CSV’den parametrik test (user_data.csv)
- İki tane negative test (404 senaryoları)

## Projeyi çalıştırma
```bash
mvn test
```
İlk çalıştırmada Maven bağımlılıkları indirecek; internet yoksa başarısız olabilir.

## Testler
- `ListUser#listUserSuccessfully` → `/users?page=2` listesini doğrular
- `ListUser#getUserDataWithCsv` → CSV’deki kullanıcı adlarını API ile karşılaştırır
- `ListUser#getNonexistentUserReturns404` → olmayan ID için 404 bekler
- `ListUser#invalidEndpointReturns404` → yanlış endpoint’e istek atıp 404 bekler

## Dosya yapısı
```
src/test/java/com/trendyol/
├── base/ApiBaseTest.java          # Ortak request & response spec
├── constants/ApiEndpoints.java    # Endpoint sabitleri
├── pojos/                         # Response modelleri
├── tests/ListUser.java            # Test senaryoları
└── utils/ConfigReader.java        # Properties okuyucu

src/test/resources/
├── properties/config*.properties  # Config dosyaları
└── testdata/user_data.csv         # Parametrik test verisi
```

## Notlar
- Proje küçük, demo amaçlı. Kodları sade tutmaya çalıştım.
- İstenirse POST/PUT testleri, Allure raporları vb. eklenebilir.

Sorular için: burakyagan_99@hotmail.com

