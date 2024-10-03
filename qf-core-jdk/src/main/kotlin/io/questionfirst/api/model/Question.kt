/*
 * Copyright (c) 2024 Question First
 *
 * This source code is licensed under the MIT License found in the LICENSE file in the root directory of this source tree.
 *
 */

package io.questionfirst.api.model

data class Question(val id: String, val question: String, val description: String) {
    private val relations : MutableList<QuestionRef>  = ArrayList()

    fun addRelation(other: Question, refType: QuestionRefType) {
        relations.add(QuestionRef(this.id, other.id, refType))
    }

    fun visit(visitor : QuestionRefVisitor ) {
        relations.forEach { questionRef ->
            visitor.visit(questionRef)
            visitor.visit(questionRef.type.createOppositeRef(questionRef))
        }
    }
}
