package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Test

class StatisticsUtilsTest {
    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero(){

        var tasks = listOf<Task>( Task("title","desc", isCompleted = false))
        var result = getActiveAndCompletedStats(tasks)

        assertThat(result.activeTasksPercent, `is`(100f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }
    @Test
    fun getActiveAndCompletedStats_Completed_returnsZeroHundred(){
        var tasks = listOf<Task>( Task("title","desc", isCompleted = true))
        var result = getActiveAndCompletedStats(tasks)

        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(100f))
    }
    @Test
    fun getActiveAndCompletedStats_TwoCompletedThreeUncompleted_returnsSixtyForty(){

        var tasks = listOf<Task>( Task("title","desc", isCompleted = true),
            Task("title","desc", isCompleted = true),
            Task("title","desc", isCompleted = false),
            Task("title","desc", isCompleted = false),
            Task("title","desc", isCompleted = false))
        var result = getActiveAndCompletedStats(tasks)

        assertThat(result.activeTasksPercent, `is`(60f))
        assertThat(result.completedTasksPercent, `is`(40f))
    }
}