package demo.yc.httpproxymode.http.proxyimpl

import demo.yc.httpproxymode.http.inface.ICallBack
import demo.yc.httpproxymode.http.inface.IHttpProxy

/**
 * @author:    YC
 * @date:    2019/3/21 0021
 * @time:    21:01
 *@detail:   代理模式中的代理类，实现规范接口
 */
// object修饰，是一种饿汉式单例模式
object HttpHelper:IHttpProxy {

    // 代理类中，持有真实对象的引用
    private var httpProxyImpl :IHttpProxy? = null

    // 初始化真实代理对象
    fun init(httpImpl:IHttpProxy){
        httpProxyImpl = httpImpl
    }

    override fun getHttp(url: String, callback: ICallBack) {
        // 运行时，调用真实对象方法
        httpProxyImpl!!.getHttp(url,callback)
    }

    override fun postHttp(url: String, params: Map<String, Any>, callback: ICallBack) {
        // 运行时，调用真实对象方法
        httpProxyImpl!!.postHttp(url,params,callback)
    }


}