package mobile.jetpackrecycleview.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var lst = MutableLiveData<ArrayList<Books>>()
    var newlist = arrayListOf<Books>()

    fun add(blog: Books){
        newlist.add(blog)
        lst.value=newlist
    }

    fun remove(blog: Books){
        newlist.remove(blog)
        lst.value=newlist
    }

}