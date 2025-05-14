package ru.project.study;

public class handmadeHashMap<K, V> {
    private int defaultSize = 16;
    private float loadFactor = 0.75f;
    private Entry<K, V>[] array = new Entry[defaultSize];

    public void put(Key<K> key, V value) {
        if (checkResize()) resize();
        var hashCode = key.hashCode();
        int size = array.length;
        int index = hashCode & (size - 1);
        if (index >= array.length) throw new ArrayIndexOutOfBoundsException();
        array[index] = new Entry<>(key, value);
    }

    public Object get(Key<K> key) {
        var hashCode = key.hashCode();
        int size = array.length;
        int index = hashCode & (size - 1);
        Entry<K, V> entry = array[index];
        if (entry != null && entry.key.equals(key)) {
            return entry.value;
        }
        return null;
    }

    public V remove(Key<K> key) {
        int index = key.hashCode() & (array.length - 1);
        Entry<K, V> entry = array[index];
        if (entry != null && entry.key.equals(key)) {
            V oldValue = entry.value;
            array[index] = null;
            return oldValue;
        }
        return null;
    }

    public boolean checkResize() {
        int nonNullSize = 0;
        for (Object o : array) {
            if (o != null) nonNullSize++;
        }
        float fillRatio = (float) nonNullSize / (float) array.length;
        return fillRatio > loadFactor;
    }

    private void resize() {
        Entry<K, V>[] oldArray = array;
        array = (Entry<K, V>[]) new Entry[oldArray.length * 2];

        for (Entry<K, V> entry : oldArray) {
            if (entry != null) {
                int newIndex = entry.key.hashCode() & (array.length - 1);
                array[newIndex] = entry;
            }
        }
    }

    public class Entry<K, V> {
        final Key<K> key;
        final V value;

        public Entry(Key<K> key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public class Key<T> {
        private final T keyValue;
        public Key(T keyValue) {
            this.keyValue = keyValue;
        }
        @Override
        public int hashCode() {
            return keyValue.hashCode();
        }
    }
}