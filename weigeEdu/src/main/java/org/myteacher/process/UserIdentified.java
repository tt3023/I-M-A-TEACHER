package org.myteacher.process;

import org.apache.log4j.Logger;
import org.myteacher.contants.Params;
import org.myteacher.util.JedisUtil;
import org.myteacher.util.JsonUtil;

import java.util.Map;

/**
 * Created by yh on 17-2-10.
 */
public class UserIdentified {
    //{“data”：{"userId":"1213",“phoneNumber”：“13545640028”,"idNumber":"421087199511225014","code":"123",},"flag":“useridentified”}
    private JedisUtil jedisUtil = new JedisUtil();
    private static Logger Log = Logger.getLogger(UserIdentified.class);
    private String result;
    public String identifiedUser(String data){
        Log.debug("UserIdentified.identifiedUser param "+data);
        //将得到的json转为map
        Map<String,Object> map = JsonUtil.strToMap(data);
        Log.debug("Useridentified map is "+map);
        //验证验证码
        String code = map.get("code").toString();
        Log.debug("Useridentified code is "+code);
        if(code == "@@@@@@"){
            //验证手机号
            String tempNumber = map.get("phoneNumber").toString();
            Log.debug("Useridentified tempNumber is "+tempNumber);
            if(jedisUtil.exists(tempNumber)){
                //为用户完善身份信息
                String userId = map.get("userId").toString();
                Log.debug("Useridentified userId is"+userId);
                String idNumber = map.get("idNumber").toString();
                jedisUtil.hset(userId,"idNumber",idNumber);
                result = Params.SUCCESS + "";
            }else {
                return Params.FAILD+"";
            }
        }else {
            return Params.FAILD+"";
        }
        return result;
    }
}
