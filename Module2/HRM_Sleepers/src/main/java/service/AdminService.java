package service;

import model.AdminModel;
import utils.FileUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AdminService implements IAminService {
    private final String fileStaff="./data/staff.txt";
    Scanner scanner=new Scanner(System.in);
    @Override
    public List<AdminModel> getAllStaff() {
        return FileUtils.readData(fileStaff, AdminModel.class);
    }

    @Override
    public AdminModel findStaffById(long id) {
    List<AdminModel>staff=getAllStaff();
    AdminModel s=staff.stream().filter(staff1 -> staff1.getId()==id).findFirst().orElseThrow();
    return s;
    }

    @Override
    public void updateStaff(long id, AdminModel staff) {
        List<AdminModel> staffs = getAllStaff();
        AdminModel staffUpDate = staffs.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);

        if (staffUpDate != null) {
            System.out.println("Nhập thông tin mới: ");
            String pos = GetValue.getPosition("");
            String name = GetValue.getFullName("");
            int age = GetValue.getAge("");
            String gender = GetValue.getGender("");
            LocalDate bir = GetValue.getBirtDay("");
            String cccd = GetValue.getCccd("");
            String phone = GetValue.getPhone("");
            String address = GetValue.getAddress("");
            String email = GetValue.getEmail("");

            if (!pos.isEmpty()) {
                staffUpDate.setPosition(pos);
            }
            if (!name.isEmpty()) {
                staffUpDate.setFullName(name);
            }
            if (age != 0) {
                staffUpDate.setAge(age);
            }
            if (!gender.isEmpty()) {
                staffUpDate.setGender(gender);
            }
            if (bir != null) {
                staffUpDate.setBirthday(bir);
            }
            if (!cccd.isEmpty()) {
                staffUpDate.setCccd(cccd);
            }
            if (!phone.isEmpty()) {
                staffUpDate.setPhone(phone);
            }
            if (!address.isEmpty()) {
                staffUpDate.setAddress(address);
            }
            if (!email.isEmpty()) {
                staffUpDate.setEmail(email);
            }


            // Cập nhật danh sách nhân viên
//            List<Staff> updatedStaff = staffs.stream()
//                    .map(u -> u.getId() == id ? staffUpDate : u)
//                    .collect(Collectors.toList());
            FileUtils.writeData(fileStaff, staffs);
            System.out.println("Đã cập nhật thông tin nhân viên!");
        } else {
            System.out.println("Không tìm thấy nhân viên với ID đã nhập.");
        }

    }



    @Override
    public void deleteStaff(long id) {
        List<AdminModel> staffs = getAllStaff();
        staffs.remove(
                staffs.stream().filter(s -> s.getId() == id).findFirst().get());
        FileUtils.writeData(fileStaff, staffs);
    }

    @Override
    public void createStaff(AdminModel staff) {
        List<AdminModel> staffs = getAllStaff();
        staffs.add(staff);
        FileUtils.writeData(fileStaff, staffs);
    }

    @Override
    public List<AdminModel> searchStaff(String name) {
        List<AdminModel> staffs = getAllStaff();
        staffs = staffs.stream().filter(o -> o.getFullName().contains(name)).collect(Collectors.toList());
        return staffs;
    }



}
