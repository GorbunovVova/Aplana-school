package task3.models;

public class Security {
    public int id;
    public String code;
    public String name_full;
    public String cfi;
    public String date_to;
    public String state_reg_date;
    public State state;
    public Currency currency;

    @Override
    public String toString() {
        return "Security{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name_full='" + name_full + '\'' +
                ", cfi='" + cfi + '\'' +
                ", date_to=" + date_to +
                ", state_reg_date=" + state_reg_date +
                ", state=" + state +
                ", currency=" + currency +
                '}';
    }
}
