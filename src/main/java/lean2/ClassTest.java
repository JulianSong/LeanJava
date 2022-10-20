package lean2;

class  InnerData {
    public String name = "hello";
}

public class ClassTest {
    static private InnerData privateInnerData = new InnerData();
    static protected InnerData protectedInnerData = new InnerData();
    public InnerData publicInnerData = new InnerData();

}
