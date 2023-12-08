package model;

import java.io.Serializable;

public class Manager extends Employee  implements Serializable {
    private int bonus;
    private String card;
    private int cardLimit;
    public Manager(){

    }
    public Manager(
            String pesel, String name, String surname, String salary, String phone,
            String bonus, String card, String cardLimit
    ){
        super(pesel, name, surname, salary, phone);
        this.bonus = Integer.parseInt(bonus);
        this.card = card;
        this.cardLimit = Integer.parseInt(cardLimit);
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public int getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(int cardLimit) {
        this.cardLimit = cardLimit;
    }
}
