import static org.junit.Assert.*;

public class Warmup1_1028Test {

    @org.junit.Test
    public void findsum1() {
        Warmup1_1028 w=new Warmup1_1028();
        assertEquals(0,w.findsum(" "));

    }
    @org.junit.Test
    public void findsum2() {
        Warmup1_1028 w=new Warmup1_1028();
        assertEquals(4,w.findsum("1 2a 3"));

    }
    @org.junit.Test
    public void findsum3() {
        Warmup1_1028 w=new Warmup1_1028();
        assertEquals(0,w.findsum("asd xcv"));

    }

    @org.junit.Test
    public void findsum4() {
        Warmup1_1028 w=new Warmup1_1028();
        assertEquals(0,w.findsum(null));

    }
    @org.junit.Test
    public void findsum5() {
        Warmup1_1028 w=new Warmup1_1028();
        assertEquals(1,w.findsum("-1 2"));

    }
}