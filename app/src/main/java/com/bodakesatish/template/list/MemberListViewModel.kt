package com.bodakesatish.template.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bodakesatish.domain.model.Member
import com.bodakesatish.domain.usecases.GetMemberUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MemberListViewModel @Inject constructor(
    private val getMemberListUseCase: GetMemberUseCase
) : ViewModel() {

    private val tag = this.javaClass.simpleName

    private val _memberList = MutableStateFlow<List<Member>>(emptyList())
    val memberList: StateFlow<List<Member>> = _memberList.asStateFlow()

    init {
        Log.d(tag, "$tag->init")
    }

    fun getMemberList() {
        Log.d(tag, "$tag->getMemberList")
        viewModelScope.launch(Dispatchers.IO) {
            getMemberListUseCase.invoke().collect { list ->
                _memberList.value = list
                Log.d(tag, "In $tag $list")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i(tag , "$tag->onCleared")
    }
}