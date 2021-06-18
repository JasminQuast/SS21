package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private DiaryService service;

	@MockBean
	private DiaryRepository repository;

	@Test
	@DisplayName("should find notes by owners email")
	void testFindByOwnerEmail() {
		var n1 = new Note("Mein Tag","Das ist ein Test.", 4);
		n1.setOwner("jasmin@test.com");
		var n2 = new Note("Neuer Tag","Das ist ein weiterer Test.", 4);
		n2.setOwner("dome@test.com");
		doReturn(List.of(n1, n2)).when(repository).findAll();

		List<Note> jasminsNotes = service.findAll("jasmin@test.com");

		Assertions.assertSame(jasminsNotes.size(), 1, "Falsche Anzahl an Note-Einträgen");
		Assertions.assertSame(jasminsNotes.get(0).getHeadline(), "Mein Tag", "Falsche Headline");

	}

}
