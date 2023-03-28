package mingsin.demo


class MovingAverage(private val size: Int) {
    private val queue = mutableListOf<Int>()
    fun next(value: Int): Double {
        if (queue.size >= size)
            queue.removeAt(0)
        queue.add(value)
        var sum = 0
        for (i in queue) {
            sum += i
        }

        return sum / queue.size.toDouble()
    }
}