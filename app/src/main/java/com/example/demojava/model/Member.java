package com.example.demojava.model;

import java.util.List;

public class Member {

    private int age;
    private String name;
    private List<MemberSub> memberSubs;


    public Member(int age, String name, List<MemberSub> memberSubs){
        this.age = age;
        this.name = name;
        this.memberSubs = memberSubs;

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public void setMemberSubs(List<MemberSub> memberSubs) {
        this.memberSubs = memberSubs;
    }
    public List<MemberSub> getMemberSubs() {
        return memberSubs;
    }
}
