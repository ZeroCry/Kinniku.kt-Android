package net.kboy.kinniku_kt.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import net.kboy.kinniku_kt.data.Schedule

class ScheduleRepository {
    private val db = FirebaseFirestore.getInstance()
    private val schedules = MutableLiveData<List<Schedule>>()

    fun getSchedules(): LiveData<List<Schedule>> {
        db.collection("Event")
            .get()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val result = it.result

                    if (result != null)
                        schedules.value = result.toObjects(Schedule::class.java)
                }
            }
        return schedules
    }
}