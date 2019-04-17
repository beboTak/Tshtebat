package bebosemsemcom.ibrahimbebo.tshtebat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Worker {

    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("phone")
    @Expose
    String phone;
    @SerializedName("jop")
    @Expose
    String jop;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getJop() {
        return jop;
    }

    public void setJop(String jop) {
        this.jop = jop;
    }
}
