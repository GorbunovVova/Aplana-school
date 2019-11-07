package task3.models;

import java.util.List;

public class Company {
    public int id;
    public String code;
    public String name_full;
    public String name_short;
    public long inn;
    public CompanyType company_type;
    public long ogrn;
    public String egrul_date;
    public Country country;
    public String fio_head;
    public String address;
    public String phone;
    public String e_mail;
    public String www;
    public Boolean is_resident;
    public List<Security> securities;

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name_full='" + name_full + '\'' +
                ", name_short='" + name_short + '\'' +
                ", inn=" + inn +
                ", company_type=" + company_type +
                ", ogrn=" + ogrn +
                ", egrul_date='" + egrul_date + '\'' +
                ", country=" + country +
                ", fio_head='" + fio_head + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", www='" + www + '\'' +
                ", is_resident=" + is_resident +
                ", securities=" + securities +
                '}';
    }
}
