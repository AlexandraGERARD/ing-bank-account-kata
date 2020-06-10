package fr.ing.interview.kata.business.impl.manager;

import fr.ing.interview.kata.business.contract.manager.AccountManager;
import fr.ing.interview.kata.model.bean.Account;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("accountManager")
public class AccountManagerImpl extends AbstractManager implements AccountManager {
    //TODO modifier
    @Override
    public Account getAccount(String pId) {
        Account vProjet = new Account(pId);
        vProjet.setAccountNumber("Projet n°" + pId);
        return vProjet;

    }

    @Override
    public List<Account> getAccountsList() {
        List<Account> vList = new ArrayList<>();

        for (int vI = 0; vI < 9; vI++) {
            Account vProjet = new Account(String.valueOf(vI));
            vProjet.setAccountNumber("Projet n°" + vI);
            vList.add(vProjet);
        }

        return vList;
    }
}
