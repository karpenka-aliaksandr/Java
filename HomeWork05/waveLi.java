package HomeWork05;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * waveLi Реализовать заполнение и вывод карты по волновому алгоритму.
 */
public class waveLi{

  public static void main(String[] args) {
    int[][] map = getMap();
    // System.out.println(rawData(getMap()));
    System.out.println(mapView(map));
    Queue<int[]> queue = new ArrayDeque<int[]>();
    int[] startPos = getStartPos();
    int[] exitPos = getExitPos();
    int count = 1;
    markPos(queue, map, startPos, count);

    while (/**map[exitPos[0]][exitPos[1]] == 0 && */!queue.isEmpty()) {
      int[] currentPos = queue.poll();
      count = map[currentPos[0]][currentPos[1]] + 1;
      // System.out.println(Arrays.toString(currentPos));
      markPos(queue, map, new int[] {currentPos[0],currentPos[1]-1}, count);
      markPos(queue, map, new int[] {currentPos[0],currentPos[1]+1}, count);  
      markPos(queue, map, new int[] {currentPos[0]-1,currentPos[1]}, count);
      markPos(queue, map, new int[] {currentPos[0]+1,currentPos[1]}, count);
    }
    System.out.println(mapView(map));
  }

  static void markPos(Queue queue, int[][] map, int[] pos, int count) {
    if (map[pos[0]][pos[1]] == 0) {
      map[pos[0]][pos[1]] = count;
      queue.add(pos);
    }
  }

  static int[] getStartPos() {
    return new int[] { 3, 3 };
  }

  static int[] getExitPos() {
    return new int[] { 6, 18 };
  }

  static int[][] getMap() {
    return new int[][] {
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, 00, -1, -1, -1, -1, 00, 00, 00, 00, -1, 00, -1, -1, -1, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, 00, -1, 00, 00, -1, 00, 00, 00, 00, -1, 00, -1, 00, 00, 00, 00, 00, 00, -1 },
        { -1, -1, -1, 00, -1, 00, -1, 00, 00, -1, 00, 00, 00, 00, -1, 00, -1, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, 00, -1, 00, 00, -1, -1, -1, 00, 00, -1, 00, -1, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, -1, -1, -1, -1, -1, 00, 00, 00, 00, -1, -1, -1, -1, -1, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, -1, -1, -1, -1, -1, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }
    };
  }

  static String rawData(int[][] map) {
    StringBuilder sb = new StringBuilder();

    for (int row = 0; row < map.length; row++) {
      for (int col = 0; col < map[row].length; col++) {
        sb.append(String.format("%5d", map[row][col]));
      }
      sb.append("\n");
    }

    return sb.toString();
  }

  static String mapView(int[][] map) {
    StringBuilder sb = new StringBuilder();
    for (int row = 0; row < map.length; row++) {
      for (int col = 0; col < map[row].length; col++) {
        switch (map[row][col]) {
          case 0:
            sb.append("  ");
            break;
          case -1:
            sb.append("##");
            break;
          default:
            sb.append(String.format("%2d", map[row][col]));
            break;
        }
      }
      sb.append("\n");
    }
    sb.append("\n");
    return sb.toString();
  }
}
