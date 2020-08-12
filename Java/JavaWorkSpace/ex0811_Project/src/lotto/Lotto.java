package ch10;

import java.util.ArrayList;
import java.util.*;


public class Lotto {

    List<Integer> list = new ArrayList<Integer>(6);
    static int cnt = 0;

    public void createLottoNo(){
        while(cnt < 6){//1
            int lottoNo =(int)(Math.random()*45)+1;//5
            if(  this.isCompareNo(lottoNo) ){
                list.add(cnt, lottoNo);
                cnt++;
            }
        }
    }
    /**
     * 로또번호 비교하는 부분
     return : true : 중복아님, false이면 중복 * */
    public boolean isCompareNo(int lottoNo ){
        for(int i : list){
            if(list.contains(lottoNo) ){
                return false;
            }
        }
        return true;
    }

    public void lottoSort(){
        Collections.sort(list);
    }

    public void printLotto(){
        for(int i=0; i<6;i++){
            System.out.print(list.get(i)+"\t");
        }
    }



    public static void main(String [] args) {
        Lotto lotto = new Lotto();
        lotto.createLottoNo();
        lotto.lottoSort();
        lotto.printLotto();

    }


}

