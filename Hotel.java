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

    for (i = 0; i < len; i++){
      newarr[i] = arr[i];
    }
    newarr[len] = a;

    return newarr;

  }

  public static void newRoom() {
    Scanner sc = new Scanner(System.in);
    double charge_price = 0;
    System.out.println("Enter room number: ");
    int room_num = sc.nextInt();

    if(check_isRoom_available(room_num)) {
      System.out.println("Room is available");
      update_room_info(room_num, 1);
    } else {
      System.out.println("Try again");
      sc.close();
      newRoom();
    }

  }

  public static void check_in() {
    System.out.println("has user rented: 1");
    System.out.println("new room: 2");
    System.out.println("Back to main: 3");

    Scanner sc = new Scanner(System.in);
    int choice = sc.nextInt();

    switch (choice) {
      case 1:
        System.out.println("Enter room number: ");
        // int room_num = sc.nextInt();
        break;
      case 2:
        newRoom();
        break;
      case 3:
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
    int [] temp = find_room(room);

    //reset room status
    for(int i =1;i<=3;i++){
      temp[i] = 0;
    }
    //return to room_info

    
    input.close();
  }

  public static void room_status() {
    Scanner input = new Scanner(System.in);
    System.out.println("----------Room Status----------");
    System.out.println("Show all room : 1");
    System.out.println("Check status by type room : 2");
    System.out.println("Check available room: 3");
    System.out.println("Check not available room : 4");
    System.out.println("Back to main : 5");
    int check = input.nextInt();
    if(check==1){ // best practice

    }
    else if(check==2){

    }
    else if(check==3){

    }
    else if(check==4){

    }
    else if(check==5){

    }
    else{
      
    }
    input.close();
    
  }
  
  public static void show_all_status(){
    System.out.println("----------All room----------");
    
  }

  public static double service(double total) {
    double totals = total;
    Scanner sc = new Scanner(System.in);
    System.out.println("----------Service----------");
    System.out.println("Car Service: 1");
    System.out.println("Mae ban thump kruwm sa art: 2");
    System.out.println("Breakfast: 3");

    switch(sc.nextInt()) {
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

    return total;
  }

  // ![room_num, room_type, room_bed, room_status, room_price]

  public static void room_detail() {
   Scanner input = new Scanner(System.in);
    System.out.println("room detail");
    System.out.print("Enter room number: ");
    int room = input.nextInt();
    int [] room_tmp = find_room(room);
    System.out.println("Room number:"+ room_tmp[0]);
    System.out.println("Room type:"+ room_tmp[1]);
    System.out.println("Room bed:"+ room_tmp[2]);
    System.out.println("Room status:"+ room_tmp[3]);
    System.out.println("Room price:"+ room_tmp[4]);
    input.close();
  }

  public static boolean check_isRoom_available(int room_num) {
    int[] room_tmp = find_room(room_num);
    if(room_tmp[3] == 1){
      System.out.println("Room is not available");
      return false;
    }
    return true;
  }
  
  // ![room_num, room_type, room_bed, room_status, room_price]

  // create method update room_info by room_num and room_status
  public static void update_room_info(int room_num, int room_status) {
    int[][] room_info;
    room_info = room_info();
    for(int i = 0 ; i < room_info.length; i++) {
      if(room_info[i][0] == room_num) {
        room_info[i][3] = room_status;
      }
    }
  }


  // create method return array of room parameters room room number
  public static int[] find_room(int room_num) {
    int[][] room_info;
    int[] tmp = new int[0];
    room_info = room_info();
    for(int i = 0 ; i < room_info.length; i++) {
      if(room_info[i][0] == room_num) {
        //loop 5 time
        for(int j = 0; j < 5; j++) {
          tmp = addElemArr(tmp, room_info[i][j]);
        }
        
      }
    }
    return tmp;
  }

  public static int[][] room_info() {
      int[][] room = {
      {101,0,0,0,2000},
      {102,0,0,0,2000},
      {103,0,0,0,2000},
      {104,0,0,0,2000},
      {105,0,0,0,2000},
      {106,0,0,0,2000},
      {107,0,0,0,2000},
      {108,0,0,0,2000},
      {109,0,0,0,2000},
      {110,0,0,0,2000},
      {201,0,0,0,2000},
      {202,0,0,0,2000},
      {203,0,0,0,2000},
      {204,0,0,0,2000},
      {205,0,0,0,2000},
      {206,0,0,0,2000},
      {207,0,0,0,2000},
      {208,0,0,0,2000},
      {209,0,0,0,2000},
      {210,0,0,0,2000},
      {301,0,0,0,2800},
      {302,0,0,0,2800},
      {303,0,0,0,2800},
      {304,0,0,0,2800},
      {305,0,0,0,2800},
      {306,0,0,0,2800},
      {307,0,0,0,2800},
      {308,0,0,0,2800},
      {309,0,0,0,2800},
      {310,0,0,0,2800},
      {401,0,0,0,3500},
      {402,0,0,0,3500},
      {403,0,0,0,3500},
      {404,0,0,0,3500},
      {405,0,0,0,3500},
      {406,0,0,0,3500},
      {407,0,0,0,3500},
      {408,0,0,0,3500},
      {409,0,0,0,3500},
      {410,0,0,0,3500},
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
    }

    scan.close();
  }

  public static void main(String[] args) {
    dashboard();
    System.out.println("Thank you for using our service");
  }
}