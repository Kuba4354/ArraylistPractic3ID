package service.serviceImpl;

import enums.Gender;
import model.DataBase;
import model.GeneredId;
import model.User;
import service.UserService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserServiceImpl implements UserService {
    @Override
    public String register() {
//        Scanner scanner = new Scanner(System.in);
//        User user = new User();
//        String email = "Kuba@gmail.com";
//        System.out.println("Напиши @email");
//        user.setEmail(scanner.nextLine());
//        if (email.equals(user.getEmail())) {
//            System.out.println("@email Успешно добавлено");
//        } else {
//            System.out.println("Не правильно");
//        }
//
//
//        int password = 1234;
//        System.out.println("Напиши пароль");
//        user.setPassword(scanner.nextInt());
//        if (password == user.getPassword()) {
//            System.out.println("Пароль Успешно добавлено");
//        } else {
//            System.out.println("Не правильно");
//        }
//
//        System.out.println("Напиши имя");
//        user.setFullName(scanner.nextLine(), scanner.nextLine());
//        user.setGender(Gender.FEMALE, Gender.MALE);
//        DataBase.users.add(user);
//        return "Успешно";
        User user = new User();
        user.setId(GeneredId.genUserId());
        System.out.println("напиши fulName");
        user.setFullName(new Scanner(System.in).nextLine());
        System.out.println("напиши email");
        user.setEmail(new Scanner(System.in).nextLine());
        System.out.println("напиши password");
        user.setPassword(new Scanner(System.in).nextInt());
        System.out.println("напиши gender");
        System.out.println(user.getGender(Gender.MALE, Gender.FEMALE));
        DataBase.users.add(user);
        return "Users registered successfully";
    }

    @Override
    public String login(String email, int password) {
        for (User user : DataBase.users) {
            if (user.getEmail().equals(email) && user.getPassword() == password) {
                return "такой логин сущшествуеть";
            }
        }
        return "такой логин не сущшествуеть";
    }

    @Override
    public User getUserByEmail(String email) {
        for (User user : DataBase.users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return DataBase.users;
    }
}
