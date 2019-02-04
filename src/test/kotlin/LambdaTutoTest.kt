package com.maestro.kata

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
class LambdaTutoTest {

    private val lambdaTuto = LambdaTuto()


    @Test
    fun should_compare_strings_in_list() {
        val items = listOf("paris", "london", "brussels", "madrid")
        val sortedList = lambdaTuto.sortLengthBased(items)

        assertThat(sortedList).isEqualTo(listOf("paris", "london", "madrid", "brussels"))
    }

    @Test
    fun should_convert_person_to_upper_cases() {
        val persons = listOf(Person("firstName1", "lastName1"),
                             Person("firstName2", "lastName2"))
        val sortedList = lambdaTuto.updatePersonNames(persons)

        assertThat(sortedList).containsExactly(
                Person("FIRSTNAME1", "LASTNAME1"),
                Person("FIRSTNAME2", "LASTNAME2"))
    }

    @Test
    fun should_convert_person_to_name_lengths() {
        val persons = listOf(Person("fName1", "lName1"),
                Person("firstName2", "lastName2"))
        val sortedList = lambdaTuto.convertToNameLengths(persons)

        assertThat(sortedList).containsExactly(12, 19)
    }

    @Test
    fun should_convert_person_to_map_name_lengths() {
        val persons = listOf(Person("fName1", "lName1", 20),
                Person("firstName2", "lastName2", 45))
        val sortedList = lambdaTuto.convertToMapNameAge(persons)

        assertThat(sortedList).hasSize(2)
        assertThat(sortedList.keys).containsExactly("fName1lName1", "firstName2lastName2")
        assertThat(sortedList.values).containsExactly(20, 45)
    }

}