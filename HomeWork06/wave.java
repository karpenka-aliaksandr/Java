import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class wave {
  public static void main(String[] args) {

    Map startMap = new Map();
    System.out.println(
        MapPrinter.mapColor(startMap.getMap()));

    WaveMap lee = new WaveMap(startMap.getMap());
    lee.Wave(new Point(3, 3));
    var road = lee.getRoad(new Point(5, 8));
    // System.out.println(road);
    // System.out.println(
    // MapPrinter.rawData(lee.getMap()));
    System.out.println(
        MapPrinter.mapColor(lee.getMap(),road));

  }
}

class Point {
  int row, column;

  public Point(int row, int column) {
    this.row = row;
    this.column = column;
  }

  @Override
  public String toString() {
    return String.format(" row: %d column: %d", row, column);
  }

  @Override
  public boolean equals(Object obj) {
    Point p = (Point) obj;
    return this.row == p.row && this.column == p.column;
  }
}

class Map {
  int[][] map;

  public Map() {
    int[][] map = {
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -2, -2, -2, -1, -2, -2, -2, -2, -2, -2, -2, -2, -2, -1 },
        { -1, -2, -2, -2, -2, -2, -2, -1, -2, -2, -2, -2, -2, -2, -1 },
        { -1, -2, -2, -2, -1, -2, -2, -1, -2, -2, -2, -2, -2, -2, -1 },
        { -1, -2, -2, -2, -1, -2, -1, -1, -1, -1, -2, -2, -2, -2, -1 },
        { -1, -2, -2, -2, -1, -2, -1, -2, -2, -1, -2, -2, -2, -2, -1 },
        { -1, -1, -1, -2, -1, -2, -1, -2, -2, -1, -2, -2, -2, -2, -1 },
        { -1, -2, -2, -2, -1, -2, -1, -2, -2, -1, -1, -1, -2, -2, -1 },
        { -1, -2, -2, -2, -1, -2, -2, -2, -2, -1, -2, -2, -2, -2, -1 },
        { -1, -2, -2, -2, -1, -2, -2, -2, -2, -1, -2, -2, -2, -2, -1 },
        { -1, -2, -2, -2, -1, -1, -1, -1, -1, -1, -2, -2, -2, -2, -1 },
        { -1, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -1 },
        { -1, -2, -2, -2, -1, -1, -1, -1, -1, -1, -1, -2, -2, -2, -1 },
        { -1, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }
    };

    this.map = map;
  }

  public int[][] getMap() {
    return map;
  }
}

class MapPrinter {
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_GREEN = "\u001B[;31;42m";
  public static final String ANSI_RED = "\u001B[;31;41m";

  public static String rawData(int[][] map) {
    StringBuilder sb = new StringBuilder();

    for (int row = 0; row < map.length; row++) {
      for (int col = 0; col < map[row].length; col++) {
        sb.append(String.format("%5d", map[row][col]));
      }
      sb.append("\n");
    }
    for (int i = 0; i < 3; i++) {
      sb.append("\n");
    }

    return sb.toString();
  }

  public static String mapColor(int[][] map, ArrayDeque<Point> road) {
    StringBuilder sb = new StringBuilder();

    for (int row = 0; row < map.length; row++) {
      for (int col = 0; col < map[row].length; col++) {
        switch (map[row][col]) {
          case 0:
            if (road.contains(new Point(row, col))) {
              sb.append(ANSI_GREEN + "K" + ANSI_RESET);
            } else {
              sb.append(ANSI_RED + "K" + ANSI_RESET);
            }
            break;
          case -1:
            sb.append("X");
            break;
          case -2:
            sb.append(" ");
            break;
          case -3:
            if (road.contains(new Point(row, col))) {
              sb.append(ANSI_GREEN + "E" + ANSI_RESET);
            } else {
              sb.append(ANSI_RED + "E" + ANSI_RESET);
            }
            break;
          default:
            if (road.contains(new Point(row, col))) {
              sb.append(ANSI_GREEN + "r" + ANSI_RESET);
            } else {
              sb.append(" ");
            }
            break;
        }
      }
      sb.append("\n");
    }
    for (int i = 0; i < 3; i++) {
      sb.append("\n");
    }
    return sb.toString();
  }

  public static String mapColor(int[][] map) {
    ArrayDeque<Point> road = new ArrayDeque<Point>(0);
    return mapColor(map, road);
  }
}

class WaveMap {
  int[][] map;

  public WaveMap(int[][] map) {
    if (map == null) {
      this.map = null;
    } else {
      int[][] copy = new int[map.length][];
      for (int i = 0; i < map.length; i++) {
        copy[i] = map[i].clone();
      }
      this.map = copy;
    }
  }

  public int[][] getMap() {
    return map;
  }

  public void Wave(Point startPoint) {
    Queue<Point> queue = new LinkedList<Point>();
    queue.add(startPoint);
    map[startPoint.row][startPoint.column] = 0;

    while (queue.size() != 0) {
      Point p = queue.remove();

      if (map[p.row - 1][p.column] == -2) {
        queue.add(new Point(p.row - 1, p.column));
        map[p.row - 1][p.column] = map[p.row][p.column] + 1;
      }
      if (map[p.row][p.column - 1] == -2) {
        queue.add(new Point(p.row, p.column - 1));
        map[p.row][p.column - 1] = map[p.row][p.column] + 1;
      }
      if (map[p.row + 1][p.column] == -2) {
        queue.add(new Point(p.row + 1, p.column));
        map[p.row + 1][p.column] = map[p.row][p.column] + 1;
      }
      if (map[p.row][p.column + 1] == -2) {
        queue.add(new Point(p.row, p.column + 1));
        map[p.row][p.column + 1] = map[p.row][p.column] + 1;
      }
    }
  }

  public ArrayDeque<Point> getRoad(Point exit) {
    int count = map[exit.row][exit.column];
    ArrayDeque<Point> road = new ArrayDeque<>(0);
    if (count >= 0) {
      Point p = exit;
      map[exit.row][exit.column] = -3;
      road.addFirst(p);
      while (count > 0) {
        if (map[p.row - 1][p.column] == count - 1) {
          p = new Point(p.row - 1, p.column);
          road.addFirst(p);
          count--;
          continue;
        }
        if (map[p.row][p.column - 1] == count - 1) {
          p = new Point(p.row, p.column - 1);
          road.addFirst(p);
          count--;
          continue;
        }
        if (map[p.row + 1][p.column] == count - 1) {
          p = new Point(p.row + 1, p.column);
          road.addFirst(p);
          count--;
          continue;
        }
        if (map[p.row][p.column + 1] == count - 1) {
          p = new Point(p.row, p.column + 1);
          road.addFirst(p);
          count--;
          continue;
        }
      }
    } else if (count == -2)  {
      map[exit.row][exit.column] = -3;
    }
    return road;
  }
}