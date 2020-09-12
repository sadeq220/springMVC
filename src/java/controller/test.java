package controller;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class test {

    public static<T extends String> boolean check(T str){
       return str.startsWith("d");

    }
    public static void practical(Collection<? extends String> strings){
        Function<String,String> function=(s)->s+"dl21";
        List<String> a=strings.stream().filter(test::check).map(function).collect(Collectors.toList());
        a.add("ds");

        a.forEach(System.out::println);
    }
    public static void main(String[] args){
        System.out.println(System.getProperty("java.io.tmpdir"));
        int pri=20;
            ArrayList<String> stringArrayList=new ArrayList();
            stringArrayList.add("dll");

            stringArrayList.sort(String::compareTo);
        PriorityQueue<String> queue=new PriorityQueue<>(String::compareTo);
        HashMap map=new HashMap<String,Integer>();
        map.put("sadeq",2);

        practical(stringArrayList);



            System.out.println(Integer.toBinaryString(pri));
            System.out.println(Integer.toHexString(pri));
            System.out.println(Integer.toOctalString(pri));
            System.out.println(new Demo()==new Demo());
    }
}

class Demo{
    @Override
    public int hashCode() {
        return 1;
    }
}
