package cn.jyw.feign.common.api;

//对应类型和类型代码
public enum Type implements ITypeCode{

    job_guide(2000,"就业指导"),

    bulletin_announcement(3001,"公告"),
    bulletin_policy(3002,"政策"),

    workplace_activity(4000,"职场活动"),
    news_trends(5000,"新闻动态");


    private  final Integer typeCode;
    private  final String  name;

    Type(int code, String name){
        this.typeCode=code;
        this.name=name;
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
        return "type=" + name ;
    }

}
