package com.example.team14communicationsapp.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import com.example.team14communicationsapp.R
import com.example.team14communicationsapp.model.TagRepository
import com.example.team14communicationsapp.model.UserRepository
import com.example.team14communicationsapp.model.UserRepository.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val tagRepo: TagRepository,
    private val userRepo : UserRepository
) : ViewModel() {
    data class HomeUIState(
        val tagMap: Map<String, List<String>> = emptyMap<String, List<String>>(),
        val user: UserRepository.User = User("name","major", Icons.Outlined.Star)
    ){
        val tagCategory: List<String>
            get() = tagMap.keys.toList()
        val tags : List<List<String>>
            get() = tagMap.values.toList()
        val userName : String
            get() = user.name
        val userMajor : String
            get() = user.major
        val userProfilePic : ImageVector
            get() = user.profilePic

    }

    //need a UI State
    private val _uiState = mutableStateOf(HomeUIState())
    val uiState : State<HomeUIState> = _uiState

    init{
        loadDummyData()
    }

    private fun loadDummyData(){
        _uiState.value = _uiState.value.copy(
            tagMap = tagRepo.getAllCategories()
        )
    }

    fun changeProfilePic(newPic : ImageVector){
       _uiState.value = _uiState.value.copy(
           user = _uiState.value.user.copy(profilePic = newPic)
       )
    }

}