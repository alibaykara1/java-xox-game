package com.ali.xox;

public class Main {
    public static void main(String[] args) {

        System.out.println("xox projesi başlıyor ! \n");

        //Board sınıfımızdan yeni bir nesne (oyun tahtası ) üretiyoruz
        Board oyunTahtasi = new Board();

        //Tahtayı ekrana çizdiriyoruz
        oyunTahtasi.printBoard();

    }
}
