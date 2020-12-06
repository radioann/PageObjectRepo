import org.junit.*;

public class MainClassTest {

    /*
    @BeforeClass
    public void beforeClass(){

    }

    @Before
    public void setUp(){

    }
     */

    @Test
    public void testMethod1(){
        int a=1;
        int b=1;
        int c=2;
        Assert.assertTrue(a+b == c);
        Assert.assertFalse( 3+9 == 7);
    }

    @Test
    //@Ignore
    public void testMethod2(){
        Assert.assertNull(null);
        Assert.assertNotNull(989);
    }

    @Test
    public void testMethod3(){
        Assert.assertEquals(10, 5+5);
        Assert.assertNotEquals(12, 5+5);
    }

    @Test
    public void testMethod4(){
        Assert.assertEquals("Expectation is not met!",10, 5+8);
        Assert.assertNotEquals(12, 5+7);
    }

    /*
    @After

    public void tearDown(){

    }

    @AfterClass
    public void afterClass(){

    }
    */
}
