package stream;

import obj.TPurchaserInvoiceObj;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StreamDemo01 {

    public static void main(String[] args) {

        /*int sum1 = Arrays.asList(1, 2, 3).stream().filter(i -> i > 1).mapToInt(b -> b).sum();
        System.out.println(sum1);*/

        /*int sum2 = Arrays.asList("1", "2", "3", "4").stream().mapToInt(Integer::valueOf).sum();
        System.out.println(sum2);*/

        /*int sum3 = Arrays.asList(1, 2, 3, 4).stream().mapToInt(Integer::valueOf).sum();
        System.out.println(sum3);*/

        /*int sum4 = Arrays.asList(1, 2, 3, 4).stream().reduce(0,Integer::sum);
        System.out.println(sum4);*/


        /*String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println(concat);*/

        /*String concat1 = Stream.of("a", "B", "c", "D", "e", "z", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);
        System.out.println(concat1);*/

        /*List<Integer> collect = Arrays.asList(1, 2, 3).stream().filter(i -> i > 1).collect(Collectors.toList());
        System.out.println(collect);*/

        /*Arrays.asList(1, 2, 3).stream().forEach(System.out::println);*/

        /*List<String> list1 = Arrays.asList("1", "2", "3");
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<? extends List<? extends Serializable>> lists = Arrays.asList(list1, list2);
        System.out.println(lists);*/

        /*String str = Arrays.asList("a", "b", "c").stream().collect(Collectors.joining(",")).toString();
        System.out.println(str);*/

        //流转换为其它数据结构
        // 1. stream转Array
        //String[] strArray1 = stream.toArray(String[]::new);
        // 2. stream转Collection
        //List<String> list1 = stream.collect(Collectors.toList());
        //List<String> list2 = stream.collect(Collectors.toCollection(ArrayList::new));
        //Set set1 = stream.collect(Collectors.toSet());
        //Stack stack1 = stream.collect(Collectors.toCollection(Stack::new));
        // 3. stream转String;
        //String str = stream.collect(Collectors.joining()).toString()


        //demo1
        /*List<BigDecimal> bigDecimals = Arrays.asList(new BigDecimal("1.1"), new BigDecimal("2.2"),
                new BigDecimal("3.2"), new BigDecimal("4.2"), new BigDecimal("5.2"));
        BigDecimal reduce = bigDecimals.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(reduce.toString());*/

        //demo2
        List<TPurchaserInvoiceObj> list = new ArrayList<TPurchaserInvoiceObj>();
        TPurchaserInvoiceObj obj1 = new TPurchaserInvoiceObj();
        obj1.setInvoiceId("000df2e1-65f3-4f1f-97e8-0e4edb59318e");
        obj1.setInvoiceNo("51848427");
        obj1.setInvoiceCode("4403162320");
        obj1.setInvoiceType("c");
        obj1.setCreateUserId("13120611062");
        obj1.setAmountWithoutTax(new BigDecimal("100.2"));
        obj1.setAmountWithTax(new BigDecimal("15544.2"));
        obj1.setTaxAmount(new BigDecimal("144.786"));
        obj1.setAuditStatus("1");
        obj1.setAuthStatus("1");
        obj1.setElTime("20170809");
        obj1.setCreateTime("20170809121223");

        TPurchaserInvoiceObj obj2 = new TPurchaserInvoiceObj();
        obj2.setInvoiceId("000df2e1-65f3-4f1f-97e8-0e4edb59319e");
        obj2.setInvoiceNo("51848474");
        obj2.setInvoiceCode("4403162321");
        obj2.setInvoiceType("s");
        obj2.setCreateUserId("13120611062");
        obj2.setAmountWithoutTax(new BigDecimal("10.2"));
        obj2.setAmountWithTax(new BigDecimal("144.2"));
        obj2.setTaxAmount(new BigDecimal("144.78"));
        obj2.setAuditStatus("2");
        obj2.setAuthStatus("1");
        obj2.setElTime("20170810");
        obj2.setCreateTime("20170809121223");
        list.add(obj1);
        list.add(obj2);

        BigDecimal amountWithoutTaxSum = list.stream()
                .filter(p -> "c".equals(p.getInvoiceType()))
                .map(TPurchaserInvoiceObj::getAmountWithoutTax)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(amountWithoutTaxSum.toString());

        /*List<BigDecimal> jineList = new ArrayList<BigDecimal>();
        list.stream().filter(p -> "s".equals(p.getInvoiceType()))
                .forEach(p -> {
                    BigDecimal amountWithTax = p.getAmountWithTax();
                    BigDecimal amountWithoutTax = p.getAmountWithoutTax();
                    BigDecimal taxAmount = p.getTaxAmount();
                    BigDecimal add = amountWithTax.add(amountWithoutTax).add(taxAmount);
                    jineList.add(add);
                });
        BigDecimal reduce = jineList.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(reduce);*/
    }


}