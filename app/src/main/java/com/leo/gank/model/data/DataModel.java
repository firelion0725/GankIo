package com.leo.gank.model.data;

import com.leo.gank.comm.model.BaseModel;
import com.leo.gank.model.comm.GankModel;

import java.util.List;

/**
 * Created by leo on 2016/4/11
 * Function 网络获取随机数据实体
 */
public class DataModel extends BaseModel {

    /**
     * error : false
     * results : [{"_id":"56cc6d1d421aa95caa7075a6","createdAt":"2015-11-02T03:53:25.557Z","desc":"11.2","publishedAt":"2015-11-02T04:16:06.443Z","type":"福利","url":"http://ww2.sinaimg.cn/large/7a8aed7bgw1exmhnx76z9j20go0dcabp.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d1d421aa95caa7075c5","createdAt":"2015-05-20T02:08:17.148Z","desc":"5.20。 520爱你，就给你甜甜的笑。今日特推！~~（づ￣3￣）づ╭❤～","publishedAt":"2015-05-21T10:05:06.527Z","type":"福利","url":"http://ww1.sinaimg.cn/large/7a8aed7bgw1esahpyv86sj20hs0qomzo.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d1d421aa95caa707573","createdAt":"2015-10-28T03:38:43.164Z","desc":"10.28","publishedAt":"2015-10-28T03:51:19.336Z","type":"福利","url":"http://ww3.sinaimg.cn/large/7a8aed7bjw1exgp509vvxj20fr0nm786.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d1d421aa95caa7075bf","createdAt":"2015-11-17T01:30:17.111Z","desc":"11.17","publishedAt":"2015-11-17T04:00:01.748Z","type":"福利","url":"http://ww4.sinaimg.cn/large/7a8aed7bjw1ey3ptkta45j20hs0qomzy.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d1d421aa95caa707642","createdAt":"2015-07-15T03:56:42.772Z","desc":"7.15","publishedAt":"2015-07-15T04:05:29.732Z","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034gw1eu3bld296jj20df0kudhx.jpg","used":true,"who":"小贝"},{"_id":"56cc6d1d421aa95caa7075e0","createdAt":"2015-05-24T06:18:30.492Z","desc":"5.25","publishedAt":"2015-05-25T03:37:08.537Z","type":"福利","url":"http://ww4.sinaimg.cn/large/7a8aed7bgw1esfbgw6vc3j20gy0pedic.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d1d421aa95caa70757d","createdAt":"2015-10-29T01:49:31.473Z","desc":"10.29","publishedAt":"2015-10-29T04:40:26.424Z","type":"福利","url":"http://ww3.sinaimg.cn/large/7a8aed7bjw1exhrgo769bj20ox0zk42e.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d1d421aa95caa7075c5","createdAt":"2015-05-20T02:08:17.148Z","desc":"5.20。 520爱你，就给你甜甜的笑。今日特推！~~（づ￣3￣）づ╭❤～","publishedAt":"2015-05-21T10:05:06.527Z","type":"福利","url":"http://ww1.sinaimg.cn/large/7a8aed7bgw1esahpyv86sj20hs0qomzo.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d1d421aa95caa70757d","createdAt":"2015-10-29T01:49:31.473Z","desc":"10.29","publishedAt":"2015-10-29T04:40:26.424Z","type":"福利","url":"http://ww3.sinaimg.cn/large/7a8aed7bjw1exhrgo769bj20ox0zk42e.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d1d421aa95caa707692","createdAt":"2015-06-12T01:31:07.31Z","desc":"6.12","publishedAt":"2015-06-12T03:48:54.790Z","type":"福利","url":"http://ww4.sinaimg.cn/large/7a8aed7bgw1et11xp5wwij20hs0qotb2.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d1d421aa95caa70757d","createdAt":"2015-10-29T01:49:31.473Z","desc":"10.29","publishedAt":"2015-10-29T04:40:26.424Z","type":"福利","url":"http://ww3.sinaimg.cn/large/7a8aed7bjw1exhrgo769bj20ox0zk42e.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d1d421aa95caa7075b1","createdAt":"2015-11-02T23:46:36.247Z","desc":"11.3","publishedAt":"2015-11-03T06:04:59.454Z","type":"福利","url":"http://ww2.sinaimg.cn/large/7a8aed7bjw1exng5dd728j20go0m877n.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d1d421aa95caa70762f","createdAt":"2015-06-02T12:52:59.4Z","desc":"6.3\u2014\u2014（1）","publishedAt":"2015-06-03T04:59:44.403Z","type":"福利","url":"http://ww3.sinaimg.cn/large/7a8aed7bgw1esq1f0899qj20hs0qo780.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d1d421aa95caa7075c5","createdAt":"2015-05-20T02:08:17.148Z","desc":"5.20。 520爱你，就给你甜甜的笑。今日特推！~~（づ￣3￣）づ╭❤～","publishedAt":"2015-05-21T10:05:06.527Z","type":"福利","url":"http://ww1.sinaimg.cn/large/7a8aed7bgw1esahpyv86sj20hs0qomzo.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d1d421aa95caa70755a","createdAt":"2015-10-26T01:16:49.787Z","desc":"10.26","publishedAt":"2015-10-26T03:52:58.746Z","type":"福利","url":"http://ww1.sinaimg.cn/large/7a8aed7bjw1exe9ssy2gsj20qo0hndjr.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d1c421aa95caa707523","createdAt":"2015-11-04T10:33:50.564Z","desc":"11.5","publishedAt":"2015-11-05T04:02:52.968Z","type":"福利","url":"http://ww4.sinaimg.cn/large/7a8aed7bjw1exp4h479xfj20hs0qoq6t.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d1d421aa95caa7075c5","createdAt":"2015-05-20T02:08:17.148Z","desc":"5.20。 520爱你，就给你甜甜的笑。今日特推！~~（づ￣3￣）づ╭❤～","publishedAt":"2015-05-21T10:05:06.527Z","type":"福利","url":"http://ww1.sinaimg.cn/large/7a8aed7bgw1esahpyv86sj20hs0qomzo.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d1d421aa95caa7075a6","createdAt":"2015-11-02T03:53:25.557Z","desc":"11.2","publishedAt":"2015-11-02T04:16:06.443Z","type":"福利","url":"http://ww2.sinaimg.cn/large/7a8aed7bgw1exmhnx76z9j20go0dcabp.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d1d421aa95caa70757d","createdAt":"2015-10-29T01:49:31.473Z","desc":"10.29","publishedAt":"2015-10-29T04:40:26.424Z","type":"福利","url":"http://ww3.sinaimg.cn/large/7a8aed7bjw1exhrgo769bj20ox0zk42e.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d1d421aa95caa707637","createdAt":"2015-06-16T01:02:36.279Z","desc":"6.16","publishedAt":"2015-06-16T05:56:27.410Z","type":"福利","url":"http://ww3.sinaimg.cn/large/7a8aed7bgw1et5nl9mno8j20hs0qoacj.jpg","used":true,"who":"张涵宇"}]
     */

    private List<GankModel> results;

    public List<GankModel> getResults() {
        return results;
    }

    public void setResults(List<GankModel> results) {
        this.results = results;
    }

}
