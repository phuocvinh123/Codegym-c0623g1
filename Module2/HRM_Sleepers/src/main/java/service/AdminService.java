package service;

import model.AdminModel;
import utils.FileUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AdminService implements IAminService {
    private final String fileStaff = "./data/staff.txt";

    @Override
    public List<AdminModel> getAllStaff() {
        return FileUtils.readData(fileStaff, AdminModel.class);
    }

    @Override
    public AdminModel findStaffById(long id) {
        List<AdminModel> staff = getAllStaff();
        AdminModel s = staff.stream().filter(staff1 -> staff1.getId() == id).findFirst().orElseThrow();
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
            String pos = EditInformation.updatePosition(staffUpDate);
            String name = EditInformation.updateFullName(staffUpDate);
            String age = EditInformation.updateAge(staffUpDate);
            String gender = EditInformation.updateGender(staffUpDate);
            String bir = EditInformation.updateBirthday(staffUpDate);
            String cccd = EditInformation.updateCCCD(staffUpDate);
            String phone = EditInformation.updatePhone(staffUpDate);
            String address = EditInformation.updateAddress(staffUpDate);
            String email = EditInformation.updateEmail(staffUpDate);
            String code = EditInformation.updateCode(staffUpDate);
            // Cập nhật danh sách nhân viên
            FileUtils.writeData(fileStaff, staffs);
        } else {
            System.err.println("Không tìm thấy nhân viên với ID đã nhập.");
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
    public List<AdminModel> searchStaff(Long id) {
        List<AdminModel> staffs = getAllStaff();
        staffs = staffs.stream().filter(o -> o.getId() == id).collect(Collectors.toList());
        return staffs;
    }



}
