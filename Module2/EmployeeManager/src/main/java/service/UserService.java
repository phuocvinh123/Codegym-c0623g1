package service;

import model.Gender;
import model.User;
import utils.DateUtils;
import utils.FileUtils;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserService implements IUserService{
    private final String fileUser = "./data/users.txt";
    Scanner scanner=new Scanner(System.in);
    @Override
    public List<User> getAllUsers() {
        return FileUtils.readData(fileUser, User.class);
    }

    @Override
    public User findUser(long id) {
        List<User> users = getAllUsers();
        User u = users.stream().filter(user -> user.getId() == id).findFirst().orElseThrow();
        return u;
    }

    @Override
    public void updateUser(long id, User user) {

        /**
         for (User u : users) {
         if (u.getId() == id) {
         u.setAge(user.getAge());
         u.setName(user.getName());
         u.setDob(user.getDob());
         u.setGender(user.getGender());
         u.setPassword(user.getPassword());
         }
         }

        users.stream()
                .filter(u0-> u0.getId() == id)
                .map(u->{
                    u.setAge(user.getAge());
                    u.setName(user.getName());
                    u.setDob(user.getDob());
                    u.setGender(user.getGender());
                    u.setPassword(user.getPassword());
                    return u;
                });  **/
        List<User> users = getAllUsers();
        User userToUpdate = users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);

        if (userToUpdate != null) {
            System.out.println("Nhập thông tin mới:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.println("passwork: ");
            String pass = scanner.nextLine();
            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập ngày sinh: (dd-MM-yyyy)");
            LocalDate dob = DateUtils.parseDate(scanner.nextLine());

            System.out.println("Nhập giới tính: ");
            for (Gender eGender : Gender.values()) {
                System.out.println(eGender.getName() + " : " + eGender.getId());
            }
            int idGender = Integer.parseInt(scanner.nextLine());
            Gender gender = Gender.findById(idGender);
            userToUpdate.setDob(dob);
            userToUpdate.setGender(gender);
            userToUpdate.setName(name);
            userToUpdate.setAge(age);
            userToUpdate.setPassword(pass);


            // Cập nhật danh sách người dùng
            List<User> updatedUsers = users.stream()
                    .map(u -> u.getId() == id ? userToUpdate : u)
                    .collect(Collectors.toList());

            FileUtils.writeData(fileUser, users);
            System.out.println("Đã cập nhật thông tin người dùng!");
        } else {
            System.out.println("Không tìm thấy người dùng với ID đã nhập.");
        }

    }

    @Override
    public void deleteUser(long id) {
        List<User> users = getAllUsers();
        /**
         for (User u : users) {
         if (u.getId() == id) {
         users.remove(u);
         }
         }
         **/
        users.remove(
                users.stream().filter(u -> u.getId() == id).findFirst().get());
        FileUtils.writeData(fileUser, users);
    }

    @Override
    public void createUser(User user) {
        List<User> users = getAllUsers();
        users.add(user);

        FileUtils.writeData(fileUser, users);
    }

    @Override
    public void sortUser(long id) {
        List<User> users = getAllUsers();
        users.sort(Comparator.comparingLong(User::getId));
        FileUtils.writeData(fileUser, users);
    }
}
