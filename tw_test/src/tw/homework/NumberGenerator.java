package tw.homework;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NumberGenerator {


    public void play(){
        int round = 0;
        Scanner scanner = new Scanner(System.in);
        String generatorNumber =generate();
        while (round<6){
            String inputNumber = scanner.next().toString();
            String result = compare(inputNumber,generatorNumber);
            if (result.equals("4A0B")){
                System.out.println("you win");
                return;
            }else {
                System.out.println(result);
            }
            round ++;
        }
        System.out.println("game over! the answer is"+ generatorNumber);

    }

    public String generate() {
        List numberPool = Arrays.asList(1,2,3,4,5,6,7,8,9,0);
        Collections.shuffle(numberPool);
        String exceptNumber = "";
        for (int i = 0; i < 4; i++) {
            exceptNumber += numberPool.get(i);
        }
        return exceptNumber;
    }

    public String compare(String inputNumber, String exceptNumber) {
        int A = 0;
        int B = 0;
        for (int i = 0; i < 4 ; i++) {
            String input = inputNumber.substring(i,i+1);
            String except = exceptNumber.substring(i,i+1);
            if (input.equals(except)){
                A++;
            }else {
                if (exceptNumber.contains(input)){
                    B++;
                }
            }

        }
        return A+"A"+B+"B";
    }
}
