import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task3 {

    private ArrayList<String> pages = new ArrayList<>();
    private String way;

    public Task3(String way) {
        this.way = way;
        readDocument( way );
        Scanner scan = new Scanner( System.in );
        System.out.println( "Введите номер страницы для печати!" );
        int pageNumber = scan.nextInt();
        printPage( pageNumber );
    }

    public void readDocument(String way) {

        try (FileInputStream in = new FileInputStream( way )) {
            byte[] arr = new byte[1800];
            while ((in.read( arr )) != -1) {
                String page = new String( arr, 0, 1800 );
                pages.add( page );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printPage(int number) {
        if (number > pages.size() || number < 1) {
            System.out.println( "Неверный номер страницы!" );
            System.out.println( "В документе " + pages.size() + " страниц!" );
        } else {
            System.out.println( pages.get( number - 1 ) );
        }
    }

}


