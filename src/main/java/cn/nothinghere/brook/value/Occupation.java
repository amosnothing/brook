package cn.nothinghere.brook.value;

import cn.nothinghere.brook.Field;
import cn.nothinghere.brook.Randomize;

import java.io.Serializable;

/**
 * @author amos.chenj@outlook.com
 */
public class Occupation implements Field, Randomize, Serializable {

    private String major;


    @Override
    public String asString() {
        return null;
    }

    @Override
    public void randomIfNull() {

    }

    public enum Major {
        /**
         * 职业总共有八大类
         */
        LEADER("国家机关、党群组织、企业、事业单位负责人"),
        PROFESSION("专业技术人员"),
        STAFF("办事人员和有关人员"),
        BUSINESS_AND_SERVICE_PERSONNEL("商业、服务业人员"),
        FARMER("农、林、牧、渔、水利业生产人员"),
        PRODUCER_AND_OPERATOR("生产、运输设备操作人员及有关人员"),
        SOLDIER("军人"),
        OTHER("不便分类的其他从业人员"),
        ;
        private String name;

        Major(String name) {
            this.name = name;
        }
    }
}
