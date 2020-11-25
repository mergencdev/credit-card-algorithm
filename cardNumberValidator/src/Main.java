import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String urunCode;
        Scanner input = new Scanner(System.in);
        urunCode = input.nextLine();

        String[] numbers = new String[4];

        int temp = 0;
        int temp1 = 4;
        int constantTemp = 4;
        int finalSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = urunCode.substring(temp, temp1);
            temp = temp1 + 1;
            temp1 = temp + constantTemp;
            int newIntNumber = stringToInt(numbers[i]);
            //System.out.println(firstIndexDoubling(newIntNumber) + " " + thirdIndexDoubling(newIntNumber)); // test;
            changeNumber(newIntNumber);
            finalSum += digitSum(newIntNumber);
            //System.out.println(finalSum); // test;
        }

        if (finalSum % 10 == 0) {
            System.out.println("Card number is valid.");
        } else {
            System.err.println("Card number is not valid.");
        }
    }

    static int digitSum(int newIntNumber) { // rakamlari toplama metodu;
        int temp = newIntNumber;
        int digit1, digit2, digit3, digit4;
        int newDigit1 = firstIndexDoubling(newIntNumber);
        int newDigit3 = thirdIndexDoubling(newIntNumber);
        int newNumber;

        digit4 = temp - ((temp / 10) * 10);
        temp /= 10;
        digit3 = newDigit3;
        temp /= 10;
        digit2 = temp - ((temp / 10) * 10);
        temp /= 10;
        digit1 = newDigit1;

        int sumOfDigits = digit1 + digit2 + digit3 + digit4;
        return sumOfDigits;
    }

    static int changeNumber(int newIntNumber) { // ikiye katlanan sayilari ekleyerek yeni kodu olusturma metodu;
        // 4539 1488 0343 6467
        int temp = newIntNumber;
        int digit1, digit2, digit3, digit4;
        int newDigit1 = firstIndexDoubling(newIntNumber);
        int newDigit3 = thirdIndexDoubling(newIntNumber);
        int newNumber;

        digit4 = temp - ((temp / 10) * 10);
        temp /= 10;
        digit3 = newDigit3;
        temp /= 10;
        digit2 = temp - ((temp / 10) * 10);
        temp /= 10;
        digit1 = newDigit1;

        newNumber = digit1 * 1000 + digit2 * 100 + digit3 * 10 + digit4;
        //digitSum = digit1 + digit2 + digit3 + digit4;

        return newNumber;
    }

    static int stringToInt(String currentNumber) { // string girilen urun kodunu integer cevirme metodu;
        int answer = 0, factor = 1;
        for (int i = currentNumber.length() - 1; i >= 0; i--) {
            answer += (currentNumber.charAt(i) - '0') * factor;
            factor *= 10;
        }
        return answer;
    }

    static int firstIndexDoubling(int newIntNumber) { // birinci indexin iki katini alma metodu;
        int firstIndex = newIntNumber / 1000;
        if (firstIndex * 2 > 9) {
            return firstIndex * 2 - 9;
        } else {
            return firstIndex * 2;
        }
    }

    static int thirdIndexDoubling(int newIntNumber) { // ucuncu indexin iki katini alma metodu;
        int thirdIndex = (newIntNumber / 10) - ((newIntNumber / 100) * 10);
        if (thirdIndex * 2 > 9) {
            return thirdIndex * 2 - 9;
        } else {
            return thirdIndex * 2;
        }
    }
}