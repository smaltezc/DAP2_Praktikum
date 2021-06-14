public class Box {

    private int geld;
    private int weight;

    public Box(int geld,int weight)
    {
        this.geld = geld;
        this.weight = weight;
    }

    public int getGeld() {
        return geld;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Box{" +
                "geld=" + geld +
                ", weight=" + weight +
                '}';
    }
}
