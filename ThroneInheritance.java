package LC;

import java.util.*;

public class ThroneInheritance {
    Map<String, List<String>> dic = new HashMap<>();
    Set<String> dead = new HashSet<>();
    String king;


    public ThroneInheritance(String kingName) {
        king = kingName;
    }

    public void birth(String parentName, String childName) {
        List<String> kids = dic.getOrDefault(parentName, new ArrayList<String>());
        kids.add(childName);
        dic.put(parentName, kids);
    }

    public void death(String name) {
//        dic.remove(name);
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> res = new ArrayList<>();
        preorder(res, king);
        return res;
    }
    void preorder(List<String> ans, String kingName){
        if(!dead.contains(kingName)) {
            ans.add(kingName);
        }

        List<String> kids = dic.getOrDefault(kingName, new ArrayList<String>());

        for(String kid: kids){
            preorder(ans, kid);
        }


    }

    public String Successor(String x, List<String> curOrder){
        return "";
    }
}
