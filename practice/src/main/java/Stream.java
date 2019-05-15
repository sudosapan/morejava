import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {

    public static void main(String[] args) {
        String s = "erewcx:";

        new Stream().do1();

    }

    public String reverse(String s, boolean yes) {
        if (yes) return new StringBuffer(s).reverse().toString();
        return s;
    }

    public void do1() {

        List<String> lst = new ArrayList<>();
        lst.add("sapan1");
        lst.add("sapan2");
        lst.add("sapan3");
        lst.add("sapan4");
        System.out.println(lst.stream().map((elem) -> reverse(elem.toLowerCase(), elem.contains("1")))
                              .collect(Collectors.joining()));

    }
}
