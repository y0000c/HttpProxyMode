package demo.yc.httpproxymode.http.inface

/**
 * @author:    YC
 * @date:    2019/3/21 0021
 * @time:    20:55
 *@detail:  代理模式中用于规范代理类和真实类行为的接口
 */
interface IHttpProxy {
    fun getHttp(url: String, callback: ICallBack)
    fun postHttp(url: String, params: Map<String, Any>, callback: ICallBack)
}