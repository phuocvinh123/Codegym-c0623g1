package bai8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManagerCard {
     List<LoanCard>loanCards;

    public ManagerCard() {
        this.loanCards = new ArrayList<>();
    }
    public  void AddLoanCard(LoanCard loanCard){this.loanCards.add(loanCard);}
    public boolean delete(String id ) {
        LoanCard Cards = this.loanCards.stream().filter(loanCard -> loanCard.getId().equals(id)).findFirst().orElse(null);
            if (loanCards == null) {
            return false;
        }
        this.loanCards.remove(Cards);
        return true;
    }
    public  List<LoanCard> searchLoanCard(String id){
        return this.loanCards.stream().filter(loanCard -> loanCard.getId().contains(id)).collect(Collectors.toList());
    }
    public void showLoanCard(){
        this.loanCards.forEach(loanCard -> System.out.println(loanCard.toString()));
    }
}
