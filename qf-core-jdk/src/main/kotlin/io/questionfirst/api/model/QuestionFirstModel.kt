/*
 * Copyright (c) 2024 Question First
 *
 * This source code is licensed under the MIT License found in the LICENSE file in the root directory of this source tree.
 *
 */

package io.questionfirst.api.model

import java.util.Collections

class QuestionFirstModel : QuestionRefVisitor {

    private val questions: MutableList<Question> = Collections.synchronizedList(ArrayList())
    private val relations: MutableList<QuestionRef> = Collections.synchronizedList(ArrayList())

    fun add(question: Question) {
        questions.add(question)
        question.visit(this)
    }

    fun getQuestions(): List<Question> {
        return Collections.unmodifiableList(questions)
    }

    fun getRelations():List<Any> {
        return Collections.unmodifiableList(relations)
    }

    override fun visit(ref: QuestionRef) {
        relations.add(ref)
    }

}
