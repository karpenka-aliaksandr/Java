package HomeWork02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class hw_002 {
    public static void main(String[] args) throws Exception {
        Map<String, Integer> params = readParametersFromFile("HomeWork02/input.txt");
        params.forEach((key, value) -> System.out.println(key + ":" + value));

    }

    private static Map<String, Integer> readParametersFromFile(String pathName) throws Exception {
        Map<String, Integer> map = new HashMap<>();
        FileReader fileReader = new FileReader(pathName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {
            String[] currentLineSplited = currentLine.split(" ");
            map.put(currentLineSplited[0],Integer.parseInt(currentLineSplited[1]));
        }
        bufferedReader.close();
        return map;
    }
}
