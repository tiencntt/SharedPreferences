package windstudy.com.sharedpreferences.json;

public class Product {
   int code,weight ,basePrice,conversionValue,id;
   String categoryName,image,createdDate,name;
   public  Product(){}

    public Product(int code, int weight, int basePrice, int conversionValue, int id, String categoryName, String image, String createdDate, String name) {
        this.code = code;
        this.weight = weight;
        this.basePrice = basePrice;
        this.conversionValue = conversionValue;
        this.id = id;
        this.categoryName = categoryName;
        this.image = image;
        this.createdDate = createdDate;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getConversionValue() {
        return conversionValue;
    }

    public void setConversionValue(int conversionValue) {
        this.conversionValue = conversionValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
