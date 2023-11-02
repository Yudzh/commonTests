package factory;

import storage.TestContext;

public class TestContextFactory {

    private TestContextFactory() {
    }

    public static TestContext getTestContext(){
        return new TestContext();
    }
}
