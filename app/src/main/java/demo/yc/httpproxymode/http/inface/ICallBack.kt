package demo.yc.httpproxymode.http.inface

/**
 * @author:    YC
 * @date:    2019/3/21 0021
 * @time:    20:46
 *@detail:   定义网络请求基类接口回调
 */
interface ICallBack {
    fun onSuccess(result: String)
    fun onFailure(result: String)
}