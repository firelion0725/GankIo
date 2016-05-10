package com.leo.gank.model.day;

import com.leo.gank.comm.model.BaseModel;
import com.leo.gank.model.comm.GankModel;

import java.util.List;

/**
 * Created by leo on 2016/4/11
 * Function 每日数据实体
 */
public class DayModel extends BaseModel {


    /**
     * category : ["iOS","拓展资源","前端","Android","App","休息视频","瞎推荐","福利"]
     * error : false
     * results : {"Android":[{"_id":"5709e4616776590f5a0ecb78","createdAt":"2016-04-10T13:28:01.470Z","desc":"react-native redux 实现干货APP","publishedAt":"2016-04-11T12:37:49.993Z","source":"web","type":"Android","url":"https://github.com/zhongjie-chen/rn_rank","used":true,"who":null},{"_id":"570ae8956776590f5a0ecb7f","createdAt":"2016-04-11T07:58:13.202Z","desc":"Hacker Scripts","publishedAt":"2016-04-11T12:37:49.993Z","source":"chrome","type":"Android","url":"https://github.com/NARKOZ/hacker-scripts","used":true,"who":"蒋朋"},{"_id":"570b00dd6776590f62db7b8c","createdAt":"2016-04-11T09:41:49.371Z","desc":"你真的会用Gson吗?Gson使用指南","publishedAt":"2016-04-11T12:37:49.993Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/e740196225a4","used":true,"who":null},{"_id":"570b01be6776590f5a0ecb84","createdAt":"2016-04-11T09:45:34.418Z","desc":"实战Kotlin@Android（一）：项目配置和语言转换","publishedAt":"2016-04-11T12:37:49.993Z","source":"web","type":"Android","url":"http://blog.chengdazhi.com/index.php/157","used":true,"who":null},{"_id":"570b15f36776590f62db7b8d","createdAt":"2016-04-11T11:11:47.909Z","desc":"APK 瘦身记，如何实现高达 53% 的压缩效果","publishedAt":"2016-04-11T12:37:49.993Z","source":"web","type":"Android","url":"http://mp.weixin.qq.com/s?__biz=MzIwMTI4Nzk5Ng==&mid=402517579&idx=1&sn=2951ec2b3aef4ce6f6a5c06ad4c49d73&scene=1&srcid=03306GCdiG6G4yhZIaDsHVL9&from=groupmessage&isappinstalled=0#wechat_redirect","used":true,"who":null},{"_id":"570b17ec6776590f57c4e0b8","createdAt":"2016-04-11T11:20:12.709Z","desc":"一行代码，圆角风雨无阻，告别离屏渲染性能损耗","publishedAt":"2016-04-11T12:37:49.993Z","source":"chrome","type":"Android","url":"http://zyden.vicp.cc/zycornerradius/","used":true,"who":"有时放纵"}],"App":[{"_id":"570a38996776590f62db7b85","createdAt":"2016-04-10T19:27:21.803Z","desc":"高仿开眼的一个 iOS 开源 App","publishedAt":"2016-04-11T12:37:49.993Z","source":"web","type":"App","url":"https://github.com/lyimin/EyepetizerApp","used":true,"who":"咕咚"}],"iOS":[{"_id":"56fe951967765933dbbd21b1","createdAt":"2016-04-01T23:34:49.546Z","desc":"iOS单例ViewController与UIImage对象内存优化","publishedAt":"2016-04-11T12:37:49.993Z","source":"chrome","type":"iOS","url":"http://blog.talisk.cn/blog/2016/03/30/iOS-Singleton-ViewController-Performance-optimization/?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io","used":true,"who":"Andrew Liu"},{"_id":"56fe953a67765933dbbd21b2","createdAt":"2016-04-01T23:35:22.195Z","desc":"Swift Runtime分析：还像OC Runtime一样吗？","publishedAt":"2016-04-11T12:37:49.993Z","source":"chrome","type":"iOS","url":"http://mp.weixin.qq.com/s?__biz=MzA3ODg4MDk0Ng==&mid=403153173&idx=1&sn=c631f95b28a0eb4b842a9494e43a30e5","used":true,"who":"Andrew Liu"},{"_id":"56fe955f67765933d8be9211","createdAt":"2016-04-01T23:35:59.137Z","desc":"iOS冰与火之歌 \u2013 利用XPC过App沙盒","publishedAt":"2016-04-11T12:37:49.993Z","source":"chrome","type":"iOS","url":"http://drops.wooyun.org/papers/14170?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io","used":true,"who":"Andrew Liu"},{"_id":"5707ac286776590f57c4e09e","createdAt":"2016-04-08T21:03:36.603Z","desc":"iOS开发中Cordova的使用 ","publishedAt":"2016-04-11T12:37:49.993Z","source":"chrome","type":"iOS","url":"https://segmentfault.com/a/1190000004887392?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io","used":true,"who":"Andrew Liu"},{"_id":"5707ac4b6776590f57c4e09f","createdAt":"2016-04-08T21:04:11.556Z","desc":"NiceGesture:现在你可以舒服的使用UIGesture了","publishedAt":"2016-04-11T12:37:49.993Z","source":"chrome","type":"iOS","url":"http://www.jianshu.com/p/54dd81995f8e?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io","used":true,"who":"Andrew Liu"},{"_id":"570925566776590f5a0ecb75","createdAt":"2016-04-09T23:52:54.458Z","desc":"在 Swift 项目中实现侧滑菜单-利用 SWRevealViewController","publishedAt":"2016-04-11T12:37:49.993Z","source":"chrome","type":"iOS","url":"https://blog.coding.net/blog/Creating-a-Sidebar-Menu-Using-SWRevealViewController-in-Swift","used":true,"who":"Andrew Liu"},{"_id":"570af8096776590f608f0bcf","createdAt":"2016-04-11T09:04:09.679Z","desc":"网易漫画Swift混编实践","publishedAt":"2016-04-11T12:37:49.993Z","source":"chrome","type":"iOS","url":"http://mp.weixin.qq.com/s?__biz=MzA3ODg4MDk0Ng==&mid=403474677&idx=1&sn=5163adb2d80aa5b4f0099f79e6d783e1#rd","used":true,"who":"Dear宅学长"}],"休息视频":[{"_id":"570a4f606776590f57c4e0af","createdAt":"2016-04-10T21:04:32.206Z","desc":"这脑洞太大我已无力承受。[笑cry]","publishedAt":"2016-04-11T12:37:49.993Z","source":"chrome","type":"休息视频","url":"http://weibo.com/p/2304446b4d386c016ef3844b67838f2453883a","used":true,"who":"LHF"}],"前端":[{"_id":"5709cb7c6776590f62db7b84","createdAt":"2016-04-10T11:41:48.412Z","desc":"Blur Admin：免费的Angular Bootstrap后台管理模板","publishedAt":"2016-04-11T12:37:49.993Z","source":"chrome","type":"前端","url":"http://akveo.com/blur-admin/#/dashboard","used":true,"who":"SASUKE40"},{"_id":"570b196c6776590f57c4e0b9","createdAt":"2016-04-11T11:26:36.681Z","desc":"angular2-mean-starter：Angular2应用创建模板","publishedAt":"2016-04-11T12:37:49.993Z","source":"chrome","type":"前端","url":"https://github.com/giacomocerquone/angular2-mean-starter","used":true,"who":"SASUKE40"}],"拓展资源":[{"_id":"5709c16d6776590f5a0ecb76","createdAt":"2016-04-10T10:58:53.640Z","desc":"如何简单入门使用Travis-CI持续集成","publishedAt":"2016-04-11T12:37:49.993Z","source":"chrome","type":"拓展资源","url":"https://github.com/nukc/how-to-use-travis-ci","used":true,"who":"蒋朋"}],"瞎推荐":[{"_id":"570b00876776590f5a0ecb83","createdAt":"2016-04-11T09:40:23.277Z","desc":"啪啪啪，打脸程序员的9本指南！","publishedAt":"2016-04-11T12:37:49.993Z","source":"web","type":"瞎推荐","url":"https://github.com/gaohailang/blog/issues/18","used":true,"who":null},{"_id":"570b00c36776590f608f0bd2","createdAt":"2016-04-11T09:41:23.779Z","desc":"2015年移动应用质量大数据报告(Kotlin : 空指针异常是 Java 代码最常出现的错误, 科科)","publishedAt":"2016-04-11T12:37:49.993Z","source":"web","type":"瞎推荐","url":"http://bugly.qq.com/bbs/forum.php?mod=viewthread&tid=763&extra=page%3D1","used":true,"who":null}],"福利":[{"_id":"570b1c5a6776590f62db7b8e","createdAt":"2016-04-11T11:39:06.138Z","desc":"4.11","publishedAt":"2016-04-11T12:37:49.993Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/7a8aed7bjw1f2sm0ns82hj20f00l8tb9.jpg","used":true,"who":"张涵宇"}]}
     */

    private ResultsEntity results;
    private List<String> category;

    public ResultsEntity getResults() {
        return results;
    }

    public void setResults(ResultsEntity results) {
        this.results = results;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public static class ResultsEntity {

        private List<GankModel> Android;
        private List<GankModel> App;
        private List<GankModel> iOS;
        private List<GankModel> 休息视频;
        private List<GankModel> 前端;
        private List<GankModel> 拓展资源;
        private List<GankModel> 瞎推荐;
        private List<GankModel> 福利;

        public List<GankModel> getAndroid() {
            return Android;
        }

        public void setAndroid(List<GankModel> Android) {
            this.Android = Android;
        }

        public List<GankModel> getApp() {
            return App;
        }

        public void setApp(List<GankModel> App) {
            this.App = App;
        }

        public List<GankModel> getIOS() {
            return iOS;
        }

        public void setIOS(List<GankModel> iOS) {
            this.iOS = iOS;
        }

        public List<GankModel> get休息视频() {
            return 休息视频;
        }

        public void set休息视频(List<GankModel> 休息视频) {
            this.休息视频 = 休息视频;
        }

        public List<GankModel> get前端() {
            return 前端;
        }

        public void set前端(List<GankModel> 前端) {
            this.前端 = 前端;
        }

        public List<GankModel> get拓展资源() {
            return 拓展资源;
        }

        public void set拓展资源(List<GankModel> 拓展资源) {
            this.拓展资源 = 拓展资源;
        }

        public List<GankModel> get瞎推荐() {
            return 瞎推荐;
        }

        public void set瞎推荐(List<GankModel> 瞎推荐) {
            this.瞎推荐 = 瞎推荐;
        }

        public List<GankModel> get福利() {
            return 福利;
        }

        public void set福利(List<GankModel> 福利) {
            this.福利 = 福利;
        }

    }
}
