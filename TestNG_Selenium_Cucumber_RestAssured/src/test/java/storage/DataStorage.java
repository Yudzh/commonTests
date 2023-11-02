package storage;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class DataStorage {

    private final ConcurrentHashMap<String, Object> store = new ConcurrentHashMap<>();
    private final CopyOnWriteArrayList<Object> deletedStore = new CopyOnWriteArrayList<>();

    /**
     * Add data to storage
     * @param name - key
     * @param o - data for the storage
     */
    public void add(String name, Object o) {
        if (store.get(name) != null) {
            deletedStore.add(store.remove(name));
        }
        store.put(name, o);
    }

    /**
     * Get data from the storage
     * @param name - key
     * @return Object - data
     */
    public Object get(String name) {
        return store.get(name);
    }


    /**
     * Remove data from the storage
     * @param name - key
     * @return Object - deleted data
     */
    public Object remove(String name) {
        Object o = store.remove(name);
        if (store.get(name) != null) {
            deletedStore.add(o);
        }
        return o;
    }

    /**
     * Clear all storage
     */
    public void clear() {
        store.clear();
        deletedStore.clear();
    }

}
