/*
 * Copyright (c) 2024 Question First
 *
 * This source code is licensed under the MIT License found in the LICENSE file in the root directory of this source tree.
 *
 */

package io.questionfirst.api.model

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class QuestionFirstModelJsonMapper {
    private val mapper = jacksonObjectMapper()

    fun toJson(questionFirstModel: QuestionFirstModel): String {
        return mapper.writeValueAsString(questionFirstModel)
    }

}
