package LC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc638 {
    Map<List<Integer>, Integer> memo = new HashMap<List<Integer>, Integer>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int N = price.size();

        List<List<Integer>> filterSpecial = new ArrayList<>();

        for(List<Integer> sp: special){
            int count = 0;
            int totalPrice = 0;
            for(int i=0; i<N; i++){
                count += sp.get(i);
                totalPrice += sp.get(i) * price.get(i);
            }

            if(count > 0 && totalPrice > sp.get(N)){
                filterSpecial.add(sp);
            }

        }


        return dfs(price, needs, filterSpecial, N);

    }


    public int dfs(List<Integer> price, List<Integer> curNeeds, List<List<Integer>> filterSpecial, int n) {
        if (!memo.containsKey(curNeeds)) {
            int minPrice = 0;
            for (int i = 0; i < n; ++i) {
                minPrice += curNeeds.get(i) * price.get(i); // 不购买任何大礼包，原价购买购物清单中的所有物品
            }
            for (List<Integer> curSpecial : filterSpecial) {
                int specialPrice = curSpecial.get(n);
                List<Integer> nxtNeeds = new ArrayList<>();
                for (int i = 0; i < n; ++i) {
                    if (curSpecial.get(i) > curNeeds.get(i)) { // 不能购买超出购物清单指定数量的物品
                        break;
                    }
                    nxtNeeds.add(curNeeds.get(i) - curSpecial.get(i));
                }
                if (nxtNeeds.size() == n) { // 大礼包可以购买
                    minPrice = Math.min(minPrice, dfs(price, nxtNeeds, filterSpecial, n) + specialPrice);
                }
            }
            memo.put(curNeeds, minPrice);
        }
        return memo.get(curNeeds);
    }



}
