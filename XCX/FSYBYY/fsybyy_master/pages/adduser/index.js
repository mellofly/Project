// pages/addressAdd/index.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    region: ['辽宁省', '抚顺市', '城区'],
    customItem: '全部',
    code:'',
    name:'',
    mobile:'',
    detailed:'',
    address:'',
    addressIs:true,
    _id:null
  },
  bindRegionChange: function (e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    console.log(e.detail.value)
    this.setData({
      region: e.detail.value
    })
  },
  bindKeyName: function (e) {
    this.setData({
      name: e.detail.value
    })
  },
  bindKeyMobile: function (e) {
    this.setData({
      mobile: e.detail.value
    })
  },
  bindKeyDetailed: function (e) {
    this.setData({
      detailed: e.detail.value
    })
  },
  submitFun: function () {
    if (this.data.addressIs){ //添加
      wx.request({
       // url: 'http://localhost:8080/springmvcnote_war/account/add.do',
        url:'https://xcx.fan/springmvcnote/account/add.do',
        data: {
        wx_id: app.globalData.code,
        name: this.data.name,
        phone: this.data.mobile,
        address: this.data.region+this.data.detailed,
        },
        method: 'POST',
        header: {
          "Content-Type":"application/json"
        },
        success: function(res){
          var jsonText = JSON.stringify(res.data);
          console.log(jsonText);
          if(res.data.abstractJsonObject.code==-1){
            console.log(res.data.abstractJsonObject.msg);
          }else{
            app.globalData.user=res.data.obj;
            console.log(app.globalData.user);
            wx.reLaunch({
              url: "/pages/homepage/index"
            })
          }
        }
      })
    }else{
      app.http('v1/user/editCity', {
        name: this.data.name,
        mobile: this.data.mobile,
        detailed: this.data.detailed,
        city: this.data.region,
        id: this.data._id
      }, 'POST')
        .then(res => {
          if (res.code == 200) {
            wx.navigateBack({
              delta: 1
            })
          }
        })
    }
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    if (options.id){
      this.setData({
          region: options.city.split(','),
          name: options.name,
          mobile: options.mobile,
          detailed: options.detailed,
          _id: options.id,
          addressIs:false
      })
    }
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  }
})