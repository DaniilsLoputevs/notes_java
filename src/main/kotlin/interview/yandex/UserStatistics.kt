package interview.yandex

/*
Есть последовательность запросов пользователей, каждый запрос —
это пара (currentTs, userId), запросы всегда приходят в отсортированном
по времени порядке.
Нужно уметь быстро отвечать: "сколько за последние k милисекунд было
пользователей, которые задали > limit запросов".

* отрабатывать за Амортизированную единицу.
*/
@Deprecated("TODO : Tests")
class UserStatistics(val k: Int, val limit: Int) {


//    private var innerMap = LinkedList<Pair<Long(currentTime),Long(user)>>();

    /** Register event for userId */
    fun event(userId: Long) {
        var currentTs = currentTimeInMs();
    }

    /** return count of users that exceed the limit for interval(currentTime-msIntervalLimit -- currentTimeMs)*/
    fun robotCount(): Int {
        var currentTs = currentTimeInMs();
        // place your code here

        return -1;
    }

    private fun currentTimeInMs(): Long {
        // do not need to implement
        return System.currentTimeMillis();
    }
}