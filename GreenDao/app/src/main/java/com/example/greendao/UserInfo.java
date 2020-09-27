package com.example.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class UserInfo {
    @Id(autoincrement = true)
    private Long ID;

    private String name;
    private int age;
    private String sex;


    @Generated(hash = 561422703)
    public UserInfo(Long ID, String name, int age, String sex) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Generated(hash = 1279772520)
    public UserInfo() {
    }
    

    public Long getID() {
        return this.ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
