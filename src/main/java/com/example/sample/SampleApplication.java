package com.example.sample;

import com.example.sample.entity.Account;
import com.example.sample.entity.Card;
import com.example.sample.entity.Transaction;
import com.example.sample.entity.User;
import com.example.sample.entity.enumm.AccountType;
import com.example.sample.entity.enumm.TransactionType;
import com.example.sample.service.AccountService;
import com.example.sample.service.CardService;
import com.example.sample.service.TransactionService;
import com.example.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.sample.entity.enumm.AccountType.JARI;
import static com.example.sample.entity.enumm.TransactionType.DEPOSIT;
import static com.example.sample.entity.enumm.TransactionType.WITHDRAW;

@SpringBootApplication
public class SampleApplication implements CommandLineRunner {
@Autowired
    private AccountService accountService;
    @Autowired
    private CardService cardService;
    @Autowired
    private TransactionService transactionService;
       @Autowired
       private UserService userService;
//   @Qualifier("AccountServiceV2Impl")
//private AccountService accountService;
//    @Autowired
//    private ApplicationContext applicationContext;
    public static void main(String[] args) {

        SpringApplication.run(SampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user=new User(2l,"davod","family",30,"4270269139",LocalDate.of(1992,01,11));
        userService.save(user);
        cardService.save(new Card("2523"));
        Account account=new Account(user,"2523",AccountType.GHARZOL_HASANE,3);
        List<Transaction>transactions=new ArrayList<>();
//        account.setTransactions(transactions);

        Transaction transaction1=new Transaction(4,500.0, DEPOSIT,account);
        accountService.save(account);
        transactionService.save(transaction1);
//        Transaction transaction2=new Transaction(5,400.0, WITHDRAW,account);
//        transactionService.save(transaction2);
//        Transaction transaction3=new Transaction(6,300.0, DEPOSIT,account);
//        transactionService.save(transaction3);
//        transactions.add(transaction1);
//        transactions.add(transaction2);transactions.add(transaction3);

//
//       account.setTransactions(transactions);
        System.out.println(account.getId()+"++++++++++++++++++++++++++++++++");
        accountService.save(account);

//accountService.save(new Account("25232249"));
//        System.out.println(accountService.getAccounts());
//        System.out.println("======================================================");
//        for (String bean:applicationContext.getBeanDefinitionNames()
//             ) {
//            System.out.println(bean);
//        }
//        Card card=new Card(3l,"1111222233334444","314",LocalDate.of(2025,01,25),"2222");
//
//        User user=new User(2l,"davod","yadegari",30,"4270269138",LocalDate.of(1992,01,11));
//        List<Transaction>transactions=new ArrayList<>();
//        Transaction transaction=new Transaction(3l,250.0,new Date(2022,01,25),2,WITHDRAW);
//        Transaction transaction1=new Transaction(5l,300.0,new Date(2022,01,22),1,DEPOSIT);
//        Transaction transaction2=new Transaction(7l,500.0,new Date(2022,01,20),2,WITHDRAW);
//transactions.add(transaction1);
//transactions.add(transaction2);
//transactions.add(transaction);
//        accountService.save(new Account(1l,"125789634985",user,"2523",300.0,card,transactions,1,JARI));
//        System.out.println(accountService.findAll());

    }
}
