public class CarD {


    private String modelD;
    private String packageD;
    private String plateD;
    private String price;
    private String id;

    public CarD(String plateD, String modelD,String price, String packageD) {
        this.modelD = modelD;
        this.packageD = packageD;
        this.plateD = plateD;
        this.price=price;
    }
public CarD(String id,String plateD, String modelD,String price, String packageD){

        this.id=id;
        this.modelD = modelD;
        this.packageD = packageD;
        this.plateD = plateD;
        this.price=price;

}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }



    public String getModelD() {
        return modelD;
    }

    public void setModelD(String modelD) {
        this.modelD = modelD;
    }

    public String getPackageD() {
        return packageD;
    }

    public void setPackageD(String packageD) {
        this.packageD = packageD;
    }

    public String getPlateD() {
        return plateD;
    }

    public void setPlateD(String plateD) {
        this.plateD = plateD;
    }
 
    public String toString(){

        return plateD;

    }
    public String toStringMy(){

        return plateD+","+modelD+","+price+","+packageD;
    }
}