package com.mars.edu.web.model.xio;

import com.chris.poi.xls.XlsColumn;
import com.chris.poi.xls.XlsSheet;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:16
 * Use for:
 */
@XlsSheet("user_info")
public class UserInfoXio {
    @XlsColumn("用户ID")
    private int userId;
    @XlsColumn("昵称")
    private String nickName;
    @XlsColumn("头像地址")
    private String photoUrl;
    @XlsColumn("性别")
    private int gender;
    @XlsColumn("身份证号码")
    private String identityCardCode;
    @XlsColumn("QQ")
    private String qqCode;
    @XlsColumn("个人主页")
    private String siteUrl;
    @XlsColumn("描述")
    private String description;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdentityCardCode() {
        return identityCardCode;
    }

    public void setIdentityCardCode(String identityCardCode) {
        this.identityCardCode = identityCardCode;
    }

    public String getQqCode() {
        return qqCode;
    }

    public void setQqCode(String qqCode) {
        this.qqCode = qqCode;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
