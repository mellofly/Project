package com.it.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.it.json.AbstractJsonObject;
import com.it.json.AccountBean;
import com.it.po.Account;
import com.it.service.AccountService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;
    /**
     * consumes 用于指定处理何种请求的提交内容类型context-type，如果不是指定的类型，则不处理
     * method 用于指定请求的方法，可以设置单个或多个，如果请求方法不满足条件则会请求失败。设置post，就只支持post请求，不设置这个属性就两种请求都支持, method = RequestMethod.POST
     * @param requsetMap
     * @return
     * @throws Exception
     */
    @RequestMapping(method= RequestMethod.POST,value="/get")
    public @ResponseBody
    AccountBean getAccount(@RequestBody Map<String, String> requsetMap) throws Exception{
        Account account = new Account();
        AccountBean accountBean = new AccountBean();
        try{
            System.out.println("打印requsetMap："+requsetMap.toString());

            /*********业务逻辑开始**********/
            String code = requsetMap.get("code").toString();
            //判断用户是否存在
            // =accountService.findAccountByCode(code);
            account= accountService.selectAccountBycode(code);
            if(account.getName()==""||account.getName()==null) {
                AbstractJsonObject abstractJsonObject = new AbstractJsonObject();
                abstractJsonObject.setCode("-1");
                abstractJsonObject.setMsg("用户未注册请前往用户界面进行注册");
                accountBean.setAbstractJsonObject(abstractJsonObject);
                accountBean.setObj(account);
                return accountBean;
            }else{
                AbstractJsonObject abstractJsonObject = new AbstractJsonObject();
                abstractJsonObject.setCode("0");
                abstractJsonObject.setMsg("用户登陆成功");
                accountBean.setAbstractJsonObject(abstractJsonObject);
            }
            System.out.println("打印user" + account.toString());

            /*********业务逻辑结束**********/

        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("接口返回的json：" + JSON.toJSONString(account));
        accountBean.setObj(account);
        return accountBean;
    }
    @RequestMapping("/getAccountByCode")
    @ResponseBody
    public Account getUserByCode( String code)throws  Exception{

        return accountService.selectAccountBycode(code);
    }

    /**
     * consumes 用于指定处理何种请求的提交内容类型context-type，如果不是指定的类型，则不处理
     * method 用于指定请求的方法，可以设置单个或多个，如果请求方法不满足条件则会请求失败。设置post，就只支持post请求，不设置这个属性就两种请求都支持, method = RequestMethod.POST
     * @param requsetMap
     * @return
     * @throws Exception
     */
    @RequestMapping(method= RequestMethod.POST,value="/add")
    public @ResponseBody
    AccountBean addAccount(@RequestBody Map<String, String> requsetMap) throws Exception{
        Account account = new Account();
        AccountBean accountBean = new AccountBean();
        int flag=0;
        try{
            System.out.println("打印requsetMap："+requsetMap.toString());

            /*********业务逻辑开始**********/
            if(requsetMap!=null){
                account.setWx_id(requsetMap.get("wx_id").toString());
                account.setId(accountService.findmaxid());
                account.setName(requsetMap.get("name").toString());
                account.setPhone(requsetMap.get("phone").toString());
                account.setAddress(requsetMap.get("address").toString());
                flag=accountService.addAccount(account);
            }


            /*********业务逻辑结束**********/

        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("接口返回的json：" + JSON.toJSONString(account));
        if(flag>0){
            AbstractJsonObject abstractJsonObject = new AbstractJsonObject();
            abstractJsonObject.setCode("0");
            abstractJsonObject.setMsg("用户注册成功");
            accountBean.setAbstractJsonObject(abstractJsonObject);
        }else{
            AbstractJsonObject abstractJsonObject = new AbstractJsonObject();
            abstractJsonObject.setCode("-1");
            abstractJsonObject.setMsg("用户注册失败");
            accountBean.setAbstractJsonObject(abstractJsonObject);
        }
        accountBean.setObj(account);
        return accountBean;
    }

}