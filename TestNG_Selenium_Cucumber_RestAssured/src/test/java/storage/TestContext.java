package storage;

import lombok.Getter;

@Getter
public class TestContext {
    private DataStorage dataStorage;

    public TestContext() {
        this.dataStorage = new DataStorage();
    }
}
