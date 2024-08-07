package cn.nothinghere.brook.value.region;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static cn.nothinghere.brook.value.region.Province.ANHUI;
import static cn.nothinghere.brook.value.region.Province.FUJIAN;
import static cn.nothinghere.brook.value.region.Province.GANSU;
import static cn.nothinghere.brook.value.region.Province.GUANGDONG;
import static cn.nothinghere.brook.value.region.Province.GUANGXI;
import static cn.nothinghere.brook.value.region.Province.GUIZHOU;
import static cn.nothinghere.brook.value.region.Province.HAINAN;
import static cn.nothinghere.brook.value.region.Province.HEBEI;
import static cn.nothinghere.brook.value.region.Province.HEILONGJIANG;
import static cn.nothinghere.brook.value.region.Province.HENAN;
import static cn.nothinghere.brook.value.region.Province.HONG_KONG;
import static cn.nothinghere.brook.value.region.Province.HUBEI;
import static cn.nothinghere.brook.value.region.Province.HUNAN;
import static cn.nothinghere.brook.value.region.Province.JIANGSU;
import static cn.nothinghere.brook.value.region.Province.JIANGXI;
import static cn.nothinghere.brook.value.region.Province.JILIN;
import static cn.nothinghere.brook.value.region.Province.LIAONING;
import static cn.nothinghere.brook.value.region.Province.MACAO;
import static cn.nothinghere.brook.value.region.Province.NEI_MONGGOL;
import static cn.nothinghere.brook.value.region.Province.NINGXIA;
import static cn.nothinghere.brook.value.region.Province.QINGHAI;
import static cn.nothinghere.brook.value.region.Province.SHAANXI;
import static cn.nothinghere.brook.value.region.Province.SHANDONG;
import static cn.nothinghere.brook.value.region.Province.SHANXI;
import static cn.nothinghere.brook.value.region.Province.SICHUAN;
import static cn.nothinghere.brook.value.region.Province.TAIWAN;
import static cn.nothinghere.brook.value.region.Province.XINJIANG;
import static cn.nothinghere.brook.value.region.Province.XIZANG;
import static cn.nothinghere.brook.value.region.Province.YUNNAN;
import static cn.nothinghere.brook.value.region.Province.ZHEJIANG;

/**
 * @author amos.chenj@outlook.com
 */
public enum City implements Region {
    /**
     * 四个直辖市
     */
    BEIJING(Province.BEIJING, "北京市"),
    TIANJIN(Province.TIANJIN, "天津市"),
    SHANGHAI(Province.SHANGHAI, "上海市"),
    CHONGQING(Province.CHONGQING, "重庆市"),

    SHIJIAZHUANG(HEBEI, "石家庄市"),
    TANGSHAN(HEBEI, "唐山市"),
    QINHUANGDAO(HEBEI, "秦皇岛市"),
    HANDAN(HEBEI, "邯郸市"),
    XINGTAI(HEBEI, "邢台市"),
    BAODING(HEBEI, "保定市"),
    ZHANGJIAKOU(HEBEI, "张家口市"),
    CHENGDE(HEBEI, "承德市"),
    CANGZHOU(HEBEI, "沧州市"),
    LANGFANG(HEBEI, "廊坊市"),
    HENGSHUI(HEBEI, "衡水市"),

    TAIYUAN(SHANXI, "太原市"),
    DATONG(SHANXI, "大同市"),
    YANGQUAN(SHANXI, "阳泉市"),
    ZHANGZHI(SHANXI, "长治市"),
    JINCHENG(SHANXI, "晋城市"),
    SHUOZHOU(SHANXI, "朔州市"),
    JINZHONG(SHANXI, "晋中市"),
    YUNCHENG(SHANXI, "运城市"),
    XINZHOU(SHANXI, "忻州市"),
    LINFEN(SHANXI, "临汾市"),
    LVLIANG(SHANXI, "吕梁市"),

    HUHEHAOTE(NEI_MONGGOL, "呼和浩特市"),
    BAOTOU(NEI_MONGGOL, "包头市"),
    WUHAI(NEI_MONGGOL, "乌海市"),
    CHIFENG(NEI_MONGGOL, "赤峰市"),
    TONGLIAO(NEI_MONGGOL, "通辽市"),
    EERDUOSI(NEI_MONGGOL, "鄂尔多斯市"),
    HULUNBEIER(NEI_MONGGOL, "呼伦贝尔市"),
    BAYANNAOER(NEI_MONGGOL, "巴彦淖尔市"),
    WULANCHABU(NEI_MONGGOL, "乌兰察布市"),
    XINGANMENG(NEI_MONGGOL, "兴安盟"),
    XILINGUOLEMENG(NEI_MONGGOL, "锡林郭勒盟"),
    ALASHANMENG(NEI_MONGGOL, "阿拉善盟"),

    SHENYANG(LIAONING, "沈阳市"),
    DALIAN(LIAONING, "大连市"),
    ANSHAN(LIAONING, "鞍山市"),
    FUSHUN(LIAONING, "抚顺市"),
    BENXI(LIAONING, "本溪市"),
    DANDONG(LIAONING, "丹东市"),
    JINZHOU(LIAONING, "锦州市"),
    YINGKOU(LIAONING, "营口市"),
    FUXIN(LIAONING, "阜新市"),
    LIAOYANG(LIAONING, "辽阳市"),
    PANJIN(LIAONING, "盘锦市"),
    TIELING(LIAONING, "铁岭市"),
    CHAOYANG(LIAONING, "朝阳市"),
    HULUDAO(LIAONING, "葫芦岛市"),

    CHANGCHUN(JILIN, "长春市"),
    /**
     * 吉林市和吉林省拼音会有冲突，所以在此加上city后缀以示区分
     */
    JILINCITY(JILIN, "吉林市"),
    SIPING(JILIN, "四平市"),
    LIAOYUAN(JILIN, "辽源市"),
    TONGHUA(JILIN, "通化市"),
    BAISHAN(JILIN, "白山市"),
    SONGYUAN(JILIN, "松原市"),
    BAICHENG(JILIN, "白城市"),
    YANBIANCHAOXIANZU(JILIN, "延边朝鲜族自治州"),

    HAERBIN(HEILONGJIANG, "哈尔滨市"),
    QIQIHAER(HEILONGJIANG, "齐齐哈尔市"),
    JIXI(HEILONGJIANG, "鸡西市"),
    HEGANG(HEILONGJIANG, "鹤岗市"),
    SHUANGYASHAN(HEILONGJIANG, "双鸭山市"),
    DAQING(HEILONGJIANG, "大庆市"),
    YICHUN_HLJ(HEILONGJIANG, "伊春市"),
    JIAMUSI(HEILONGJIANG, "佳木斯市"),
    QITAIHE(HEILONGJIANG, "七台河市"),
    MUDANJIANG(HEILONGJIANG, "牡丹江市"),
    HEIHE(HEILONGJIANG, "黑河市"),
    SUIHUA(HEILONGJIANG, "绥化市"),
    DAXINGANLING(HEILONGJIANG, "大兴安岭地区"),

    NANJING(JIANGSU, "南京市"),
    WUXI(JIANGSU, "无锡市"),
    XUZHOU(JIANGSU, "徐州市"),
    CHANGZHOU(JIANGSU, "常州市"),
    SUZHOU_SJ(JIANGSU, "苏州市"),
    NANTONG(JIANGSU, "南通市"),
    LIANYUNGANG(JIANGSU, "连云港市"),
    HUAIAN(JIANGSU, "淮安市"),
    YANCHENG(JIANGSU, "盐城市"),
    YANGZHOU(JIANGSU, "扬州市"),
    ZHENJIANG(JIANGSU, "镇江市"),
    TAIZHOU_JS(JIANGSU, "泰州市"),
    SUQIAN(JIANGSU, "宿迁市"),

    HANGZHOU(ZHEJIANG, "杭州市"),
    NINGBO(ZHEJIANG, "宁波市"),
    WENZHOU(ZHEJIANG, "温州市"),
    JIAXING(ZHEJIANG, "嘉兴市"),
    HUZHOU(ZHEJIANG, "湖州市"),
    SHAOXING(ZHEJIANG, "绍兴市"),
    JINHUA(ZHEJIANG, "金华市"),
    QUZHOU(ZHEJIANG, "衢州市"),
    ZHOUSHAN(ZHEJIANG, "舟山市"),
    TAIZHOU_ZJ(ZHEJIANG, "台州市"),
    LISHUI(ZHEJIANG, "丽水市"),

    HEFEI(ANHUI, "合肥市"),
    WUHU(ANHUI, "芜湖市"),
    BANGBU(ANHUI, "蚌埠市"),
    HUAINAN(ANHUI, "淮南市"),
    MAANSHAN(ANHUI, "马鞍山市"),
    HUAIBEI(ANHUI, "淮北市"),
    TONGLING(ANHUI, "铜陵市"),
    ANQING(ANHUI, "安庆市"),
    HUANGSHAN(ANHUI, "黄山市"),
    CHUZHOU(ANHUI, "滁州市"),
    FUYANG(ANHUI, "阜阳市"),
    SUZHOU_AH(ANHUI, "宿州市"),
    LIUAN(ANHUI, "六安市"),
    BOZHOU(ANHUI, "亳州市"),
    CHIZHOU(ANHUI, "池州市"),
    XUANCHENG(ANHUI, "宣城市"),

    FUZHOU_FJ(FUJIAN, "福州市"),
    SHAMEN(FUJIAN, "厦门市"),
    PUTIAN(FUJIAN, "莆田市"),
    SANMING(FUJIAN, "三明市"),
    QUANZHOU(FUJIAN, "泉州市"),
    ZHANGZHOU(FUJIAN, "漳州市"),
    NANPING(FUJIAN, "南平市"),
    LONGYAN(FUJIAN, "龙岩市"),
    NINGDE(FUJIAN, "宁德市"),

    NANCHANG(JIANGXI, "南昌市"),
    JINGDEZHEN(JIANGXI, "景德镇市"),
    PINGXIANG(JIANGXI, "萍乡市"),
    JIUJIANG(JIANGXI, "九江市"),
    XINYU(JIANGXI, "新余市"),
    YINGTAN(JIANGXI, "鹰潭市"),
    GANZHOU(JIANGXI, "赣州市"),
    JIAN(JIANGXI, "吉安市"),
    YICHUN_JX(JIANGXI, "宜春市"),
    FUZHOU_JX(JIANGXI, "抚州市"),
    SHANGRAO(JIANGXI, "上饶市"),

    JINAN(SHANDONG, "济南市"),
    QINGDAO(SHANDONG, "青岛市"),
    ZIBO(SHANDONG, "淄博市"),
    ZAOZHUANG(SHANDONG, "枣庄市"),
    DONGYING(SHANDONG, "东营市"),
    YANTAI(SHANDONG, "烟台市"),
    WEIFANG(SHANDONG, "潍坊市"),
    JINING(SHANDONG, "济宁市"),
    TAIAN(SHANDONG, "泰安市"),
    WEIHAI(SHANDONG, "威海市"),
    RIZHAO(SHANDONG, "日照市"),
    LAIWU(SHANDONG, "莱芜市"),
    LINYI(SHANDONG, "临沂市"),
    DEZHOU(SHANDONG, "德州市"),
    LIAOCHENG(SHANDONG, "聊城市"),
    BINZHOU(SHANDONG, "滨州市"),
    HEZE(SHANDONG, "菏泽市"),

    ZHENGZHOU(HENAN, "郑州市"),
    KAIFENG(HENAN, "开封市"),
    LUOYANG(HENAN, "洛阳市"),
    PINGDINGSHAN(HENAN, "平顶山市"),
    ANYANG(HENAN, "安阳市"),
    HEBI(HENAN, "鹤壁市"),
    XINXIANG(HENAN, "新乡市"),
    JIAOZUO(HENAN, "焦作市"),
    JIYUAN(HENAN, "济源市"),
    PUYANG(HENAN, "濮阳市"),
    XUCHANG(HENAN, "许昌市"),
    LUOHE(HENAN, "漯河市"),
    SANMENXIA(HENAN, "三门峡市"),
    NANYANG(HENAN, "南阳市"),
    SHANGQIU(HENAN, "商丘市"),
    XINYANG(HENAN, "信阳市"),
    ZHOUKOU(HENAN, "周口市"),
    ZHUMADIAN(HENAN, "驻马店市"),

    WUHAN(HUBEI, "武汉市"),
    HUANGSHI(HUBEI, "黄石市"),
    SHIYAN(HUBEI, "十堰市"),
    YICHANG(HUBEI, "宜昌市"),
    XIANGYANG(HUBEI, "襄阳市"),
    EZHOU(HUBEI, "鄂州市"),
    JINGMEN(HUBEI, "荆门市"),
    XIAOGAN(HUBEI, "孝感市"),
    JINGZHOU(HUBEI, "荆州市"),
    HUANGGANG(HUBEI, "黄冈市"),
    XIANNING(HUBEI, "咸宁市"),
    SUIZHOU(HUBEI, "随州市"),
    ENSHITUJIAZUMIAOZU(HUBEI, "恩施土家族苗族自治州"),
    XIANTAO(HUBEI, "仙桃市"),
    QIANJIANG(HUBEI, "潜江市"),
    TIANMEN(HUBEI, "天门市"),
    SHENNONGJIALINQU(HUBEI, "神农架林区"),

    CHANGSHA(HUNAN, "长沙市"),
    ZHUZHOU(HUNAN, "株洲市"),
    XIANGTAN(HUNAN, "湘潭市"),
    HENGYANG(HUNAN, "衡阳市"),
    SHAOYANG(HUNAN, "邵阳市"),
    YUEYANG(HUNAN, "岳阳市"),
    CHANGDE(HUNAN, "常德市"),
    ZHANGJIAJIE(HUNAN, "张家界市"),
    YIYANG(HUNAN, "益阳市"),
    CHENZHOU(HUNAN, "郴州市"),
    YONGZHOU(HUNAN, "永州市"),
    HUAIHUA(HUNAN, "怀化市"),
    LOUDI(HUNAN, "娄底市"),
    XIANGXITUJIAZUMIAOZU(HUNAN, "湘西土家族苗族自治州"),

    GUANGZHOU(GUANGDONG, "广州市"),
    SHAOGUAN(GUANGDONG, "韶关市"),
    SHENZHEN(GUANGDONG, "深圳市"),
    ZHUHAI(GUANGDONG, "珠海市"),
    SHANTOU(GUANGDONG, "汕头市"),
    FOSHAN(GUANGDONG, "佛山市"),
    JIANGMEN(GUANGDONG, "江门市"),
    ZHANJIANG(GUANGDONG, "湛江市"),
    MAOMING(GUANGDONG, "茂名市"),
    ZHAOQING(GUANGDONG, "肇庆市"),
    HUIZHOU(GUANGDONG, "惠州市"),
    MEIZHOU(GUANGDONG, "梅州市"),
    SHANWEI(GUANGDONG, "汕尾市"),
    HEYUAN(GUANGDONG, "河源市"),
    YANGJIANG(GUANGDONG, "阳江市"),
    QINGYUAN(GUANGDONG, "清远市"),
    DONGGUAN(GUANGDONG, "东莞市"),
    ZHONGSHAN(GUANGDONG, "中山市"),
    CHAOZHOU(GUANGDONG, "潮州市"),
    JIEYANG(GUANGDONG, "揭阳市"),
    YUNFU(GUANGDONG, "云浮市"),

    NANNING(GUANGXI, "南宁市"),
    LIUZHOU(GUANGXI, "柳州市"),
    GUILIN(GUANGXI, "桂林市"),
    WUZHOU(GUANGXI, "梧州市"),
    BEIHAI(GUANGXI, "北海市"),
    FANGCHENGGANG(GUANGXI, "防城港市"),
    QINZHOU(GUANGXI, "钦州市"),
    GUIGANG(GUANGXI, "贵港市"),
    YULIN_GX(GUANGXI, "玉林市"),
    BAISE(GUANGXI, "百色市"),
    HEZHOU(GUANGXI, "贺州市"),
    HECHI(GUANGXI, "河池市"),
    LAIBIN(GUANGXI, "来宾市"),
    CHONGZUO(GUANGXI, "崇左市"),

    HAIKOU(HAINAN, "海口市"),
    SANYA(HAINAN, "三亚市"),
    SANSHA(HAINAN, "三沙市"),
    WUZHISHAN(HAINAN, "五指山市"),
    QIONGHAI(HAINAN, "琼海市"),
    DANZHOU(HAINAN, "儋州市"),
    WENCHANG(HAINAN, "文昌市"),
    WANNING(HAINAN, "万宁市"),
    DONGFANG(HAINAN, "东方市"),
    DINGANXIAN(HAINAN, "定安县"),
    TUNCHANGXIAN(HAINAN, "屯昌县"),
    CHENGMAIXIAN(HAINAN, "澄迈县"),
    LINGAOXIAN(HAINAN, "临高县"),
    BAISHALIZU(HAINAN, "白沙黎族自治县"),
    CHANGJIANGLIZU(HAINAN, "昌江黎族自治县"),
    LEDONGLIZU(HAINAN, "乐东黎族自治县"),
    LINGSHUILIZU(HAINAN, "陵水黎族自治县"),
    BAOTINGLIZUMIAOZU(HAINAN, "保亭黎族苗族自治县"),
    QIONGZHONGLIZUMIAOZU(HAINAN, "琼中黎族苗族自治县"),

    CHENGDOU(SICHUAN, "成都市"),
    ZIGONG(SICHUAN, "自贡市"),
    PANZHIHUA(SICHUAN, "攀枝花市"),
    LUZHOU(SICHUAN, "泸州市"),
    DEYANG(SICHUAN, "德阳市"),
    MIANYANG(SICHUAN, "绵阳市"),
    GUANGYUAN(SICHUAN, "广元市"),
    SUINING(SICHUAN, "遂宁市"),
    NEIJIANG(SICHUAN, "内江市"),
    LESHAN(SICHUAN, "乐山市"),
    NANCHONG(SICHUAN, "南充市"),
    MEISHAN(SICHUAN, "眉山市"),
    YIBIN(SICHUAN, "宜宾市"),
    GUANGAN(SICHUAN, "广安市"),
    DAZHOU(SICHUAN, "达州市"),
    YAAN(SICHUAN, "雅安市"),
    BAZHONG(SICHUAN, "巴中市"),
    ZIYANG(SICHUAN, "资阳市"),
    ABAZANGZUQIANGZU(SICHUAN, "阿坝藏族羌族自治州"),
    GANZIZANGZU(SICHUAN, "甘孜藏族自治州"),
    LIANGSHANYIZU(SICHUAN, "凉山彝族自治州"),

    GUIYANG(GUIZHOU, "贵阳市"),
    LIUPANSHUI(GUIZHOU, "六盘水市"),
    ZUNYI(GUIZHOU, "遵义市"),
    ANSHUN(GUIZHOU, "安顺市"),
    TONGREN(GUIZHOU, "铜仁市"),
    QIANXINANBUYIZUMIAOZU(GUIZHOU, "黔西南布依族苗族自治州"),
    BIJIE(GUIZHOU, "毕节市"),
    QIANDONGNANMIAOZUDONGZU(GUIZHOU, "黔东南苗族侗族自治州"),
    QIANNANBUYIZUMIAOZU(GUIZHOU, "黔南布依族苗族自治州"),

    KUNMING(YUNNAN, "昆明市"),
    QUJING(YUNNAN, "曲靖市"),
    YUXI(YUNNAN, "玉溪市"),
    BAOSHAN(YUNNAN, "保山市"),
    ZHAOTONG(YUNNAN, "昭通市"),
    LIJIANG(YUNNAN, "丽江市"),
    PUER(YUNNAN, "普洱市"),
    LINCANG(YUNNAN, "临沧市"),
    CHUXIONGYIZU(YUNNAN, "楚雄彝族自治州"),
    HONGHEHANIZUYIZU(YUNNAN, "红河哈尼族彝族自治州"),
    WENSHANZHUANGZUMIAOZU(YUNNAN, "文山壮族苗族自治州"),
    XISHUANGBANNADAIZU(YUNNAN, "西双版纳傣族自治州"),
    DALIBAIZU(YUNNAN, "大理白族自治州"),
    DEHONGDAIZUJINGPOZU(YUNNAN, "德宏傣族景颇族自治州"),
    NUJIANGLISUZU(YUNNAN, "怒江傈僳族自治州"),
    DIQINGZANGZU(YUNNAN, "迪庆藏族自治州"),

    LASA(XIZANG, "拉萨市"),
    CHANGDOU(XIZANG, "昌都市"),
    SHANNAN(XIZANG, "山南市"),
    RIKAZE(XIZANG, "日喀则市"),
    NEIQU(XIZANG, "那曲市"),
    ALI(XIZANG, "阿里地区"),
    LINZHI(XIZANG, "林芝市"),

    XIAN(SHAANXI, "西安市"),
    TONGCHUAN(SHAANXI, "铜川市"),
    BAOJI(SHAANXI, "宝鸡市"),
    XIANYANG(SHAANXI, "咸阳市"),
    WEINAN(SHAANXI, "渭南市"),
    YANAN(SHAANXI, "延安市"),
    HANZHONG(SHAANXI, "汉中市"),
    YULIN_SX(SHAANXI, "榆林市"),
    ANKANG(SHAANXI, "安康市"),
    SHANGLUO(SHAANXI, "商洛市"),

    LANZHOU(GANSU, "兰州市"),
    JIAYUGUAN(GANSU, "嘉峪关市"),
    JINCHANG(GANSU, "金昌市"),
    BAIYIN(GANSU, "白银市"),
    TIANSHUI(GANSU, "天水市"),
    WUWEI(GANSU, "武威市"),
    ZHANGYE(GANSU, "张掖市"),
    PINGLIANG(GANSU, "平凉市"),
    JIUQUAN(GANSU, "酒泉市"),
    QINGYANG(GANSU, "庆阳市"),
    DINGXI(GANSU, "定西市"),
    LONGNAN(GANSU, "陇南市"),
    LINXIAHUIZU(GANSU, "临夏回族自治州"),
    GANNANZANGZU(GANSU, "甘南藏族自治州"),

    XINING(QINGHAI, "西宁市"),
    HAIDONG(QINGHAI, "海东市"),
    HAIBEIZANGZU(QINGHAI, "海北藏族自治州"),
    HUANGNANZANGZU(QINGHAI, "黄南藏族自治州"),
    HAINANZANGZU(QINGHAI, "海南藏族自治州"),
    GUOLUOZANGZU(QINGHAI, "果洛藏族自治州"),
    YUSHUZANGZU(QINGHAI, "玉树藏族自治州"),
    HAIXIMENGGUZUZANGZU(QINGHAI, "海西蒙古族藏族自治州"),

    YINCHUAN(NINGXIA, "银川市"),
    SHIZUISHAN(NINGXIA, "石嘴山市"),
    WUZHONG(NINGXIA, "吴忠市"),
    GUYUAN(NINGXIA, "固原市"),
    ZHONGWEI(NINGXIA, "中卫市"),

    WULUMUQI(XINJIANG, "乌鲁木齐市"),
    KELAMAYI(XINJIANG, "克拉玛依市"),
    TULUFAN(XINJIANG, "吐鲁番市"),
    HAMI(XINJIANG, "哈密市"),
    CHANGJIHUIZU(XINJIANG, "昌吉回族自治州"),
    BOERTALAMENGGU(XINJIANG, "博尔塔拉蒙古自治州"),
    BAYINGUOLENGMENGGU(XINJIANG, "巴音郭楞蒙古自治州"),
    AKESU(XINJIANG, "阿克苏地区"),
    KEZILESUKEERKEZI(XINJIANG, "克孜勒苏柯尔克孜自治州"),
    KASHEN(XINJIANG, "喀什地区"),
    HETIAN(XINJIANG, "和田地区"),
    YILIHASAKE(XINJIANG, "伊犁哈萨克自治州"),
    TACHENG(XINJIANG, "塔城地区"),
    ALETAI(XINJIANG, "阿勒泰地区"),
    KEKEDALA(XINJIANG, "可克达拉市"),
    SHIHEZI(XINJIANG, "石河子市"),
    ALAER(XINJIANG, "阿拉尔市"),
    TUMUSHUKE(XINJIANG, "图木舒克市"),
    WUJIAQU(XINJIANG, "五家渠市"),
    BEITUN(XINJIANG, "北屯市"),
    TIEMENGUAN(XINJIANG, "铁门关市"),
    SHUANGHE(XINJIANG, "双河市"),
    KUNYU(XINJIANG, "昆玉市"),

    TAIBEI(TAIWAN, "台北市"),
    GAOXIONG(TAIWAN, "高雄市"),
    TAINAN(TAIWAN, "台南市"),
    TAIZHONG(TAIWAN, "台中市"),
    JINMENXIAN(TAIWAN, "金门县"),
    NANTOUXIAN(TAIWAN, "南投县"),
    JILONG(TAIWAN, "基隆市"),
    XINZHU(TAIWAN, "新竹市"),
    JIAYI(TAIWAN, "嘉义市"),
    XINBEI(TAIWAN, "新北市"),
    YILANXIAN(TAIWAN, "宜兰县"),
    XINZHUXIAN(TAIWAN, "新竹县"),
    TAOYUAN(TAIWAN, "桃园市"),
    MIAOLIXIAN(TAIWAN, "苗栗县"),
    ZHANGHUAXIAN(TAIWAN, "彰化县"),
    JIAYIXIAN(TAIWAN, "嘉义县"),
    YUNLINXIAN(TAIWAN, "云林县"),
    PINGDONGXIAN(TAIWAN, "屏东县"),
    TAIDONGXIAN(TAIWAN, "台东县"),
    HUALIANXIAN(TAIWAN, "花莲县"),
    PENGHUXIAN(TAIWAN, "澎湖县"),
    LIANJIANGXIAN(TAIWAN, "连江县"),

    HONGKONGISLAND(HONG_KONG, "香港岛"),
    KOWLOONPENINSULA(HONG_KONG, "九龙"),
    NEWTERRITORIES(HONG_KONG, "新界"),

    PENINSULAOFMACAO(MACAO, "澳门半岛"),
    LIDAO(MACAO, "离岛"),
    ;
    private final Province parent;
    private final String name;

    City(Province parent, String name) {
        this.parent = parent;
        this.name = name;
    }

    public static City[] getByParent(Province parent) {
        Objects.requireNonNull(parent);
        City[] cities = City.values();
        List<City> cityList = new ArrayList<>();
        for (City city : cities) {
            if (city.getParent() == parent) {
                cityList.add(city);
            }
        }
        return cityList.toArray(new City[0]);
    }

    public String getName() {
        return this.name;
    }

    public Province getParent() {
        return this.parent;
    }
}
