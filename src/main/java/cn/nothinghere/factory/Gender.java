package cn.nothinghere.factory;

/**
 * @author amos
 */
public class Gender implements Value {

    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return 男 or 女
     */
    @Override
    public String asString() {
        return this.gender;
    }

    /**
     * @return 男 偶数 | 女 奇数
     */
    @Override
    public String asCode() {
        return null;
    }
}
