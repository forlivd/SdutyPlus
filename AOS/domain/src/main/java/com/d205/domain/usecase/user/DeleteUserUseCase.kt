package com.d205.domain.usecase.user

import com.d205.domain.model.user.User
import com.d205.domain.repository.UserRepository
import com.d205.domain.utils.ResultState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DeleteUserUseCase @Inject constructor(private val userRepository: UserRepository) {
    operator fun invoke(): Flow<ResultState<Boolean>> =
        userRepository.deleteUser()
}