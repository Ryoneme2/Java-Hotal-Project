import java.util.*;

public class Hotel_test {

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

  // create medthod return array of room parameters room room number
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
  public static void main(String[] args) {

    System.out.println(Arrays.toString(find_room(105)));
    
  }
}
