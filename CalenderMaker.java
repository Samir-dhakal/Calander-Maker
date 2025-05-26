import java.util.Scanner;

public class CalenderMaker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter year ");
        int year = input.nextInt();
        System.out.println("enter month");
        int month = input.nextInt();

        System.out.println("the first day of the " + getMonthName(month) + " of year " + year + " is "
                + GetFirstDayOfMonth(month, year));

        System.out.println("__________________________");
        System.out.println(getMonthName(month) + " " + year);
        System.out.println("Sun   Mon   Tue   Wed   Thu   Fri   Sat");

        String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

        String firstDay = GetFirstDayOfMonth(month, year);
        int firstDayInNum = 0;

        for (int i = 0; i < 7; i++) {
            if (days[i].equals(firstDay)) {
                firstDayInNum = i;
                break;
            }
        }

        // Print spaces for first day indentation
        for (int j = 0; j < firstDayInNum; j++) {
            System.out.print("      ");
        }

        int daysInMonth = GetDaysInMonth(month, year);
        int dayCounter = firstDayInNum; // tracks day of week (0=Sun,...6=Sat)

        for (int k = 1; k <= daysInMonth; k++) {
            System.out.printf("%-6d", k);

            dayCounter++;
            if (dayCounter % 7 == 0) {
                System.out.println();
            }
        }

        input.close();
    }

    // method to get the name of the month
    public static String getMonthName(int month) {
        String[] monthNames = { "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December" };

        return monthNames[month - 1];
    }

    // method to get the number of days in the month
    public static int GetDaysInMonth(int month, int year) {
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (month == 2 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
            daysInMonth[1] = 29;
        }
        return daysInMonth[month - 1];
    }

    // method to find the first day of the month (day = 1)
    public static String GetFirstDayOfMonth(int m, int y) {
        int y0, x, m0, d0;
        y0 = y - (14 - m) / 12;
        x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        m0 = m + 12 * ((14 - m) / 12) - 2;
        d0 = (1 + x + 31 * m0 / 12) % 7;

        String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        return days[d0];
    }
}
