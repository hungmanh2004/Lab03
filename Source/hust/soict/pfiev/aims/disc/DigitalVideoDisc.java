public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private int id;
    private static int nbDigitalVideoDiscs = 0;

    // Constructors
    public DigitalVideoDisc(String title) {
        this.title = title;
        this.id = ++nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }

    // getters
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + "$";
    }

    public boolean isMatch(int id) {
        if(this.id == id) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isMatch(String title) {
        if(this.title == title) {
            return true;
        }
        else {
            return false;
        }
    }
}
