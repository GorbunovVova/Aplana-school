package task3.models;

public class Currency {
    public int id;
    public String code;
    public String name_short;
    public String name_full;

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name_short='" + name_short + '\'' +
                ", name_full='" + name_full + '\'' +
                '}';
    }
}
