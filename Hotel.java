import java.util.*;

// first check-in - checkout
// -- check-in: if customers rented enter the room number
//            : if not check room available and get info from customer
// -- checkout: if customers rented enter the room number

class Hotel {
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
  public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
  public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
  public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
  public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
  public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
  public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
  public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
  public static String[][] userStrings = {};
  public static int[][] room2 = {
      { 101, 0, 0, 0, 2000 },
      { 102, 0, 0, 0, 2000 },
      { 103, 0, 0, 1, 2000 },
      { 104, 0, 0, 0, 2000 },
      { 105, 0, 0, 1, 2000 },
      { 106, 0, 1, 0, 2000 },
      { 107, 0, 1, 0, 2000 },
      { 108, 0, 1, 0, 2000 },
      { 109, 0, 1, 1, 2000 },
      { 110, 0, 1, 0, 2000 },
      { 201, 1, 0, 0, 2800 },
      { 202, 1, 0, 0, 2800 },
      { 203, 1, 0, 1, 2800 },
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

  // ![room_num, room_type, room_bed, room_status, room_price]
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

  public static void printRow(String[] row) {
    for (String i : row) {
      System.out.print(i);
      System.out.print("\t");
    }
    System.out.println();
  }

  // sub method(check in)
  public static void newRoom() {
    try (Scanner sc = new Scanner(System.in)) {
      // double charge_price = 0;
      System.out.println("How many people: ");
      int guest_num = sc.nextInt();
      int room = (int) Math.ceil(guest_num / 2);
      System.out.println(guest_num / 2);
      int[] room_avi = new int[room];
      double all_total = 0;
      int[][] all_type_of_room = new int[room][2];
      for (int i = 0; i < room; i++) {
        System.out.println("Room " + room + " option");
        System.out.println("---Type of room---");
        System.out.println("Standard room : 1");
        System.out.println("Superior room : 2");
        System.out.println("Deluxe room : 3");
        int room_type = sc.nextInt();
        room_type = room_type - 1;
        System.out.println("---Bed option---");
        System.out.println("Single bed : 1");
        System.out.println("King size bed : 2");
        int bed_type = sc.nextInt();
        

        all_type_of_room[i][0] = room_type;
        all_type_of_room[i][1] = bed_type;
        // System.out.println(Arrays.toString(all_type_of_room[i]));
      }

      System.out.println("How many days do you want to stay?");
      int days = sc.nextInt();

      for (int index = 0; index < room; index++) {
        int room_num = 101;
        while (true) {
          int[] getOneRoom_info = find_room(room_num);
          System.out.println(Arrays.toString(getOneRoom_info));
          if (room_num > 310) {
            System.out.println("Sorry, we don't have room for you");
            break;
          }

          if (getOneRoom_info[3] == 0) {
            addElemArr(room_avi, getOneRoom_info[0]);
            System.out.println(Arrays.toString(room_avi));
            update_room_info(getOneRoom_info[0], 1);
            break;
          }

          if (room_num == 110 || room_num == 210 || room_num == 310) {
            room_num += 91;
          }
          room_num++;
        }
      }
      all_total += total_price(days, room_avi);
      System.out.println(Arrays.toString(room_avi));

      System.out.println("Check in success");
      for (int i = 0; i < room_avi.length; i++) {
        System.out.println("Room number: " + room_avi[i]);
      }
      System.out.println("Total price: " + all_total);
      // System.out.println(ANSI_RESET);

      dashboard();

      // Name: SmartJame So-cool
      // Total Price: $100 (1 night) + service charge
      // Room Number: 1,2,3,...
      // Room type: Standard
      // Bed type: Single
      // Total price: $100
      // Change: $0
      // Thank you for your stay!

    }
  }

  public static int bed() {
    try (Scanner sc = new Scanner(System.in)) {
      System.out.println("---Bed option---");
      System.out.println("Single bed : 1");
      System.out.println("King size bed : 2");
      int bed_type = sc.nextInt();
      return bed_type;
    }
  }

  // method 1 (check in)
  public static void check_in() {
    System.out.println("new room: 1");
    System.out.println("Back to main: 2");

    try (Scanner sc = new Scanner(System.in)) {
      int choice = sc.nextInt();

      switch (choice) {
        case 1:
          newRoom();
          break;
        case 2:
          dashboard();
          break;
        default:
          System.out.println(ANSI_RED + "xxxxx Invalid input xxxxx" + ANSI_RESET);
          check_in();
          break;
      }
    }
  }

  // method 2 (check out)
  public static void check_out() {
    try (Scanner input = new Scanner(System.in)) {
      System.out.println("Check out");
      System.out.print("Enter room number: ");
      int room = input.nextInt();
      // int[] temp = find_room(room);

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
          System.out.println("Complete !!");
          dashboard();
        default:
          System.out.println(ANSI_RED + "xxxxx Invalid input xxxxx" + ANSI_RESET);
          break;
      }
    }
  }

  // method 3(room status)
  public static void room_status() {
    try (Scanner input = new Scanner(System.in)) {
      System.out.println(ANSI_BLUE + "----------Room Status----------" + ANSI_RESET);
      System.out.println("Show all : 1");
      System.out.println("Check status by type room : 2");
      System.out.println("Check available room: 3");
      System.out.println("Check not available room : 4");
      System.out.println("Back to main : 5");
      switch (input.nextInt()) {
        case 1:
          show_all_status();
          break;
        case 2:
          check_available_room_byType();
          break;
        case 3:
          System.out.println("----------Available Room----------");
          String[][] table = new String[room2.length][];
          table[0] = new String[] { "Room number", "Status\t\t", "Room type", "Bed Type\t", "Price" };
          for (int i = 1; i < room2.length; i++) {
            String room_num = room2[i][0] + "\t";
            String status = "";
            String type = "";
            String b_type = "";
            if (room2[i][3] == 0) {
              status = ANSI_GREEN + "Available\t" + ANSI_RESET;
            }
            if (room2[i][1] == 1) {
              type = "Standard";
            } else if (room2[i][1] == 2) {
              type = "Superior";
            } else {
              type = "Deluxe\t";
            }
            if (room2[i][2] == 1) {
              b_type = "Single\t\t";
            } else {
              b_type = "Queen size\t";
            }
            String price = "" + room2[i][4] + "\t";
            if (room2[i][3] == 0) {
              table[i] = new String[] { room_num, status, type, b_type, price };
            }
          }
          for (String[] row : table) {
            printRow(row);
            System.out.println(
                "======================================================================================================");
          }
          break;
        case 4:
          System.out.println(ANSI_BLUE + "----------Not Available Room----------" + ANSI_RESET);
          String[][] tables = new String[room2.length][];
          tables[0] = new String[] { "Room number", "Status\t\t", "Room type", "Bed Type\t", "Price" };
          for (int i = 1; i < room2.length; i++) {
            String room_num = room2[i][0] + "\t";
            String status = "";
            String type = "";
            String b_type = "";
            if (room2[i][3] == 1) {
              status = ANSI_RED + "Not available\t" + ANSI_RESET;
            } else {
            }
            if (room2[i][1] == 1) {
              type = "Standard";
            } else if (room2[i][1] == 2) {
              type = "Superior";
            } else {
              type = "Deluxe\t";
            }
            if (room2[i][2] == 1) {
              b_type = "Single\t\t";
            } else {
              b_type = "Queen size\t";
            }
            String price = "" + room2[i][4] + "\t";

            if (room2[i][3] == 1) {
              tables[i] = new String[] { room_num, status, type, b_type, price };
            }
          }
          for (String[] row : tables) {
            printRow(row);
            System.out.println(
                "======================================================================================================");
          }
          break;
        case 5:
          dashboard();
          break;
        default:
          System.out.println(ANSI_RED + "xxxxx Invalid input xxxxx" + ANSI_RESET);
          room_status();
      }

    }
  }

  public static void show_all_status() {
    System.out.println(ANSI_BLUE + "----------All room----------" + ANSI_RESET);
    String[][] table = new String[room2.length][];
    table[0] = new String[] { "Room number", "Status\t\t", "Room type", "Bed Type\t", "Price" };
    for (int i = 1; i < room2.length; i++) {
      String room_num = room2[i][0] + "\t";
      String status = "";
      String type = "";
      String b_type = "";

      if (room2[i][3] == 0) {
        status = ANSI_GREEN + "Available\t" + ANSI_RESET;
      } else {
        status = ANSI_RED + "Not available\t" + ANSI_RESET;
      }
      if (room2[i][1] == 1) {
        type = "Standard";
      } else if (room2[i][1] == 2) {
        type = "Superior";
      } else {
        type = "Deluxe\t";
      }
      if (room2[i][2] == 1) {
        b_type = "Single\t\t";
      } else {
        b_type = "Queen size\t";
      }
      String price = "" + room2[i][4] + "\t";

      table[i] = new String[] { room_num, status, type, b_type, price };
    }
    for (String[] row : table) {
      printRow(row);
      System.out.println(
          "======================================================================================================");
    }

    dashboard();
  }

  public static void check_available_room_byType() {
    System.out.print("Enter room type: ");
    try (Scanner sc = new Scanner(System.in)) {
      try {
        switch (sc.nextInt()) {
          case 1:

            for (int j = 101; j <= 110; j++) {
              check_isRoom_available(j);
            }
            break;
          case 2:

            for (int j = 201; j <= 210; j++) {
              check_isRoom_available(j);
            }
            break;
          case 3:

            for (int j = 301; j <= 310; j++) {
              check_isRoom_available(j);
            }
            break;
          default:
            System.out.println(ANSI_RED + "xxxxx Invalid input xxxxx" + ANSI_RESET);
            newRoom();
            break;
        }
      } catch (Exception e) {
        System.out.println(ANSI_RED + "xxxxx Invalid input xxxxx" + ANSI_RESET);
        // newRoom();
      }
    }
  }

  public static double service(double total) {
    double totals = total;
    try (Scanner sc = new Scanner(System.in)) {
      String str = "";
      System.out.println(ANSI_BLUE + "----------Service----------" + ANSI_RESET);

      try {
        System.out.println("1. Car Service : ฿800 (y/n)");
        str = sc.nextLine();
        if (str.equals("y")) {
          totals += 800;
        }
        str = "";
        System.out.println("2. Cleaning Room service : ฿200 (y/n)");
        str = sc.nextLine();
        if (str.equals("y")) {
          totals += 200;
        }
        str = "";
        System.out.println("3. Breakfast : ฿100 (y/n)");
        str = sc.nextLine();
        if (str.equals("y")) {
          totals += 100;
        }
      } catch (Exception e) {
        System.out.println(ANSI_RED + "xxxxx Invalid input xxxxx" + ANSI_RESET);
        service(total);
      } finally {

      }
    }
    return totals;
  }

  public static double total_price(int days, int room_num[]) {
    double price = 0;
    price += service(price);

    System.out.println("Total price");

    for (int i = 0; i < room_num.length; i++) {
      price += days * room2[room_num[i]][4];
    }

    return price;
  }

  // method 4(room detail)
  public static void room_detail() {
    try (Scanner input = new Scanner(System.in)) {
      try {

        System.out.println(ANSI_BLUE + "----------room detail----------" + ANSI_RESET);
        System.out.print("Enter room number: ");
        int room = input.nextInt();
        int[] room_tmp = find_room(room);
        if (room_tmp.length <= 0) {
          System.out.println(ANSI_RED + "ROOM NOT FOUND" + ANSI_RESET);
          System.out.println(
              "======================================================================================================");
          room_detail();
        }
        String[][] table = new String[room_tmp.length][];
        String room_num = room_tmp[0] + "\t";
        String status = "";
        String type = "";
        String b_type = "";

        if (room_tmp[3] == 0) {
          status = ANSI_GREEN + "Available\t" + ANSI_RESET;
        } else {
          status = ANSI_RED + "Not available\t" + ANSI_RESET;
        }
        if (room_tmp[1] == 1) {
          type = "Standard";
        } else if (room_tmp[1] == 2) {
          type = "Superior";
        } else {
          type = "Deluxe\t";
        }
        if (room_tmp[2] == 1) {
          b_type = "Single\t\t";
        } else {
          b_type = "Queen size\t";
        }
        String price = "" + room_tmp[4] + "\t";

        table[0] = new String[] { room_num, status, type, b_type, price };
        for (String[] row : table) {
          System.out.println(
              "======================================================================================================");
          printRow(row);
          System.out.println(
              "======================================================================================================");
        }

        System.out.println("Room number:" + room_tmp[0]);
        System.out.println("Room type:" + room_tmp[1]);
        System.out.println("Room bed:" + room_tmp[2]);
        System.out.println("Room status:" + room_tmp[3]);
        System.out.println("Room price:" + room_tmp[4]);

      } finally {
        dashboard();
      }
    }
  }

  public static boolean check_isRoom_available(int room_num) {
    int[] room_tmp = find_room(room_num);
    if (room_tmp[3] == 1) {
      System.out.println("Room " + room_tmp[0] + " is not available");
      return false;
    }
    System.out.println("Room " + room_tmp[0] + " is available");
    return true;
  }

  // create method update room_info by room_num and room_status
  public static void update_room_info(int room_num, int room_status) {
    for (int i = 0; i < room2.length; i++) {
      if (room2[i][0] == room_num) {
        room2[i][3] = room_status;
      }
    }
  }

  // create method return array of room parameters room room number
  public static int[] find_room(int room_num) {
    int[] tmp = new int[0];
    for (int i = 0; i < room2.length; i++) {
      if (room2[i][0] == room_num) {
        // loop 5 time
        for (int j = 0; j < 5; j++) {
          tmp = addElemArr(tmp, room2[i][j]);
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

  public static void dashboard() {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.println(ANSI_BLUE + "----------Welcome to the Hotel----------" + ANSI_RESET);
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
          end();
        default:
          System.out.println(ANSI_RED + "xxxxx Invalid input xxxxx" + ANSI_RESET);
          dashboard();
      }
    } catch (InputMismatchException e) {
      System.out.println(ANSI_RED + "xxxxx Invalid input xxxxx" + ANSI_RESET);
      dashboard();
    } finally {
      end();
    }
  }

  public static void end() {
    return;
  }

  public static void main(String[] args) {
    try {
      dashboard();
      System.out.println("Thank you for using our service");
    } catch (Exception e) {
      System.out.println(ANSI_YELLOW + "BYE BYE BYE" + ANSI_RESET);
    } finally {
      System.out.println("Thank you for using our service");
    }
  }
}
