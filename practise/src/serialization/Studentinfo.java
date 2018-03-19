package serialization;

import java.io.Serializable;

public class Studentinfo implements Serializable {

    String name;
    int rid;
    static String contact;

    public Studentinfo(String n, int r, String c)
    {
        this.name = n;
        this.rid = r;
        this.contact = c;
    }

    @Override
    public String toString() {
        return "Studentinfo{" +
                "name='" + name + '\'' +
                ", rid=" + rid +
                '}';
    }
}