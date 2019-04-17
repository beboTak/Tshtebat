package bebosemsemcom.ibrahimbebo.tshtebat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ibrahim bebo on 9/10/2018.
 */

public class Owner {
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("phone")
    @Expose
    String phone;
    @SerializedName("description")
    @Expose
    String description;



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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
