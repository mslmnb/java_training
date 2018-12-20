package com.epam.bitstring;

public class StartBitStringProgram {
    public static void main(String[] args) {
        BitString bitString1 = new BitString("0010001110111101001101");
        BitString bitString2 = new BitString("0011000110111011001101");

        System.out.println("Исходники:   " + bitString1
                + "\t"
                + bitString2);
        System.out.println("Перевертыши: " + bitString1.moveOneToLeft()
                + "\t"
                + bitString2.moveOneToLeft());
        System.out.println("hashCode():  " + bitString1.hashCode()
                + "\t\t\t\t"
                + bitString2.hashCode());
        System.out.println("Сравнение c помощью equals(): " + bitString1.equals(bitString2));
        System.out.println();
        System.out.println("Проверка для сдвига нулей:");
        bitString1 = new BitString("10001010010000101");
        System.out.println("Исходник:   " + bitString1);
        System.out.println("Перевертыш: " + bitString1.moveOneToLeft());
    }
}

/*
Исходники:   0010001110111101001101	0011000110111011001101
Перевертыши: 0011111110101010010001	0011111110101010010001
hashCode():  -1032640802				-1032640802
Сравнение c помощью equals(): true

Проверка для сдвига нулей:
Исходник:   10001010010000101
Перевертыш: 10101001000100001
 */


