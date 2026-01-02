package com.padding;

public class StringPadding {
    public static void main(String[] args) {
        String str = "JAVA";

        /// right padding with spaces
        String paddedRight = String.format("%-15s",str);
        System.out.println("Right Padded: '" + paddedRight + "'");

        String paddedLeft = String.format("%15s",str);
        System.out.println("Padded Left: '" + paddedLeft + "'");
    }
}
