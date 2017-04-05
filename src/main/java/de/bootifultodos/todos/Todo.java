/*
 * Copyright 2017 michael-simons.eu.
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
package de.bootifultodos.todos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Eine beliebige, zu erledigendes Aufgabe. Beinhaltet in diesem Kontext noch
 * kein Datum, an dem etwas erledigt werden soll oder nicht.
 *
 * @author Michael J. Simons, 2017-03-13
 */
@SuppressWarnings({"checkstyle:designforextension"})
@Document(collection = "todos")
@Getter
public class Todo {

	public enum  Status {
		OFFEN, ERLEDIGT
	}

	private String id;

	/** Externe Id des Besitzers. */
	private final String userId;

	/** Die zu erledigende Aufgabe */
	@Setter
	private String aufgabe;

	/** Status des Todos. */
	@Setter
	@Getter
	private Status status;

	public Todo(final String userId, final String aufgabe) {
		this.userId = userId;
		this.aufgabe = aufgabe;
		this.status = Status.OFFEN;
	}
}