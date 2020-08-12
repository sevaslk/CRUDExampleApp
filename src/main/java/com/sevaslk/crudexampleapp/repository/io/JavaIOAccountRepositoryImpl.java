package com.sevaslk.crudexampleapp.repository.io;

import com.sevaslk.crudexampleapp.model.Account;
import com.sevaslk.crudexampleapp.model.AccountStatus;
import com.sevaslk.crudexampleapp.repository.AccountRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.sevaslk.crudexampleapp.repository.io.JavaIOUtil.*;

public class JavaIOAccountRepositoryImpl implements AccountRepository {

    private final String ACCOUNTS_TXT = "src/main/resources/accounts.txt";

    @Override
    public List<Account> getAll() throws IOException {
        return getAccounts();
    }

    @Override
    public Account getById(Long id) throws IOException {
        List<Account> accountsList = getAccounts();
        return accountsList.stream()
                .filter(account -> account.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public Account save(Account newAccount) throws IOException {
        if (Files.exists(Paths.get(ACCOUNTS_TXT))) {
            List<Account> accountsList = getAccounts();
            Long generatedId = generatedId(accountsList);
            newAccount.setId(generatedId);
            newAccount.setStatus(AccountStatus.ACTIVE);
            accountsList.add(newAccount);
            writeStringToFile(convertListToString(accountsList), ACCOUNTS_TXT);
        } else {
            Files.createFile(Paths.get(ACCOUNTS_TXT));
            save(newAccount);
        }
        return newAccount;
    }

    private Long generatedId(List<Account> accountsList) {
        return accountsList.get(accountsList.size() - 1).getId() + 1;
    }

    @Override
    public Account update(Account newAccount) throws IOException {
        List<Account> accountsList = getAccounts();
        for (int i = 0; i < accountsList.size(); i++) {
            Account element = accountsList.get(i);
            if (element.getId().equals(newAccount.getId())) {
                accountsList.set(i, newAccount);
            }
        }
        writeStringToFile(convertListToString(accountsList), ACCOUNTS_TXT);
        return newAccount;
    }

    @Override
    public void deleteById(Long id) throws IOException {
        List<Account> accountList = getAccounts();
        accountList.removeIf(item -> item.getId().equals(id));
        writeStringToFile(convertListToString(accountList), ACCOUNTS_TXT);
    }

    private List<Account> getAccounts() throws IOException {
        List<Account> accountList = new ArrayList<>();
        String files = readFile(ACCOUNTS_TXT);
        String[] accountsStringArray = files.split("/");
        for (String element : accountsStringArray) {
            String[] accountItemStringArray = element.split(",");
            accountList.add(new Account(Long.parseLong(accountItemStringArray[0]), AccountStatus.valueOf(accountItemStringArray[1])));
        }
        return accountList;
    }
}
