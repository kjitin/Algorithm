import org.junit.*;

/**
 * Created by Jitin on 24/03/2017.
 */
public class SanityTest {


    @BeforeClass
    public static void beforeClass(){
        System.out.println("**Before Class is invoked");
    }

    @Before
    public void before(){

        System.out.println("**Before is invoked");
    }


    @After
    public void after(){
        System.out.println("**After is invoked");
    }

    @Test
    public void someTest(){
        System.out.println("**Test");

    }

    @AfterClass
    public static  void afterClass(){
        System.out.println("**After Class is invoked");
    }


}
