package com.dawang.wechat.message.resp;

import com.dawang.wechat.message.resp.BaseMessage;

/**
 * ClassName: ImageMessage
 * @Description: 图片消息
 * @author dapengniao
 * @date 2016 年 3 月 8 日 下午 5:58:10
 */
public class ImageMessage extends BaseMessage {

    private Image Image;

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        Image = image;
    }

}