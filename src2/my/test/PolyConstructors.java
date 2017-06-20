package my.test;

import static my.test.BMGotoAlternative.print;

class Glyph {
    void draw() { print("my.test.Glyph.draw_main()"); }
    Glyph() {
        print("my.test.Glyph() before draw_main()");
        draw();
        print("my.test.Glyph() after draw_main()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;
    RoundGlyph(int r) {
        radius = r;
        print("my.test.RoundGlyph.my.test.RoundGlyph(), radius = " + radius);
    }
    void draw() {
        print("my.test.RoundGlyph.draw_main(), radius = " + radius);
    }
}

public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}