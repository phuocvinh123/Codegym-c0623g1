package com.example.demo1.format;


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;


public class FormatDecimal {
        public static String formatCurrency(BigDecimal amount) {
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
            return currencyFormat.format(amount);
        }


    public static void main(String[] args) {
        BigDecimal price = new BigDecimal("11300000000");
        String formattedPrice = FormatDecimal.formatCurrency(price);
        System.out.println(formattedPrice);
    }
    }


