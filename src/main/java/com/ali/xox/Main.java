package com.ali.xox;

import java.util.Scanner; // Kullanıcıdan veri almak için gerekli kütüphane

public class Main {
    public static void main(String[] args) {
        System.out.println("XOX projesi başlıyor!\n");
        //Board sınıfımızdan yeni bir nesne (oyun tahtası ) üretiyoruz
        Board oyunTahtasi = new Board();
        Scanner scanner = new Scanner(System.in); //Klavyeyi dinleyecek obje

        char siradakiOyuncu = 'X'; //Oyuna her zaman X başlar
        boolean oyunDevamediyor = true; //Oyun bitene kadar döngüyü çalıştıracak anahtar

        //Oyun Döngüsü (Oyun bitene kadar dönecek )
        while (oyunDevamediyor) {
            oyunTahtasi.printBoard(); //Her turda tahtayı göster
            System.out.println("Sıra " + siradakiOyuncu + " oyuncusunda. ");

            //Kullanıcıdan satır ve sütun alıyoruz
            // NOT: Normal insanlar 1,2,3 sayar ama Java (diziler) 0,1,2 sayar.
            // Bu yüzden kullanıcının girdiği sayıdan 1 çıkarıyoruz.
            System.out.print("Satır girin (1-3) :");
            int satir = scanner.nextInt() - 1;

            System.out.print("Sütun girin (1-3) :");
            int sutun = scanner.nextInt() - 1;

            //Hamleyi tahtaya yapmaya çalışıyoruz
            boolean hamleBasarilimi = oyunTahtasi.placeMark(satir, sutun, siradakiOyuncu);

            if (hamleBasarilimi) {
                //Hamle yapıldıysa oyun bittimi diye kontrol et
                if (oyunTahtasi.checkWin(siradakiOyuncu)) {
                    oyunTahtasi.printBoard();
                    System.out.println("MÜKEMMEL! Kazanan: " + siradakiOyuncu);
                    oyunDevamediyor = false;//Oyunu bitir  (Döngüden çık )
                } else if (oyunTahtasi.isBoardFull()) {
                    oyunTahtasi.printBoard();
                    System.out.println("Oyun berabere ! tahta doldu.");
                    oyunDevamediyor = false;// Oyunu bitir
                } else {
                    //Oyun bitmediyse , sırayı diğer oyuncuya geçir
                    if (siradakiOyuncu == 'X') {
                        siradakiOyuncu = 'O';
                    } else {
                        siradakiOyuncu = 'X';
                    }
                }
            } else {
                //Hamle başarısızsa (kare doluysa veya 1-3 arası bir şey girilmediyse )
                System.out.println("GEÇERSİZ HAMLE! Lütfen boş bir kareye 1, 2 veya 3 değerlerini girin. \n");
            }
        }

       //Oyun bitince scanner'ı kapat (Hafıza yönetimi için iyi bir alışkanlık )
        scanner.close();
    }
}