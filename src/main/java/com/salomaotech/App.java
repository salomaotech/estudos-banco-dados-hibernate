package com.salomaotech;

import com.salomaotech.repository.JpaUtil;

public class App {

    public static void main(String[] args) {

        JpaUtil jpaUtil = new JpaUtil();

        jpaUtil.close();

    }

}
