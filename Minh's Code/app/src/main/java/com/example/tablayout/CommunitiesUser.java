package com.example.tablayout;

public class CommunitiesUser {
    private  int resourceId;
    private String name;
    private String members;
    private String type;

    public CommunitiesUser(int resourceId, String name, String members, String type) {
        this.resourceId = resourceId;
        this.name = name;
        this.members = members;
        this.type = type;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }
    public String getMembers() {
        return members;
    }

    public String getType() {
        return type;
    }
}
