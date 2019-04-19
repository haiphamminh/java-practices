package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapExample {

    public static void main(String[] args) {
        Key key1 = new Key("key1", "value1");
        Key key2 = new Key("key2", "value2");
        Map<Key, String> map = new HashMap<>();
        map.put(key1, "value1");
        map.put(key1, "value2");

        System.out.println("Before changing size: " + map.size());
        map.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));

        key1.setKey("key2");
        map.put(key1, "value11");
        System.out.println("After changing size: " + map.size());
        map.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));

        System.out.println(map.get(key1));
    }

    private static class Key {
        private String key;
        private String value;

        public Key(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public void setKey(String key) {
            this.key = key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) { return true; }
            if (o == null || getClass() != o.getClass()) { return false; }
            final Key key1 = (Key) o;
            return Objects.equals(key, key1.key);
        }

        @Override
        public int hashCode() {
            System.out.println("key: " + key + "; hash: " + Objects.hash(key));
            return Objects.hash(key);
        }

        @Override
        public String toString() {
            return String.format("Key(key=%s,value=%s)", key, value);
        }
    }
}
