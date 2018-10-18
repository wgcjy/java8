package test;

import com.sun.org.apache.bcel.internal.generic.POP2;

import java.org.way.exmple.java8.RepeatTester;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author wgc
 * @create 2018-10-17 10:16
 */
public class Test05 {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        List<Person> javaProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
                add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
                add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
                add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
                add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
                add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
                add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
                add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
                add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
                add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
            }
        };

        List<Person> phpProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
                add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
                add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
                add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
                add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
                add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
                add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
                add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
                add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
                add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
            }
        };


    public static void main(String[] args) {
        Test05 t=new Test05();
        t.test5();
    }
    public void test5(){


        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);

        System.out.println("Long.MIN_VALUE = " + Long.MIN_VALUE);
        System.out.println("Long.MAX_VALUE = " + Long.MAX_VALUE);

        System.out.println("Float.MIN_VALUE = " + Float.MIN_VALUE);
        System.out.println("Float.MIN_NORMAL = " + Float.MIN_NORMAL);
        System.out.println("Float.MAX_VALUE = " + Float.MAX_VALUE);

        System.out.println("Double.MAX_VALUE = " + Double.MAX_VALUE);
        System.out.println("Double.MIN_VALUE = " + Double.MIN_VALUE);

       /* phpProgrammers.stream().filter(person -> person.getSalary()>1400)
                .forEach(person->System.out.printf("%s %s; ", person.getFirstName(), person.getLastName()));
*/
/*
        Person person = javaProgrammers.stream().min((p1, p2) -> p1.getSalary() - p2.getSalary()).get();
        System.out.println("person = " + person);*/
        /*IntStream intStream = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
        System.out.println("intStream = " + intStream.count());*/
        /*Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);*/

        Map<Trader, List<Transaction>> transactionsByCurrencies =
                transactions.stream().collect(Collectors.groupingBy(Transaction::getTrader));
        System.out.println("transactionsByCurrencies = " + transactionsByCurrencies);
    }
    public void test4(){

       /* phpProgrammers.stream().filter(person -> person.getSalary()>1400)
                .forEach(person->System.out.printf("%s %s; ", person.getFirstName(), person.getLastName()));
*/
        Predicate<Person> fileter1=person -> person.getAge()>25;
        Predicate<Person> salaryFilter = (p) -> (p.getSalary() > 1400);
        Predicate<Person> genderFilter = (p) -> ("female".equals(p.getGender()));
        javaProgrammers.stream().filter(fileter1).filter(salaryFilter)
                .filter(genderFilter)
                .forEach(person -> System.out.printf("%s %s; ", person.getFirstName(), person.getLastName()));
    }
    public void test3(){

    transactions.stream().filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                 .map(transaction -> transaction.getValue())
                 .forEach(System.out::println);


    }
    public void test2(){

        List<Trader> collect = transactions.stream().map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct().sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        collect.stream().forEach(Trader ->{
            System.out.println("Trader.getName() = " + Trader.getName());
        });
    }
    public void test1(){

        List<Transaction> collect = transactions.stream().filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        collect.stream().forEach(Transaction ->{
            System.out.println("Transaction.getYear() = " + Transaction.getYear());
        });
    }



    public void test6(){

        System.out.println("wgc test");
    }
    public void test7(){

        System.out.println("wgc test");
    }
}
