package com.shelly.ambar.chatup.Utils;

public class BMHelper {
  public  static boolean isNullOrEmpthy(String s){
        if(s!=null){
            if(!s.isEmpty()){
                return false;
            }
        }
        return true;
    }
}
