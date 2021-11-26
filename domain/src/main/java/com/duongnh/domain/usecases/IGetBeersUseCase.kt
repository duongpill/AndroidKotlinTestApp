package com.duongnh.domain.usecases

import com.duongnh.domain.base.BaseUseCase
import com.duongnh.domain.base.BaseRequest
import com.duongnh.domain.models.Beer
import kotlinx.coroutines.flow.Flow

interface IGetBeersUseCase: BaseUseCase<BaseRequest, Flow<List<Beer>>>