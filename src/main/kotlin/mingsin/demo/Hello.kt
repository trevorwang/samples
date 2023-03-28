package mingsin.demo

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

suspend fun hello() {
    delay(1999)
    println("hello -world " + System.currentTimeMillis())

}


suspend fun getData(i: Int): Flow<String> = flow {
    emit("$i : First")
    delay(500)
    emit("$i: Second")
}

fun hello22() {
    val o = object {
        var a = 1
    }

    var b = with(o) {}
    println(b)
    println(o.let {
        "abc"
    })

    println(o.apply { a =3  })
    println(o.also { o.a = 2 })



    var a = 3

    var c = 4

    println( c.also { c = 5 })
    println(a.apply { a = 6 })
    println(a)
}