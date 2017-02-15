package org.myteacher.pojo;

/**
 * Created by yh on 17-2-12.
 */
public class User {
    //用户ID
    private String userId;
    //用户头像
    private String photoUrl;
    //用户手机号
    private String phoneNumber;
    //用户密码
    private String password;
    //用户名
    private String userName;
    //用户性别
    private String userSex;
    //用户身份证号号码
    private String idUnmber;
    //用户出生日期
    private String bornDate;
    //用户的爱好
    private String userHooby;
    //用户设备ID
    private String toolId;
    //用户的money
    private String userMoney;
    //用户身高
    private String userHeight;
    //用户的星座
    private String userStar;
    //用户的个性签名
    private String userSignature;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getIdUnmber() {
        return idUnmber;
    }

    public void setIdUnmber(String idUnmber) {
        this.idUnmber = idUnmber;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    public String getUserHooby() {
        return userHooby;
    }

    public void setUserHooby(String userHooby) {
        this.userHooby = userHooby;
    }

    public String getToolId() {
        return toolId;
    }

    public void setToolId(String toolId) {
        this.toolId = toolId;
    }

    public String getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(String userMoney) {
        this.userMoney = userMoney;
    }

    public String getUserHeight() {
        return userHeight;
    }

    public void setUserHeight(String userHeight) {
        this.userHeight = userHeight;
    }

    public String getUserStar() {
        return userStar;
    }

    public void setUserStar(String userStar) {
        this.userStar = userStar;
    }

    public String getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature;
    }

    public User(String userId, String photoUrl, String phoneNumber, String password, String userName, String userSex, String identified, String bornDate, String userHooby, String toolId, String userMoney, String userHeight, String userStar, String userSignature) {
        this.userId = userId;
        this.photoUrl = photoUrl;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.userName = userName;
        this.userSex = userSex;
        this.idUnmber = idUnmber;
        this.bornDate = bornDate;
        this.userHooby = userHooby;
        this.toolId = toolId;
        this.userMoney = userMoney;
        this.userHeight = userHeight;
        this.userStar = userStar;
        this.userSignature = userSignature;
    }

    public User() {
    }

    public User(String userId,String photoUrl,String phoneNumber,String password,String userName){
        this.userId = userId;
        this.photoUrl = photoUrl;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.userName = userName;

    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", idUnmber='" + idUnmber + '\'' +
                ", bornDate='" + bornDate + '\'' +
                ", userHooby='" + userHooby + '\'' +
                ", toolId='" + toolId + '\'' +
                ", userMoney='" + userMoney + '\'' +
                ", userHeight='" + userHeight + '\'' +
                ", userStar='" + userStar + '\'' +
                ", userSignature='" + userSignature + '\'' +
                '}';
    }

}
