package com.zrg.play.effectiveJave.No2;

import lombok.Data;

/**
 * Builder模式 创建对象
 * <p>
 * 创建 / 销毁对象
 * author: Snail
 * 2019-04-22 23:39
 */
@Data
public class BuildPeople {

    private String name;

    private Sex sex;

    private Integer age;

    private String phoneNumber;

    public enum Sex {
        /**
         * 男
         */
        MEN,
        /**
         * 女
         */
        FEMEN,
    }


    private Double weight;


    public static class Builder {
        private String name;

        private Integer age;

        private Sex sex;

        private String phoneNumber = "19595956868";

        private Double weight;

        public Builder(String name, Sex sex) {
            this.name = name;
            this.sex = sex;
        }

        public Builder weight(Double weight1) {
            weight = weight1;

            return this;
        }

        public Builder age(Integer age1) {
            age = age1;

            return this;
        }


        public BuildPeople build() {
            return new BuildPeople(this);
        }


    }

    private BuildPeople(Builder build) {
        name = build.name;

        sex = build.sex;

        age = build.age;

        phoneNumber = build.phoneNumber;

        weight = build.weight;

    }


    public static void main(String[] args) {

        BuildPeople zs = new BuildPeople.Builder("張三", Sex.MEN).age(20).weight(100.25).build();

        System.out.println("--->" + zs.name + "--->" + zs.sex);
    }
}
