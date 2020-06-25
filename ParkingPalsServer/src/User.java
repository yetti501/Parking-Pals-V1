public class User {

    private long UserId;
    private String UserName;
    private long ParkingSpotId;
    private long PaymentId;

    // record PremiumStatus: number of day, e.p. 2 days
    private int PremiumStatus = 0;

    public User(long userId, String userName, long parkingSpotId, long paymentId){
        setUserId(userId);
        setUserName(userName);
        setParkingSpotId(parkingSpotId);
        setPaymentId(paymentId);
    }

    /**
     * pass parkingSpotId to User, update DB
     * @param parkingSpotId
     */
    public void park(long parkingSpotId){
        setParkingSpotId(parkingSpotId);
        // update DB

    }

    /**
     * read payment data, and update DB
     * @param paymentType
     * @param paymentAmount
     */
    public void pay(String paymentType, double paymentAmount){
        tools tool = new tools();
        // generate random payment id
        // compare with existing one to avoid repeat
        // Payment payment = new Payment(tool.generatePaymentId(), this.UserId, paymentType, paymentAmount, System.currentTimeMillis());

        // write data from payment class to DB ...

    }

    /**
     * return parking time using parkingSpotId
     *
     * Same as getStartParkingTime
     *
     * @param parkingSpotId
     */
    public void checkParkingStatus(long parkingSpotId){
        // search in DB
    }

    /**
     * return payment info
     * @param paymentId
     */
    public void checkPaymentInfo(long paymentId){
        // search in DB
    }

    /**
     * check premium status
     * @return premiumStatus
     */
    public int CheckPremiumsStatus(){

        return this.PremiumStatus;
    }

    /**
     * upgrade premium
     * @param num the number of day to
     * @param paymentType
     * @param paymentAmount
     */
    public void upgradePremium(int num, String paymentType, double paymentAmount){
        // pay first
        pay(paymentType,paymentAmount);
        // update PremiumStatus
        this.PremiumStatus = num;

        // update DB
    }

    /**
     * Get user id
     * @return UserId
     */
    public long getUserId(){
        return this.UserId;
    }

    /**
     * Get user name
     * @return UserName
     */
    public String getUserName(){
        return this.UserName;
    }

    /**
     * Get parking spot id
     * @return ParkingSpotId
     */
    public long getParkingSpotId(){
        return this.ParkingSpotId;
    }

    /**
     * Get payment id
     * @return PaymentId
     */
    public long getPaymentId(){
        return this.PaymentId;
    }

    /**
     * Set user id
     */
    public void setUserId(long userId){
        this.UserId = userId;
    }

    /**
     * Set user name
     */
    public void setUserName(String userName){
        this.UserName = userName;
    }

    /**
     * Set parking spot id
     */
    public void setParkingSpotId(long parkingSpotId){
        this.ParkingSpotId = parkingSpotId;
    }

    /**
     * Set payment id
     */
    public void setPaymentId(long paymentId){
        this.PaymentId = paymentId;
    }
}
