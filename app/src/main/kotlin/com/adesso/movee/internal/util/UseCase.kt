/**
 * Copyright (C) 2020 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.adesso.movee.internal.util

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class UseCase<out Type : Any, in Params> {

    protected abstract suspend fun buildUseCase(params: Params): Type

    suspend fun run(params: Params): Result<Type, Failure> = withContext(Dispatchers.IO) {
        try {
            Ok(buildUseCase(params))
        } catch (failure: Failure) {
            Err(failure)
        }
    }

    object None {
        override fun toString() = "UseCase.None"
    }
}
