package com.it.util.wx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.it.po.Account;
import com.it.util.http.HttpRequest;

/**
 * 微信登录相关的工具类
 */
public class WxLogUtils {
    /**
     * 向微信服务器去请求，根据小程序传来的code获取openID
     * @param loginCode
     * @return
     */
    public static Account jsCode2Session(String loginCode){
//        if(loginCode==null||loginCode.length()<=0){
//            return ReturnData.fail("参数有误");
//        }
        //loginCode="1232312";
        //请求服务器参数
        String params="appid="+SettingUtils.WX_APPID+"&secret="+SettingUtils.WX_APPSECRET
                +"&js_code="+loginCode+"&grant_type="+SettingUtils.GRANT_TYPE_AUTHORIZATION_CODE;
        //发送请求
        String value = HttpRequest.sendGet(UrlUtils.GET_SESSION_BY_CODE,params);
        JSONObject jsonObject = JSON.parseObject(value);
        if(jsonObject==null){
            return null;
        }
        Integer errcode = (Integer)jsonObject.get("errcode");
        String errmsg = (String)jsonObject.get("errmsg");
        if(errcode!=null&&errcode!=0){
            return null;
        }
        String openid = (String)jsonObject.get("openid");
        Account account = new Account();
        account.setWx_id(openid);
        return account;
    }
}
