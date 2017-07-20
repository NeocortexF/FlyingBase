package secure;

public class ClassificatorEntity {

    private int id;
    private int category;
    private String classificatorPoint;

    public ClassificatorEntity(int id, int category, String classificatorPoint) {
        this.id = id;
        this.category = category;
        this.classificatorPoint = classificatorPoint;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getClassificatorPoint() {
        return classificatorPoint;
    }

    public void setClassificatorPoint(String classificatorPoint) {
        this.classificatorPoint = classificatorPoint;
    }
}
