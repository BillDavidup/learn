package com.bill.learn.base.common.tool;

public class MD5UtilTest {
    private static final String url = "https://ks3-cn-beijing.ksyun.com/bkt-tj-mv-transcode-kscn/kvideo-transcoding/A677E76094156FAA696F7BD9B27839C8-1547257803268-480p.mp4";
    private static final String resultUrl = "https://kvideo.cdn.pandora.xiaomi.com/kvideo-transcoding/A677E76094156FAA696F7BD9B27839C8-1547257803268-480p.mp4";
    private static final String key = "kingsoft";

    /**
     * main
     * @param args args
     */
    public static void main(String[] args) {
        String rs = MD5Util.md5(key);
        System.out.println("rs:" + rs);
        System.out.println(transMd5String(url));
    }

    /**
     *
     * @param url 视频地址url
     * @return 防盗链url
     */
    public static String transMd5String(String url) {
        String cdn = "https://kvideo.cdn.pandora.xiaomi.com";
        //原视频地址截取：
        String[] strings = url.split("/");
        //路径：kvideo-transcoding
        String path = strings[4];
        //视频名称：A677E76094156FAA696F7BD9B27839C8-1547257803268-480p.mp4
        String videoName = strings[5];
        //时间戳：单位秒
        Long timeStamp = System.currentTimeMillis() / 1000;
        System.out.println(timeStamp);
        StringBuilder stringBuilder = new StringBuilder();
        //格式：kingsoft/kvideo-transcoding/A677E76094156FAA696F7BD9B27839C8-1547257803268-480p.mp41547282335
        stringBuilder.append(key).append("/").append(path).append("/").append(videoName).append(timeStamp);
        String md5String = stringBuilder.toString();
        System.out.println("md5String:" + md5String);
        String md5 = MD5Util.md5(md5String);
        System.out.println(md5);

        for (int i = 0; i < strings.length; i++) {
            System.out.println(i + ":" + strings[i]);
        }
        //https://kvideo.cdn.pandora.xiaomi.com/kvideo-transcoding/A677E76094156FAA696F7BD9B27839C8-1547257803268-480p.mp4?k=2B086DC065935F6B4F1D5742008F0C56&t=1547282897
        return new StringBuilder()
                .append(cdn).append("/")
                .append(path).append("/")
                .append(videoName).append("?")
                .append("k=").append(md5)
                .append("&t=").append(timeStamp)
                .toString();
    }
}
