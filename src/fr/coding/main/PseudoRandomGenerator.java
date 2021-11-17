package fr.coding.main;

public class PseudoRandomGenerator {
    int INIT_SEED = 123_456_789;

    long COEF = 22_696_477;
    long OFFSET = 1;
    long MODULO = (long)(Math.pow(2, 61)) -1;
    long MASK = 0x7FFF_FFFF;
    int internalValue;

    public PseudoRandomGenerator() {
        this.internalValue = INIT_SEED;
    }

    public PseudoRandomGenerator(int value) {
        this.internalValue = value;
    }

    int getNextValue() {
        long value = (long)this.internalValue;

        value *= COEF;
        value += OFFSET;
        value %= MODULO;

        this.internalValue = (int)((value >> 16) & MASK);

        return this.internalValue;
    }

    public double random() {
        long value = this.getNextValue();

        return ((double)value) / MASK;
    }
}