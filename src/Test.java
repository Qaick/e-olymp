class Test{
    public static void main(String args[]) {
        int or = 0b1;
        int noSignRightShift = 0xffff_ffff;
        int xor = 0b1;
        or |= 4;
        System.out.println(Integer.toString(noSignRightShift,2));
        noSignRightShift >>= 1;//no sign right shift
        System.out.println(Integer.toString(noSignRightShift,2));
        noSignRightShift >>>= 1;//sign right shift
        System.out.println(Integer.toString(noSignRightShift,2));
        System.out.println(Integer.toString(0xffffffff,2));

        xor ^= 3;
        System.out.println(or + " " + noSignRightShift + " " + xor);
    }
}