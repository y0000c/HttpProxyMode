package demo.yc.httpproxymode

import android.app.Application
import demo.yc.httpproxymode.http.proxyimpl.HttpHelper
import demo.yc.httpproxymode.http.proxyimpl.OkHttpProxyImpl

/**
 * @author:    YC
 * @date:    2019/3/21 0021
 * @time:    21:16
 *@detail:
 */
class MyApp :Application() {
    override fun onCreate() {
        super.onCreate()
        HttpHelper.init(OkHttpProxyImpl()) // 设置真实代理对象
    }
}