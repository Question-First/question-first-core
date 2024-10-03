/*
 * Copyright (c) 2024 Question First
 *
 * This source code is licensed under the MIT License found in the LICENSE file in the root directory of this source tree.
 *
 */

package io.questionfirst.api.model

import net.javacrumbs.jsonunit.assertj.assertThatJson
import org.junit.jupiter.api.Test


class QuestionFirstModelJsonMapperTest {

    val testee = QuestionFirstModelJsonMapper()

    @Test
    fun `How to generate JSON for a single question`() {
        val question = Question("q1", "How to xxx?", "Any description to xxx")
        val questionFirstModel = QuestionFirstModel()

        questionFirstModel.add(question)
        val json = testee.toJson(questionFirstModel)

        assertThatJson(json).isEqualTo(
            """{
                "questions" : [ 
                    {
                        "id" : "q1",
                        "question" : "How to xxx?",
                        "description" : "Any description to xxx"
                    } 
                ],
                "relations" : []
            }"""
        )
    }

    @Test
    fun `How to generate JSON for two unrelated question`() {
        val question1 = Question("q1","How to xxx?", "Any description to xxx")
        val question2 = Question("q2","How to yyy?", "Any description to yyy")
        val questionFirstModel = QuestionFirstModel()

        questionFirstModel.add(question1)
        questionFirstModel.add(question2)
        val json = testee.toJson(questionFirstModel)

        assertThatJson(json).isEqualTo(
            """{
                "questions" : [ 
                    {
                        "id" : "q1",
                        "question" : "How to xxx?",
                        "description" : "Any description to xxx"
                    }, 
                    {
                        "id" : "q2",
                        "question" : "How to yyy?",
                        "description" : "Any description to yyy"
                    }
                 ],
                "relations" : []
            }"""
        )
    }

    @Test
    fun `How to store the relation between two questions`() {
        val question1 = Question("q1","How to xxx?", "Any description to xxx")
        val question2 = Question("q2","How to yyy?", "Any description to yyy")
        question2.addRelation(question1, QuestionRefType.ASSOCIATED)
        val questionFirstModel = QuestionFirstModel()

        questionFirstModel.add(question1)
        questionFirstModel.add(question2)
        val json = testee.toJson(questionFirstModel)

        assertThatJson(json).isEqualTo(
            """{
                "questions" : [ 
                    {
                        "id" : "q1",
                        "question" : "How to xxx?",
                        "description" : "Any description to xxx"
                    }, 
                    {
                        "id" : "q2",
                        "question" : "How to yyy?",
                        "description" : "Any description to yyy"
                    }
                 ],
                "relations" : [
                    {"from" : "q2", "to": "q1", "type" : "ASSOCIATED"},
                    {"from" : "q1", "to": "q2", "type" : "ASSOCIATED"}
                ]
            }"""
        )
    }
}