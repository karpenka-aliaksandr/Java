package HomeWork02;

import java.util.HashMap;
import java.util.Map;

public class hw_002 {
    public static void main(String[] args) throws Exception {
        Map<String, Integer> params = readParameters();
        params.forEach((key, value) -> System.out.println(key + ":" + value));

    }

    private static Map<String, Integer> readParameters() throws Exception {
        int a = 0;
        int b = 1;
        Map<String, Integer> dict = new HashMap<>();
        dict.put("b", b);
        dict.put("a", a);
        return dict;
    }

}
