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

    //Belirlenen sütun ve satıra hamle yapmayı sağlayan metod
    public boolean placeMark(int row ,int col , char mark ){
        //1. kural girilen değerler 0,1 veya 2 olmalı (çünkü diziler sıfırdan başlar )
        if(row>=0 && row < 3 && col >=0 && col<3){

            //2. kural: seçilen kare boş mu? ('-' işareti mi var?)
            if(grid[row][col] == '-'){
                grid[row][col] = mark ;//Boşsa harfi koy
                return true ; //Hamle başarılı anlamında true döndür
            }
        }
        return false; //Kare doluysa veya sınırlar dışındaysa hamle başarısız

    }
}