package com.mars.edu.web.model.orm;

import javax.persistence.*;
import java.util.Objects;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 11:13
 * Use for:
 */
@Entity
@Table(name = "sys_user_info", schema = "db_mars_edu", catalog = "")
public class SysUserInfoEntity {
    private int id;
    private int userId;
    private String nickName;
    private String photoUrl;
    private byte gender;
    private String identityCardCode;
    private String qqCode;
    private String siteUrl;
    private String description;
    private byte status;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "nick_name", nullable = false, length = 20)
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Basic
    @Column(name = "photo_url", nullable = false, length = 512)
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Basic
    @Column(name = "gender", nullable = false)
    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "identity_card_code", nullable = false, length = 18)
    public String getIdentityCardCode() {
        return identityCardCode;
    }

    public void setIdentityCardCode(String identityCardCode) {
        this.identityCardCode = identityCardCode;
    }

    @Basic
    @Column(name = "qq_code", nullable = false, length = 13)
    public String getQqCode() {
        return qqCode;
    }

    public void setQqCode(String qqCode) {
        this.qqCode = qqCode;
    }

    @Basic
    @Column(name = "site_url", nullable = true, length = 128)
    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 20)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysUserInfoEntity that = (SysUserInfoEntity) o;
        return id == that.id &&
                userId == that.userId &&
                gender == that.gender &&
                status == that.status &&
                Objects.equals(nickName, that.nickName) &&
                Objects.equals(photoUrl, that.photoUrl) &&
                Objects.equals(identityCardCode, that.identityCardCode) &&
                Objects.equals(qqCode, that.qqCode) &&
                Objects.equals(siteUrl, that.siteUrl) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, nickName, photoUrl, gender, identityCardCode, qqCode, siteUrl, description, status);
    }
}
