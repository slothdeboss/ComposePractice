package com.slothdeboss.composepractice.ui.screens.interests

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slothdeboss.composepractice.ui.screens.interests.entity.InterestTopic
import com.slothdeboss.composepractice.ui.screens.interests.entity.provider.InterestTopicProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private const val INITIAL_PROGRESS = 0F
private const val PROGRESS_STEP = 0.2F

class ChooseYourInterestsViewModel : ViewModel() {

    private val _interests = MutableStateFlow(InterestTopicProvider.provideTopics())
    val interests = _interests.asStateFlow()

    private val _isValid = MutableStateFlow(false)
    val isValid = _isValid.asStateFlow()

    private val _progress = MutableStateFlow(INITIAL_PROGRESS)
    val process = _progress.asStateFlow()

    fun updateItemState(index: Int) {
        _interests.update { items ->
            val topics = items.toMutableList()
            val topic = topics[index]
            topics[index] = topic.copy(selected = !topic.selected)
            topics
        }
        validateInterests()
    }

    private fun validateInterests() {
        viewModelScope.launch {
            val selectedTopics = _interests.value.filter { it.selected }.size
            _isValid.emit(selectedTopics >= 5)
            _progress.emit(selectedTopics * PROGRESS_STEP)
        }
    }
}
