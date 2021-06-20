package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private DiaryService service;

	@MockBean
	private DiaryRepository repository;

	@Test
	@DisplayName("should find all notes by owners email, except todays note if existing and return Notes by Date descending")
	void getNotesUser() {

		String userEmail = "dome@test.com";

		Note note1 = new Note("Mein Tag","Das ist ein Test.", 4, LocalDate.of(2021, 6, 19));
		note1.setOwner("jasmin@test.com");
		Note note2 = new Note("Neuer Tag","Das ist ein weiterer Test.", 4, LocalDate.of(2021, 6, 18));
		note2.setOwner(userEmail);
		Note note3 = new Note("Mein Tag", "Zum Frühstück gab es ein Omelette mit Tomaten, Zucchini und Zwiebeln", 3, LocalDate.of(2021, 6, 19));
		note3.setOwner(userEmail);
		Note note4 = new Note("Heute", "Heute war ich mit Freunden am See!", 1);
		note4.setOwner(userEmail);
		doReturn(List.of(note1, note2, note3, note4)).when(repository).findAll();

		var expected = List.of(note3, note2);
		var actual = service.getNotesUser(userEmail);

		Assertions.assertArrayEquals(new List[]{expected}, new List[]{actual});
	}

	@Test
	@DisplayName("should find todays note by owners email and return this note")
	void getTodaysNote(){

		String userEmail = "dome@test.com";

		Note note1 = new Note("Meine erste Notiz", "Das ist meine erste Notiz in der Diaryst App", 2);
		note1.setOwner(userEmail);
		Note note2 = new Note("Der Sommer kommt!", "Heute sind es 35 Grad", 1);
		note2.setOwner("jasmin@test.com");
		Note note3 = new Note("Alte Notiz", "Das ist eine alte Notiz", 6, LocalDate.of(2021,6,19));
		note3.setOwner(userEmail);

		doReturn(List.of(note1, note2, note3)).when(repository).findAll();
		var expected = note1;
		var actual = service.getTodaysNote(userEmail);

		Assertions.assertSame(expected, actual);
	}

	@Test
	@DisplayName("return empty Note if there is no Note for today entered by owner")
	void getTodaysNote2(){

		String userEmail = "dome@test.com";

		Note note1 = new Note("Mein Tag", "Zum Frühstück gab es ein Omelette mit Tomaten, Zucchini und Zwiebeln", 2);
		note1.setOwner("maria@test.com");
		Note note2 = new Note("Der Sommer kommt!", "Heute sind es 35 Grad", 1);
		note2.setOwner("jasmin@test.com");
		Note note3 = new Note("Alte Notiz", "Das ist eine alte Notiz", 6, LocalDate.of(2021,6,19));
		note3.setOwner(userEmail);

		doReturn(List.of(note1, note2, note3)).when(repository).findAll();

		var actual = service.getTodaysNote(userEmail);

		Assertions.assertSame(null, actual);
	}
}
