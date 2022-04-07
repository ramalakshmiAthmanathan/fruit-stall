package Models;

public class BuyAndGet {

    private String name;
    private Integer buyCount;
    private Integer freeCount;

    public BuyAndGet(String name, Integer buyCount, Integer freeCount) {
        this.name = name;
        this.buyCount = buyCount;
        this.freeCount = freeCount;
    }

    /**
     * get field
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * get field
     *
     * @return buyCount
     */
    public Integer getBuyCount() {
        return this.buyCount;
    }

    /**
     * get field
     *
     * @return freeCount
     */
    public Integer getFreeCount() {
        return this.freeCount;
    }
}
