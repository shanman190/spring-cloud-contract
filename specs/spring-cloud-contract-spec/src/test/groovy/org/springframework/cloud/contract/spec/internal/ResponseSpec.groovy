/*
 * Copyright 2013-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.contract.spec.internal

import spock.lang.Specification

/**
 * @author Marcin Grzejszczak
 */
class ResponseSpec extends Specification {

	def 'should throw exception when on response side a value contains regex for client'() {
		given:
			Response response = new Response()
		when:
			response.with {
				value(producer("foo"), consumer(regex("foo")))
			}
		then:
			thrown(IllegalStateException)
		when:
			response.with {
				value(consumer(regex("foo")), producer("foo"))
			}
		then:
			thrown(IllegalStateException)
	}


	def 'should set property when using the $() convenience method'() {
		given:
			Response contract = new Response()
			DslProperty property
		when:
			contract.with {
				property = $(producer(regex("[0-9]{5}")))
			}
			def generatedValue = property.clientValue
			generatedValue instanceof String
			def value = Integer.valueOf(generatedValue as String)
		then:
			value >= 0
			value <= 99_999
	}

	def 'should set property when using the $() convenience method for Double'() {
		given:
			Response contract = new Response()
			DslProperty property
		when:
			contract.with {
				property = $(producer(regex("[0-9]{5}").asDouble()))
			}
			def value = property.clientValue
			value instanceof Double
		then:
			value >= 0
			value <= 99_999
	}

	def 'should set property when using the $() convenience method for Short'() {
		given:
			Response contract = new Response()
			DslProperty property
		when:
			contract.with {
				property = $(producer(regex("[0-9]{1}").asShort()))
			}
			def value = property.clientValue
			value instanceof Short
		then:
			value >= 0
			value <= 9
	}

	def 'should set property when using the $() convenience method for Long'() {
		given:
			Response contract = new Response()
			DslProperty property
		when:
			contract.with {
				property = $(producer(regex("[0-9]{5}").asLong()))
			}
			def value = property.clientValue
			value instanceof Long
		then:
			value >= 0
			value <= 99_999
	}

	def 'should set property when using the $() convenience method for Integer'() {
		given:
			Response contract = new Response()
			DslProperty property
		when:
			contract.with {
				property = $(producer(regex("[0-9]{5}").asInteger()))
			}
			def value = property.clientValue
			value instanceof Integer
		then:
			value >= 0
			value <= 99_999
	}

	def 'should set property when using the $() convenience method for Float'() {
		given:
			Response contract = new Response()
			DslProperty property
		when:
			contract.with {
				property = $(producer(regex("[0-9]{5}").asFloat()))
			}
			def value = property.clientValue
			value instanceof Float
		then:
			value >= 0
			value <= 99_999
	}
}
