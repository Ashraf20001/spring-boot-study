package com.problems.function;

public class SwitchStatements {
    public static void main(String[] args) {
        String string = yieldSwitch("Tuesday");
        String string1 = multipleSwitches("Tuesday");
        String string2 = typePatternSwitch(1);
        System.out.println(string + " "+string1+" "+string2);
    }

    private static String yieldSwitch(String tuesday) {
        return switch (tuesday){
            case "Monday":
                yield "Weekday";
            case "Tuesday":
                yield "Weekday";
            case "Wednesday":
                yield "Weekday";
            case "Thursday":
                yield "Weekday";

            case "Friday":
                yield "Weekday";

            case "Saturday":
                yield "Weekend";
            default:
                yield "Holiday";
        };

    }

    private static String multipleSwitches(String tuesday) {
        return switch (tuesday) {
            case "Monday","Tuesday", "Wednesday","Thursday","Friday" -> "Weekday";
            case "Saturday","Sunday" -> "Weekend";
            default -> "Null";
        };
    }

    private static String typePatternSwitch(Object tuesday){
        return switch (tuesday){
            case String s -> "It is String";
            case Integer i when i.equals(1) -> "123";
            default -> null;
        };
    }
}
