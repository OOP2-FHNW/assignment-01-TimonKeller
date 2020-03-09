package portfolio;


import portfolio.investments.Investment;

import java.util.HashSet;

public class Portfolio<T extends Investment> {

    HashSet<T> investments = new HashSet<>();

    public Portfolio() {
    }

    public boolean contains(T invest) {

        return investments.contains(invest);
    }

    public void buy(T ubs) {

        if (investments.contains(ubs)) {
            for (T shares : investments) {
                if (shares.equals(ubs)) {
                    shares.setCount(shares.getCount() + 1);
                }
            }
        } else {
            investments.add(ubs);
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
            }

        }return null;

    }
}

