import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by Jitin on 25/03/2017.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestExecutionOrderTest {


    @Test
    public void edit(){
        System.out.println("edit invoked");
    }

    @Test
    public void create(){
        System.out.println("create invoked");
    }

    @Test
    public void remove(){
        System.out.println("delete invoked");
    }



}
