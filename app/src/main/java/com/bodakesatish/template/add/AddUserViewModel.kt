package com.bodakesatish.template.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bodakesatish.domain.model.Member
import com.bodakesatish.domain.repository.MemberRepository
import com.bodakesatish.domain.usecases.AddMemberUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddUserViewModel @Inject constructor(
    private val addMemberUseCase: AddMemberUseCase
) : ViewModel() {

    private val _response = MutableStateFlow<Boolean>(false)
    val response: StateFlow<Boolean> = _response.asStateFlow()

    fun addUser(member: Member) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(2000)
            val response = addMemberUseCase.invoke(member)
            viewModelScope.launch(Dispatchers.Main) {
                _response.value = response
            }
        }
    }

}