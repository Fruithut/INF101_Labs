package inf101.v17.util;

import inf101.v17.util.generators.IntGenerator;
import inf101.v17.util.generators.StringGenerator;

public class MyRandom {
    public static void main(String[] args) {
        IGenerator<String> rStrings = new StringGenerator();
        IGenerator<Integer> rIntegers = new IntGenerator(0,1000);
        int sum = 0;

        for (int i = 0; i < 10; i++) {System.out.println(rStrings.generate());}
        System.out.println("----SPLIT----");
        System.out.println(rStrings.generateEquals(5));
        System.out.println("----SPLIT----");
        for (int i = 0; i < 1000000; i++) {
            sum += rIntegers.generate();
        }
        System.out.println(sum/1000000);
        
    }
}
