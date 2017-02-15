package org.myteacher.pojo;

import java.io.Serializable;

/**
 * Created by yh on 17-2-10.
 */
public class MyRoom implements Serializable {
    private static final long serialVersionUID = 145L;
    //教室的名字
    private String classroomname;
    //教室的id
    private String roomId;
    //教室类型
    private String roomType;
    //教室创建的时间
    private String roomTime;
    //教室图片的url
    private String roomPhoto;
    //教室的简介
    private String roomInfo;
    //教室的主人
    private String ownerId;

    public String getClassroomname() {
        return classroomname;
    }

    public void setClassroomname(String classroomname) {
        this.classroomname = classroomname;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomTime() {
        return roomTime;
    }

    public void setRoomTime(String roomTime) {
        this.roomTime = roomTime;
    }

    public String getRoomPhoto() {
        return roomPhoto;
    }

    public void setRoomPhoto(String roomPhoto) {
        this.roomPhoto = roomPhoto;
    }

    public String getRoomInfo() {
        return roomInfo;
    }

    public void setRoomInfo(String roomInfo) {
        this.roomInfo = roomInfo;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public MyRoom(String classroomname, String roomId, String roomType, String roomTime, String roomPhoto, String roomInfo, String ownerId) {
        this.classroomname = classroomname;
        this.roomId = roomId;
        this.roomType = roomType;
        this.roomTime = roomTime;
        this.roomPhoto = roomPhoto;
        this.roomInfo = roomInfo;
        this.ownerId = ownerId;
    }

    public MyRoom() {
    }

    @Override
    public String toString() {
        return "MyRoom{" +
                "classroomname='" + classroomname + '\'' +
                ", roomId='" + roomId + '\'' +
                ", roomType='" + roomType + '\'' +
                ", roomTime='" + roomTime + '\'' +
                ", roomPhoto='" + roomPhoto + '\'' +
                ", roomInfo='" + roomInfo + '\'' +
                ", ownerId='" + ownerId + '\'' +
                '}';
    }
}
