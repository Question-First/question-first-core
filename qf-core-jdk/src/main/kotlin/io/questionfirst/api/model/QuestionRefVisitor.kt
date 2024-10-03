package io.questionfirst.api.model

interface QuestionRefVisitor {
    fun visit(it: QuestionRef)
}
