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
    public boolean placeMark(int row, int col, char mark) {
        //1. kural girilen değerler 0,1 veya 2 olmalı (çünkü diziler sıfırdan başlar )
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {

            //2. kural: seçilen kare boş mu? ('-' işareti mi var?)
            if (grid[row][col] == '-') {
                grid[row][col] = mark;//Boşsa harfi koy
                return true; //Hamle başarılı anlamında true döndür
            }
        }
        return false; //Kare doluysa veya sınırlar dışındaysa hamle başarısız

    }

    //Gönderilen harfin (X veya O )kazanıp kazanmadığını kontrol eden metod
    public boolean checkWin(char mark) {
        //Satır ve sütun kontrolleri (Döngü ile 3 satırı ve 3 sütunu kontrol ediyoruz )
        for (int i = 0; i < 3; i++) {
            if ((grid[i][0] == mark && grid[i][1] == mark && grid[i][2] == mark) || //Yatay satır kontrolü
                (grid[0][i] == mark && grid[1][i] == mark && grid[2][i] == mark )){ //Dikey sütun kontrolü
                return true; //Kazanan bulundu !
            }
        }

        //Çapraz (Diagonal) kontrolleri
        if ((grid[0][0] == mark && grid[1][1] == mark && grid[2][2] == mark) || //Sol üstten sağ alta çapraz
           (grid[0][2] == mark && grid[1][1] == mark && grid[2][0] == mark )){  //Sağ üstten sol alta çapraz
            return true ; //Kazanan bulundu !
        }
        return false ; // Eğer yukarıdaki şartlar sağlanmıyorsa kazanan yoktur .
    }

    //Tahtanın tamamen dolup dolmadığını (Beraberlik durumunu) kontrol eden metod
    public boolean isBoardFull() {
        for(int i=0 ; i<3 ; i++ ){
            for(int j=0 ; j<3 ; j++ ){
                if(grid[i][j] == '-'){
                    return false; //Hala boş ('-') bir yer var , oyun devam edebilir
                }
            }
        }
        return true ; //Hiç boş yer kalmamış , Tahta dolu
    }
}