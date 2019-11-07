package task3;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import task3.models.Company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Task3Main {
    public static Company[] companies;

    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();
        companies = gson.fromJson(new JsonReader(new FileReader("test.json")), Company[].class);
        //Вывести все имеющиеся компании в формате «Краткое название» – «Дата основания 17/01/98»;
        System.out.println("Все компании:");
        for (Company company : companies) {
            System.out.println(company.name_short + " " + company.egrul_date);
        }
        System.out.println();
        System.out.println("Аннулированные бумаги:");
        //Вывести все ценные бумаги (их код, дату истечения и полное название организации-владельца),
        //которые просрочены на текущий день, а также посчитать суммарное число всех таких бумаг;
        AtomicInteger count = new AtomicInteger();
        for (Company company : companies) {
            company.securities.stream()
                    .filter(x -> x.state.name.equals("Аннулирован"))
                    .forEach(x -> {
                        count.getAndIncrement();
                        System.out.println(x.code + " " + x.date_to + " " + company.name_full);
                    });
        }
        System.out.println("Аннулированных бумаг - " + count);
        System.out.println();
        readCommand();
    }

    private static void readCommand() {
        System.out.println("Введите команду");
        Scanner input = new Scanner(System.in);
        String command = input.next();
        if (!command.equals("end")) {
            if (command.length() == 3) {
                //На запрос пользователя в виде кода валюты, например EU, USD, RUB и пр. выводить id и коды
                //ценных бумаг, использующих заданную валюту.
                if (command.equals("RUB") || command.equals("USD") || command.equals("EUR") || command.equals("UAH")) {
                    getSecuritiesByCurrency(command);
                } else {
                    System.out.println("Bad command");
                }
            } else if (command.length() == 8 || command.length() == 10) {
                //На запрос пользователя в виде даты «ДД.ММ.ГГГГ», «ДД.ММ,ГГ», «ДД/ММ/ГГГГ» и «ДД/ММ/ГГ»
                //вывести название и дату создания всех организаций, основанных после введенной даты;
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd.MM.yyyy");
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd.MM,yy");
                SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat sdf4 = new SimpleDateFormat("dd/MM/yy");
                Date date = null;
                try {
                    date = sdf1.parse(command);
                } catch (ParseException e1) {
                    try {
                        date = sdf2.parse(command);
                    } catch (ParseException e2) {
                        try {
                            date = sdf3.parse(command);
                        } catch (ParseException e3) {
                            try {
                                date = sdf4.parse(command);
                            } catch (ParseException e4) {
                                System.out.println("Bad command");
                            }
                        }
                    }
                }
                if (date != null) {
                    try {
                        getCompaniesByDate(date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("Bad command");
            }
            readCommand();
        }
    }

    private static void getCompaniesByDate(Date date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Компании, созданные после " + sdf.format(date) + ":");
        for (Company company : companies) {
            Date egrulDate = sdf.parse(company.egrul_date);
            if (egrulDate.after(date)) {
                System.out.println(company.name_full + " " + company.egrul_date);
            }
        }
        System.out.println();
    }

    private static void getSecuritiesByCurrency(String cur) {
        System.out.println("Ценные бумаги, использующие " + cur + ":");
        for (Company company : companies) {
            company.securities.stream()
                    .filter(x -> x.currency.code.equals(cur))
                    .forEach(x -> System.out.println(x.id + " " + x.code));
        }
        System.out.println();
    }
}
