package com.cg.controller;

import com.cg.model.Customer;
import com.cg.model.Deposit;
import com.cg.model.Transfer;
import com.cg.model.Withdraw;
import com.cg.service.customer.ICustomerService;
import com.cg.service.deposit.IDepositService;
import com.cg.service.transfer.ITransferService;
import com.cg.service.withdraw.IWithdrawService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;


@Controller
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IDepositService depositService;
    @Autowired
    private ITransferService transferService;
    @Autowired

    private IWithdrawService withdrawService;


    @GetMapping
    public String showListPage(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);

        return "customer/list";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        model.addAttribute("customer", new Customer());

        return "customer/create";
    }

    @GetMapping("/delete/{customerId}")
    public String showDeletePage(@PathVariable Long customerId, Model model) {
        Customer customerOptional = customerService.findById(customerId);
        if(customerOptional==null){
            model.addAttribute("success", false);
            model.addAttribute("message", "id not found");
            model.addAttribute("customer", new Customer());
            return "customer/delete";
        }
        model.addAttribute("customer", customerOptional);
        return "customer/delete";
    }

    @GetMapping("/deposit/{customerId}")
    public String showDepositPage(@PathVariable Long customerId, Model model) {
        Customer customerOptional = customerService.findById(customerId);
        Deposit deposit = new Deposit();
        deposit.setCustomer(customerOptional);
        model.addAttribute("deposit", deposit);
        return "customer/deposit";
    }

    @GetMapping("/withdraw/{customerId}")
    public String showWithdrawPage(@PathVariable Long customerId, Model model) {

        Customer customerOptional = customerService.findById(customerId);
        if(customerOptional==null){
            model.addAttribute("success", false);
            model.addAttribute("message", "id not found");
            model.addAttribute("withdraw", new Withdraw());
            return "customer/withdraw";
        }
        Withdraw withdraw = new Withdraw();
        withdraw.setCustomer(customerOptional);

        model.addAttribute("withdraw", withdraw);

        return "customer/withdraw";
    }

    @GetMapping("/transfer/{senderId}")
    public String showTransferPage(@PathVariable Long senderId, Model model) {
        Customer customerOptional = customerService.findById(senderId);
        List<Customer> recipients = customerService.findAllByIdNot(senderId);
        if(customerOptional==null) {
            model.addAttribute("success", false);
            model.addAttribute("message", "id not found");
            model.addAttribute("transfer", new Transfer());
            model.addAttribute("recipients", recipients);
            return "customer/transfer";
        }

        Transfer transfer = new Transfer();
        transfer.setSender(customerOptional);
        model.addAttribute("transfer", transfer);
        model.addAttribute("recipients", recipients);

        return "customer/transfer";
    }

    @GetMapping("/update/{id}")
    public String ShowUpdate(@PathVariable long id, Model model) {
        Customer customerOptional = customerService.findById(id);
        if(customerOptional==null){
            model.addAttribute("success", false);
            model.addAttribute("message", "id not found");
            model.addAttribute("customer", new Customer());
        }else{
            model.addAttribute("success", true);
            model.addAttribute("customer", customerOptional);
        }

        return "customer/update";
    }

    @GetMapping("/transfer_histories")
    public String ShowTransferHistories(Model model) {
        List<Transfer> transfers = transferService.findAll();
        model.addAttribute("transfers", transfers);
        return "customer/transfer_histories";
    }

    @GetMapping("/history-deposit")
    public String showHistoryDepositPage(Model model) {
        List<Deposit> deposits = depositService.findAll();
        model.addAttribute("deposits", deposits);

        return "customer/history-deposit";
    }

    @GetMapping("/history-withdraw")
    public String showHistoryWithdrawPage(Model model) {
        List<Withdraw> withdraws = withdrawService.findAll();
        model.addAttribute("withdraws", withdraws);

        return "customer/history-withdraw";
    }

    @PostMapping("/create")
    public String createCustomer(@Validated @ModelAttribute Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("success", false);
            model.addAttribute("message", "Created unsuccessful");
            model.addAttribute("error", true);
            model.addAttribute("customer", customer);
            return "customer/create";
        }
        customerService.save(customer);
        model.addAttribute("customer", new Customer());
        model.addAttribute("success", true);
        model.addAttribute("message", "Created successfully");
        return "customer/create";
    }

    @PostMapping("/update/{id}")
    public String updateCustomer(@Validated @ModelAttribute Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("success", false);
            model.addAttribute("message", "UnUpdated successfully");
            model.addAttribute("error", true);
            model.addAttribute("customer", customer);
            return "customer/update";
        }
        customerService.save(customer);
        model.addAttribute("success", true);
        model.addAttribute("message", "Updated successfully");
        return "customer/update";
    }

    @PostMapping("/delete/{customerId}")
    public String deleteCustomer(@PathVariable Long customerId ,@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.deleteById(customerId);
        redirectAttributes.addFlashAttribute("success", true);
        redirectAttributes.addFlashAttribute("message", "Deleted successfully");

        return "redirect:/customers";
    }

    @PostMapping("/deposit/{customerId}")
    public String deposit( @PathVariable Long customerId, @ModelAttribute Deposit deposit,BindingResult bindingResult, Model model) {
        new Deposit().validate(deposit,bindingResult);
        Customer customer = customerService.findById(customerId);
        deposit.setCustomer(customer);
        if (bindingResult.hasErrors()) {
            model.addAttribute("success", false);
            model.addAttribute("error", true);
            model.addAttribute("deposit", deposit);
            return "customer/deposit";
        }
//        customerService.deposit(deposit);
        depositService.save(deposit);
        deposit.setTransactionAmount(null);
        model.addAttribute("deposit", new Deposit(customerService.findById(customerId)));
        model.addAttribute("success", true);
        model.addAttribute("message", "Deposit successfully");

        return "customer/deposit";
    }

    @PostMapping("/withdraw/{customerId}")
    public String Withdraw(@PathVariable Long customerId, @ModelAttribute Withdraw withdraw,BindingResult bindingResult, Model model) {
        new Withdraw().validate(withdraw,bindingResult);
        Customer customer = customerService.findById(customerId);
        withdraw.setCustomer(customer);



        if (withdrawService.isValidWithdrawal(withdraw)) {
//            customerService.withdraw(withdraw);
            withdrawService.save(withdraw);
            model.addAttribute("success", true);
            model.addAttribute("message", "Withdrawal successful");
        } else {
            if (bindingResult.hasErrors()) {
                model.addAttribute("success", false);
                model.addAttribute("message", "Invalid withdrawal");
                model.addAttribute("error", true);
                model.addAttribute("withdraw", withdraw);
                return "customer/withdraw";
            }
        }

        withdraw.setTransactionAmount(null);
        model.addAttribute("withdraw", new Withdraw(customerService.findById(customerId)));

        return "customer/withdraw";
    }

    @PostMapping("/transfer/{senderId}")
    public String Transfer(@PathVariable Long senderId, @ModelAttribute Transfer transfer, @RequestParam Long recipientId, Model model) {
        Customer sender = customerService.findById(senderId);
        Customer recipient = customerService.findById(recipientId);
        transfer.setSender(sender);
        transfer.setRecipient(recipient);

        if (transferService.isValidTransfer(transfer)) {
            customerService.transfer(transfer);
            transferService.save(transfer);
            transfer.setTransferAmount(null);
            model.addAttribute("success", true);
            model.addAttribute("message", "Transfer successful");
        } else {
            model.addAttribute("success", false);
            model.addAttribute("message", "Invalid transfer");
        }

        List<Customer> recipients = customerService.findAllByIdNot(senderId);
        model.addAttribute("transfer", transfer);
        model.addAttribute("recipients", recipients);

        return "customer/transfer";
    }

}
