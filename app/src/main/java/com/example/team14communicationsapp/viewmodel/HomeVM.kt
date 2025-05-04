package com.example.team14communicationsapp.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.viewModelScope
import com.example.team14communicationsapp.model.TagRepository
import com.example.team14communicationsapp.model.UserRepository
import com.example.team14communicationsapp.model.UserRepository.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val tagRepo: TagRepository,
    private val userRepo: UserRepository
) : ViewModel() {

    data class HomeUIState(
        val tagMap: Map<String, List<String>>, // All available
        val selectedTags: Map<String, MutableList<String>> = emptyMap(), // 👈 NEW
        val user: UserRepository.User
    ) {
        val tagCategory: List<String> get() = selectedTags.keys.toList()
        val tags: List<List<String>> get() = selectedTags.values.toList()
        val userName: String get() = user.name
        val userMajor: String get() = user.major
        val userProfilePic: ImageVector? get() = user.profilePic
    }

    private val _uiState = MutableStateFlow(
        HomeUIState(
            tagMap = emptyMap(),
            selectedTags = mutableMapOf(),
            user = userRepo.emptyUser
        )
    )
    val uiState: StateFlow<HomeUIState> = _uiState

    fun changeProfilePic(newPic: ImageVector) {
        _uiState.value = _uiState.value.copy(
            user = _uiState.value.user.copy(profilePic = newPic)
        )
    }

    fun updateUserName(newName: String) {
        _uiState.value = _uiState.value.copy(
            user = _uiState.value.user.copy(name = newName)
        )
    }

    fun updateUserMajor(newMajor: String) {
        _uiState.value = _uiState.value.copy(
            user = _uiState.value.user.copy(major = newMajor)
        )
    }


    fun addTag(category: String, tag: String) {
        val map = _uiState.value.selectedTags.toMutableMap()
        val list = map[category]?.toMutableList() ?: mutableListOf()
        list.add(tag)
        map[category] = list
        _uiState.value = _uiState.value.copy(selectedTags = map)
    }

    init {
        viewModelScope.launch {
            val tags = tagRepo.getAllCategories()
            _uiState.value = _uiState.value.copy(tagMap = tags)
        }
    }
}