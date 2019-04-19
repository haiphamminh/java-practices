package com.example.pattern;

public class DecoratorPattern {
    public static void main(String[] args) {
        ChristmasTree tree2 = new BubbleLights(
                new Garland(new Garland(new ChristmasTreeImpl())));
        System.out.println(tree2.decorate());
    }

    public interface ChristmasTree {
        String decorate();
    }

    public static class ChristmasTreeImpl implements ChristmasTree {

        @Override
        public String decorate() {
            return "Christmas tree";
        }
    }

    public static abstract class TreeDecorator implements ChristmasTree {
        private ChristmasTree tree;

        public TreeDecorator(ChristmasTree tree) {
            this.tree = tree;
        }

        // standard constructors
        @Override
        public String decorate() {
            return tree.decorate();
        }
    }

    public static class BubbleLights extends TreeDecorator {

        public BubbleLights(ChristmasTree tree) {
            super(tree);
        }

        public String decorate() {
            return super.decorate() + decorateWithBubbleLights();
        }

        private String decorateWithBubbleLights() {
            return " with Bubble Lights";
        }
    }

    public static class Garland extends TreeDecorator {

        public Garland(ChristmasTree tree) {
            super(tree);
        }

        public String decorate() {
            return super.decorate() + decorateWithGarland();
        }

        private String decorateWithGarland() {
            return " with Garland";
        }
    }
}
