package io.questionfirst.api.model

enum class QuestionRefType {
    REFINE{
        private fun getOpposite(type:QuestionRefType): QuestionRefType = ABSTRACT
    },
    ABSTRACT {
        private fun getOpposite(type:QuestionRefType): QuestionRefType = REFINE
    },
    ASSOCIATED;

    fun createOppositeRef(origin: QuestionRef) : QuestionRef {
        return QuestionRef(origin.to, origin.from, getOpposite(origin.type))
    }

    private fun getOpposite(type:QuestionRefType): QuestionRefType = type

}