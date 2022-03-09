import java.util.Scanner;

// first check-in - checkout
// -- check-in: if customers rented enter the room number
//            : if not check room available and get info from customer

// -- checkout: if customers rented enter the room number

class Hotel {
  public static int[] addElemArr(int arr[], int a) {
    int i;
    int len = arr.length;

    int newarr[] = new int[len + 1];

    for (i = 0; i < len; i++) {
      newarr[i] = arr[i];
    }
    newarr[len] = a;

    return newarr;
  }

  public static void newRoom() {
    Scanner sc = new Scanner(System.in);
    double charge_price = 0;
    System.out.println("How many people: ");
    int guest_num = sc.nextInt();
    System.out.println("How many room: ");
    int room_num = sc.nextInt();
      System.out.println("---Type of room---");
      System.out.println("Standard room : 1");
      System.out.println("Superior room : 2");
      System.out.println("Deluxe room : 3");
      int room_type = sc.nextInt();
      
    // how many people , room type , bed type ,

    if (check_isRoom_available(room_num)) {
      System.out.println("Room is available");
      update_room_info(room_num, 1);
      service(charge_price);
    } else {
      System.out.println("Try again");
      sc.close();
      newRoom();
    }

  }

  public static void check_available_room_byType(int type){
    switch (type) {
      case 1:
        // single bed
        for (int j = 101; j <= 105; j++) {
          check_isRoom_available(j);
        }
        // queen bed
        for (int j = 106; j <= 110; j++) {
          check_isRoom_available(j);
        }
        break;
      case 2:
        // 201-210
        break;
      case 3:
        // 301-310
        break;
      default:
        System.out.println("Invalid input Please try again");
        newRoom();
        break;
    }
  }

  public static void check_bed() {

  }

  public static void check_in() {
    System.out.println("new room: 1");
    System.out.println("Back to main: 2");

    Scanner sc = new Scanner(System.in);
    int choice = sc.nextInt();

    switch (choice) {
      case 1:
        newRoom();
        break;
      case 2:
        sc.close();
        dashboard();
        break;
      default:
        System.out.println("Invalid input Please try again");
        sc.close();
        check_in();
        break;
    }
  }

  public static void check_out() {
    Scanner input = new Scanner(System.in);
    System.out.println("Check out");
    System.out.print("Enter room number: ");
    int room = input.nextInt();
    int[] temp = find_room(room);

    // show room option , user info

    // service

    // reset room status and return to room_info
    System.out.print("cancel :0");
    System.out.print("confirm :1");
    int confirm = input.nextInt();
    switch (confirm) {
      case 0:
        check_out();
        break;
      case 1:
        update_room_info(room, 0);
        input.close();
        break;
      default:
        System.out.println("Invalid input Please try again");
        input.close();
        break;
    }
  }

  public static void room_status() {
    Scanner input = new Scanner(System.in);
    System.out.println("----------Room Status----------");
    System.out.println("Show all : 1");
    System.out.println("Check status by type room : 2");
    System.out.println("Check available room: 3");
    System.out.println("Check not available room : 4");
    System.out.println("Back to main : 5");
    switch (input.nextInt()) {
      case 1:
        
        break;
      case 2:
        break;
      case 3:
      
        break;
      case 4:
        break;
      case 5:
        break;
      default:
        System.out.println("Invalid input Please try again");
        room_status();
    }
    input.close();
  }

  public static void show_all_status() {
    System.out.println("----------All room----------");

  }

  // TODO : loop for more service required
  public static double service(double total) {
    double totals = total;
    Scanner sc = new Scanner(System.in);
    System.out.println("----------Service----------");
    System.out.println("Car Service: 1");
    System.out.println("Mae ban thump kruwm sa art: 2");
    System.out.println("Breakfast: 3");

    switch (sc.nextInt()) {
      case 1:
        total += 800;
        break;
      case 2:
        total += 200;
        break;
      case 3:
        total += 100;
        break;
      default:
        System.out.println("Invalid input Please try again");
        sc.close();
        service(totals);
        break;
    }

    return totals;
  }

  public static void total_price() {
    Scanner input = new Scanner(System.in);
    double price = 0;
    System.out.println("Total price");
    System.out.print("Enter room number: ");
    int room = input.nextInt();
    int[] room_tmp = find_room(room);
    price = service(price);
    price += room_tmp[4];
    System.out.print("Room number: " + room_tmp[0] + " total price is " + price);
    input.close();
  }

  // ![room_num, room_type, room_bed, room_status, room_price]

  public static void room_detail() {
    Scanner input = new Scanner(System.in);
    System.out.println("room detail");
    System.out.print("Enter room number: ");
    int room = input.nextInt();
    int[] room_tmp = find_room(room);
    System.out.println("Room number:" + room_tmp[0]);
    System.out.println("Room type:" + room_tmp[1]);
    System.out.println("Room bed:" + room_tmp[2]);
    System.out.println("Room status:" + room_tmp[3]);
    System.out.println("Room price:" + room_tmp[4]);
    input.close();
  }

  public static boolean check_isRoom_available(int room_num) {
    int[] room_tmp = find_room(room_num);
    if (room_tmp[3] == 1) {
      System.out.println("Room " + room_tmp[3] +" is not available");
      return false;
    }
      System.out.println("Room " + room_tmp[3] +" is available");
      return true;
  }

  // ![room_num, room_type, room_bed, room_status, room_price]

  // create method update room_info by room_num and room_status
  public static void update_room_info(int room_num, int room_status) {
    int[][] room_info;
    room_info = room_info();
    for (int i = 0; i < room_info.length; i++) {
      if (room_info[i][0] == room_num) {
        room_info[i][3] = room_status;
      }
    }
  }

  // create method return array of room parameters room room number
  public static int[] find_room(int room_num) {
    int[][] room_info;
    int[] tmp = new int[0];
    room_info = room_info();
    for (int i = 0; i < room_info.length; i++) {
      if (room_info[i][0] == room_num) {
        // loop 5 time
        for (int j = 0; j < 5; j++) {
          tmp = addElemArr(tmp, room_info[i][j]);
        }

      }
    }
    return tmp;
  }

  public static void add_user_info(String name, String room_numString, String pString) {

  }

  // ["name", "room", "price"]
  public static String[][] user_info(String[] args) {
    String[][] user_info = new String[0][0];
    return user_info;
  }

  public static int[][] room_info() {
    int[][] room = {
        { 101, 0, 0, 0, 2000 },
        { 102, 0, 0, 0, 2000 },
        { 103, 0, 0, 0, 2000 },
        { 104, 0, 0, 0, 2000 },
        { 105, 0, 0, 0, 2000 },
        { 106, 0, 1, 0, 2000 },
        { 107, 0, 1, 0, 2000 },
        { 108, 0, 1, 0, 2000 },
        { 109, 0, 1, 0, 2000 },
        { 110, 0, 1, 0, 2000 },
        { 201, 1, 0, 0, 2800 },
        { 202, 1, 0, 0, 2800 },
        { 203, 1, 0, 0, 2800 },
        { 204, 1, 0, 0, 2800 },
        { 205, 1, 0, 0, 2800 },
        { 206, 1, 1, 0, 2800 },
        { 207, 1, 1, 0, 2800 },
        { 208, 1, 1, 0, 2800 },
        { 209, 1, 1, 0, 2800 },
        { 210, 1, 1, 0, 2800 },
        { 301, 2, 0, 0, 3500 },
        { 302, 2, 0, 0, 3500 },
        { 303, 2, 0, 0, 3500 },
        { 304, 2, 0, 0, 3500 },
        { 305, 2, 0, 0, 3500 },
        { 306, 2, 1, 0, 3500 },
        { 307, 2, 1, 0, 3500 },
        { 308, 2, 1, 0, 3500 },
        { 309, 2, 1, 0, 3500 },
        { 310, 2, 1, 0, 3500 },
    };

    return room;
  }

  public static void dashboard() {
    Scanner scan = new Scanner(System.in);

    System.out.println("Welcome to the Hotel");
    System.out.println("Check in: 1");
    System.out.println("Check out: 2");
    System.out.println("Room status: 3");
    System.out.println("Room detail: 4");
    System.out.println("exit: 5");

    switch (scan.nextInt()) {
      case 1:
        check_in();
        break;
      case 2:
        check_out();
        break;
      case 3:
        room_status();
        break;
      case 4:
        room_detail();
        break;
      case 5:
        scan.close();
        return;
      default:
        System.out.println("Invalid input");
        dashboard();
    }

    scan.close();
  }

  public static void main(String[] args) {
    dashboard();
    System.out.println("Thank you for using our service");
  }
}