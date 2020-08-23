import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class URSiPTaskTest extends Assert {

    private final Map<String, List<Integer>> testResources = new LinkedHashMap<>();

    @Before
    public void setUp() throws Exception {
        testResources.put("002", Arrays.asList(1, 3, 6, 3));
        testResources.put("004", Arrays.asList(1, 2, 3));
        testResources.put("001", Collections.singletonList(3));
    }

    @After
    public void tearDown() throws Exception {
        testResources.clear();
    }

    @Test
    public void testGeneNum() {
        for (Map.Entry<String, List<Integer>> entry : testResources.entrySet()) {
            assertEquals(entry.getKey(), URSiPTask.geneNum(entry.getValue()));
        }
    }
}