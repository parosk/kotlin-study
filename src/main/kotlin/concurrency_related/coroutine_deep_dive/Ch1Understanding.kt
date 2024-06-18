package concurrency_related.coroutine_deep_dive

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

/**
 * Problem for other concurrency methods
 *
 * typical scenario for concurrency
 *
 * val news = getNewsFromApi() // wait for IO
 * val sortedNews = news.sortedByDescending { it.publishedAt }
 * view.showNews(sortedNews)
 *
 * 1.Thread switching
 *  - memory leaks if thread is not cancelled
 *  - costly
 *  - hard to understand code
 *
 * 2. Callback
 *  - callback hell
 *
 * 3. RxJava/reactive
 *  - hard to learn
 */

/**
 * Coroutines
 *  workload that can be suspended
 *  when suspended, the thread is free to go
 *  once the data is ready, it can continus from where it stop
 */

/**
 * Coroutines
 *  workload that can be suspended
 *  when suspended, the thread is free to go
 *  once the data is ready, it can continus from where it stop
 */
//fun showNewsSequentially() {
//    // call happen sequentially
//    viewModelScope.launch {
//        val config = getConfigFromApi()
//        val news = getNewsFromApi(config)
//        val user = getUserFromApi() view . showNews (user, news)
//    }
//}
//
//fun showNewsParallel() {
//    // with the async keyword, workload are started in parallel
//    viewModelScope.launch {
//        val config = async { getConfigFromApi() }
//        val news = async { getNewsFromApi(config.await()) }
//        val user = async { getUserFromApi() } view . showNews (user.await(), news.await())
//    }
//}

fun mainWithThread() { repeat(100_000) {
    thread {
        Thread.sleep(1000L)
        print(".")
    } }
}

fun main() = runBlocking { repeat(100_000) {
    launch {
        delay(1000L)
        print(".") }
} }