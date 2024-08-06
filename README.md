# api_automation
Project Description: API Automation Testing with Java
Test Framework menggunakan : JUnit dan TestNG
Reporting menggunakan: Allure plugin
Bahasa Pemogramam: Java
Contoh Rest API menggunakan: https://reqres.in
Operating System: Windows 

Cara menjalankan project:
1. clone repository
2. pastikan gradle anda sudah terinstalasi di lokal mesin anda
3. Buka dengan IDE Kesesukaan anda, saat ini saya menggunakan IntelliDJA karena lebih user friendly jika dibandingkan dengan eclipse. altenatif bisa menggunakan VS Code
4. Synchonkan dependencies anda dengan build.gradle (Kebetulan saya menggunakan intelliDJA, tinggal klik tombol play button)
5. Jalankan project melalui IDE kesukaan anda.
6. Untuk testing secara CLI , masuk ke command prompt dan bisa menjalankan perintah didalam project  **.gradlew clean test** sehingga menyerupai tampilan dibawah ini

   ![image](https://github.com/user-attachments/assets/61e7523c-c75d-4d1e-8efa-e70c3ef9c92b)

7. project menggunakan plugin allure, untuk mengenerate reporting allure bisa menggunakan perintah CLI **allure serve build/allure-results** dan contoh perintah seperti tampilan dibawah

   ![image](https://github.com/user-attachments/assets/15f8061c-49ab-4987-a836-dc5c5f636cbe)

8. Jika browser tidak otomomatis muncul ,maka di browser ketikkanlah alamat yang disebutkan seperti contoh diatas: **http://192.168.56.1:58127 **(anda mgkn akan mendapatkan alamat yang berbeda, sesuaikanlah dengan alamat allure anda) dan hasilnya akan seperti contoh tamplian di bawah ini.
   ![image](https://github.com/user-attachments/assets/92aebeea-61bb-451a-aa09-627ceab1cb63)
9. Jika anda mengalami kesulitan boleh menghubungi saya, siap membantu.
10. Terima kasih

