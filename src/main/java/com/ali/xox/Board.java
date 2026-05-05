package com.ali.xox;

public class Board {
    //3x3 boyutunda bir karakter matrisi sadece bu sınıf içerisinden erişilebilmesi için private yapıyoruz
    private char[][] grid;

    //Sınıf çağırıldığında (new Board () denildiğinde ) ilk çalışacak constructor (yapıcı) metodumuz
    public Board() {
        grid = new char[3][3];
        initializeBoard(); //Tahtayı oluşturur oluşturmaz içini boş karakterlerle dolduruyoruz
    }

    //Tahtanın  içini başlangıçta '-' (boşluk) karakteri ile dolduran metod
    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {//Satırları Döner
            for (int j = 0; j < 3; j++) {//Sütunları Döner
                grid[i][j] = '-';
            }
        }
    }

    // Tahtanın güncel halini konsola estetik bir şekilde çizen metod
    public void printBoard() {
        System.out.println("----------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + " | ");
            }
            System.out.println();
            System.out.println("----------------");
        }

    }

}
