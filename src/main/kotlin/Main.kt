import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import mingsin.demo.getData
import mingsin.demo.hello
import mingsin.demo.hello22

suspend fun main(args: Array<String>) {
//    coroutineScope {
//        launch {
//            async { hello() }
//            async { hello() }
//            async { hello() }
//            async { hello() }
//            async { hello() }
//            async { hello() }
//            getData(20).onStart {
//                println("start ....")
//            }.collect {
//                println("$it --->   ...")
//            }
//
//            hello()
//            hello()
//            hello()
//            hello()
//            hello()
//            hello()
//            hello()
//            hello()
//        }
//        println("hello from main")
//    }
//

//    hello22()


    println(1000 == 1000)
}