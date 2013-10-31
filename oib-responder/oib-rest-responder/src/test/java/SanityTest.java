
import java.util.HashMap;
import java.util.Map;
import junit.framework.TestCase;

/**
 *
 * @author rick
 */
public class SanityTest extends TestCase {

    public SanityTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testEmptyMap() {
        
        Map<String,String> map = new HashMap<String,String>();
        
        assertTrue( map.get("whatever") == null );
        
    }

}
