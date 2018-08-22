/*
 * Copyright 2018 the original author or authors.
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
package example.springdata.r2dbc.basics;

import reactor.core.publisher.Flux;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author Oliver Gierke
 */
interface CustomerRepository extends ReactiveCrudRepository<Customer, Long> {

	@Query("select id, firstname, lastname from customer c where c.lastname = $1")
	Flux<Customer> findByLastnameLike(String lastname);
}