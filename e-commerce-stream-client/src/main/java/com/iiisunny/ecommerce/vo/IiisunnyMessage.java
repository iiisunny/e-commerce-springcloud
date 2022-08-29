package com.iiisunny.ecommerce.vo;

/**
 * <h1>消息传递对象: SpringCloud Stream + Kafka/RocketMQ</h1>
 * */
public class IiisunnyMessage {

    private Integer id;
    private String projectName;
    private String org;
    private String author;
    private String version;

    /**
     * <h2>返回一个默认的消息, 方便使用</h2>
     * */
    public static IiisunnyMessage defaultMessage() {

        return new IiisunnyMessage(
                1,
                "e-commerce-stream-client",
                "iiisunny.com",
                "iiisunny",
                "1.0"
        );
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public IiisunnyMessage(Integer id, String projectName, String org, String author, String version) {
        this.id = id;
        this.projectName = projectName;
        this.org = org;
        this.author = author;
        this.version = version;
    }
}
