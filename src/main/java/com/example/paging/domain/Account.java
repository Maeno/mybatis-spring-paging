package com.example.paging.domain;

public class Account {
    private Integer id;
    private String name;
    private String email;
    private Sex sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}

enum Sex {

    MAN {
        @Override
        public String getSex() {
            return "男性";
        }
    },
    WOMAN {
        @Override
        public String getSex() {
            return "女性";
        }
    };
    public abstract String getSex();
}
