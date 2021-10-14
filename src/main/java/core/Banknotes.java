package core;

public enum Banknotes {
    FIVEHUNDREDEURO(500), TWOHUNDREDEURO(200), ONEHUNDREDEURO(100),
    FIFTYEURO(50), TWENTYEURO(20), TENEURO(10), FIVEEURO(5),
    TWOEURO(2), ONEEURO(1), FIFTYCENT(0.50), TWENTYCENT(0.20),
    TENCENT(0.10), FIVECENT(0.05), TWOCENT(0.02), ONECENT(0.01);

    private double value;

    Banknotes(double value) {
        this.value = value;
    }

    /**
     * @return Current real banknote value.
     */
    public double getValue() {
        return value;
    }
}
