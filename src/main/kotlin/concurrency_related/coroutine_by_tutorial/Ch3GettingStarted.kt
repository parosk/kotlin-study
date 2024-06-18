package concurrency_related.coroutine_by_tutorial

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main() {
    (1..10000).forEach {
        GlobalScope.launch {
            val threadName = Thread.currentThread().name
            println("$it printed on thread $threadName")
        }
        Thread.sleep(1000)
    }

}
/**
 * when launch a coroutine, CoroutineScope is needed
 * it govern the lifecycle of the coroutine
 * GlobalScope - coroutine lifecycle is bounded to  lifecycle of the application
 *
 * `launch` -  function is called coroutine builder
 *  in the launch function
 *  public fun CoroutineScope.launch(
 *  context: CoroutineContext = EmptyCoroutineContext,
 *   start: CoroutineStart = CoroutineStart.DEFAULT,
 *   block: suspend CoroutineScope.() -> Unit
 *   ): Job
 *
 *  CoroutineContext - persistenct dataset of contextual information about current coroutine
 *  CoroutineStart - mode where you can start a coroutine
 *
 *  DEFAULT - Immediately schedules a coroutine for execution to its context
 *  LAZY - start coroutine lazily
 *  ATOMIC - same as DEFAULT but cannot be cancelled before it starts
 *  UNDISPATCHED - run coroutine imediately until first suspension
 *
 *  Job is returned
 */