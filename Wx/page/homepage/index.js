// page/homepage/index.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    inputShowed:false,
    inputVal:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var _this = this;
    if (app.globalData.userInfo) {
        this.setData({
            userInfo: app.globalData.userInfo,
            hasUserInfo: true,
        });
    }
    else if (this.data.canIUse) {
        app.userInfoReadyCallback = function (res) {
            _this.setData({
                userInfo: res.userInfo,
                hasUserInfo: true,
            });
        };
    }
    else {
        wx.getUserInfo({
            success: function (res) {
                app.globalData.userInfo = res.userInfo;
                _this.setData({
                    userInfo: res.userInfo,
                    hasUserInfo: true,
                });
            },
        });
    }
    this.setData({
      search:this.search.bind(this)
    })
  },
  getUserInfo: function (e) {
    console.log(e);
    app.globalData.userInfo = e.detail.userInfo;
    this.setData({
        userInfo: e.detail.userInfo,
        hasUserInfo: true,
    });
  },
  search: function (value){
    return new Promise((resolve,reject)=>{
      setTimeout(()=>{
        resolve([{text: '搜索结果',value: 1},{text:'搜索结果2',value:2}])
      },200)
    })
  },
  selectResult:function(e){
    console.log('select result',e.detail)
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