package demo.yc.httpproxymode.entity

/**
 * @author:    YC
 * @date:    2019/3/21 0021
 * @time:    22:11
 *@detail:
 */
class Author {
    var data: List<Data> = arrayListOf()
    var errorCode: Int = 0
    var errorMsg: String = ""

    class Data{
        var children: List<String> = arrayListOf()
        var courseId: Int = 0
        var id: Int = 0
        var name: String = ""
        var order: Long = 0
        var parentChapterId: Int = 0
        var userControlSetTop: Boolean = false
        var visible: Int = 0
    }

    fun getInfo():String{
        val result  = StringBuffer()
        for(d in data)
        {
            result.append(d.name).append("==")
        }
        return result.toString()
    }
}