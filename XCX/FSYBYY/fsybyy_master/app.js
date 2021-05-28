// app.js
App({
  onLaunch() {
    // 展示本地存储能力
    const logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    // 登录
    wx.login({
      success: res => {
        var that =this;
        console.log(res)
        
        
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
        wx.request({
          //url: 'http://localhost:8080/springmvcnote_war/account/get.do',
          url:'https://xcx.fan/springmvcnote/account/get.do',
          data: {"code":res.code},
          method: 'POST',
          header: {
            "Content-Type":"application/json"
          },
          success: function(res){
            var jsonText = JSON.stringify(res.data);
            console.log(jsonText);
            if(res.data.abstractJsonObject.code==-1){
              // wx.showModal({
              //   title: '提示',
              //   content: res.data.message,
              //   success: function (res) {
              //     if (res.confirm) {
              //       console.log('用户点击确定')
              //       wx.reLaunch({
              //         url: "/pages/adduser/index"
              //       })
              //     } else if (res.cancel) {
              //       console.log('用户点击取消')
              //     }
              //   }
              // })
              wx.reLaunch({
                url: "/pages/adduser/index"
              })
              that.globalData.code=res.data.obj.wx_id;
              console.log(res.data.abstractJsonObject.msg);
              
            }
            console.log(that.globalData.code);
            //var show="表单提交返回jsonusername:"+jsonText+"age:"+res.data.message.msg;
            //console.log(show);
          }
          
        })
      }
    })
  },
  globalData: {
    userInfo: {},
    user:{},
    code:null
  }
})
