package cn.jyw.feign.common.api;

//对应类型和类型代码
public enum Type implements ITypeCode {

    homepage_recruitment_work(1001, "招聘"),
    homepage_speech(1002,"宣讲双选"),
    homepage_speech_preach(10021,"宣讲会"),
    homepage_speech_double_choose(10022,"双选会"),
    homepage_recruitment_internship(1003, "实习"),

    job_guide(2000, "就业指导"),

    bulletin(3000,"公告政策"),
    bulletin_announcement(3001, "公告"),
    bulletin_policy(3002, "政策"),

    workplace_activity(4000, "职场活动"),
    news_trends(5000, "新闻动态"),
    well_known_enterprises(6000,"知名企业"),
    school_recruitment_guide(7000,"校招指南"),
    departments_introduce(8000,"学院风采");


    private final Integer typeCode;
    private final String name;

    Type(int code, String name) {
        this.typeCode = code;
        this.name = name;
    }

    @Override
    public Integer getCode() {
        return this.typeCode;
    }

    @Override
    public String getMessage() {
        return this.name;
    }

    @Override
    public String toString() {
        return "type=" + name;
    }

}
