package test.g2a.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.Vector;

import static java.util.concurrent.ThreadLocalRandom.current;

public class RandomUtils {

    public WebDriver driver;

    public RandomUtils(WebDriver driver) {
        this.driver = driver;
    }

    public static int getRandomInt(int min, int max) {
        //return random int in rage [min,max)
        return current().nextInt(min, max + 1);
    }

    public static String getRandomString(int min, int max) {
        String generatedString = RandomStringUtils.randomAlphabetic(getRandomInt(min, max));
        return (generatedString);
    }

//    public static <T> T randomItem(List<T> list) {
//        Random random = new Random();
//        return list.get(random.nextInt(list.size()));
//    }
//
//    public static String randomDateGenerator(int min, int max) {
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMyy");
//        LocalDateTime localDateTime = LocalDateTime.now();
//        int randomAmountOfYears = getRandomInt(min, max);
//        LocalDateTime randomLocalDateTime = localDateTime.plusYears(randomAmountOfYears);
//        String formattedRandomLocalDateTime = randomLocalDateTime.format(dateTimeFormatter);
//        return formattedRandomLocalDateTime;
//    }
//
//    ///////////////////////////////////////////////////Random PESEL generator/////////////////////////////////
//
//    public static String first() {
//        Random rand = new Random();
//        int wynik, x = 1800, y = 2099;
//        wynik = rand.nextInt(y - x + 1) + x;
//        String rok = Integer.toString(wynik);
//        return (rok);
//
//    }
//
//    public static String second() {
//        Random rand = new Random();
//        int a, b;
//        a = rand.nextInt(2);
//        do {
//            if (a == 0) {
//                b = rand.nextInt(10);
//            } else {
//                b = rand.nextInt(3);
//            }
//        }
//        while (a + b == 0);
//
//        String dzien1 = Integer.toString(a);
//        String dzien2 = Integer.toString(b);
//        String miesiac = dzien1 + dzien2;
//        return (miesiac);
//    }
//
//    public static String third() {
//        Random rand = new Random();
//        int a, b;
//        a = rand.nextInt(4);
//        do {
//            if (a == 0 || a == 1 || a == 2) {
//                b = rand.nextInt(10);
//            } else {
//                b = rand.nextInt(2);
//            }
//
//        }
//        while (a + b == 0);
//
//        String liczba1 = Integer.toString(a);
//        String liczba2 = Integer.toString(b);
//        String dzien = liczba1 + liczba2;
//        return (dzien);
//
//    }
//
//    public static String forth() {
//        Random rand = new Random();
//        int a = rand.nextInt(10000);
//        String liczba = Integer.toString(a);
//        int b = liczba.length();
//        if (b == 1) {
//            liczba = "000" + liczba;
//        } else if (b == 2) {
//            liczba = "00" + liczba;
//        } else if (b == 3) {
//            liczba = "0" + liczba;
//        }
//        return (liczba);
//
//    }
//
//    public static String checksum(String str) {
//        int edycja;
//        int wynik = 0;
//        int[] tab = new int[10];
//        int[] tab1 = new int[10];
//        for (int i = 0; i <= 9; i++) {
//            edycja = Character.getNumericValue(str.charAt(i));
//            tab[i] = edycja;
//        }
//        tab1[0] = 1;
//        tab1[1] = 3;
//        tab1[2] = 7;
//        tab1[3] = 9;
//        tab1[4] = 1;
//        tab1[5] = 3;
//        tab1[6] = 7;
//        tab1[7] = 9;
//        tab1[8] = 1;
//        tab1[9] = 3;
//
//        for (int x = 0; x < 10; x++) {
//            wynik += tab[x] * tab1[x];
//        }
//
//        wynik = wynik % 10;
//
//        wynik = 10 - wynik;
//
//        wynik = wynik % 10;
//        str = Integer.toString(wynik);
//        return (str);
//    }
//
//    public static String getPesel() {
//        String rok = first(), miesiac = second(), dzien = third(), liczba = forth();
//        int kontrola = Integer.parseInt(miesiac), rok_sp = Integer.parseInt(rok);
//        if (1800 < rok_sp && rok_sp < 1899) {
//            kontrola += 80;
//            miesiac = Integer.toString(kontrola);
//        } else if (2000 < rok_sp && rok_sp < 2099) {
//            kontrola += 20;
//            miesiac = Integer.toString(kontrola);
//        } else {
//            if (kontrola < 10) {
//                miesiac = "0" + Integer.toString(kontrola);
//            }
//        }
//
//        rok = rok.substring(2);
//        String wejscie = rok + miesiac + dzien + liczba;
//        String str = checksum(wejscie);
//
//        return rok + miesiac + dzien + liczba + str;
//    }
//
//    ///////////////////////////////////////Random Credit Card Number Generator/////////////////////////////////////////////
//
//    public static final String[] MASTERCARD_PREFIX_LIST = new String[]{
//            "51", "52", "53", "54", "55", "2221", "2222", "2223", "2224", "2225", "2226", "2227", "2228", "2229", "223", "224", "225", "226", "227", "228", "229", "23", "24", "25", "26", "270", "271", "2720"
//    };
//
//    static String strRev(String str) {
//        if (str == null)
//            return "";
//        String revstr = "";
//        for (int i = str.length() - 1; i >= 0; i--) {
//            revstr += str.charAt(i);
//        }
//        return revstr;
//    }
//
//    static String completedNumber(String prefix, int length) {
//
//        String ccNumber = prefix;
//        while (ccNumber.length() < (length - 1)) {
//            ccNumber += new Double(Math.floor(Math.random() * 10)).intValue();
//        }
//        String reversedCCnumberString = strRev(ccNumber);
//
//        List<Integer> reversedCCnumberList = new Vector<Integer>();
//        for (int i = 0; i < reversedCCnumberString.length(); i++) {
//            reversedCCnumberList.add(new Integer(String
//                    .valueOf(reversedCCnumberString.charAt(i))));
//        }
//
//        int sum = 0;
//        int pos = 0;
//
//        Integer[] reversedCCnumber = reversedCCnumberList
//                .toArray(new Integer[reversedCCnumberList.size()]);
//        while (pos < length - 1) {
//
//            int odd = reversedCCnumber[pos] * 2;
//            if (odd > 9) {
//                odd -= 9;
//            }
//
//            sum += odd;
//
//            if (pos != (length - 2)) {
//                sum += reversedCCnumber[pos + 1];
//            }
//            pos += 2;
//        }
//
//
//        int checkdigit = new Double(
//                ((Math.floor(sum / 10) + 1) * 10 - sum) % 10).intValue();
//        ccNumber += checkdigit;
//
//        return ccNumber;
//
//    }
//
//    public static String[] credit_card_number(String[] prefixList, int length,
//                                              int howMany) {
//
//        Stack<String> result = new Stack<String>();
//        for (int i = 0; i < howMany; i++) {
//            int randomArrayIndex = (int) Math.floor(Math.random()
//                    * prefixList.length);
//            String ccnumber = prefixList[randomArrayIndex];
//            result.push(completedNumber(ccnumber, length));
//        }
//
//        return result.toArray(new String[result.size()]);
//    }
//
//    public static String generateMasterCardNumber() {
//        return credit_card_number(MASTERCARD_PREFIX_LIST, 16, 1)[0];
//    }

}
