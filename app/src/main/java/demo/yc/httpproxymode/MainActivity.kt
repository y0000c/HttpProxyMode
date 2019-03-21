package demo.yc.httpproxymode

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import demo.yc.httpproxymode.entity.Author
import demo.yc.httpproxymode.http.inface.IHttpCallBack
import demo.yc.httpproxymode.http.proxyimpl.HttpHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // wanandroid开放的api,非常感谢鸿洋大神,获取公众号列表
    val URL = "https://wanandroid.com/wxarticle/chapters/json"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        json_get_btn.setOnClickListener {
            HttpHelper.getHttp(URL, object : IHttpCallBack<Author>() {
                override fun onSuccess(result: Author) {
                    json_result_tv.text = result.getInfo()
                    Toast.makeText(
                        this@MainActivity,
                        "请求成功", Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onFailure(result: String) {
                    json_result_tv.text = result
                    Toast.makeText(
                        this@MainActivity,
                        "请求失败", Toast.LENGTH_SHORT
                    ).show()
                }
            })
        }
    }
}
