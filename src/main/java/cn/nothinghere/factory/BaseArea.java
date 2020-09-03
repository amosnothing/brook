package cn.nothinghere.factory;

/**
 * 省-市-区
 *
 * @author amos
 */
public abstract class BaseArea implements Value, Verifiable{

    private String province;
    private String city;
    private String district;

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }


    public String getCity() {
        return city;
    }


    public String getDistrict() {
        return district;
    }

}
