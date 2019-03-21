package demo.yc.httpproxymode.http.proxyimpl

import android.os.Handler
import android.os.Looper
import demo.yc.httpproxymode.http.inface.ICallBack
import demo.yc.httpproxymode.http.inface.IHttpProxy
import okhttp3.*
import java.io.IOException

/**
 * @author:    YC
 * @date:    2019/3/21 0021
 * @time:    21:18
 *@detail:   代理模式中的真实实体类。这里使用的okHttp
 */
class OkHttpProxyImpl : IHttpProxy {

    // 声名主线程handler
    val handler = Handler(Looper.getMainLooper())

    override fun getHttp(url: String, callback: ICallBack) {
        // 创建okHttpClient对象
        val mOkHttpClient = OkHttpClient()
        //创建一个Request
        val request = Request.Builder()
            .url(url)
            .build()
        //new call
        val call = mOkHttpClient.newCall(request)
        //请求加入调度
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                handler.post {
                    callback.onFailure(e.toString())
                }
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val string = response.body()?.string()
                    handler.post {
                        callback.onSuccess(string!!)
                    }
                } else {
                    handler.post {
                        callback.onFailure(response.message())
                    }
                }
            }

        })
    }

    override fun postHttp(url: String, params: Map<String, Any>, callback: ICallBack) {
    }
}