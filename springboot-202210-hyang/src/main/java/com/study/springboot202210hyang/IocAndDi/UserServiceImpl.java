package com.study.springboot202210hyang.IocAndDi;

public class UserServiceImpl implements UserService {
    // 싱글톤
    private static UserServiceImpl instance = null;
    private UserServiceImpl(){}
    public static UserServiceImpl getInstance() {
        if(instance == null){
            return new UserServiceImpl();
        }
        return instance;
    }


    @Override
    public void createUser() {
        System.out.println("사용자 등록");
    }

    @Override
    public void getUsers() {
        System.out.println("사용자 조회");
    }

    @Override
    public void updateUser() {
        System.out.println("사용자 수정");
    }

    @Override
    public void deleteUser() {
        System.out.println("사용자 삭제");
    }
}
