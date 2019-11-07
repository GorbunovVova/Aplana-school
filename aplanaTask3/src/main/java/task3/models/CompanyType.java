package task3.models;

public class CompanyType {
    public int id;
    public String name_short;
    public String name_full;

    @Override
    public String toString() {
        return "CompanyType{" +
                "id=" + id +
                ", name_short='" + name_short + '\'' +
                ", name_full='" + name_full + '\'' +
                '}';
    }
}
