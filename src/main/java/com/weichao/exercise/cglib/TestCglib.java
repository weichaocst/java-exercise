package com.weichao.exercise.cglib;

/**
 * @author weichao
 * @Description
 * @date 2019/4/16 14:47
 */
public class TestCglib {

    public static void main(String[] args) {
        UserServiceCglib cglib = new UserServiceCglib();
        UserServiceImpl bookFacedImpl = (UserServiceImpl) cglib.getInstance(new UserServiceImpl());
        bookFacedImpl.addUser();
    }
}
