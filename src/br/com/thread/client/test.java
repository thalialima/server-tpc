package br.com.thread.client;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        //System.out.println(getAsterisk(10));

        String[] strings = toJadenCase(19);

        Arrays.stream(strings).forEach(System.out::println);

        System.out.println();

    }

    public static String[] toJadenCase(int nFloors) {

        String[] array = new String[nFloors];
        int count = 1;
        for (int i = 0; i < nFloors; i++) {
            array[i] = getAsterisk(count, nFloors);
            count += 2;
        }
        return array;
    }

    public static String getAsterisk(int i, int nFloors) {
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < i; j++) {
            builder.append("*");
        }
        int length = builder.toString().length();
        int space = (nFloors*2) - length;
        StringBuilder result = new StringBuilder();
        for (int k = 0; k < space/2; k++) {
            result.append(" ");
        }
        return result.append(builder.append(result)).toString();
    }

}
