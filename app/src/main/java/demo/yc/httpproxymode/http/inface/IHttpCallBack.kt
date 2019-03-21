package demo.yc.httpproxymode.http.inface

import com.google.gson.Gson
import java.lang.reflect.ParameterizedType

/**
 * @author:    YC
 * @date:    2019/3/21 0021
 * @time:    20:54
 *@detail:
 * 在基类回调接口中，多一层封装，主要用来解析json。
 * 避免在每个回调实例中，编写解析json的代码
 *
 */
@Suppress("UNCHECKED_CAST")
abstract class IHttpCallBack<T> : ICallBack {
    override fun onSuccess(result: String) {
        val obj = (Gson().fromJson(result, getRealType(this)))
        val realObj: T? = try {
            obj as T
        } catch (e: Exception) {
            null
        }
        onSuccess(realObj!!)
    }

    abstract fun onSuccess(result: T)  // 最终解析后的回调函数

    /**
     * 获取泛型的真实对象
     */
    private fun getRealType(any: Any): Class<*> {
        val genType = any.javaClass.genericSuperclass
        val params = (genType as ParameterizedType).actualTypeArguments
        return params[0] as Class<*>
    }

}