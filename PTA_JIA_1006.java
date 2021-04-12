package LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PTA_JIA_1006 {
    public void solution(){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String unlockMan = "";
        String unlockTime = "";
        String lockedMan = "";
        String lockedTime = "";
        List<String> unlockTList = new ArrayList<>();
        List<String> lockTList = new ArrayList<>();
        int N = Integer.parseInt(s);
        while (N>0){
            N--;
            String info = in.nextLine();
//            System.out.println(info);
            List<String> infoList = new ArrayList<>();
            infoList = Arrays.asList(info.split(" "));
//            for (String value : infoList) System.out.printf("%s\t", value);
//            System.out.println("");
            if(unlockMan.equals("")) {
                // Init
                unlockMan = infoList.get(0);
                unlockTime = infoList.get(1);
                lockedMan = infoList.get(0);
                lockedTime = infoList.get(2);
                unlockTList = Arrays.asList(infoList.get(1).split(":"));
                lockTList = Arrays.asList(infoList.get(2).split(":"));
            }
            else{

                List<String> unlockInput = new ArrayList<>();
                List<String> lockTInput = new ArrayList<>();
                unlockInput = Arrays.asList(infoList.get(1).split(":"));
                lockTInput = Arrays.asList(infoList.get(2).split(":"));
                boolean unlock = false, lock = false;
                for(int i=0;i<3;i++){
//                    System.out.printf("%d\t%d\t", Integer.parseInt(unlockInput.get(i)),
//                            Integer.parseInt(unlockTList.get(i)));
                    if(Integer.parseInt(unlockInput.get(i))<Integer.parseInt(unlockTList.get(i))){

                        unlock = true;
                        break;
                    }else if(Integer.parseInt(unlockInput.get(i))==Integer.parseInt(unlockTList.get(i))){
                        continue;
                    }else{
                        break;
                    }

                }
//                System.out.println("");
                for(int i=0;i<3;i++){
//                    System.out.printf("%d\t%d\t", Integer.parseInt(lockTInput.get(i)),
//                            Integer.parseInt(lockTList.get(i)));
                    if(Integer.parseInt(lockTInput.get(i))>Integer.parseInt(lockTList.get(i))){
                        lock = true;
                        break;
                    }else if(Integer.parseInt(lockTInput.get(i))==Integer.parseInt(lockTList.get(i))){
                        continue;
                    }else{
                        break;
                    }
                }

                if(unlock){
                    unlockMan = infoList.get(0);
                    unlockTime = infoList.get(1);
                }
                if(lock){
                    lockedMan = infoList.get(0);
                    lockedTime = infoList.get(2);
                }
                unlockTList = Arrays.asList(unlockTime.split(":"));
                lockTList = Arrays.asList(lockedTime.split(":"));

            }

        }
        System.out.printf("%s %s", unlockMan, lockedMan);
    }

}
