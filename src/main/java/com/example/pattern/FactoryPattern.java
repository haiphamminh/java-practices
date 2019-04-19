package com.example.pattern;

import java.util.HashMap;
import java.util.Map;

public class FactoryPattern {
    public static void main(String[] args) {
        PolygonFactory pf = new PolygonFactory();
        for (int i = 0; i < 10; i++) {
            Polygon polygon = pf.getPolygon(i);
            System.out.println(polygon == null ? "undefined type" : pf.getPolygon(i).getType());
        }
    }

    private interface Polygon {
        String getType();
    }

    private static class PolygonFactory {
        private static Map<Integer, Polygon> map;// = new HashMap<>();

        /*static {
            map.put(3, new Triangle());
            map.put(4, new Square());
            map.put(5, new Pentagon());
            map.put(7, new Heptagon());
            map.put(8, new Octagon());
        }*/

        public Polygon getPolygon(int numberOfSides) {
            /*if (numberOfSides == 3) {
                return new Triangle();
            }
            if (numberOfSides == 4) {
                return new Square();
            }
            if (numberOfSides == 5) {
                return new Pentagon();
            }
            if (numberOfSides == 7) {
                return new Heptagon();
            }
            if (numberOfSides == 8) {
                return new Octagon();
            }
            return null;*/
            if (map == null) {
                map = new HashMap<>();
                map.put(3, new Triangle());
                map.put(4, new Square());
                map.put(5, new Pentagon());
                map.put(7, new Heptagon());
                map.put(8, new Octagon());
            }
            return map.getOrDefault(numberOfSides, null);
        }
    }

    private static class Triangle implements Polygon {
        @Override
        public String getType() {
            return "Triangle";
        }
    }

    private static class Square implements Polygon {
        @Override
        public String getType() {
            return "Square";
        }
    }

    private static class Pentagon implements Polygon {
        @Override
        public String getType() {
            return "Pentagon";
        }
    }

    private static class Heptagon implements Polygon {
        @Override
        public String getType() {
            return "Heptagon";
        }
    }

    private static class Octagon implements Polygon {
        @Override
        public String getType() {
            return "Octagon";
        }
    }
}
