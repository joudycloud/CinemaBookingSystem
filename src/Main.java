
import java.util.Scanner;
public class Main {
    static String movieName;
    static String roomType;
    static int ticketNumber;
    static boolean vipSeat;
    static String snacks;
    static double ticketPrice;
    static int ticketsNumber;
    static double total;
    static String[] chosenSeats;
    static String[][]Seat;
    static  Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Seat= new String[][]{{"A1","A2","A3","A4"},
                {"B1","B2","B3","B4"},
                {"C1","C2","C3","C4"}};
        int choice;
        do {

        menu();
             choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> bookTicket();

                case 2 -> buySnacks();

                case 3 -> printReceipt(movieName,ticketsNumber,roomType,vipSeat,snacks,ticketPrice,total);
            }

            } while (choice != 4);
}
static void bookTicket() {
    ticketPrice=0;
    System.out.print("Movie Name : ");
    movieName = scanner.nextLine();
    System.out.print("How many ticket ? ");
     ticketsNumber = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Choose a hall category :\n-Standrnd\n-Gold\n-Junior");
     roomType = scanner.next().toLowerCase();
    switch (roomType){
        case("standrnd") -> ticketPrice = 30;
        case("gold") -> ticketPrice = 45;
        case("junior") -> ticketPrice = 15;
        default -> System.out.println("Enter a correct hall category");
    }
    chosenSeats=bookSeat(chosenSeats);
    isSeatAvailbleBOOKIT(chosenSeats);
    /*
    System.out.println("choose your seat ? ");
    String bookSeat = scanner.next();
    cinemaRoom(bookSeat);
    vipSeat = (bookSeat.toUpperCase().startsWith("C"));
   if (vipSeat) ticketPrice+= 10.50;
  */
}
static void menu(){
    System.out.println("======= CINEMA =======");
    System.out.println("1- Book Ticket\n2- Buy Snacks\n3- Print Receipt\n4- Exit");
    System.out.print("Enter your choise : ");
}
static void buySnacks(){
    System.out.println("-Popcorn\n-Nachos\n-soft Drink\n-Water");
    String snacks = scanner.nextLine();
   int snacksNumber = 0;
    if (snacks.equalsIgnoreCase("popcorn") || snacks.equalsIgnoreCase("nachos")
            ||snacks.equalsIgnoreCase("soft drink" )||snacks.equalsIgnoreCase("softdrink") ||
            snacks.equalsIgnoreCase("water")) {
        if (snacks.equalsIgnoreCase("softdrink")||snacks.equalsIgnoreCase("soft drink")) {
            System.out.println("-Pepsi\n-Sprite\n-Mirinda\n-7UP\n-Dew");
            snacks = scanner.next().toUpperCase();
        }
        System.out.println("How many ? ");
        snacksNumber = scanner.nextInt();
        for (int i = 1; i <= snacksNumber; i++) {
            System.out.println("Adding " + snacks+" ...");
            System.out.println("");
        }

    }else{
        System.out.println("Enter correct order 😊🍿");
    }
}
static void cinemaRoom() {
   /* System.out.println("");
    for (char row='A';row<='C';row++){
      for (int i =1;i<=4;i++){
          String seat = row+""+i;
          if(seat.equalsIgnoreCase(bookSeat)){
              System.out.println("XX");
          }else{
              System.out.print(seat + " ");
          }
      }
        System.out.println(" ");
        }
*/
}

static String[] bookSeat(String[] chosenSeats ){

   chosenSeats= new String[ticketsNumber];
    System.out.println("------  Screen  -----");
    System.out.println("");
    for (String[] row: Seat){
        for (String seat:row){
            System.out.print(seat+" ");
        }
        System.out.println("");
    }
  for(int i=0;i<chosenSeats.length;i++){
      System.out.print("choose seat number "+(i+1)+" : ");
      chosenSeats[i] = scanner.next();
  }
  return chosenSeats;
}

static String[][] isSeatAvailbleBOOKIT(String[] chosenSeats){
    /*for (String chosenSeat : chosenSeats){
        for (int i = 0; i < seats.length; i++) {
            if (chosenSeat.equalsIgnoreCase(seats[i])){
              if (chosenSeat.equals("XX")){
                  System.out.println("sorry, this seat is riceved");
              }else {
                  seats[i]="XX";
              }
            }
        }
    }*/
    for (String chosenSeat : chosenSeats) {
        boolean isFound = false;
        for (int i = 0; i < Seat.length; i++) {
            for (int j = 0; j < Seat[i].length; j++) {
                if (chosenSeat.equalsIgnoreCase(Seat[i][j])) {
                    isFound = true;
                    Seat[i][j] = "XX";
                }
            }
        }
        if (isFound) System.out.println("Seat found!");
         else System.out.println("Invaild seat.");
    }
    return Seat;
}
static double printReceipt(String movieName ,int ticketsNumber , String roomType , boolean vipSeat , String snacks ,double ticketPrice,double total){
    System.out.println("Movie : "+movieName);
    System.out.println("Tickets : "+ticketsNumber);
    System.out.println("Hall Category : "+roomType);
    if(vipSeat){
        System.out.println("VIP : YES");
    }else{
        System.out.println("VIP : NO");
    }
    total = ticketsNumber * ticketPrice;
    System.out.println("Total = "+total);
    return total;
}

}
