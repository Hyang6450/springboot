package com.study.springboot202210hyang.IocAndDi;

public class Main {

    private final UserService userService;

    public Main(UserService userService) {
        this.userService = userService; // 결합도가 낮춘다.
        // this.userService = UserServiceImpl.getInstance(); main문에 의존하고 있으므로 결합도가 높다.
    }

    public void run() {
        userService.createUser();
        userService.getUsers();
        userService.updateUser();
        userService.deleteUser();
    }

    public static void main(String[] args) {
        // DI이다. 의존성 주입 => 결합도를 낮춰서 의존성을 주입해야한다. (객체 지향적개념으로 결합도는 낮고 응집도는 높아야한다.)
        // 스프링은 의존성을 자동으로 주입한다.
        UserService userService = UserServiceImpl.getInstance();

        Main main = new Main(userService);
        main.run();
    }

}
