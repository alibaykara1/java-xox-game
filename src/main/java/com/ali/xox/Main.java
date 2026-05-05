package com.ali.xox;

public class Main {
    public static void main(String[] args) {

        System.out.println("xox projesi başlıyor ! \n");

        //Board sınıfımızdan yeni bir nesne (oyun tahtası ) üretiyoruz
        Board oyunTahtasi = new Board();

        //Test: Sol üst köşeye (0. satır , 0. sütun) X koyalım
        oyunTahtasi.placeMark(0,0,'X');

        //Test: Tam ortaya (1. satır, 1. sütun) O koyalım
        oyunTahtasi.placeMark(1,1,'O');

        //Test: Tahtanın yeni halini çizdirelim
        //Tahtayı ekrana çizdiriyoruz
        oyunTahtasi.printBoard();

    }
}
