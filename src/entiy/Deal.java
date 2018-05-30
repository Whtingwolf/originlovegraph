package entiy;

public class Deal {
    private int id;
    private String originator;
    private String accpter;
    private String typename;
    private int price ;
    private String description;
    private  int [] picutres ;

    public Deal () {

    }
    public void init(int i){
        picutres = new int[i];
    }
    public void setId (int id) {
        this.id = id;
    }

    public int getId ( ) {
        return id;
    }

    public void setTypename (String typename) {
        this.typename = typename;
    }

    public String getTypename ( ) {
        return typename;
    }

    public void setOriginator (String originator) {
        this.originator = originator;
    }

    public void setAccpter (String accpter) {
        this.accpter = accpter;
    }

    public void setPrice (int price) {
        this.price = price;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public void setPicutres (int[] picutres) {
        this.picutres = picutres;
    }

    public String getOriginator ( ) {
        return originator;
    }

    public String getAccpter ( ) {
        return accpter;
    }

    public int getPrice ( ) {
        return price;
    }

    public String getDescription ( ) {
        return description;
    }

    public int[] getPicutres ( ) {
        return picutres;
    }
}
