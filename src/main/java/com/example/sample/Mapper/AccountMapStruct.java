package com.example.sample.Mapper;

import com.example.sample.dto.AccountDto;
import com.example.sample.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserMapStruct.class,CardMapStruct.class})
public interface AccountMapStruct {
    @Mapping(source ="userDto" ,target ="user" )
    @Mapping(source ="cardDto" ,target = "card")
    Account toAccount(AccountDto accountDto);
    @Mapping(source ="user" ,target ="userDto" )
    @Mapping(source ="card" ,target = "cardDto")
    AccountDto toAccountDto(Account account);
    @Mapping(source ="userDto" ,target ="user" )
    @Mapping(source ="cardDto" ,target = "card")
    List<Account> toAccount(List<AccountDto> accountDto);
    @Mapping(source ="user" ,target ="userDto" )
   @Mapping(source ="card" ,target = "cardDto")
    List<AccountDto> toAccountDto(List<Account>accounts);
}