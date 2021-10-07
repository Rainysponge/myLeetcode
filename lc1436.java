package LC;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc1436 {
    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        Set<String> allCity = new HashSet<>();

        for(List<String> path: paths){
            set.add(path.get(0));
            allCity.add(path.get(0));
            allCity.add(path.get(1));

        }

        for(String city: allCity){
            if(set.contains(city)){

            }else{
                return city;
            }
        }

        return "";

    }
}
