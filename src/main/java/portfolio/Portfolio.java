package portfolio;


import portfolio.investments.Investment;

import java.util.HashSet;

public class Portfolio<T extends Investment> {

    HashSet<T> investments = new HashSet<>();

    public Portfolio() {
    }

    public boolean contains(T ubs) {

        for (T shares : investments) {
            if (shares.equals(ubs)) {
                return true;
            }

        } return false;
    }

    public void buy(T ubs) {

        if (investments.contains(ubs)) {
            for (T shares : investments) {
                if (!shares.equals(ubs)) {
                    investments.add(ubs);
                }
            }
        } else {
            for(T shares : investments)
            shares.setCount(shares.getCount() + 1);
        }
    }

    public void sell(String ubs, double number) {

        T shares = getShare(ubs);
        if (shares != null) {
            shares.setCount(shares.getCount() - number);
            if (shares.getCount() == 0) {
                shares.setCount(0);
                investments.remove(shares);
            }
        }
    }


    public T getShare(String ubs) {

        for (T shares : investments) {
            if (shares.getTitel().equals(ubs)) {
                return shares;
            } else {
                return null;
            }
        }
        return null;
    }
}

